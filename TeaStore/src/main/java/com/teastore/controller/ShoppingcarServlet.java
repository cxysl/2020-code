package com.teastore.controller;

import com.teastore.po.Shoppingcar;
import com.teastore.po.Userinfo;
import com.teastore.service.ShoppingcarService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.List;

@WebServlet("/Shoppingcar")
public class ShoppingcarServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;

    /**
     * 购物车查询所有
     */
    public String ShoppingcarQueryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nShoppingcarQueryAll");
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("loginUser");
        if (userinfo == null) {
            JOptionPane.showMessageDialog(null, "你还未登录!", "错误操作", JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("http://localhost:8080/TeaStore/view/login/login.jsp");
            return null;
        }
        Integer id = userinfo.getId();
        System.out.println(id+"\t\t4444");
        ShoppingcarService shoppingcarService = new ShoppingcarService();
        List<Shoppingcar> lists = shoppingcarService.queryOneUserinfoAll(id);
        for(Shoppingcar s: lists){
            System.out.println(s);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("shoppingcar", lists);
        response.sendRedirect(request.getContextPath()+"/view/shop/shop.jsp");
        //request.getRequestDispatcher("/view/shop/shop.jsp").forward(request, response);   //请求转发到表单页面
        return null;
    }

    /**
     * 改购买数量
     */
    public void buyCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nbuyCount");
        Integer id =new Integer(request.getParameter("id"));		//购物车Id
        String str = new String(request.getParameter("op"));       // 操作
        System.out.println(id+"\t\t"+str);
        ShoppingcarService shoppingcarService = new ShoppingcarService();
        Shoppingcar shoppingcar = shoppingcarService.queryOne(id);
        System.out.println(shoppingcar);
        if (str.equals("j")){       //增加
            shoppingcar.setBuycount(shoppingcar.getBuycount()+1);
            shoppingcarService.updateOD(shoppingcar);
            request.getRequestDispatcher("/Shoppingcar?method=ShoppingcarQueryAll").forward(request,response);
        }else{      //减少
            shoppingcar.setBuycount(shoppingcar.getBuycount()-1);
            shoppingcarService.updateOD(shoppingcar);
            request.getRequestDispatcher("/Shoppingcar?method=ShoppingcarQueryAll").forward(request,response);
        }

    }


    /**
     * 删除
     */
    public void delshopping(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\ndelshopping");
        Integer id =new Integer(request.getParameter("id"));		//购物车Id
        System.out.println(id);
        ShoppingcarService shoppingcarService = new ShoppingcarService();
        shoppingcarService.delOD(id);

//        response.sendRedirect("Shoppingcar?method=ShoppingcarQueryAll");
        request.getRequestDispatcher("/Shoppingcar?method=ShoppingcarQueryAll").forward(request,response);
    }

    /**
     * 添加购物车
     */
    public void addshopping(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\naddshopping");

        String goodscode = new String(request.getParameter("goodscode"));
        String goodsname = new String(request.getParameter("goodsname"));
        String goodspicture = new String(request.getParameter("goodspicture"));
        Double goodsprice = new Double(request.getParameter("goodsprice"));
        Integer buycount = 1;
        String goodsdescribe = new String(request.getParameter("goodsdescribe"));
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("loginUser");
        Integer userid = userinfo.getId();
        Shoppingcar shoppingcar = new Shoppingcar(null,goodscode,goodsname,goodspicture,goodsprice,buycount,goodsdescribe,userid);

        System.out.println(shoppingcar);

        ShoppingcarService shoppingcarService = new ShoppingcarService();
        shoppingcarService.addOD(shoppingcar);

        request.getRequestDispatcher("/Shoppingcar?method=ShoppingcarQueryAll").forward(request,response);
    }

}
