<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>

		<!-- Standard -->
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


		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/logins.css"/>
	</head>
	<body>
		<div id="dh">
			<a href="#"></a>
		</div>
		<!--头部-->
		<div id="header">
			<div class="headerZero">
				<span>湖南郴州刘氏茶叶购物网站</span>
			</div>
		</div>
			<!--注册-->
			<div id="login01">
					<div class="input-states">
						<h4 class="mb">
							<a href=""></a>
							用户注册
						</h4>
						<form action="${pageContext.request.contextPath }/User?method=register" method="post" id="registerForm" class="form-horizontal">

							<input type="hidden" class="form-control" name="isadmin" value="0">
							<div class="form-group has-success">
								<div class="row">
									<label class="col-sm-3 control-label">账号:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="账号" name="accountnumber" value="">
									</div>
								</div>
							</div>
							<div class="form-group has-success">
								<div class="row">
									<label class="col-sm-3 control-label">密码:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="请输入密码" name="pwd" value="">
									</div>
								</div>
							</div>
							<div class="form-group has-success">
								<div class="row">
									<label class="col-sm-3 control-label">用户姓名</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="请输入姓名" name="username" value="">
									</div>
								</div>
							</div>
							<div class="form-group has-success">
								<div class="row">
									<label class="col-sm-3 control-label">收货地址</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="请输入收货地址" name="address" value="">
									</div>
								</div>
							</div>
							<div class="form-group has-success">
								<div class="row">
									<label class="col-sm-3 control-label">手机号</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder="请输入手机号" name="phone" value="">
									</div>
								</div>
							</div>

							<div style="text-align: center">
								<button type="reset" class="btn btn-warning m-b-10 m-l-5" >重置</button>
								<button type="submit" class="btn btn-success  m-b-10 m-l-5" >提交</button>
							</div>
						</form>
					</div>
				<%--<form action="${pageContext.request.contextPath }/User?method=register" method="post" id="registerForm">--%>
					<%--<div class="box01">--%>
						<%--<h2 align="center">注册</h2><br>--%>
						<%--<div id="content">--%>
							<%--<p align="center">账号:--%>
								<%--<input type="text" name="accountnumber" placeholder="账号首字符为字母">--%>
							<%--</p><br>--%>
							<%--<p align="center">密码:--%>
								<%--<input  type="password" name="pwd" placeholder="请输入密码">--%>
							<%--</p><br>--%>
							<%--<p align="center">用户姓名:--%>
								<%--<input  type="password" name="username" placeholder="请输入姓名">--%>
							<%--</p><br>--%>
							<%--<p align="center">收货地址:--%>
								<%--<input  type="password" name="address" placeholder="请输入姓名">--%>
							<%--</p><br>--%>
							<%--<p align="center">手机号:--%>
								<%--<input  type="password" name="phone" placeholder="请输入姓名">--%>
							<%--</p><br>--%>
							<%--<div id="error_box">${error }<br></div><br>--%>
							<%--<button onclick="checkRegister()" type='submit'>注册</button>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</form>--%>
			</div>
				<!--底部-->


		<div id="footer">
			湖南郴州刘氏茶叶购物网站
		</div>
	</body>
</html>
<script src="static/js/middle01.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/dr.js" type="text/javascript" charset="utf-8"></script>
