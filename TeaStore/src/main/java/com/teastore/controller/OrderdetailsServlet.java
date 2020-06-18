package com.teastore.controller;

import com.teastore.po.Orderdetails;
import com.teastore.service.OrderdetailsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/Orderdetails")
public class OrderdetailsServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;

    /**
     * 订单明细查询所有 顾客版
     */
    public String OrderdetailsQueryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nOrderdetailsQueryAll");

        String id =new String(request.getParameter("id"));		//获取URL中传的参数

        OrderdetailsService ordersService = new OrderdetailsService();
        List<Orderdetails> lists = ordersService.queryAllOneOrders(id);   //根据用户id查这个用户的全部订单
        for(Orderdetails s: lists){
            System.out.println(s);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("ods", lists);
        response.sendRedirect(request.getContextPath()+"/view/orderdetails.jsp");
        return null;
    }

    /**
     * 订单明细查询所有     管理员版
     */
    public String OrderdetailsQueryAllAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nOrderdetailsQueryAll");

        String id =new String(request.getParameter("id"));		//获取URL中传的参数

        OrderdetailsService ordersService = new OrderdetailsService();
        List<Orderdetails> lists = ordersService.queryAllOneOrders(id);   //根据用户id查这个用户的全部订单
        for(Orderdetails s: lists){
            System.out.println(s);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("ods", lists);
        response.sendRedirect(request.getContextPath()+"/view/admin/orderdetails.jsp");
        return null;
    }

//    /**
//     * 添加订单明细
//     */
//    public String addOrderdetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("\naddOrderdetails");
//
//        OrderdetailsService ordersService = new OrderdetailsService();
//
//
//
//
//        response.sendRedirect(request.getContextPath()+"/view/admin/orders.jsp");
//        return null;
//    }
}
