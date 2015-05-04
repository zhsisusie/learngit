<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/photo.js"></script>
<title>upLoadFile</title>
</head>
<body>
<!-- addAction.do -->
 <!--  <form id="uploadForm" action="addAction.do" method="post" enctype="multipart/form-data" target="hiddenFrame">  -->
 <form id="uploadForm"   enctype="multipart/form-data" target="hiddenFrame">
 <table>
 	<tr>
 		<td width="100" align="right">照片:</td>
 		<td><input type="file" name="photo" id="inputFile"/>
 		<!--  <iframe name="hiddenFrame" style="display:none"></iframe> --><!-- 利用表单请求之后返回false,就阻止表单默认提交 -->
 		</td> 
 	</tr>
 </table>
  <input type="submit" id="pclick"/> 
 </form>
 <button id="getdata"></button>
 <div id="display"></div>
</body>
</html>