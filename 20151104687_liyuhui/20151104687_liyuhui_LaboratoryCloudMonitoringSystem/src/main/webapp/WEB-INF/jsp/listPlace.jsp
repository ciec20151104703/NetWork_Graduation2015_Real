<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>实验室云端监管系统</title>
            
        <!-- CSS -->
        <link rel="stylesheet" type="text/css"
	href="superAdministrator/css/style.css" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/form.css" rel="stylesheet">
        <link href="css/calendar.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/icons.css" rel="stylesheet">
        <link href="css/generics.css" rel="stylesheet"> 
    </head>
    <body id="${User.color}">

        <header id="header" class="media">
            <a href="" id="menu-toggle"></a> 
            <a class="logo pull-left" href="">实验室云端监管系统</a>
            
            <div class="media-body">
                <div class="media" id="top-menu">
                    
                    <div id="time" class="pull-right">
   
                        <span id="hours"></span>
                        :
                        <span id="min"></span>
                        :
                        <span id="sec"></span>
                    </div>
                </div>
            </div>
        </header>
        
        <div class="clearfix"></div>
        
        <section id="main" class="p-relative" role="main">
            
            <!-- Sidebar -->
            <aside id="sidebar">
                
                <!-- Sidbar Widgets -->
                <div class="side-widgets overflow">
                    <!-- Profile Menu -->
                    <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                            <img class="profile-pic animated" src="${pageContext.request.contextPath }/${User.image }" alt=""><!--头像-->
                            <table>
                            	<tr>
                            		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            		<td>姓名：</td>
                            		<td>${User.name}</td>
                            	</tr>
                            	<tr>
                            		<td></td>
                            		<td>编号： </td>
                            		<td>${User.num }</td>
                            	</tr>
                            </table>
                            <a href="doLogout">登出</a>  
                    </div>
                    <!-- Calendar -->
                    <div class="s-widget m-b-25">
                        <div id="sidebar-calendar"></div>
                    </div>


                    <!-- Projects -->
                    
                </div>
                
                <!-- Side Menu -->
                <ul class="list-unstyled side-menu">
                    <li class="active">
                        <a class="sa-side-home" href="${pageContext.request.contextPath }/menu">
                            <span class="menu-item">主页</span>
                        </a>
                    </li>
                    <li>
                        <a class="sa-side-form" href="${pageContext.request.contextPath }/mine">
                            <span class="menu-item">我的信息</span>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a class="sa-side-folder" href="">
                            <span class="menu-item">实验室用户信息</span>
                        </a>
                        <ul class="list-unstyled menu-item">
                        	<li><a href="${pageContext.request.contextPath }/config/listAll">实验室全部用户信息管理</a></li>
                        	<li><a href="${pageContext.request.contextPath }/config/listStu">实验室学生用户信息管理</a></li>
                        	<li><a href="${pageContext.request.contextPath }/config/listTeach">实验室教师用户信息管理</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="sa-side-table" href="">
                            <span class="menu-item">后勤管理</span>
                        </a>
                        <ul class="list-unstyled menu-item">
                        	<li><a href="${pageContext.request.contextPath }/config/listLab">实验室管理</a></li>
                        	<li><a href="${pageContext.request.contextPath }/config/listPlace">位置管理</a></li>                   
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a class="sa-side-chart" href="">
                            <span class="menu-item">超级管理</span>
                        </a>
                         <ul class="list-unstyled menu-item">
                            <li><a href="${pageContext.request.contextPath }/config/listUser">用户管理</a></li>
                            <li><a href="${pageContext.request.contextPath }/config/listRole">角色管理</a></li>
                            <li><a href="${pageContext.request.contextPath }/config/listPermission">权限管理</a></li>                     
                        </ul>
                    </li>
                </ul>

            </aside>
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <div id="messages" class="tile drawer animated">
                    <div class="listview narrow">
                        <div class="media">
                            <a href="">Send a New Message</a>
                            <span class="drawer-close">&times;</span>
                            
                        </div>
                        <div class="overflow" style="height: 254px">
                            <div class="media">
                                <div class="pull-left">
                                    <img width="40" src="img/profile-pics/1.jpg" alt="">
                                </div>
                                <div class="media-body">
                                    <small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
                                    <a class="t-overflow" href="">Mauris consectetur urna nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu adipiscing lectus</a>
                                </div>
                            </div><!--通知-->
                        </div>
                        <div class="media text-center whiter l-100">
                            <a href=""><small>展开全部</small></a>
                        </div>
                    </div>
                </div>
                
                <hr class="whiter" />
                <div style="font-size:20px; text-align:center; ">
                	<a >实验室位置信息管理</a>
                </div>
                <hr class="whiter" />
                <hr class="whiter" />
                <hr class="whiter" />
			<div class="workingroom">
				
				<table>
					<tr>
						<td>序号</td>
						<td>位置ID</td>
						<td>校区</td>
						<td>教学楼</td>
						<td>房间号</td>
						<td>所属专业</td>
						<td>编辑</td>
						<td>删除</td>
					</tr>
					<c:forEach items="${ps}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.placeId}</td>
							<td>${p.campus}</td>
							<td>${p.building}</td>
							<td>${p.houseId}</td>
							<td>${p.major}</td>
							<td><a href="editPlace?id=${p.id}">编辑</a></td>
							<td><a href="deletePlace?id=${p.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>

				<div class="addOrEdit">
					<form action="addPlace" method="post">
						位置ID：<div style="color: black;"> <input type="text" name="placeId"> </div><br> 
						校区：<div style="color: black;"> <input type="text" name="campus"> </div><br> 
						教学楼：<div style="color: black;"> <input type="text" name="building"> </div><br> 
						房间号：<div style="color: black;"> <input type="text" name="houseId"> </div><br> 
						所属专业：<div style="color: black;"> <input type="text" name="major"> </div><br> 
						<br> <input type="submit" value="增加" style="color: black;">
					</form>
				</div>
			</div>

		</section>

	</section>

	<!-- Javascript Libraries -->
	<!-- jQuery -->
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<!-- jQuery Library -->
	<script src="js/jquery-ui.min.js" type="text/javascript"></script>
	<!-- jQuery UI -->
	<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
	<!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	>


	<!--  Form Related -->
	<script src="js/icheck.js" type="text/javascript"></script>
	<!-- Custom Checkbox + Radio -->

	<!-- UX -->
	<script src="js/scroll.min.js" type="text/javascript"></script>
	<!-- Custom Scrollbar -->

	<!-- Other -->
	<script src="js/calendar.min.js" type="text/javascript"></script>
	<!-- Calendar -->
	<script src="js/feeds.min.js" type="text/javascript"></script>
	<!-- News Feeds -->


	<!-- All JS functions -->
	<script src="js/functions.js" type="text/javascript"></script>
</body>
