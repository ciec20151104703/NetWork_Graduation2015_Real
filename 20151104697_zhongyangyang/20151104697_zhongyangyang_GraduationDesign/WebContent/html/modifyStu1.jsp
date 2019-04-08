<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.qst.service.StudentServiceimp"%>
<%@page import="com.qst.service.StudentService"%>
<%@page import="com.qst.bean.Student"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
	function check() {
		for (var i = 0; i < document.form1.elements.length - 1; i++) {
			if (document.form1.elements[i].value == "") {
				alert("当前表单不能有空项");
				document.form1.elements[i].focus();
				return false;
			}
		}
		return true;

	}

	function show() {
		var fileTag = document.getElementById('file');
		fileTag.onchange = function() {
			var file = fileTag.files[0];
			var fileReader = new FileReader();
			fileReader.onloadend = function() {
				if (fileReader.readyState == fileReader.DONE) {
					document.getElementById('img').setAttribute('src',
							fileReader.result);
				}
			}
			fileReader.readAsDataURL(file);
		}
	}
</script>
</head>
<body>
	<h2>修改商品信息</h2>
	<form action="../AddStudent?opr=modifyStu" method="post"
		enctype="multipart/form-data">
		<table id="stuDetailList">
			<%
				int id = Integer.parseInt(request.getParameter("id"));
				request.getSession().setAttribute("user_id", id);
				StudentService studentService = new StudentServiceimp();
				Student stu = new Student();
				stu.setId(id);
				stu = studentService.getStudentMoreInfo(stu);
			%>
			<tr>
				<img src="${pageContext.request.contextPath}/image/preview.jpg"
					id="img" style="width: 80px; height: 80px;" />
			</tr>
			<tr>
				<td>图片上传</td>
				<td><input type="file" id="file" name="fileupload"
					onclick="show()" /></td>
			</tr>
			<tr>
				<td>商品名：</td>
				<td><input type="text" id="stuName" name="stuName"
					value="<%=stu.getName()%>"></td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" id="sex" name="sex"
					value="<%=stu.getSex()%>"></td>
			</tr>
			<tr>
				<td>数量：</td>
				<td><input type="text" id="stuAge" name="stuAge"
					value="<%=stu.getAge()%>"></td>
			</tr>
			<td><input type="hidden" name="stuId" value="<%=id%>"></td>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="提交信息"></td>
			</tr>
		</table>
	</form>

</body>
</html>