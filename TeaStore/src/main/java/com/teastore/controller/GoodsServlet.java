package com.teastore.controller;

import com.teastore.po.Goods;
import com.teastore.service.GoodsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/Goods")
public class GoodsServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;

    /**
     * 商品查询所有
     */
    public String GoodsQueryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nGoodsQueryAll");
        GoodsService goodsService = new GoodsService();
        List<Goods> lists = goodsService.queryAll();
        for(Goods g: lists){
            System.out.println(g);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("goods", lists);
        response.sendRedirect(request.getContextPath()+"/view/allproducts.jsp");
        return null;
    }
    /**
     * 商品查询所有
     */
    public String GoodsQueryAllAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nGoodsQueryAllAdmin");
        GoodsService goodsService = new GoodsService();
        List<Goods> lists = goodsService.queryAll();
        for(Goods g: lists){
            System.out.println(g);
        }
        //查找成功把用户信息添加到session
        request.getSession().setAttribute("goods", lists);
        response.sendRedirect(request.getContextPath()+"/view/admin/GoodsManage.jsp");
        return null;
    }

    /**
     * 商品模糊查询所有
     */
    public String GoodsQueryAny(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String goodsname =new String(request.getParameter("goodsname"));		//获取URL中的参数
        System.out.println("111\t\t"+goodsname);

        GoodsService goodsService = new GoodsService();
        List<Goods> lists = goodsService.queryAll();
        List<Goods> list2 = new ArrayList<Goods>();
        String str = null;
        for(Goods g: lists){
            str = g.getGoodsname()+g.getGoodsdescribe()+g.getGoodstype();
            if(goodsname.length()!=0) {
                if (str.contains(goodsname) || goodsname.contains(str)) {
                    list2.add(g);
                    System.out.println(g);
                }
            }
        }
        //查找成功把用户信息添加到session
        if (goodsname==null||goodsname.length()==0){
            request.getSession().setAttribute("goods", lists);
        }else{
            request.getSession().setAttribute("goods", list2);
        }
        response.sendRedirect(request.getContextPath()+"/view/allproducts.jsp");
        return null;
    }


    /**
     * 商品进货
     */
    public String GoodsCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nGoodsCount");     //检查是否进来

        Integer id =new Integer(request.getParameter("id"));		//获取URL中传的参数
        Integer count =new Integer(request.getParameter("count"));		//获取URL中传的参数

        if (count==1){             //第一次进来，找到那件商品先，然后传到界面上方便修改
            GoodsService goodsService = new GoodsService();
            Goods goods1 = goodsService.queryOne(id);        //找到是那个商品
            System.out.println("修改前:"+goods1);
            request.getSession().setAttribute("goods1", goods1);//存过去，方便改库存
//            request.setAttribute("goods1", goods1);
            response.sendRedirect(request.getContextPath()+"/view/admin/form/GoodsCount.jsp");
        }
        if (count==2){      //第二次进来，直接修改
            GoodsService goodsService = new GoodsService();
            Goods goods1 = goodsService.queryOne(id);        //找到是那个商品
            Integer goodsCount2 =new Integer(request.getParameter("goodsCount2"));
//            Integer goodsCount2=(Integer)request.getParameter("goodsCount2");
            goods1.setCount(goods1.getCount()+goodsCount2);
            goodsService.updateGoods(goods1);
            System.out.println("修改后:"+goods1);
            request.getRequestDispatcher("/Goods?method=GoodsQueryAllAdmin").forward(request,response);
        }

        return null;
    }

    /**
     * 添加新商品
     */
    public String AddGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nAddGoods");     //检查是否进来

        GoodsService goodsService = new GoodsService();

//        String goodscode =new String(request.getParameter("goodscode"));
//        String goodspicture =new String(request.getParameter("goodspicture"));
        UUID uuid = UUID.randomUUID();
        String goodscode1 = uuid.toString().substring(0,8);
        String goodsname1 =new String(request.getParameter("goodsname"));
        String goodstype1 =new String(request.getParameter("goodstype"));
        String goodspecs1 =new String(request.getParameter("goodspecs"));
        String goodsbrand1 =new String(request.getParameter("goodsbrand"));
        String goodspicture1 = "static/img/none.jpg";
        Double saleprice1 =new Double(request.getParameter("saleprice"));
        Integer count1 =new Integer(request.getParameter("count"));
        String isonsale1 =new String(request.getParameter("isonsale"));
        String goodsdescribe1 =new String(request.getParameter("goodsdescribe"));

        Goods goods1 = new Goods(null,goodscode1,goodsname1,goodstype1,goodspecs1,goodsbrand1,goodspicture1,saleprice1,count1,isonsale1,goodsdescribe1);
        System.out.println("添加的商品信息为:"+goods1);
        goodsService.addGoods(goods1);

        request.getRequestDispatcher("/Goods?method=GoodsQueryAllAdmin").forward(request,response);
        return null;
    }

    /**
     * 删除商品
     */
    public String delGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\ndelGoods");     //检查是否进来

        Integer id =new Integer(request.getParameter("id"));		//获取URL中传的参数
        GoodsService goodsService = new GoodsService();
        goodsService.delGoods(id);

        request.getRequestDispatcher("/Goods?method=GoodsQueryAllAdmin").forward(request,response);
        return null;
    }

    /**
     * 修改商品信息
     */

    public String updateGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("\nupdateGoods");     //检查是否进来

        Integer id =new Integer(request.getParameter("id"));		//获取URL中传的参数
        Integer count =new Integer(request.getParameter("count"));		//获取URL中传的参数

        if (count==1){             //第一次进来，找到那件商品先，然后传到界面上方便修改
            GoodsService goodsService = new GoodsService();
            Goods goods1 = goodsService.queryOne(id);        //找到是那个商品
            System.out.println("修改前:"+goods1);
            request.getSession().setAttribute("goods1", goods1);//存过去，方便改库存
            response.sendRedirect(request.getContextPath()+"/view/admin/form/Goods.jsp");
        }
        if (count==2){      //第二次进来，直接修改
            GoodsService goodsService = new GoodsService();
            Goods goods1 = goodsService.queryOne(id);        //找到是那个商品

            //id不变
            //条码不变
            goods1.setGoodsname(new String(request.getParameter("goodsname")));     //名称
            goods1.setGoodstype(new String(request.getParameter("goodstype")));     //类别
            goods1.setGoodspecs(new String(request.getParameter("goodspecs")));     //商品规格
            goods1.setGoodsbrand(new String(request.getParameter("goodsbrand")));     //商品品牌
            //图片不变
            goods1.setSaleprice(new Double(request.getParameter("saleprice")));     //销售价格
            goods1.setCount(new Integer(request.getParameter("Goodscount")));     //库存量
            goods1.setIsonsale(new String(request.getParameter("isonsale")));     //上架状态
            goods1.setGoodsdescribe(new String(request.getParameter("goodsdescribe")));     //商品描述

            goodsService.updateGoods(goods1);
            System.out.println("修改后:"+goods1);
            request.getSession().setAttribute("goods1", null);      //修改完将对象指向空
            request.getRequestDispatcher("/Goods?method=GoodsQueryAllAdmin").forward(request,response);
        }

        return null;
    }


}
