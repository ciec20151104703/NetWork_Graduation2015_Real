<%@page import="com.qst.bean.RecommendBean"%>
<%@page import="java.util.List"%>
<%@page import="com.qst.service.RecommendService"%>
<%@page import="com.qst.service.RecommendServiceimp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息列表</title>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var mymessage = confirm("确定要删除吗？");
		if (mymessage == true) {

			return true;
		} else if (mymessage == false) {
			return false;
		}

	}
</script>
</head>

<body>
	<div align="right">
		欢迎你，${sessionScope.username } &nbsp;&nbsp;&nbsp;<a href="logout.jsp">退出</a>
	</div>
	<h2>商品信息列表</h2>
	<p id="addRec">
		<a href="recommend.jsp"><input type="button" value="添加商品"></a>
	</p>

	<table>
		<tr>
			<td class="listTable" width="100">编号</td>
			<td class="listTable" width="100">商品名</td>
			<td class="listTable" width="100">价格</td>
			<td id="profile" width="200">图片</td>
			<td id="operate">操作</td>
		</tr>
		<%
			session.removeAttribute("list");
			RecommendService recService = new RecommendServiceimp();
			List<RecommendBean> list = recService.getAllRecommend();
			session.setAttribute("list", list);
			for (RecommendBean rec : list) {
		%>

		<tr>
			<td><%=rec.getComid()%></td>
			<td><%=rec.getComname()%></td>
			<td><%=rec.getPrice()%></td>
			<td><%=rec.getPhotoname()%></td>
	
			<td><a href="modifyrec.jsp?comid=<%=rec.getComid()%>">修改&nbsp;</a>
				<a href="../Delrec?comid=<%=rec.getComid()%>"
				onclick="return check()">删除&nbsp;</a></td>
		</tr>
		<%
			}
		%>




	</table>

</body>
</html>