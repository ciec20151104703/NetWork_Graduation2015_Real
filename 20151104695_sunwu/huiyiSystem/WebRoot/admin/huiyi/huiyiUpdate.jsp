<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
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
        
       <%--  <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" /> --%>
        
        <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet"/> 
		 <link href="<%=path %>/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
		 <link href="<%=path %>/bootstrap/custom.min.css" rel="stylesheet"/>
		 
	</head>

	<body background="qy_back.gif" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0" bgcolor="#FFFFFF" style="background:rgb(236,240,245); padding-left:20px;">

	<div class="title clearfix">
	<h2 style="font-size:34px; font-weight:bold;">更新会议室信息</h2>
	</div>
	<ul class="breadcrumb" style="">
	<li>
	<i class="fa fa-home"></i>
	<i style="color:rgb(42,63,84); font-style:normal;" id="breadcrumbSeal">操作   /   更新会议室信息</i>
	</li>
	</ul>
	<ul id="myTab" class="nav nav-tabs" style="height:30px;">
	<li class="active"><a href="#home" data-toggle="tab" style="height:30px; line-height:3px;" id="tabTitle">
	更新会议室信息</a>
	</li>
	</ul>
	<div id="myTabContent" class="tab-content" style="margin-top:20px;">
	<div class="tab-pane fade in active" id="home">
	<section class="content">
	<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
	<div id="table-box" style="display: block; height:440px;">
	
	<form action="<%=path %>/huiyi?type=huiyiUpdate" name="formAdd" method="post" class="form-horizontal form-label-left">
	
    <input type="hidden" name="id" value="${bean.id }"/>

	    <div class="form-group">
		<label class="control-label col-xs-3" >有无多媒体: </label>
		<div class="col-xs-6">
	    <select id="salestate" name='salestate'  class="form-control" >
	      <option value="有多媒体" <c:if test="${bean.salestate=='有多媒体' }">selected</c:if>>有多媒体</option>
	      <option value="无多媒体"  <c:if test="${bean.salestate=='无多媒体' }">selected</c:if>>无多媒体</option>
	    </select>
	    </div>     
		</div>
		
  		<div class="form-group">
		<label class="control-label col-xs-3" >门牌号:
		</label>
		<div class="col-xs-6">
		<input type="text" name="menpaihao" class="form-control col-xs-6" value="${bean.menpaihao }"/>
		</div>
		</div> 
  
 				 <div class="form-group">
		<label class="control-label col-xs-3" >会议室用途:
		</label>
		<div class="col-xs-6">
		<input type="text" class="form-control col-xs-6"  name="fangwujiegou" value="${bean.fangwujiegou }"/>
		</div>
		</div> 
		
		<div class="form-group">
		<label class="control-label col-xs-3" >会议室名称:
		</label>
		<div class="col-xs-6">
		<input type="text" name="shebei" class="form-control col-xs-6" value="${bean.shebei }"/>
		</div>
		</div> 
		
		<div class="form-group">
		<label class="control-label col-xs-3" >容纳人数:
		</label>
		<div class="col-xs-6">
		<input type="text" name="mianji" class="form-control col-xs-6" value="${bean.mianji }"/>
		</div>
		</div> 
		
		<div class="form-group">
		<label class="control-label col-xs-3" >会议室地点:
		</label>
		<div class="col-xs-6">
		<input type="text" class="form-control col-xs-6"  name="price" value="${bean.price }"/>
		</div>
		</div> 
		
		<div class="form-group">
		<label class="control-label col-xs-3" >备注:
		</label>
		<div class="col-xs-6">
		 <textarea rows="7" class="form-control col-xs-6" cols="50" name="beizhu">${bean.beizhu }</textarea>
		</div>
		</div> 
		
		<div class="col-md-offset-3 col-xs-6">
		 <input type="submit" class="btn btn-primary col-md-offset-1" value="提交"/>&nbsp;&nbsp;
		 <input type="reset" class="btn btn-primary col-md-offset-1" value="重置"/>&nbsp;&nbsp;
		 <input  onclick="javascript:history.go(-1);" class="btn btn-primary col-md-offset-1" type="button" value="返回" />&nbsp;
	    </div>
  
</form>

</div>
</div>
</div>
</div>
</section>
</div>
</div>

</body>
</html>
