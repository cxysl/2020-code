<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>湖南郴州刘氏茶叶购物网站</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/culture.css"/>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="header1">
			<ul class="dar">
				<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAll">所有产品</a></li>
				<li><a class="dar01" href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
				<li><a href="${pageContext.request.contextPath }/Shoppingcar?method=ShoppingcarQueryAll">购物车</a></li>
			</ul>
			</div>
			<!--第一张图片-->
			<div id="culture01">
			</div>
				<!--茶道-->
		<div id="ceremony">
			<div class="ceremony">
			<div class="ceremony01"><img src="${pageContext.request.contextPath }/static/img/ceremony01.png"/></div>
			<div class="ceremony02"><img src="${pageContext.request.contextPath }/static/img/ceremony03.png"/></div>
			<div class="ceremony03"><img src="${pageContext.request.contextPath }/static/img/ceremony02.png"/></div>
			</div>
		</div>
		<!--明  前  独  芽图片-->
		<div id="culture02">
			<div>明  前  独  芽</div>
			<div>鲜  爽  回  甘</div>
		</div>
		<!--禅茶一味-->
		<div id="blindly">
			<div><h3>禅茶一味</h3>
				<div><p>浮华过后静心难，</p><p>御上茗中自在安，</p><p>有话则长无话短，</p><p>禅茶一味口间念。</p></div>
			</div>
			<div></div>
		</div>
		<!--品-->
		<div id="pin">
			<img src="${pageContext.request.contextPath }/static/img/pin01.png"/>
			<div class="pin">品</div>
			<div class="pin01">
				<div> 沁 人 心 脾 </div>
				<div> 茶 香 缥 缈 </div>
				
			</div>
		</div>
			<!--底部-->
		<div id="footer">
			湖南郴州刘氏茶叶购物网站
		</div>
	</body>
</html>
<script src="static/js/middle01.js" type="text/javascript" charset="utf-8"></script>