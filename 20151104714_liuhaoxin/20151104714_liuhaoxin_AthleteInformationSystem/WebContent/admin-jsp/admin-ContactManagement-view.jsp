 <%--  管理员查看所有的用户申请（忘记密码和用户受限）  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<title>Insert title here</title>
<script type="text/javascript">
function reason(){
	var b=event.target.id;
	var r=confirm("确定删除此条申请？");
	if (r==true){
		window.location.href="ContactManagementDelete?cid="+b;
	}
	else{
		alert("您取消了删除")
	}
	
}
</script>
</head>
<body>
	<div align="center">
		<table border="0" cellpadding="0" cellspacing="0" style="font-size: 20px" width="100%" height="31">
			<thead>
				<tr>
					<th align="left" valign="middle">情况说明</th>
					<th align="left" valign="middle">申请人</th>
					<th align="left" valign="middle">联系方式</th>
					<th align="left" valign="middle">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userdata}" var="w">
					<tr>
						<td align="left" valign="middle">${w.reason}</td>
						<td align="left" valign="middle">${w.username}</td>
						<td align="left" valign="middle">${w.phone}</td>
						<td align="left" valign="middle">
						
						<td>
					<input type="submit" id=${w.cid} style="width: 150px" onclick="reason()"  value="删除">
					
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>