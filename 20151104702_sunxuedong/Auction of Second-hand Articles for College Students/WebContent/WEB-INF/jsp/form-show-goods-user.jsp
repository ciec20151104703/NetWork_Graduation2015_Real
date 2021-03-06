<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>添加商品</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<link rel="stylesheet" href="assets/css/app.css">
<!-- <script>
	var Year = document.getElementByName('year');
	var index = Year.selectedIndex; //序号，取当前选中选项的序号
	var val = Year.options[index].text;

	var Month = document.getElementByName('month');
	var index = Month.selectedIndex; //序号，取当前选中选项的序号
	var val = Month.options[index].text;

	var Day = document.getElementByName('day');
	var index = Day.selectedIndex; //序号，取当前选中选项的序号
	var val = Day.options[index].text;

	var l_in_time = Year + Month + Day;
	
</script> -->




<script language="JavaScript">
	function dateStart() {
		//月份对应天数
		MonHead = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

		//给年下拉框赋内容   
		var y = new Date().getFullYear();
		for (var i = (y - 50); i < (y + 50); i++)
			//以今年为准，前50年，后50年   
			document.date.year.options.add(new Option(" " + i + " 年", i));

		//给月下拉框赋内容   
		for (var i = 1; i < 13; i++)
			document.date.month.options.add(new Option(" " + i + " 月", i));

		document.date.year.value = y;
		document.date.month.value = new Date().getMonth() + 1;
		var n = MonHead[new Date().getMonth()];
		if (new Date().getMonth() == 1 && IsPinYear(yearvalue))
			n++;
		writeDay(n); //赋日期下拉框   
		document.date.day.value = new Date().getDate();
	}

	if (document.attachEvent)
		window.attachEvent("onload", dateStart);
	else
		window.addEventListener('load', dateStart, false);

	function selectYear(str) //年发生变化时日期发生变化(主要是判断闰平年)   
	{
		var monthvalue = document.date.month.options[document.date.month.selectedIndex].value;
		if (monthvalue == "") {
			var e = document.date.day;
			optionsClear(e);
			return;
		}
		var n = MonHead[monthvalue - 1];
		if (monthvalue == 2 && IsPinYear(str))
			n++;
		writeDay(n);
	}

	function selectMonth(str) //月发生变化时日期联动   
	{
		var yearvalue = document.date.year.options[document.date.year.selectedIndex].value;
		if (yearvalue == "") {
			var e = document.date.day;
			optionsClear(e);
			return;
		}
		var n = MonHead[str - 1];
		if (str == 2 && IsPinYear(yearvalue))
			n++;
		writeDay(n);
	}

	function writeDay(n) //据条件写日期的下拉框   
	{
		var e = document.date.day;
		optionsClear(e);
		for (var i = 1; i < (n + 1); i++)
			e.options.add(new Option(" " + i + " 日", i));
	}

	function IsPinYear(year)//判断是否闰平年   
	{
		return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
	}

	function optionsClear(e) {
		e.options.length = 1;
	}
</script>
</head>


<body data-type="generalComponents">


	<header class="am-topbar am-topbar-inverse admin-header">
	<div class="am-topbar-brand">
		<a href="javascript:;" class="tpl-logo"> <img
			src="assets/img/logo.png" alt="">
		</a>
	</div>
	<div
		class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

	</div>

	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-bell-o"></span> 提醒 <span
					class="am-badge tpl-badge-success am-round">5</span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-success">5</span> 条提醒
						</h3> <a href="###">全部</a>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span>
							【预览模块】移动端 查看时 手机、电脑框隐藏。</a> <span class="tpl-dropdown-list-fr">3小时前</span>
					</li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span>
							移动端，导航条下边距处理</a> <span class="tpl-dropdown-list-fr">15分钟前</span></li>
					<li class="tpl-dropdown-list-bdbc"><a href="#"
						class="tpl-dropdown-list-fl"><span
							class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span>
							追加统计代码</a> <span class="tpl-dropdown-list-fr">2天前</span></li>
				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-comment-o"></span> 消息
					<span class="am-badge tpl-badge-danger am-round">9</span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-danger">9</span> 条新消息
						</h3> <a href="###">全部</a>
					</li>
					<li><a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/user02.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from">
									${USER_SESSION.username} </span> <span
								class="tpl-dropdown-content-time">10分钟前 </span>
						</span> <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于
								GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
					</a> <a href="#" class="tpl-dropdown-content-message"> <span
							class="tpl-dropdown-content-photo"> <img
								src="assets/img/user03.png" alt="">
						</span> <span class="tpl-dropdown-content-subject"> <span
								class="tpl-dropdown-content-from"> Steam </span> <span
								class="tpl-dropdown-content-time">18分钟前</span>
						</span> <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题，
								建议你在反馈时附上演示，方便我们理解。 </span>
					</a></li>
				</ul>
			</li>
			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="am-icon-calendar"></span> 进度 <span
					class="am-badge tpl-badge-primary am-round">4</span>
			</a>
				<ul class="am-dropdown-content tpl-dropdown-content">
					<li class="tpl-dropdown-content-external">
						<h3>
							你有 <span class="tpl-color-primary">4</span> 个任务进度
						</h3> <a href="###">全部</a>
					</li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">Amaze UI 用户中心 v1.2 </span> <span
								class="percent">45%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-success"
										style="width: 45%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">新闻内容页 </span> <span class="percent">30%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-secondary"
										style="width: 30%"></div>
								</div>
						</span>
					</a></li>
					<li><a href="javascript:;"
						class="tpl-dropdown-content-progress"> <span class="task">
								<span class="desc">管理中心 </span> <span class="percent">60%</span>
						</span> <span class="progress">
								<div class="am-progress tpl-progress am-progress-striped">
									<div class="am-progress-bar am-progress-bar-warning"
										style="width: 60%"></div>
								</div>
						</span>
					</a></li>

				</ul>
			</li>
			<li class="am-hide-sm-only"><a href="javascript:;"
				id="admin-fullscreen" class="tpl-header-list-link"><span
					class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="tpl-header-list-user-nick">${USER_SESSION.username}</span><span
					class="tpl-header-list-user-ico"> <img
						src="assets/img/user01.png"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
					<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
					<li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
				</ul>
			</li>
			<li><a href="###" class="tpl-header-list-link"><span
					class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
		</ul>
	</div>
	</header>







	<div class="tpl-page-container tpl-page-header-fixed">
		<div class="tpl-left-nav tpl-left-nav-hover">
			<div class="tpl-left-nav-title">Amaze UI 列表</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a href="admin.jsp"
						class="nav-link"> <i class="am-icon-home"></i> <span>首页</span>
					</a></li>
					<li class="tpl-left-nav-item"><a href="chart.html"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-bar-chart"></i> <span>数据表</span> <i
							class="tpl-left-nav-content tpl-badge-danger"> 12 </i>
					</a></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>信息表單</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a
								href="${pageContext.request.contextPath }/table-user-list.action">
									<i class="am-icon-angle-right"></i> <span>用户列表</span> <i
									class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
							</a> <a
								href="${pageContext.request.contextPath }/table-goods-list-admin.action">

									<i class="am-icon-angle-right"></i> <span>商品列表</span> <i
									class="tpl-left-nav-content tpl-badge-success"> 18 </i>
							</a> <a href="${pageContext.request.contextPath }/form-news.action">
									<i class="am-icon-angle-right"></i> <span>评价信息</span> <i
									class="tpl-left-nav-content tpl-badge-primary"> 5 </i>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item">
						<!-- 打开状态 a 标签添加 active 即可   --> <a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>商品信息</span> <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
							<i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
					</a> <!-- 打开状态 添加 display:block-->
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<!-- 打开状态 a 标签添加 active 即可   --> <a
								href="${pageContext.request.contextPath }/form-show-goods-user.action">
									<i class="am-icon-angle-right"></i> <span>上架商品</span> <i
									class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
							</a> <a href="${pageContext.request.contextPath }/form-lease.action">
									<i class="am-icon-angle-right"></i> <span>租賃商品</span>
							</a>
							</li>
						</ul>
					</li>

					<li class="tpl-left-nav-item"><a
						href="${pageContext.request.contextPath }/logout.action"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>退出</span>

					</a></li>
				</ul>
			</div>
		</div>





		<div class="tpl-content-wrapper">
			<div class="tpl-content-page-title">Amaze UI 表单</div>
			<ol class="am-breadcrumb">
				<li><a href="${pageContext.request.contextPath }/main.action"
					class="am-icon-home">首页</a></li>
				<li><a href="#">表单</a></li>
				<li class="am-active">Amaze UI 表单</li>
			</ol>
			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">
						<span class="am-icon-code"></span> 表单
					</div>
					<div class="tpl-portlet-input tpl-fz-ml">
						<div class="portlet-input input-small input-inline">
							<div class="input-icon right">
								<i class="am-icon-search"></i> <input type="text"
									class="form-control form-control-solid" placeholder="搜索...">
							</div>
						</div>
					</div>


				</div>
				<div class="tpl-block ">

					<div class="am-g tpl-amazeui-form">


						<div class="am-u-sm-12 am-u-md-9">
							<form class="am-form am-form-horizontal"
								action="${pageContext.request.contextPath }/addgoods.action"
								method="post" enctype="multipart/form-data"
								onsubmit="return check()" name="date" id="form1">
								<div class="am-form-group">
									<label for="l_name" class="am-u-sm-3 am-form-label">商品名称</label>
									<div class="am-u-sm-9">
										<input type="text" id="l_name" name="l_name"
											placeholder="商品名称"> <small>输入商品的名字，让别人记住你。</small>
									</div>
								</div>
								<div class="am-form-group">
									<label class="am-u-sm-3 am-form-label">上传封面：</label> <input
										type="file" name="file">
								</div>
								<div class="am-form-group">
									<label for="l_price" class="am-u-sm-3 am-form-label">价格</label>
									<div class="am-u-sm-9">
										<input type="text" id="l_price" name="l_price"
											placeholder="输入你的商品价格 / Price,仅允许数字"
											onkeyup="this.value=this.value.replace(/[^\d\.]/g)">
									</div>
								</div>

								<div class="am-form-group">
									<label for="l_info" class="am-u-sm-3 am-form-label">商品信息</label>
									<div class="am-u-sm-9">
										<input type="text" id="l_info" name="l_info"
											placeholder="输入你的商品信息">
									</div>
								</div>


								<div class="am-form-group">
									<label for="l_type" class="am-u-sm-3 am-form-label">商品类型
										<span class="tpl-form-line-small-title">Type</span>
									</label>
									<div class="am-u-sm-9">
										<select data-am-selected="{searchBox: 1}" name="l_type"
											id="l_type">
											<option value="笔记">笔记</option>
											<option value="图书">图书</option>
											<option value="工具">工具</option>
											<option value="娱乐">娱乐</option>
										</select>
									</div>
								</div>





								<div class="am-form-group">
									<label for="l_out_time" class="am-u-sm-3 am-form-label">允许租赁时间:</label>
									<div class="am-u-sm-9">

										<input id="l_out_time" name="l_out_time" type="text" value=""
											readonly="true" />
									</div>
								</div>
								<script language="javascript" type="text/javascript">
									function shijian() {
										var D = new Date();
										var yy = D.getFullYear();
										var mm = D.getMonth() + 1;
										var dd = D.getDate();

										var time = yy + "-" + mm + "-" + dd;
										document.getElementById("l_out_time").value = time;
										setTimeout("shijian()", 1000);
									}
									shijian();
								</script>
								<div class="am-form-group">
									<label for="l_in_time" class="am-u-sm-3 am-form-label">租赁截止日期</label>
									<div class="am-u-sm-9">

										<select name="year" id="year"
											onchange="selectYear(this.value)">
											<option value="year">选择 年</option>
										</select> <select name="month" id="month"
											onchange="selectMonth(this.value)">
											<option value="mothe">选择 月</option>
										</select> <select name="day" id="day">
											<option value="day">选择 日</option>
										</select>

									</div>
								</div>

								<div class="am-form-group"></div>

								<div class="am-form-group">
									<label for="u_id" class="am-u-sm-3 am-form-label">卖家ID：</label>
									<div class="am-u-sm-9">
										<input id="u_id" name="u_id" type="text"
											value="${USER_SESSION.id}" readonly="readonly">

									</div>
								</div>


								<div class="am-form-group">
									<label for="u_id" class="am-u-sm-3 am-form-label">卖家：</label>
									<div class="am-u-sm-9">
										<input id="u_name" name="u_name" type="text"
											value="${USER_SESSION.username}" readonly="readonly">

									</div>
								</div>

								<div class="am-form-group">
									<label for="l_addr" class="am-u-sm-3 am-form-label">商品地址</label>
									<div class="am-u-sm-9">
										<textarea class="" id="l_addr" name="l_addr"
											placeholder="请输入地址"></textarea>

									</div>
								</div>

								<div class="am-form-group">
									<div class="am-u-sm-9 am-u-sm-push-3">
										<button type="submit" class="am-btn am-btn-primary">保存修改</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>










		</div>

	</div>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>

</body>

</html>