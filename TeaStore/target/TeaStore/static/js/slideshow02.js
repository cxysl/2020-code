var slideshow002 = document.getElementsByClassName("slideshow002"); //均匀分布的图片
var buttonimg=document.getElementsByClassName("buttonimg")[0];//隐藏的图片div
var butimg=buttonimg.getElementsByTagName("img");
var hide02 = document.getElementById("hide02"); //隐藏的大盒子
var hideClass = document.getElementsByClassName("hide02")[0]; //隐藏居中的div
var divlong = document.getElementById("divlong"); //隐藏div的图片
var divlong01 = document.getElementById("divlong01"); //隐藏div的文字
var shut01 = document.getElementById("shut01"); //关闭
var left01 = document.getElementById("left01"); //隐藏左边的按钮
var right01 = document.getElementById("right01"); //隐藏右边的按钮
var p1 = document.getElementById("p1");//文字
var p2 = document.getElementById("p2");
var p3 = document.getElementById("p3");
var a;
var arrimg = [{
	src: "static/img/productimgs01.jpg",
	p1: "西湖龙井 正宗味道普及款 绿茶",
	p2: "龙井",
	p3: "45克/罐"
}, {
	src: "static/img/productimgs02.jpg",
	p1: "新茶 明前特级贡韵西湖龙井 鲜醇甘爽",
	p2: "龙井",
	p3: "45克/罐"
}, {
	src: "static/img/productimgs03.jpg",
	p1: "明前特级黄山毛峰 鲜美醇爽 茶叶 80克/罐",
	p2: "黄山毛峰",
	p3: "80克/罐"
}, {
	src: "static/img/productimgs04.jpg",
	p1: "新茶 雨前一级安吉白茶 鲜爽浓厚",
	p2: "安吉白茶",
	p3: "45克/罐"
}, {
	src: "static/img/productimgs05.jpg",
	p1: "新茶 雨前西湖龙井 靠谱茶 醇厚回甘",
	p2: "龙井",
	p3: "45克/罐"
}, {
	src: "static/img/productimgs06.jpg",
	p1: "菊博士胎菊王 桐乡杭白菊 菊花茶 80克/罐",
	p2: "菊花茶",
	p3: "80克/罐"
}, {
	src: "static/img/productimgs07.jpg",
	p1: "桂花茶 回味清甘 杭州西子特产 花草茶 75克/罐",
	p2: "花茶",
	p3: "75克/罐"
}, {
	src: "static/img/productimgs08.jpg",
	p1: "茉莉花茶 清甜淡雅 广西横县产 花草茶 45克/罐",
	p2: "花茶",
	p3: "45克/罐"
}, {
	src: "static/img/productimgs09.jpg",
	p1: "洋甘菊 甘醇适口 花草茶 60克/罐",
	p2: "花草茶",
	p3: "60克/罐"
}, {
	src: "static/img/productimgs10.jpg",
	p1: "金银花 河南封丘产 花草茶 70克/罐",
	p2: "花草茶",
	p3: "70克/罐"
}, {
	src: "static/img/productimgs11.jpg",
	p1: "红枸杞子 温润味甘 宁夏中宁产 花草茶",
	p2: "花草茶",
	p3: "70克/罐"
}, {
	src: "static/img/productimgs12.jpg",
	p1: "黑苦荞茶 醇厚回甘 四川凉山产 荞麦茶",
	p2: "荞麦茶",
	p3: "70克/罐"
}];
for(var i=0;i<slideshow002.length;i++){
	slideshow002[i].index=i;
	slideshow002[i].onclick = function() {
		hide02.style.display = "block";
		a=this.index;
		 aa(a);
		tiHuan(a);
	}
}
function aa01(b){
			for (i in butimg) {
			butimg[i].in=i;
			butimg[i].onclick=function(){
				a=Number(this.in)+b
				tiHuan(a)
			}
		}
		}
function aa(a){
	
	if(a<6) {
		
		buttonimg.innerHTML=`				
			<img src="${arrimg[0].src}"/>
			<img src="${arrimg[1].src}"/>
			<img src="${arrimg[2].src}"/>
			<img src="${arrimg[3].src}"/>
			<img src="${arrimg[4].src}"/>
			<img src="${arrimg[5].src}"/>
		`;
		
		aa01(0);
	} else{
		b=6;
		buttonimg.innerHTML=`
			<img src="${arrimg[6].src}"/>
			<img src="${arrimg[7].src}"/>
			<img src="${arrimg[8].src}"/>
			<img src="${arrimg[9].src}"/>
			<img src="${arrimg[10].src}"/>
			<img src="${arrimg[11].src}"/>
		`;
		aa01(6);
}	
}

	/*关闭*/
	shut01.onclick = function() {
		hide02.style.display = "none";
	}
	hideClass.onclick = function(event) {
		/*阻止冒泡事件*/
		event.stopPropagation();
	}
	hide02.onclick = function() {
		hide02.style.display = "none";
	}

/*左边按钮*/
left01.onclick = function() {
	if(a>= 6) {
		if(a == 11) a=6;
		else a++;
	} else{
		if(a == 5) a=0;
		else a++;
	}
tiHuan(a);
}
//右边按钮
right01.onclick = function() {
	if(a >= 6) {
		if(a == 6) a=11;
		 else a--;
	} else {
		if(a == 0) a=5;
		else a--;
	}
	tiHuan(a);
}
function tiHuan(a){
		divlong.innerHTML = `
				<img src="${arrimg[a].src}"/>
		`;
		p1.innerHTML=`
				<span>${arrimg[a].p1}</span>
		`;
		p2.innerHTML=`
				<span>${arrimg[a].p2}</span>
		`;
		p3.innerHTML=`
				<span>${arrimg[a].p3}</span>
		`;
}
