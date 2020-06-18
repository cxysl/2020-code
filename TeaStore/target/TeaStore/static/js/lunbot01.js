var lunbot=document.getElementsByClassName("lbt01")[0];
var but=document.getElementsByClassName("button01")[0];
var ton=document.getElementsByClassName("button02")[0];
setInterval(function(){
	if(lunbot.offsetLeft==0){
	lunbot.style.left="-100vw";
	}else{
	lunbot.style.left="0";
	}
},5000)
but.onclick=function(){
	if(lunbot.offsetLeft==0){
		lunbot.style.left="-100vw";
	}else{
		lunbot.style.left=0;
	}
}
ton.onclick=function(){
	if(lunbot.offsetLeft==0){
		lunbot.style.left="-100vw";
	}else{
		lunbot.style.left=0;
	}
}