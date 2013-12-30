<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://js.t.sinajs.cn/t4/enterprise/js/public/appframe/appClient.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
</div>
<!--=========wrapper end=========-->
<script type="text/javascript">
$(document).ready(function() {
	App.AuthDialog.show({client_id:'${appKey}',redirect_uri:'${redirectUri}',display:'apponweibo'});
});
</script>
</body>
</html>