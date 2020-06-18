<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>湖南郴州刘氏茶叶购物网站</title>
		<link rel="stylesheet" type="text/css" href="../../static/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="../../static/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="../../static/css/middle.css"/>
		<script src="../../static/js/middle01.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../static/js/lunbot01.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../static/js/slideshow02.js" type="text/javascript" charset="utf-8"></script>
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


	<script>
        function forword(url) {
            window.location.replace(url);
        }
	</script>


	<body>
		
		<jsp:include page="head.jsp"></jsp:include>
		<div id="header1">
			<ul class="dar">
				<li><a href="${pageContext.request.contextPath }/User?method=UserQueryAll">顾客管理</a></li>
				<li><a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAllAdmin">商品管理</a></li>
				<li><a class="dar01" href="${pageContext.request.contextPath }/Order?method=OrderQueryAllAdmin">订单管理</a></li>
			</ul>
		</div>


		<div class="main-content">



			<div class="row" style="margin-left: 180px;">
				<div class="col-lg-10">
					<div class="card alert">
						<div class="card-header">
							<h4>订单信息表</h4>

						</div>

						<div class="card-body">
							<table class="table table-responsive table-hover ">
								<thead>
								<tr>
									<th style="text-align: center;display: none">ID</th>
									<th style="text-align: center">订单ID</th>
									<th style="text-align: center">顾客ID</th>
									<th style="text-align: center">顾客名字</th>
									<th style="text-align: center">订单总金额</th>
									<th style="text-align: center">下单时间</th>
									<th style="text-align: center">订单状态</th>
									<th style="text-align: center">操作</th>
								</tr>
								</thead>
								<tbody>

								<c:forEach var="p" items="${orders}">
									<tr>
										<td style="text-align: center;display: none">${p.id}</td>
										<td style="text-align: center">${p.orderid}</td>
										<td style="text-align: center" class="color-success">${p.userid}</td>
										<td style="text-align: center" class="color-success">${p.username}</td>
										<td style="text-align: center" class="color-success">${p.orderprice}</td>
										<td style="text-align: center" class="color-success">${p.orderdate}</td>
										<td style="text-align: center" class="color-success">
											<c:if test="${p.orderstate==1}">已支付</c:if>
											<c:if test="${p.orderstate==0}">待付款</c:if>
										</td>
										<td style="text-align: center">
											<button type="button" onclick="forword('${pageContext.request.contextPath }/Orderdetails?method=OrderdetailsQueryAllAdmin&id=${p.orderid}')" class="btn btn-info btn-outline btn-xs">查看订单明细</button>
											<button type="button" onclick="forword('${pageContext.request.contextPath }/User?method=adminQueryOneUser&userId=${p.userid}')" class="btn  btn-info btn-outline btn-xs">查看顾客信息</button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div><!-- /# column -->
			</div><!-- /# row -->

		</div>


		<!--底部-->
		<%--<div id="footer">--%>
			<%--湖南郴州刘氏茶叶购物网站--%>
		<%--</div>--%>


	</body>
</html>
