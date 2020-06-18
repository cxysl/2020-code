package com.teastore.controller;

import com.teastore.po.Goods;
import com.teastore.po.Orderdetails;
import com.teastore.po.Orders;
import com.teastore.po.Userinfo;
import com.teastore.service.GoodsService;
import com.teastore.service.OrderdetailsService;
import com.teastore.service.OrdersService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/Order")
public class OrdersServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;

    /**
     * 订单查询所有
     */
    public String OrderQueryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nOrderQueryAll");
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("loginUser");
        if (userinfo == null) {     //判断是否登录了，没登录去登录先
            JOptionPane.showMessageDialog(null, "你还未登录!", "错误操作", JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("http://localhost:8080/TeaStore/view/login/login.jsp");
            return null;
        }
        Integer id = userinfo.getId();
        System.out.println(id+"\t\t4444");
        OrdersService ordersService = new OrdersService();
        List<Orders> lists = ordersService.queryOneUserAll(id);     //根据用户id查这个用户的全部订单
        for(Orders s: lists){
            System.out.println(s);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("orders", lists);
        response.sendRedirect(request.getContextPath()+"/view/order.jsp");
        return null;
    }

    /**
     * 这个是给管理员的
     */
    public String OrderQueryAllAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nOrderQueryAllAdmin");

        OrdersService ordersService = new OrdersService();
        List<Orders> lists = ordersService.queryAll();     //根据用户id查这个用户的全部订单
        for(Orders s: lists){
            System.out.println(s);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("orders", lists);
        response.sendRedirect(request.getContextPath()+"/view/admin/orders.jsp");
        return null;
    }


    /**
     *  下订单
     *            用户下单时同时添加订单和订单详情，但实际有时间差，先添加订单，
     *          * 因此订单详情中的订单号即为订单表中最后一条记录的订单号（即刚添加的订单）
     */
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\naddOrder");

        String[] id = request.getParameterValues("proid[]");      //购物车id
        String[] goodscode =request.getParameterValues("goodscode[]");           //商品条码
        String[] buycount =request.getParameterValues("pronum[]");        //购买数量
        Double orderprice1 =new Double(request.getParameter("total"));      //订单总价

        System.out.println(orderprice1);
        System.out.print("buycount:");
        for (String s:buycount){System.out.print(s+"\t");}
        System.out.print("\nid:");
        for (String s:id){System.out.print(s+"\t");}
        System.out.print("\ngoodscode:");
        for (String s:goodscode){System.out.print(s+"\t");}

        OrdersService ordersService = new OrdersService();

        UUID uuid = UUID.randomUUID();
        String orderid = uuid.toString().substring(0,8);        //订单号
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("loginUser");
        String userid = userinfo.getUserid();           //下单的顾客ID
        String username = userinfo.getUsername();       //下单的顾客名字
        /** !!!!注意!!!订单总金额，需要从前台页面通过url参数形式传过来**/
        Double orderprice = orderprice1;      //订单的总金额
        SimpleDateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd  HH:mm");
        String orderdate =   dateFormat.format( new Date() );        //订单的下单时间
        Integer orderstate = 0;     //订单状态     0待付款     1已支付

        Orders orders = new Orders(null,orderid,userid,username,orderprice,orderdate,orderstate);
        System.out.println("\n\n\n添加的订单"+orders+"\n\n\n");
        ordersService.addOrders(orders);

/**
 * 加订单详情
 */
        for (int i = 0; i <goodscode.length ; i++) {
            GoodsService goodsService = new GoodsService();
            Goods goods = goodsService.queryOneByGoodscode(goodscode[i]);
            System.out.println(goods);

            Orderdetails orderdetails = new Orderdetails(null,goods.getGoodscode(),goods.getGoodsname()
            ,Integer.parseInt(buycount[i]),goods.getSaleprice(),orderid);

            System.out.println("添加的订单明细"+orderdetails);
            OrderdetailsService orderdetailsService = new OrderdetailsService();
            orderdetailsService.addOD(orderdetails);
        }
    }

}
