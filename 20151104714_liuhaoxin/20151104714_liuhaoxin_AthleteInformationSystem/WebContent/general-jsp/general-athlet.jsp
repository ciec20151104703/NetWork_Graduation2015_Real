<%-- 一般用户查看运动员信息 --%>
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
<form action="GeneralAthletesQuery" method="post">
			<table border="0" cellpadding="0" cellspacing="0" style="font-size: 20px"  width="50%" height="31" >
		<tr>
		<td>
		<h3>项目:</h3></td><td>
				<select name="events">
				<option value="所有信息">所有信息</option>
				<c:forEach items="${abe}" var="w">
					<option value="${w.events}">${w.events}</option>
				</c:forEach>
					</select>
					</td>
			<td>	<input type="submit" value="查询"></td>
		</tr>
		</table>
	</form>
<table border="2" cellpadding="0" cellspacing="0"
		style="font-size: 40px" width="100%" height="100%">
		<thead>
			<tr>          
				<th>运动员名字</th>
				<th>班级</th>
				<th>项目</th>
				<th>成绩</th>
				<th>排名</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mea}" var="w">
				<tr align="center">
				<td>${w.athletusername}</td>
				<td>${w.theclass}</td>
				<td>${w.events}</td>
				<td>${w.results}</td>
				<td>${w.ranking}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>