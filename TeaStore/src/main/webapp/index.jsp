<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>湖南郴州刘氏茶叶购物网站</title>
		<link rel="stylesheet" type="text/css" href="static/css/reset.css"/>
		<link rel="stylesheet" type="text/css" href="static/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="static/css/middle.css"/>
	</head>
	<body>
		
		<jsp:include page="view/header.jsp"></jsp:include>
		<div id="header1">
				<ul class="dar">
					<li><a class="dar01" href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/Goods?method=GoodsQueryAll">所有产品</a></li>
					<li><a href="${pageContext.request.contextPath }/view/culture.jsp">茶文化</a></li>
					<li><a href="${pageContext.request.contextPath }/Shoppingcar?method=ShoppingcarQueryAll">购物车</a></li>
				</ul>
			</div>
	<!--轮播图-->
		<div id="header02">
			<div class="lbt01">
			<div class="lbt02">
			<div>
				
			</div>
			</div>
			<div class="lbt03">
			<div>
				
			</div>
			</div>
			</div>
			<div class="button01"><div></div></div>
			<div class="button02"><div></div></div>
		</div>
		<!--茶道-->
		<div id="ceremony">
			<div class="ceremony">
			<div class="ceremony01"><img src="static/img/ceremony01.png"/></div>
			<div class="ceremony02"><img src="static/img/ceremony03.png"/></div>
			<div class="ceremony03"><img src="static/img/ceremony02.png"/></div>
			</div>
		</div>
		<!--大红袍-->
		<div id="clovershrub">
			<div id="clovershrub01">
			<div class="clovershrub">
			<p>大红袍 铁罗汉 武夷水仙</p>
			<p>位于福建崇安东南部的武夷山，大红袍是武夷岩茶中的“王者”，</p>
			<p>铁罗汉出现于公元1782年，铁罗汉茶树长于武夷山内山（岩山）岩石中，形成其独特的风味。</p>
			<p>武夷水仙是历史上较为有名的茶品，成茶品后，干茶条索肥壮、呈绿褐色油润有宝色泽，部分茶叶叶背出现沙粒，叶脉清晰，冲泡后，茶汤呈现深橙黄色且汤色浓艳，茶香清扬，兰花香显著，入口滋味醇爽，汤中花香明显</p>
			<p>其中以大红袍而闻名</p>
			</div>
			<img src="static/img/lovershrub02.png" class="clovershrub02"/>
			</div>
			
		</div>
		<!--产品01-->
		<div id="product">
			<div class="product01">
				<div class="productimg">
					<img src="static/img/productimg01.jpg"/>
				</div>
				<div class="productimgs">
					<div class="slideshow002">
						<img src="static/img/productimgs01.jpg"/>
						<div>西湖龙井 正宗味道普及款 绿茶</div>
					</div >
					<div class="slideshow002">
						<img src="static/img/productimgs02.jpg"/>
						<div>新茶 明前特级贡韵西湖龙井 鲜醇甘爽</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs03.jpg"/>
						<div>明前特级黄山毛峰 鲜美醇爽 茶叶 80克/罐</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs04.jpg"/>
						<div>新茶 雨前一级安吉白茶 鲜爽浓厚	</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs05.jpg"/>
						<div>新茶 雨前西湖龙井 靠谱茶 醇厚回甘</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs06.jpg"/>
						<div>菊博士胎菊王 桐乡杭白菊 菊花茶 80克/罐</div>
					</div>
				</div>
			</div>
		</div>
		<!--好茶-->
		<div id="niceTea">
			<div class="nicetea">
				<h3>诚心诚意做好茶</h3>
				<p>用心做品质好茶，确保每一颗茶叶的健康和安全，我们在国内外市场上赢得了良好的美誉度！</p>
				<div>
					<div>
						<img src="static/img/niceTea01.jpg"/>
						<p>选择茶菁优良品种，良好的栽培</p>
							<p>和管理</p>
					</div>
					<div>
						<img src="static/img/niceTea02.jpg"/>
						<p>把握茶菁采摘时机与方法，采得茶菁</p>
							<p>要妥善处理</p>
					</div>
					<div>
						<img src="static/img/niceTea03.jpg"/>
						<p>晒青→摇青→炒青→揉捻→包捻</p>
							<p>→焙干→挑梗→包装</p>
					</div>
				</div>
			</div>
		</div>
		<!--产品02-->
		<div id="product">
			<div class="product01">
				<div class="productimg">
					<img src="static/img/productimg02.jpg"/>
				</div>
				<div class="productimgs">
					<div class="slideshow002">
						<img src="static/img/productimgs07.jpg"/>
						<div>桂花茶 回味清甘 杭州西子特产 花草茶 75克/罐</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs08.jpg"/>
						<div>茉莉花茶 清甜淡雅 广西横县产 花草茶 45克/罐</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs09.jpg"/>
						<div>洋甘菊 甘醇适口 花草茶 60克/罐</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs10.jpg"/>
						<div>金银花 河南封丘产 花草茶 70克/罐</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs11.jpg"/>
						<div>红枸杞子 温润味甘 宁夏中宁产 花草茶</div>
					</div>
					<div class="slideshow002">
						<img src="static/img/productimgs12.jpg"/>
						<div>黑苦荞茶 醇厚回甘 四川凉山产 荞麦茶</div>
					</div>
				</div>
			</div>
		</div>
		<!--品-->
		<div id="pin">
			<img src="static/img/pin01.png"/>
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
		<!--隐藏的轮播图-->
		<div id="hide02">
			<div class="hide02">
				<a href="javascript:;" id="shut01"></a>
				<a href="Javascript:;" id="left01"></a>
				<a href="Javascript:;" id="right01"></a>
				<div id="hideSlideshow2">
					<div id="divlong">
					<img src=""/>
					</div>
					<div id="divlong01">
						<p id="p1"><span></span></p>
						<div></div>
						<p>类&nbsp;&nbsp;&nbsp;&nbsp;型&nbsp;&nbsp;:&nbsp;&nbsp;<span id="p2"></span></p>
						<p>规&nbsp;&nbsp;&nbsp;&nbsp;格&nbsp;&nbsp;:&nbsp;&nbsp;<span id="p3"></span></p>
						<p>品&nbsp;&nbsp;&nbsp;&nbsp;牌&nbsp;&nbsp;:&nbsp;&nbsp;Tea Design</p>
					</div>
				</div>
				<div class="buttonimg">
					
				</div>
			
			</div>
		</div>
	</body>
</html>
<script src="static/js/middle01.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/lunbot01.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/slideshow02.js" type="text/javascript" charset="utf-8"></script>