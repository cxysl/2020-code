<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="dh">
			<a href="#"></a>
		</div>
		<!--头部-->
		<div id="header">
			<div class="headerZero">
				<span>湖南郴州刘氏茶叶购物网站</span>
				<ul>
					<c:if test="${loginUser==null }">
						<li><a href="${pageContext.request.contextPath }/view/login/login.jsp">登录</a></li>
						<li><a href="${pageContext.request.contextPath }/view/register.jsp">注册</a></li>
					</c:if>
					
					<c:if test="${loginUser!=null }">
						<div style="display: none">${loginUser.id}</div>
						<li><a href="${pageContext.request.contextPath }/User?method=userInformation&flag=y&id=${loginUser.id}">用户名：${loginUser.username }</a></li>
						<li><a href="${pageContext.request.contextPath }/User?method=logout">退出登录</a></li>
					</c:if>
					
				</ul>
				
			</div>
		</div>

</body>
</html>