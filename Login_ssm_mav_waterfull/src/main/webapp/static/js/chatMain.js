$(function(){
	initFace();//初始化表情
	getMessageList();//取得聊天信息
	getOnlineList();//取得在线人员
	
	/**
	 * 点击按钮发送
	 */
	$("#btnSend").bind("click",function(){
		var $content=$("#txtContent");
		if($content.val()!=""){
			sendContent($content.val());
		}else{
			alert("发送内容不能为空");
			$content.focus();
			return false;
		}
	});
	/**
	 * 点击表情图标
	 */
	$("table tr td img").bind("click",function(){
		var $strContent=$("#txtContent").val()+"<:"+this.id+":>";
		$("#txtContent").val(strContent);
	});
});

/**
 * 发送聊天内容函数
 */
function sendContent(content){
	$.ajax({
		type:"get",
		data:{"content":content},
		url:"sentContent.html",
		dataType:"text",
		success:function(data){
			if(data="success"){
				getMessageList();
				$("#txtContent").val("");
			}else{
				alert("发送失败");
				return false;
			}
		}
	});
}
/**
 * 取得聊天内容数据
 */

function getMessageList(){
	$.ajax({
		type:"get",
		url:"getMessageList.html",
		dataType:"text",
		success:function(data){
			$("#divContent").html(data);
		}
	});
	autoUpdContent()//定时获取聊天信息
}
/**
 * 获得在线用户
 */
function getOnlineList(){
	$.ajax({
		type:'get',
		url:'getOnlineList.html',
		dataType:'text',
		success:function(data){
			alert("zhsi"+data);
			$("#divOnLine").html(data)
		}
	});
}

/**
 * 设置图标表情函数
 */
function initFace(){
	var strHTML="";
	for(var i=1;i<=2;i++){
		strHTML+="<img src='/static/pic/"+i+".jpg' id='"+i+"'/>";
	}
	$("#divFace").html(strHTML);
	alert(document.getElementById("divFace").innerHTML);
}
/*
 * 定时返回聊天内容和在线人数
 */
function autoUpdContent(){
	setTimeout(getMessageList,5000);
	setTimeout(getOnlineList,6000);
}
