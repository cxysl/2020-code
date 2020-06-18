<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>湖南郴州刘氏茶叶购物网站</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>


	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/reset.css"/>
	<script src="static/js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/allproducts.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<div id="header1">
		<ul class="dar">
			<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
			<li><a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAll">所有产品</a></li>
			<li><a href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
			<li><a class="dar01" href="${pageContext.request.contextPath }/Shoppingcar?method=ShoppingcarQueryAll">购物车</a></li>
		</ul>
	</div>


	<div class="total_count">全部商品<em>3</em>件</div>
	<ul class="cart_list_th clearfix">
		<li class="col01">商品名称</li>
		<li class="col02"></li>
		<li class="col03">商品单价</li>
		<li class="col04">数量</li>
		<li class="col05">小计</li>
		<li class="col06">操作</li>
	</ul>
     <form id="profrom" action="" method="post">
	<c:forEach	items="${shoppingcar}" var="g">
		<ul class="cart_list_td clearfix" id="232">
			<li class="col01"><input type="checkbox" name="product" value="${g.id}" checked="">
			<input type="hidden" id="goodscode${g.id}" value="${g.goodscode}">
			</li>
			<li class="col02"><img src="${pageContext.request.contextPath }/${g.goodspicture}"></li>
			<li class="col03">${g.goodsdescribe}</li>
			<li class="col04"></li>
			<li class="col05">${g.goodsprice}</li>
			<li class="col06">
				<div class="num_add">
					<a href="javascript:;" class="add fl" onclick="forward('${pageContext.request.contextPath }/Shoppingcar?method=buyCount&id=${g.id}&op=j')">+</a>
					<input id="num${g.id}" type="text" class="num_show fl" value="${g.buycount}">
					<a href="javascript:;" class="minus fl" onclick="forward('${pageContext.request.contextPath }/Shoppingcar?method=buyCount&id=${g.id}&op=jian')">-</a>
					<span class="kucun" style="display: none">978</span>
					<span class="goodsid" style="display: none">44</span>
				</div>
			</li>
			<li class="col07">${g.goodsprice}</li>
			<li class="col08"><a onclick="forward('${pageContext.request.contextPath }/Shoppingcar?method=delshopping&id=${g.id}')">删除</a></li>
		</ul>
	</c:forEach>
	 </form>

	<script>
        function forward(url) {
            window.location.replace(url);
        }
        var myobj = {
            proid:[],
            goodscode:[],
			pronum:[],
			total:0
		};
        function profrom() {

            myobj.total = $('#zong').html();
            $('input[type=checkbox][name=product]').each(function (index,item) {
                console.log("1111")
                 if($(this).is(':checked')){
				     var pid = $(this).val();
				     var str = '#num'+pid;
					 var num = $(str).val();
					 var str2 = '#goodscode'+pid;
					 var goodscode = $(str2).val();
				     myobj.proid.push(pid);
				     myobj.pronum.push(num);
				     myobj.goodscode.push(goodscode);
                 }
            })
			console.log(myobj);
            $.ajax({
				url:'${pageContext.request.contextPath }/Order?method=addOrder',
				type:'post',
				data: myobj,
				success:function () {
                    console.log("success");
                    forward('${pageContext.request.contextPath }/Order?method=OrderQueryAll');
                }
			});
			//$("#profrom").submit();
        }
	</script>

	

	<ul class="settlements">
		<li class="col01"><input type="checkbox" id="check_all" name="" checked=""></li>
		<li class="col02">全选</li>
		<li class="col03">合计(不含运费)：<span>¥</span><em id="zong">365.90</em><br>共计<b id="zongshu">3</b>件商品</li>
		<li class="col04"><a href="javascript:;" id="jiesuan" style="background-color: rgb(255, 61, 61);" onclick="profrom()">去结算</a></li>
	</ul>

	<!--底部-->
	<%--<div id="footer">--%>
		<%--湖南郴州刘氏茶叶购物网站--%>
	<%--</div>--%>
</body>
</html>
<script type="text/javascript" src="js/shop.js"></script>
