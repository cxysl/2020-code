<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
	<script src="static/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/allproducts.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">

	<link rel="stylesheet" type="text/css" href="../static/css/user/main.css">
	<link rel="stylesheet" type="text/css" href="../static/css/user/reset.css">

	<%-- ---------- --%>
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
	<script src="${pageContext.request.contextPath }/static/js/js/lib/jquery.min.js"></script><!-- jquery vendor -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/jquery.nanoscroller.min.js"></script><!-- nano scroller -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/sidebar.js"></script><!-- sidebar -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/bootstrap.min.js"></script><!-- bootstrap -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/mmc-common.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/mmc-chat.js"></script>
	<!--  Chart js -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/chart-js/Chart.bundle.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/chart-js/chartjs-init.js"></script>
	<!-- // Chart js -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/sparklinechart/jquery.sparkline.min.js"></script><!-- scripit init-->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/sparklinechart/sparkline.init.js"></script><!-- scripit init-->
	<!--  Datamap -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/datamap/d3.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/datamap/topojson.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/datamap/datamaps.world.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/datamap/datamap-init.js"></script>
	<!-- // Datamap -->
	<script src="${pageContext.request.contextPath }/static/js/js/lib/weather/jquery.simpleWeather.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/weather/weather-init.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/owl-carousel/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/lib/owl-carousel/owl.carousel-init.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/js/scripts.js"></script><!-- scripit init-->
	<%-- ---------- --%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="header1">
	<ul class="dar">
		<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
		<li><a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAll">所有产品</a></li>
		<li><a href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
		<li><a href="${pageContext.request.contextPath }/Shoppingcar?method=ShoppingcarQueryAll">购物车</a></li>
	</ul>
</div>


    <!--头部 结束-->
    <!--内容 开始-->
	<div class="search_bar clearfix">
		<div class="sub_page_name fl"></div>
		<div class="search_con fr">
			<form action="${pageContext.request.contextPath }/User?method=search" method="post">
				<c:if test="${userInformation!=null }">
					<input type="hidden" name="id" value="${userInformation.id}">
				</c:if>
				<input type="text" class="input_text fl" value="${goodsname}" name="goodsname" placeholder="搜索商品">
				<input type="submit" class="input_btn fr" value="搜索">
        	</form>
		</div>
	</div>
	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="User.jsp" >· 个人信息</a></li>
				<li><a href="${pageContext.request.contextPath }/Order?method=OrderQueryAll" class="active">· 全部订单</a></li>
			</ul>
		</div>
		
		<div class="right_content clearfix">

			<h3 class="common_title2">订单信息</h3>
			<div class="has_view_list">

				<div class="main-content">



					<div class="row">
						<div class="col-lg-10">
							<div class="card alert">
								<div class="card-header">
									<h4 class="mb">
										<a href="${pageContext.request.contextPath }/Order?method=OrderQueryAll"><i class="ti-arrow-circle-left"></i> </a>
										我的订单
									</h4>
								</div>

								<div class="card-body">
									<table class="table table-responsive table-hover ">
										<thead>
										<tr>
											<th style="text-align: center;display: none">ID</th>
											<th style="text-align: center">商品条码</th>
											<th style="text-align: center">商品名称</th>
											<th style="text-align: center">购买数量</th>
											<th style="text-align: center">销售价格</th>
											<th style="text-align: center">订单号</th>
										</tr>
										</thead>
										<tbody>

										<c:forEach var="p" items="${ods}">
											<tr>
												<td style="text-align: center;display: none">${p.id}</td>
												<td style="text-align: center">${p.goodscode}</td>
												<td style="text-align: center" class="color-success">${p.goodsname}</td>
												<td style="text-align: center" class="color-success">${p.buycount}</td>
												<td style="text-align: center" class="color-success">${p.goodsprice}</td>
												<td style="text-align: center" class="color-success">${p.orderid}</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div><!-- /# column -->
					</div><!-- /# row -->

				</div>

			</div>
		</div>
    </div>
	<!--内容 结束-->

<!--底部-->
<div id="footer">
	湖南郴州刘氏茶叶购物网站
</div>
</body>
</html>