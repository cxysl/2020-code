package com.teastore.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import com.teastore.po.Goods;
import com.teastore.service.GoodsService;
import org.apache.commons.lang3.StringUtils;

import com.teastore.po.Userinfo;
import com.teastore.service.UserinfoService;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@WebServlet("/User")
public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * 用户登录
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//创建一个对象用于接收前端传过来的数据
		Userinfo user = new Userinfo();
		//把接收到的数据复制给user
		BeanUtils.populate(user, request.getParameterMap());
		//校验用户名密码不能为空
		if(StringUtils.isBlank(user.getAccountnumber())||StringUtils.isBlank(user.getPwd())) {
			//提示错误信息
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空!", "登录失败", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("http://localhost:8080/TeaStore/view/login/login.jsp");
			return null;
		}
		System.out.println(user.getAccountnumber()+""+user.getPwd());
		UserinfoService userService = new UserinfoService();
		Userinfo existU = userService.doLogin(user.getAccountnumber(),user.getPwd());
		//校验用户名密码是否正确
		if(null == existU){
			//登录失败，提示错误信息
			System.out.println("登录失败！");
			JOptionPane.showMessageDialog(null, "账号或密码错误!", "登录失败", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("http://localhost:8080/TeaStore/view/login/login.jsp");
			return null;
		}
		//登录成功把用户信息添加到session
		request.getSession().setAttribute("loginUser", existU);
		request.getSession().setMaxInactiveInterval(60 * 60 * 24 * 7);

		// 保存登录状态
		Cookie ck = new Cookie("JSESSIONID", request.getSession().getId());
		ck.setPath("/");
		ck.setMaxAge(30);

		//登录成功之后重定向的页面
		System.out.println(existU+"\n登录成功!");
		if (existU.getIsadmin().intValue()==0){			//顾客		普通用户
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} else{				//管理员
			request.getRequestDispatcher("/User?method=UserQueryAll").forward(request,response);
		}
		return null;
	}


	/**
	 * 用户注册
	 */
	public String register(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception  {
		System.out.println("1111111111111111111111");
		//创建一个对象用于接收前端传过来的数据
		Userinfo user = new Userinfo();
		user.setId(null);
		UUID uuid = UUID.randomUUID();
		String userid = uuid.toString().substring(0,8);
		user.setUserid(userid);		//随机生成ID
		//把接收到的数据复制给user
		BeanUtils.populate(user, request.getParameterMap());

		System.out.println(user+"\t"+userid+"\t"+user.getIsadmin());

		//校验用户名密码不能为空
		if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPwd())||StringUtils.isBlank(user.getUsername())
				||StringUtils.isBlank(user.getAddress())||StringUtils.isBlank(user.getPhone())) {
			request.setAttribute("error", "用户名或密码不能为空！");
			return "/view/register.jsp";
		}

		System.out.println("账号:"+user.getAccountnumber()+"\t密码:"+user.getPwd()+"\t名字:"+user.getUsername()+
				"\t收货地址:"+user.getAddress()+"\t电话:"+user.getPhone());
		UserinfoService userService = new UserinfoService();

		//调用userService的注册方法把数据添加到数据库
		if(userService.addUser(user)!=-1) {
			//数据添加成功，即注册成功
			//注册成功之后重定向到登录页面
			response.getWriter().print("<script>"
					+ "alert('注册成功！');"
					+ "window.location='"+request.getContextPath()
					+"/view/login/login.jsp'"
					+ "</script>");
			return null;
		}else {
			//数据添加失败
			request.setAttribute("error", "注册失败！");
			//注册失败之后重新注册，并且提示错误信息
			return "/view/register.jsp";
		}
	}


	/**
	 * 退出登录
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//退出登录，移出用户的session
		request.getSession().removeAttribute("loginUser");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}


	/**
	 * 顾客个人信息页面
	 */
	public String userInformation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag=new String(request.getParameter("flag"));		//获取URL中的参数
		Integer id =new Integer(request.getParameter("id"));

		if (flag==null){		//说明为登录
			System.out.println("你还未登录！");
			return null;
		}else {		//说明已经登录
			UserinfoService userService = new UserinfoService();
			Userinfo user = userService.queryOne(id);
			if (user.getIsadmin()==1){
				response.sendRedirect(request.getContextPath()+"/view/admin/main.jsp");
				return null;

			}
			//查找成功把用户信息添加到session
			request.getSession().setAttribute("userInformation", user);

			GoodsService service = new GoodsService();
			List<Goods> lists = service.queryAll();
			for (Goods g: lists){
				System.out.println(g);
			}
			request.getSession().setAttribute("goods", lists);
			System.out.println(user);
			response.sendRedirect(request.getContextPath()+"/view/User.jsp");
			return null;
		}
	}

	/**
	 * 顾客个人信息页面
	 */
	public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id =new Integer(request.getParameter("id"));
		String goodsname =new String(request.getParameter("goodsname"));		//获取URL中的参数
		System.out.println(id+"\t\t"+goodsname);
		UserinfoService userService = new UserinfoService();
		Userinfo user = userService.queryOne(id);
		//查找成功把用户信息添加到session
		request.getSession().setAttribute("userInformation", user);
		GoodsService service = new GoodsService();
		List<Goods> lists = service.queryAll();
		List<Goods> list2 = new ArrayList<Goods>();
		String str = null;
		for(Goods p: lists){
			str = p.getGoodsname()+p.getGoodsdescribe()+p.getGoodstype();
			if(goodsname.length()!=0) {
				if (str.contains(goodsname) || goodsname.contains(str)) {
					list2.add(p);
					System.out.println(p);
				}
			}else{
				System.out.print("");
			}
		}
		if (goodsname==null||goodsname.length()==0){
			request.getSession().setAttribute("goods", lists);
		}else{
			request.getSession().setAttribute("goods", list2);
		}
		System.out.println(user);
		response.sendRedirect(request.getContextPath()+"/view/User.jsp");
		return null;
	}


	/**
	 * 商品查询所有
	 */
	public String UserQueryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("\nUserQueryAll");
		UserinfoService userService = new UserinfoService();
		List<Userinfo> lists = userService.queryAll();
		for(Userinfo u: lists){
			System.out.println(u);
		}
		//查找成功把用户信息添加到session
		request.getSession().setAttribute("users", lists);
		response.sendRedirect(request.getContextPath()+"/view/admin/main.jsp");
		return null;
	}


	/**
	 * 管理员 查看订单的顾客信息
	 */
	public String adminQueryOneUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("\nadminQueryOneUser");

		String userId =new String(request.getParameter("userId"));		//获取URL中的参数
		UserinfoService userService = new UserinfoService();
		Userinfo user = userService.queryOneByOrders(userId);
		System.out.println(user);

		request.getSession().setAttribute("user", user);

		response.sendRedirect(request.getContextPath()+"/view/admin/user.jsp");
		return null;
		}

	/**
	 * 管理员  添加顾客信息
	 */
	public String adminAddOneUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("\nadminAddOneUser");

		UserinfoService userService = new UserinfoService();

		UUID uuid = UUID.randomUUID();
		String userid = uuid.toString().substring(0,8);
		String accountnumber =new String(request.getParameter("accountnumber"));
		String pwd =new String(request.getParameter("pwd"));
		Integer isadmin =0;
		String username =new String(request.getParameter("username"));
		String address =new String(request.getParameter("address"));
		String phone =new String(request.getParameter("phone"));

		Userinfo userinfo = new Userinfo(null,userid,accountnumber,pwd,isadmin,username,address,phone);
		System.out.println("添加的顾客信息为:"+userinfo);
		userService.addUser(userinfo);

		request.getRequestDispatcher("/User?method=UserQueryAll").forward(request,response);
		return null;
	}

	/**
	 * 管理员  删除顾客信息
	 */
	public String adminDelOneUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("\nadminDelOneUser");

		UserinfoService userService = new UserinfoService();
		Integer id =new Integer(request.getParameter("id"));		//获取URL中传的参数
		userService.delUser(id);

		request.getRequestDispatcher("/User?method=UserQueryAll").forward(request,response);
		return null;
	}

	/**
	 * 管理员  修改顾客信息
	 */
	public String adminUpdateOneUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("\nadminUpdateOneUser");

		Integer id =new Integer(request.getParameter("id"));		//获取URL中传的参数
		Integer count =new Integer(request.getParameter("count"));		//获取URL中传的参数

		if (count==1){             //第一次进来，找到该顾客先，然后传到界面上方便修改
			UserinfoService userService = new UserinfoService();
			Userinfo user1 = userService.queryOne(id);        //找到是那个
			System.out.println("修改前:"+user1);
			request.getSession().setAttribute("user22", user1);//存过去，方便改库存
			response.sendRedirect(request.getContextPath()+"/view/admin/form/User.jsp");
		}
		if (count==2){      //第二次进来，直接修改
			UserinfoService userService = new UserinfoService();
			Userinfo user1 = userService.queryOne(id);        //找到是那个商品

			//id不变
			//用户Id
			//登录账号
			user1.setPwd(new String(request.getParameter("pwd")));//密码
			//是否是管理员不变
			user1.setUsername(new String(request.getParameter("username")));//用户姓名
			user1.setAddress(new String(request.getParameter("address")));//收货地址
			user1.setPhone(new String(request.getParameter("phone")));//手机号

			userService.updateUser(user1);
			System.out.println("修改后:"+user1);
			request.getSession().setAttribute("user22", null);      //修改完将对象指向空
			request.getRequestDispatcher("/User?method=UserQueryAll").forward(request,response);
		}

		return null;
	}



}
