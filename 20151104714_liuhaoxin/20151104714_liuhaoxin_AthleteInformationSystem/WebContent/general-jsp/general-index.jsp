<%--  一般用户的主页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css" type="text/css" media="all">
<title>Insert title here</title>
</head>
<frameset rows="15%,*" frameborder="NO" border="0" framespacing="2">
<frame noresize="noresize" src="general-jsp/general-title.jsp" >
<frameset cols="200,*">
<frame noresize="noresize" src="general-jsp/general-left.jsp">
<frame noresize="noresize" src="general-jsp/general-right.jsp" name="general-right" >
</frameset>
</frameset>
</html>