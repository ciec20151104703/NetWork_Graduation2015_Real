<%--  管理员的菜单页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css" type="text/css" media="all">
<title>Insert title here</title>
</head>
<body>
	<div align="center"><br><br>
		
		<a href="${pageContext.request.contextPath}/SelectMy.action"  target="admin-right">我的信息          </a>   <br><br><br> 
		<a href="${pageContext.request.contextPath}/SelectAll.action"  target="admin-right">所有用户信息          </a>   <br><br><br>
		<a href="${pageContext.request.contextPath}/SelectTc.action"   target="admin-right">老师          </a>   <br><br><br>
		<a href="${pageContext.request.contextPath}/SelectInf.action"  target="admin-right">家长          </a>   <br><br><br>
	    <a href="${pageContext.request.contextPath}/Selectpl.action"  target="admin-right">评论        </a>   <br><br><br>
	</div>
</body>
</html>