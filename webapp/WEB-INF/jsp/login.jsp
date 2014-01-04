<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离雾霾，拒绝烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://js.t.sinajs.cn/t4/enterprise/js/public/appframe/appClient.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
<!--====headerArea====-->
<div id="headerArea">
<h1><img src="images/title.png" alt="绿茶生活，远离雾霾，拒绝烟花"/></h1>
<div class="explan">
<p>【活动内容】 活动参与人数达到即定人数参与，<br />即可打开竹叶青茶茶弈基金.</p>
<p>【活动时间】 1月10日-1月20日</p>
<p>【活动参与方式】 以竹叶青LOGO光标涂抹雾霾页面，<br />即算参与成功。同时，计数器自动增加数量。</p>
</div>
<div class="counter">
<ul>
<li>0</li>
<li>0</li>
<li>0</li>
<li>0</li>
<li>0</li>
<li>1</li>
</ul>
</div>
</div>
<!--====headerArea end====-->
</div>
<!--=========wrapper end=========-->
<script type="text/javascript">
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}',display:'apponweibo'});
});
</script>
</body>
</html>