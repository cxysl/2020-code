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
		<a href="index.html" class="logo fl"><img src=""></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
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
				<li><a href="User.jsp" class="active">· 个人信息</a></li>
				<li><a href="${pageContext.request.contextPath }/Order?method=OrderQueryAll">· 全部订单</a></li>
			</ul>
		</div>
		
		<div class="right_content clearfix">
			<div class="info_con clearfix">
				<h3 class="common_title2">基本信息</h3>
				<ul class="user_info_list">
					<c:if test="${userInformation!=null }">
					<input type="hidden" name="id" value="${userInformation.id}">
					<li><span>用户名：</span>${userInformation.username}</li>
					<li><span>登录账号：</span>${userInformation.accountnumber}</li>
					<li><span>收货地址：</span>${userInformation.address}</li>
					<li><span>手机号：</span>${userInformation.phone}</li>
					</c:if>
				</ul>
			</div>
				
			<h3 class="common_title2">推荐商品</h3>
			<div class="has_view_list">
			<ul class="goods_type_list clearfix">
				<c:forEach items="${goods}" var="goods">
					<li>
						<a href=""><img src="${pageContext.request.contextPath }/${goods.goodspicture}"></a>
						<h4><a href="">${goods.goodsname}</a></h4>
						<div class="operate">
							<span class="prize">${goods.saleprice}</span>
							<span class="unit">${goods.goodspecs}</span>
							<a href="#" class="add_goods" title="加入购物车"></a>
						</div>
					</li>
				</c:forEach>
			</ul>
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