<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离雾霾，拒绝烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css"/>
<style type="text/css">
body {padding-top:70px;}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#admin-menu">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/a"><span class="glyphicon glyphicon-user"></span>&nbsp;${weiboUser.userName}</a>
		</div>
		<div id="admin-menu" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">奖品管理 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li id="prizeListBtn"><a href="javascript:void(0);">奖品信息</a></li>
					</ul>
				</li>
				<li><a href="javascript:void(0);">用户授权</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div id="prizePanel" class="panel panel-primary">
				<div class="panel-heading">奖品列表</div>
				<table class="table table-hover table-bordered">
					<colgroup>
						<col style="width:5%">
						<col style="width:40%">
						<col style="width:10%">
						<col style="width:10%">
						<col style="width:15%">
						<col style="width:10%">
						<col style="width:10%">
					</colgroup>
					<thead>
					<tr class="active">
						<th>ID</th>
						<th>奖品内容</th>
						<th>总数量</th>
						<th>当前数量</th>
						<th>最低参与人数</th>
						<th>中奖机率</th>
						<th>是否启用</th>
					</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<script id="prizeListTmpl" type="text/x-jquery-tmpl">
				<tr>
					<td>${'${'}prizeId}</td>
					<td>${'${'}prizeName}</td>
					<td><input type="test" value="${'${'}totalCount}" style="width:60px;"/></td>
					<td><input type="test" value="${'${'}currentCount}" style="width:60px;"/></td>
					<td><input type="test" value="${'${'}minJoinCount}" style="width:60px;"/></td>
					<td><input type="test" value="${'${'}probability}" style="width:60px;"/></td>
					<td>{{if activeYn == 'Y'}}启用{{/if}}{{if activeYn == 'N'}}未启用{{/if}}</td>
				</tr>
				</script>
				<div class="panel-footer">
					<a id="updatePrizeBtn" href="javascript:void(0);" type="button" class="btn btn-primary btn-sm btn">更新数据</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	initPanel();
	bindMenuEvent();
	bindPrizeEvent();
});
function initPanel() {
	$('#prizePanel').hide();
}
function bindMenuEvent() {
	$('#prizeListBtn').click(function() {
		initPanel();
		loadPrizeList();
	});
}
function bindPrizeEvent() {
	$('#prizePanel #updatePrizeBtn').click(function() {
		$('#prizePanel tbody tr').each(function(i,e) {
			var item = $(e).tmplItem();
			console.log(item);
		});
	});
}
function loadPrizeList() {
	$('#prizePanel').show();
	$('#prizePanel tbody').empty();
	$.ajax({
		url: '/p/l',
		type: 'post',
		dataType: 'json',
		success: function(data) {
			$('#prizePanel #prizeListTmpl').tmpl(data).appendTo($('#prizePanel tbody'));
		}
	});
}
</script>
</body>
</html>