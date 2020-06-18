<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/logins.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="header1">
    <ul class="dar">
        <li><a class="dar01" href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath }/Goods?method=queryWithPage">所有产品</a></li>
        <li><a href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
        <li><a href="${pageContext.request.contextPath }/view/shop.jsp">购物车</a></li>
    </ul>
</div>
