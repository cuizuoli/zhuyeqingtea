<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离雾霾，拒绝烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://js.t.sinajs.cn/t4/enterprise/js/public/appframe/appClient.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<script type="text/javascript">
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}',display:'apponweibo'});
});
</script>
<style type="text/css">
#authDiv {z-index:10}
</style>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
<!--====contentsArea====-->
<div id="contentsArea">
<p class="search"><a href="javascript:void(0);"><img src="images/btn_search.gif" alt="查询获奖" /></a></p>
</div>
<!--====contentsArea end====-->

<!--====headerArea====-->
<div id="headerArea">
<h1><img src="images/title.gif" alt="绿茶生活，拒绝雾霾，远离烟花" /></h1>
<div class="explan">
<p><img src="images/txt_info.gif" alt="" /></p>
</div>
</div>
<!--====headerArea end====-->
</div>
<!--=========wrapper end=========-->
</body>
</html>