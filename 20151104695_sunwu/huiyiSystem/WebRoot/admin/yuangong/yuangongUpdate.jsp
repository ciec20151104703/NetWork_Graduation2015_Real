<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script type="text/javascript">
		    function orgAll()
		    {
		       	var strUrl = "<%=path %>/org?type=orgAll";
				var ret = window.showModalDialog(strUrl,"","dialogWidth:350px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
			    if(ret==undefined)
			    {
			        ret="";
			    }
			    document.getElementById("org_id").value=ret;
		    }
		    
		    
		    
		    function check()
		    {
		        if(document.getElementById("org_id").value=="")
		        {
		            alert("请选择小组");
		            return false;
		        }
		        if(document.getElementById("name").value=="")
		        {
		            alert("请输入员工姓名");
		            return false;
		        }
		        document.formAdd.submit();
		    } 
		    
		    
		</script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'>
			<form action="<%=path %>/yuangong?type=yuangongUpdate" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>员工管理</span></td>
					    </tr>
					    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         小组：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" value="${requestScope.yuangong.org_id}" name="org_id" id="org_id" readonly="readonly"/>
						        <input type="button" value="选择小组" onclick="orgAll()"/>
						    </td>
						</tr>
					    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						               学号：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" value="${requestScope.yuangong.bianhao}" name="bianhao" id="bianhao" size="22"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						               姓名：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" value="${requestScope.yuangong.name}" name="name" id="name" size="22"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         性别：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						    <c:if test="${requestScope.yuangong.sex=='男'}">
						        <input type="radio" name="sex" value="男" checked="checked"/>男
						        &nbsp;&nbsp;&nbsp;&nbsp;
						        <input type="radio" name="sex" value="女"/>女
						        </c:if>
						        <c:if test="${requestScope.yuangong.sex=='女'}">
						        <input type="radio" name="sex" value="男"/>男
						        &nbsp;&nbsp;&nbsp;&nbsp;
						        <input type="radio" name="sex" value="女" checked="checked"/>女
						        </c:if>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         账号：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" value="${requestScope.yuangong.loginname}" name="loginname" size="22" />
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         密码：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="loginpw" value="${requestScope.yuangong.loginpw}" size="22" value="000000"/>
						    </td>
						</tr>
						 <input type="hidden" name="id" value="<%=request.getParameter("id") %>"/>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="button" value="提交" onclick="check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
