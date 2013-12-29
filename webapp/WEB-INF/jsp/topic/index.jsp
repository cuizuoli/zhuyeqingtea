<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="/js/wScratchPad.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
<!--====headerArea====-->
<div id="headerArea">
<h1><a href="http://zhuyeqingtea.sinaapp.com/t"><img src="img/logo.png" alt="竹叶青茶微博活动 - “绿茶生活，远离烟花”" /></a></h1>

<div class="globalNav">
<ul>
<li class="nav01"><a id="introBtn" href="javascript:void(0);"><img src="img/img_nav01.gif" alt="活动介绍" /></a></li>
<li class="nav02"><a id="gameBtn" href="javascript:void(0);"><img src="img/img_nav02.gif" alt="小游戏" /></a></li>
<li class="nav03"><a href="javascript:void(0);"><img src="img/img_nav03.gif" alt="抽奖活动" /></a></li>
</ul>
</div>
</div>
<!--====headerArea end====-->
<!--====contentsArea====-->
<div id="contentsArea">
<div class="counter">
<ul>
<li>0</li>
<li>0</li>
<li>0</li>
<li>0</li>
<li>1</li>
</ul>
</div>

<div class="introArea" style="display:none;">
<p class="introTxt"><img src="img/txt_intro.gif" alt="“为成都送一个红包”，点击小游戏并参与活动,分享至微博，微信有机会获竹叶青茶春节定制红包等奖品。" /></p>
<p class="introBtn"><a id="closeIntroBtn" href="javascript:void(0);"><img src="img/btn_confirm.gif" alt="确定" /></a></p>
</div>

<div class="gameArea" style="display:none;">
<div class="game01">
<p class="redPaper"><img src="img/img_redpaper01.jpg" alt="" /></p>
<p class="gameTxt"><img src="img/txt_game01.gif" alt="您已成功参与“送成都一个红包活动”，是否愿意将活动分享给朋友？" /></p>
<ul class="btnList">
<li><a href="#"><img src="img/btn_share01.gif" alt="下次再分享" /></a></li>
<li><a href="#"><img src="img/btn_share02.gif" alt="马上分享" /></a></li>
</ul>
</div>

<p class="line"></p>

<div class="game02">
<p class="gameTxt"><img src="img/txt_game02.gif" alt="#绿茶生活，远离烟花爆竹#" /></p>
<p class="textCont"><textarea name="textCont" rows="2" cols="" id="textCont"></textarea></p>
<ul class="btnList">
<li><a href="#"><img src="img/btn_cancel.gif" alt="取消" /></a></li>
<li><a id="shareBtn" href="#"><img src="img/btn_confirm01.gif" alt="确定" /></a></li>
</ul>
</div>

<p class="success"><img src="img/img_success.png" alt="分享成功!" /></p>
</div>

</div>
<!--====contentsArea end====-->

</div>
<!--=========wrapper end=========-->
<script type="text/javascript">
$(document).ready(function() {
	$('#introBtn').click(function() {
		$('.introArea').show();
	});
	$('#closeIntroBtn').click(function() {
		$('.introArea').hide();
	});
	$('#gameBtn').click(function() {
		$('.gameArea').show();
	});
	$('.gameArea #shareBtn').click(function() {
		$('.gameArea').hide();
	});
});
</script>
</body>
</html>