<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>湖南郴州刘氏茶叶购物网站</title>


		<link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
		<!-- Retina iPad Touch Icon-->
		<link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
		<!-- Retina iPhone Touch Icon-->
		<link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
		<!-- Standard iPad Touch Icon-->
		<link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
		<!-- Standard iPhone Touch Icon-->
		<link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

		<!-- Styles -->
		<link href="${pageContext.request.contextPath }/static/css/css/lib/font-awesome.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/css/lib/themify-icons.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/css/lib/owl.carousel.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/static/css/css/lib/owl.theme.default.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/static/css/css/lib/weather-icons.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/static/css/css/lib/mmc-chat.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/static/css/css/lib/sidebar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/css/lib/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/css/lib/simdahs.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/css/style.css" rel="stylesheet">


		<link rel="stylesheet" type="text/css" href="../static/css/user/main.css">
		<link rel="stylesheet" type="text/css" href="../static/css/user/reset.css">
		<script type="text/javascript" src="../static/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="../static/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="../static/js/slide.js"></script>


		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/allproducts.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
			<div id="header1">
				<ul class="dar">
					<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
					<li><a class="dar01" href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAll">所有产品</a></li>
					<li><a href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
					<li><a href="${pageContext.request.contextPath }/Shoppingcar?method=ShoppingcarQueryAll">购物车</a></li>
				</ul>
			</div>

		<div class="search_bar clearfix" style="margin-left: 800px;margin-bottom: 20px">
			<div class="search_con fl">
				<form action="${pageContext.request.contextPath }/Goods?method=GoodsQueryAny" method="post">
					<input type="text" class="input_text fl" value="${goodsname}" name="goodsname" placeholder="搜索商品">
					<input type="submit" class="input_btn fr" value="搜索">
				</form>
			</div>
		</div>


		<!--所有产品-->

		<div  style="margin-top:20px;margin-left:1200px;">
		<%--<input type="hidden"  name="method" value="queryWithPage"/>--%>
			<%--<input type="text" placeholder="请输入搜索关键字" value="${goodsname}" name="goodsname"/>--%>
		<%--<button type="submit">搜索</button>--%>
		</div>

		<div id="allproduct" >

			<div class="allproducts">
				<ul class="goods_list fl">
			 <c:forEach	items="${goods }" var="g">
					<%--<div>--%>
						<%--<img src="${pageContext.request.contextPath }/${g.goodspicture}"/>--%>
						<%--<p>${g.goodsname }</p>--%>
						<%--<p><fmt:formatNumber type="number" value="${g.saleprice }" pattern="#.00"/>元</p>--%>
						<%--<button type="button" class="layui-btn layui-btn-primary layui-btn-sm addCart"><a onclick="addCart(${g.id})">+购物车</a></button>--%>
					<%--</div>--%>
				 <li>
					 <h4 style="height: 20px"><a href="">${g.goodstype}</a></h4>
					 <input type="hidden" name="goodscode" value="${g.goodscode}">
					 <input type="hidden" name="goodsname" value="${g.goodsname}">

					 <a href=""><img src="${pageContext.request.contextPath }/${g.goodspicture}"></a>
					 <h4><a href="">${g.goodsdescribe}</a></h4>
					 <div>
						 <div style="display: none">${g.id}</div>
						 <div class="prize" style="float: left;margin-left: 5px">${g.saleprice }</div>
						 <button type="button" class="addCart btn btn-danger m-b-10 m-l-5"
								 style="float: right;margin-right: 5px;" onclick="forward('${pageContext.request.contextPath }/Shoppingcar?method=addshopping&goodscode=${g.goodscode}&goodsname=${g.goodsname}&goodspicture=${g.goodspicture}&goodsprice=${g.saleprice}&goodsdescribe=${g.goodsdescribe}')">+购物车</button>
					 </div>


				 </li>
				</c:forEach>
				</ul>
			</div>

		</div>

  </div><script>
            function forward(url) {
                window.location.replace(url);
            }
		</script>
</fieldset>
		<!--底部
		style="position:fixed; bottom:0; "
		-->
		<%--<div id="footer">--%>
			<%--湖南郴州刘氏茶叶购物网站--%>
		<%--</div>--%>

	</body>
</html>
<script src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/static/js/middle01.js" type="text/javascript" charset="utf-8"></script>
<script>
layui.use(['laypage', 'layer'], function(){
	  var laypage = layui.laypage
	  ,layer = layui.layer;
	  
	  //分页功能
	  laypage.render({
	    elem: 'demo0'
	    ,count: "${page.totalRecord}" //数据总数
	    ,curr: "${page.currentPage}"
	    ,limit: 12
	    ,jump: function(obj,first){
	    	
	    	//首次不执行
	        if(!first){
	        	window.location.href="${pageContext.request.contextPath }/Goods?method=queryWithPage&name=${name}&pageNum="+obj.curr;
	        }
	    }
	  });
	  
	  //添加商品到购物车
	  $(".addCart").click(function(){
		  $.get("${pageContext.request.contextPath }/Cart?method=addCart&goodId="+$(this).attr("id"))
		  layer.msg('添加成功', {icon: 1});
	  })	  
	  
	  
	});
	

</script>