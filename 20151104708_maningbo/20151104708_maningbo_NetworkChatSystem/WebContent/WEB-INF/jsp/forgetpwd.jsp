<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<!-- Custom Theme files -->
<link href="<%=basePath%>css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
<div class="login">
	<h2>Login Form</h2>
	<div class="login-top">
		<h1>LOGIN FORM</h1>
		<form  action="${pageContext.request.contextPath}/send.action" method="post" onsubmit="return check()">
			<input type="text" id="email" name="email" value="email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'email';}">
	    <div class="forgot">
	    	<span>
	    		<a>${msg}</a>
	    	</span>
	    	<input type="submit" value="获取验证码" >
	    </div>
	</form>
	</div>
	<div class="login-bottom">
		<h3>New User &nbsp;<a href="${pageContext.request.contextPath}/register.action">Register</a>&nbsp; Here</h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy; 2018.内蒙古师范大学.网络编程.马宁博</p>
</div>
</body>
</html>