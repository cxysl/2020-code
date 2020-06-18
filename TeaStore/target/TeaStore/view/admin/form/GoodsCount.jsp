<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>湖南郴州刘氏茶叶购物网站</title>
    <link rel="stylesheet" type="text/css" href="../../../static/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../../static/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="../../../static/css/middle.css"/>
    <script src="../../../static/js/middle01.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../../static/js/lunbot01.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../../static/js/slideshow02.js" type="text/javascript" charset="utf-8"></script>

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

    <jsp:include page="../head.jsp"></jsp:include>
    <div id="header1">
        <ul class="dar">
            <li><a href="${pageContext.request.contextPath }/User?method=UserQueryAll">顾客管理</a></li>
            <li><a class="dar01" href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAllAdmin">商品管理</a></li>
            <li><a href=" ">订单管理</a></li>
        </ul>
    </div>


    <div class="main-content">
        <div class="row">
            <div class="col-lg-6">
                <div class="card alert">
                    <div class="card-header">
                    </div>
                    <div class="card-body">

                        <div class="input-states">

                            <%--采购操作--%>
                            <h4 class="mb">
                                <a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAllAdmin"><i class="ti-arrow-circle-left"></i> </a>
                                商品进库存
                            </h4>
                            <c:if test="${goods1!=null }">
                                <input type="hidden" name="id" value="${goods1.id}">
                                <form action="${pageContext.request.contextPath }/Goods?method=GoodsCount&id=${goods1.id}&count=2" method="post" class="form-horizontal">

                                    <div class="form-group has-success">
                                        <div class="row">
                                            <label class="col-sm-3 control-label">商品名称</label>
                                            <div class="col-sm-9">
                                                <input type="text" disabled="disabled" class="form-control" placeholder="商品名称" name="goodsname" value="${goods1.goodsname}">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group has-success">
                                        <div class="row">
                                            <label class="col-sm-3 control-label">采购数量</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="库存量" name="goodsCount2" value="${goods1.count}">
                                            </div>
                                        </div>
                                    </div>



                                    <div style="text-align: center">
                                        <button type="reset" class="btn btn-warning m-b-10 m-l-5" >重置</button>
                                        <button type="submit" class="btn btn-info m-b-10 m-l-5" >提交</button>
                                    </div>
                                </form>
                            </c:if>

                            <%--我要的--%>
                        </div>


                    </div>
                </div>
            </div>
        </div><!-- / -->

    </div>


    <!--底部-->
    <%--<div id="footer">--%>
    <%--湖南郴州刘氏茶叶购物网站--%>
    <%--</div>--%>


</body>
</html>
