<<<<<<< HEAD
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
<title>Register</title>
<!-- Custom Theme files -->
<link href="<%=basePath%>css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<script>
		function check(){
			var email = $("#email").val();
			var userPass = $("#userPass").val();
			if(email==""||userPass==""){
				alert("账号密码为空");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<div class="login">
	<h2>Register Form</h2>
	<div class="login-top">
		<h1>REGISTER FORM</h1>
		<form action="${pageContext.request.contextPath}/register.action" method="post">
			<input type="text" id="userName" name="userName" value="username"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'userName';}">
	    	<input type="text" id="Gender" name="Gender" value="Gender"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Gender';}">
	    	<input type="text" id="Phone" name="Phone" value="Phone"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone';}">
	    	<input type="text" id="Email" name="Email" value="Email"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
	    	<input type="password" placeholder="Password" id="userPass" name="userPass"value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
	    <div class="forgot">
	    	<a href="#">forgot Password</a>
	    	<span>
	    		<a>${msg}</a>
	    	</span>
	    	<input type="submit" value="submit" >
	    </div>
	    </form>
	</div>
	<div class="login-bottom">
		<h3>New User &nbsp;<a href="${pageContext.request.contextPath}/login.action">Login</a>&nbsp; Here</h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy;  2018.内蒙古师范大学.网络编程.马宁博</p>
</div>
=======
<<<<<<< HEAD
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
<title>Register</title>
<!-- Custom Theme files -->
<link href="<%=basePath%>css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="login">
	<h2>Acced Form</h2>
	<div class="login-top">
		<h1>Register FORM</h1>
		<form action="${pageContext.request.contextPath}/register.action" method="post">
			<input type="text" id="email" name="email" value="username"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}">
			<input type="password" placeholder="Password" id="userPass" name="userPass"value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
	    	  <div class="forgot">
	    	<a href="#">forgot Password</a>
	    	<input type="submit" value="submit" >
	    </div>
	</div>
	</form>
	<div class="login-bottom">
		<h3>New User &nbsp;<a href="${pageContext.request.contextPath}/register.action">Login</a>&nbsp Here</h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy;  2018.内蒙古师范大学.网络编程.</p>
</div>


</body>
=======
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
<title>Register</title>
<!-- Custom Theme files -->
<link href="<%=basePath%>css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
	<script>
		function check(){
			var email = $("#email").val();
			var userPass = $("#userPass").val();
			if(email==""||userPass==""){
				alert("账号密码为空");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<div class="login">
	<h2>Acced Form</h2>
	<div class="login-top">
		<h1>Register FORM</h1>
		<form action="${pageContext.request.contextPath}/register.action" method="post">
			<input type="text" id="email" name="email" value="username"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}">
			<input type="password" placeholder="Password" id="userPass" name="userPass"value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
	    
	    <div class="forgot">
	    	<a href="#">forgot Password</a>
	    	<input type="submit" value="submit" >
	    </div>
	</div>
	</form>
	<div class="login-bottom">
		<h3>New User &nbsp;<a href="${pageContext.request.contextPath}/register.action">Login</a>&nbsp Here</h3>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy;  2018.内蒙古师范大学.网络编程.</p>
</div>


>>>>>>> refs/heads/master1
</body>
>>>>>>> refs/remotes/origin/master
</html>