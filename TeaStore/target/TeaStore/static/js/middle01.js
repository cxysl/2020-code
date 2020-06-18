window.onscroll = function() {
	var header1 = document.getElementById("header1"); //获取导航栏
	var heightTop = document.documentElement.scrollTop || document.body.scrollTop;
	//右下角的箭头
	if(heightTop >= 100) {
		document.getElementById("dh").style.display = "block";
	} else {
		document.getElementById("dh").style.display = "none";
	}
	//导航栏
	if(heightTop >= 100) {
		header1.style.position = "fixed";
		header1.style.top = 0;
		header1.style.left = 0;

	} else {
		header1.style.position = "static";
	}
}