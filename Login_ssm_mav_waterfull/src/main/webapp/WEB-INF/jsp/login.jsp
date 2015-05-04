<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
@CHARSET "UTF-8";
/*全局控制*/
* {
	margin: 0;
	padding: 0;
}

body {
	font-size: 12px;
	font-family: "宋体";
	text-align: center;
}

a {
	color: #e3e3e3;
	background-color: #606870;
}

ul {
	list-style: none; /*list-style 简写属性在一个声明中设置所有的列表属性*/
	margin: 10px auto;
}

li {
	margin: 3px 1px;
	line-height: 24px;
	height: 24px;
}

li:hover {
	background-color: #eee;
}

button {
	line-height: 24px;
	height: 26px;
}

fieldset {
	height: 120px;
	width: 250px;
	padding: 5px;
}

label {
	width: 80px;
	float: left;
	text-align:
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js"></script>
</head>
<body>
	<fieldset>
		<legend>登录</legend>
		<!-- 在字段集包含的文本和其它元素外面画一个方框 -->
		<ul>
			<li><span>用户名:</span><input type="text" id="txtName" /></li>
			<li><span>密码:</span><input type="password" id="txtPassword" /></li>
			<li>
				<button id="btnLogin">登录</button>
				<button id="btnReset" type="reset">重置</button>
			</li>
		</ul>
		<span id="msg"></span>
	</fieldset>
	<!-- legend域标题  在 fieldSet 对象绘制的方框内插入一个标题 -->
</body>
</html>