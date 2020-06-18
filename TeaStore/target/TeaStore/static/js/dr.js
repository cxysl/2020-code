function checkLogin() {

 var oUname = document.getElementById("uname")
 var oUpass = document.getElementById("upass")
 var oError = document.getElementById("error_box")
 var isError = true;
 if (oUname.value.length > 20 || oUname.value.length < 6) {
  oError.innerHTML = "用户名请输入6-20位字符";
  isError = false;
  return;
 }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
  oError.innerHTML = "首字符必须为字母";
  return;
 }else
	for(var i=0;i<oUname.value.charCodeAt(i);i++){
  if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
   oError.innerHTML = "必须为字母跟数字组成";
   return;
  }
 }
 
 if (oUpass.value.length > 20 || oUpass.value.length < 6) {
  oError.innerHTML = "密码请输入6-20位字符"
  isError = false;
  return;
 }
 login();
}

function checkRegister() {
	 var oUname = document.getElementById("uname")
	 var oUpass = document.getElementById("upass")
	 console.log(oUname)
	 var oError = document.getElementById("error_box")
	 var isError = true;
	 if (oUname.value.length > 20 || oUname.value.length < 6) {
	  oError.innerHTML = "用户名请输入6-20位字符";
	  isError = false;
	  return;
	 }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
	  oError.innerHTML = "首字符必须为字母";
	  return;
	 }else for(var i=0;i<oUname.value.charCodeAt(i);i++){
	  if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
	   oError.innerHTML = "必须为字母跟数字组成";
	   return;
	  }
	 }
	 
	 if (oUpass.value.length > 20 || oUpass.value.length < 6) {
	  oError.innerHTML = "密码请输入6-20位字符"
	  isError = false;
	  return;
	 }
	
		 register();
	
	}

function login(){
	 var loginForm = document.getElementById("loginForm")
	 loginForm.submit();
	/*$.ajax({
		type:"post",
		url:"UserServlet",
		data:{
			"method":"login",
			"username":$("#uname").val(),
			"password":$("#upass").val()
		},
		dataType:"json",
		complete:function(data){
			var jsonData = eval("("+data.responseText+")");
			var result = jsonData.result;
			if(result!=""){
				alert(result);
			}
			if("REDIRECT" == data.getResponseHeader("REDIRECT")){ //若HEADER中含有REDIRECT说明后端想重定向，
                var win = window;
                while(win != win.top){
                    win = win.top;
                }
                win.location.href = data.getResponseHeader("CONTENTPATH");//将后端重定向的地址取出来,使用win.location.href去实现重定向的要求
                return;
			}
			
			
		}
	});*/
}

function register(){
	var registerForm = document.getElementById("registerForm")
	 registerForm.submit();
	/*$.ajax({
		type:"post",
		url:"user/register",
		data:{
			"username":$("#uname").val(),
			"password":$("#upass").val()
		},
		dataType:"json",
		 beforeSend:function(XMLHttpRequest){
			$("#show").text=data
		} 
		complete:function(data){
			var jsonData = eval("("+data.responseText+")");
			var result = jsonData.result;
			if(result!=""){
				alert(result);
			}
			if("REDIRECT" == data.getResponseHeader("REDIRECT")){ //若HEADER中含有REDIRECT说明后端想重定向，
                var win = window;
                while(win != win.top){
                    win = win.top;
                }
                win.location.href = data.getResponseHeader("CONTENTPATH");//将后端重定向的地址取出来,使用win.location.href去实现重定向的要求
                return;
			}
			
			
		}
	});*/
}