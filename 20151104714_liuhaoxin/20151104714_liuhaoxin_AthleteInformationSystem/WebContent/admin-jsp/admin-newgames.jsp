<%--  管理员创建运动会 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<title>Insert title here</title>
</head>
<body>
<div class="yongdonghui">
	<form action="GameAdd" method="post">
		<input type="text" name=gamesname placeholder="运动会名字" required=""><br>
		<h4>选择记录员<select name="username">
				<c:forEach items="${userbean}" var="w">
					<option value="${w.username}">${w.username}</option>
				</c:forEach>
					</select><br>
			开始时间<input type="date" name=date1 placeholder="开始时间" required=""><br>
			结束时间<input type="date" name=date2 placeholder="结束时间" required="">
		</h4>
		<input type="submit" value="创建">
	</form>
</div>
</body>
</html>