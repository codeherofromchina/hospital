<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XXXX医院挂号系统</title>
<script type="text/javascript" src="js/jquery-1.7.2.js" ></script>
<script type="text/javascript">
// 3秒后跳转到首页
$(function(){
	setTimeout(redirectUrl, 3000); 
});
function redirectUrl(){
	 window.location = "index.htm";
}
</script>
</head>
<body>
<img src="img/404.jpg">
</body>
</html>