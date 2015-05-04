/**
 * 
 */

var fileName;
$(document).ready(function(){
	var currentFile,
		index;
	//下面直接取的页面上提交按钮旁边显示的文件名
	/*$("#pclick").bind("click",function(){
		currentFile = document.getElementById("inputFile").value;
		index = currentFile.lastIndexOf("\\");
		fileName = currentFile.substring(index+1);
		photo();
		//return false，会造成得不到文件的内容，我利用一个隐藏的iframe来放置内容
	});*/
	
	/*下面这种方式真正实现了从后台传递到前台的数据*/
	$('#uploadForm').submit(function(){
		$(this).ajaxSubmit({
			type:'post',
			url:'addAction.do',
			success:function(data){
				fileName=eval(data);
				alert("提交成功:"+data);
			}
		});
		return false;//阻止表单默认提交
	});
	
	$("#getdata").bind('click',function(){
		getDataFromFile(fileName);
	});
});

/*--------------------------------获得后台传过来的json格式的数据---------------------------------------------*/
/*function photo(){
	var val;
	$.ajax({
		async:false,
		type:'get',//get是获取数据，post是带数据的向服务器发送请求
		url:'addAction.do',
		dataType:'json',
		success:function(data){
			val=eval(data);//转换成js对象
			alert(val.length);
			alert(val[2].name);
			alert(data);
		},
		error:function(data){
			alert("JSON数据获取失败，请联系管理员！");
		}
	});
}*/
/*-----------------------------------------------------------------------------------*/

/*-----------------获得后台传过来的数据，但是这种情况下实现了两次ajax请求，第一次是form表单的action,第二次是下面的ajax中定义的url请求-----------------------------------------------------------------*/
function photo(){
	$.ajax({
		async:false,//同步，意思是当有返回值以后才会进行后面的js程序
		type:'get',//get是获取数据，post是带数据的向服务器发送请求
		url:'addAction.do',
		//dataType:'text',
		success:function(data){
			var val=eval(data);//转换成js对象
			alert("文件上传成功："+val);
		},
		error:function(data){
			alert("文件上传失败，请重新上传！");
		}
	});
}


/*总结下这里，要想通过$.get('/Login_ssm_mav_waterfull/kzn.csv')这样来取得文件，应该将文件上传到服务器的项目路径下，后台中获得的地址
 * 为String path = request.getSession().getServletContext().getRealPath("/"); 而不是写在配置文件中定义的绝对地址*/
function getDataFromFile(name){
	$.get('/Login_ssm_mav_waterfull/'+name,function(csvString){
		$('#display').html(csvString); 
	});
}