$(document).ready(function(){
	//全局AJAX事件开始
	$("#msg").ajaxStart(function(){
		$(this).html("正在登录聊天室中。。。");
	});
	$("#btnLogin").bind("click",function(){
		var name=$("#txtName").val();
		var password=$("#txtPassword").val();//注意在ajax中这样取得值
		if(name == ""){
			alert("用户名不能为空");
			name.focus();
			return false;
		}else if(password == ""){
			alert("密码不能为空");
			password.focus();
			return false;
		}else{
			userLogin(name,password);
		}
	});
});

//ajax登录处理
function userLogin(name,password){
	$.ajax({
		type:"GET",
		url:"login.html",
		data:{"name":name,"password":password},
		dataType:"text",
		success:function(data){
			if(data=="success"){
				//window.location.href="/Login_ssm_mav/user/toChatMain.html";
				window.location.href="/Login_ssm_mav/user/toWaterfullPic.html";
			}else{
				$("#msg").html("用户名或密码错误，请重新登录");
				return false;
			}
		}
	});
}