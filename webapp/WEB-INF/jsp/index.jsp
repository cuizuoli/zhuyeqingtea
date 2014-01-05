<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>竹叶青茶微博活动 - “绿茶生活，远离雾霾，拒绝烟花”</title>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/js/jquery.class.support.js"></script>
<script type="text/javascript" src="/js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="/js/wScratchPad.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
<!--====contentsArea====-->
<div id="contentsArea" class="haze">

<div class="scratch" style="display:none;">

</div>
<div class="gamePop01">
<p class="gameTxt">
<img src="images/txt_game01.png" alt="你已经成功为成都送出一个红包，感谢您的参与!再为成都送出XXX个红包即可打开茶弈基金第一关。是否邀请朋友继续参与活动或将活动分享到朋友圈" />
<span class="num01"></span>
<span class="num02"></span>
</p>
<ul class="btnList">
<li><a id="nextShareBtn" href="#"><img src="images/btn_no.png" alt="下次再说" /></a></li>
<li><a id="shareBtn" href="#"><img src="images/btn_yes.png" alt="当然" /></a></li>
</ul>
</div>

<div class="success" style="display:none;">
<p><img src="images/txt_success.png" alt="分享成功!您已获得一次抽奖机会，现在抽奖？" /></p>
<ul class="btnList">
<li><a id="lotteryCancelBtn" href="#"><img src="images/btn_cancel.gif" alt="取消" /></a></li>
<li><a id="lotteryOkBtn" href="#"><img src="images/btn_confirm01.gif" alt="确认" /></a></li>
</ul>
</div>

<div class="gamePop02" style="display:none;">
<p class="gameTxt"><img src="images/txt_game02.gif" alt="绿茶生活，远离雾霾，拒绝烟花 2014新年快乐" /></p>
<ul class="btnList">
<li><a id="nextShareConfirmBtn" href="#"><img src="images/btn_confirm.gif" alt="确定" /></a></li>
</ul>
</div>

<div class="gamePop03" style="display:none;">
<p class="textCont"><textarea name="textCont" rows="2" cols="" id="textCont"></textarea></p>
<ul class="btnList">
<li><a id="shareConfirmBtn" href="#"><img src="images/btn_share01.png" alt="分享到新浪微博" /></a></li>
</ul>
<p class="weChat"><a id="weixinShareBtn" href="#"><img src="images/btn_wechat.png" alt="" /></a></p>
<p class="close"><a id="closeShareBtn" href="#"><img src="images/btn_close.png" alt="" /></a></p>
</div>

<div class="gamePop04" style="display:none;">
<p class="weChat"><span id="qrcode"></span></p>
<p class="close"><a id="closeWeixinShareBtn" href="#"><img src="images/btn_close.png" alt="" /></a></p>
</div>

<div class="lottery" style="display:none;">
<ul class="redPaper">
<li><a href="#"><img src="images/img_paper01.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper02.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper03.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper04.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper05.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper06.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper07.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper08.jpg" alt="" /></a></li>
<li><a href="#"><img src="images/img_paper09.jpg" alt="" /></a></li>
</ul>
<p class="close"><a href="#"><img src="images/btn_close01.png" alt="" /></a></p>

<div class="win" style="display:none;">
<p class="winTxt"><img src="images/txt_win01.gif" alt="" /></p>
<ul class="btnList">
<li><a id="prizeBtn" href="#"><img src="images/btn_win.gif" alt="领取奖品" /></a></li>
</ul>
</div>

<div class="notWin" style="display:none;">
<p class="notwinTxt"><img src="images/txt_notwin.gif" alt="" /></p>
<ul class="btnList">
<li><a id="nextBtn" href="#"><img src="images/btn_next.gif" alt="下次吧" /></a></li>
<li><a id="againBtn" href="#"><img src="images/btn_again.gif" alt="再来一次" /></a></li>
</ul>

<div class="again" style="display:none;">
<p class="againTxt"><img src="images/txt_again.gif" alt="" /><span class="num"></span></p>
<ul class="btnList">
<li><a id="againConfirmBtn" href="#"><img src="images/btn_confirm02.gif" alt="确定" /></a></li>
</ul>
</div>
</div>
</div>

<div class="prizePool" style="display:none;">
<ul class="rating">
<li class="rating01">
<p class="ratingTtl"><img src="images/ttl_rating01.png" alt="" /></p>
<p class="bar"><img src="images/img_bar.png" alt="" /></p>
<p class="icon"><img src="images/icon01.png" alt="" /></p>
</li>
<li class="rating02">
<p class="ratingTtl"><img src="images/ttl_rating02.png" alt="" /></p>
<p class="bar"><img src="images/img_bar.png" alt="" /></p>
<p class="icon"><img src="images/icon02.png" alt="" /></p>
</li>
<li class="rating03">
<p class="ratingTtl"><img src="images/ttl_rating03.png" alt="" /></p>
<p class="bar"><img src="images/img_bar.png" alt="" /></p>
<p class="icon"><img src="images/icon03.png" alt="" /></p>
</li>
<li class="rating04">
<p class="ratingTtl"><img src="images/ttl_rating04.png" alt="" /></p>
<p class="bar"><img src="images/img_bar.png" alt="" /></p>
<p class="icon"><img src="images/icon04.png" alt="" /></p>
</li>
<li class="rating05">
<p class="ratingTtl"><img src="images/ttl_rating05.png" alt="" /></p>
<p class="bar"><img src="images/img_bar.png" alt="" /></p>
<p class="icon"><img src="images/icon05.png" alt="" /></p>
</li>
</ul>
<p class="close"><a href="#"><img src="images/btn_close01.png" alt="" /></a></p>
</div>

<p class="search"><a href="#"><img src="images/btn_search.gif" alt="查询获奖" /></a></p>
</div>
<!--====contentsArea end====-->

<!--====headerArea====-->
<div id="headerArea">
<div class="counter">
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</div>
</div>
<!--====headerArea end====-->
</div>
<!--=========wrapper end=========-->
<script type="text/javascript">
(function($) {
	Class('com.sinaapp.zhuyeqingtea.Index', {
		init : function(options) {
			var _this = this;
			_this._options = $.extend({
				id : '#wrapper'
			}, options);
			_this._root = $(_this._options.id);
			_this._contentsArea = _this._root.find('#contentsArea');
			_this._headerArea = _this._root.find('#headerArea');
			_this._bindEvent();
			_this._initIndex();
			_this._initCounter();
		},
		// 初始化首页
		_initIndex : function() {
			var _this = this;
			_this._headerArea.show();
			_this._contentsArea.hide();
		},
		// 销毁首页，初始化内容页
		_destroyIndex : function() {
			var _this = this;
			_this._initGame();
			_this._contentsArea.fadeIn(1000);
		},
		// 初始化游戏页
		_initGame : function() {
			var _this = this;
			_this._destroyLottery();
			_this._destroyPrizePool();
			_this._contentsArea.find('.scratch').show();
			_this._contentsArea.find('.gamePop01').hide();
			_this._contentsArea.find('.gamePop02').hide();
			_this._contentsArea.find('.gamePop03').hide();
			_this._contentsArea.find('.gamePop04').hide();
			_this._contentsArea.find('.success').hide();
			_this._sp.wScratchPad('reset');
		},
		// 销毁游戏页
		_destroyGame : function() {
			var _this = this;
			_this._contentsArea.find('.scratch').hide();
			_this._contentsArea.find('.gamePop01').hide();
			_this._contentsArea.find('.gamePop02').hide();
			_this._contentsArea.find('.gamePop03').hide();
			_this._contentsArea.find('.gamePop04').hide();
			_this._contentsArea.find('.success').hide();
		},
		// 初始化抽奖页
		_initLottery : function() {
			var _this = this;
			_this._destroyGame();
			_this._destroyPrizePool();
			_this._contentsArea.find('.lottery').show();
			_this._contentsArea.find('.lottery .win').hide();
			_this._contentsArea.find('.lottery .notWin').hide();
			_this._contentsArea.find('.lottery .again').hide();
		},
		// 销毁抽奖页
		_destroyLottery : function() {
			var _this = this;
			_this._destroyGame();
			_this._contentsArea.find('.lottery').hide();
			_this._contentsArea.find('.lottery .win').hide();
			_this._contentsArea.find('.lottery .notWin').hide();
			_this._contentsArea.find('.lottery .again').hide();
		},
		// 初始化奖池页
		_initPrizePool : function() {
			var _this = this;
			_this._destroyGame();
			_this._destroyLottery();
			_this._loadPrizePool();
			_this._contentsArea.find('.prizePool').show();
		},
		// 销毁奖池页
		_destroyPrizePool : function() {
			var _this = this;
			_this._contentsArea.find('.prizePool').hide();
		},
		// 绑定事件
		_bindEvent : function() {
			var _this = this;
			_this._bindIndexEvent();
			_this._bindGameEvent();
			_this._bindLotteryEvent();
			_this._bindPrizePoolEvent();
			_this._bindSearchPrizeEvent();
		},
		// 绑定活动介绍事件
		_bindIndexEvent : function() {
			var _this = this;
			_this._root.mousemove(function(e) {
				_this._root.unbind('mousemove');
				_this._destroyIndex();
			});
		},
		// 绑定游戏事件
		_bindGameEvent : function() {
			var _this = this;
			_this._sp = _this._contentsArea.find('.scratch').wScratchPad({
				width: 456,
				height: 341,
				image: 'images/img_scratch02.png',
				image2: 'images/img_scratch01.png',
				cursor: 'images/logo.cur',
				overlay: 'none',
				size: 50,
				scratchUp: function(e, percent) {
					if (percent > 30) {
						$.ajax({
							url: '/g/join',
							type: 'post',
							dataType: 'json',
							success: function(data) {
								_this._contentsArea.find('.scratch').hide();
								// 弹出"你已经成功为成都送出一个红包"
								_this._showWeiboCount();
								_this._contentsArea.find('.gamePop01').show();
								_this._initCounter();
							}
						});
					}
				}
			});
			// 弹出"分享到新浪微博"窗口
			_this._contentsArea.find('.gamePop01 #shareBtn').click(function() {
				$.ajax({
					url: '/g/wb_cont',
					type: 'get',
					dataType: 'json',
					cache: false,
					success: function(data) {
						_this._contentsArea.find('#textCont').text(data.weiboContent);
						_this._contentsArea.find('.gamePop03').show();
					}
				});
			});
			// "分享到新浪微博"确认事件
			_this._contentsArea.find('.gamePop03 #shareConfirmBtn').click(function() {
				$.ajax({
					url: '/g/share',
					type: 'post',
					data: {'text':_this._contentsArea.find('#textCont').text()},
					dataType: 'json',
					success: function() {
						_this._contentsArea.find('.success').show();
					},
					error: function(jqXhr, textStatus, errorThrown) {
						alert('请稍候再试！');
					}
				});
			});
			// 关闭"分享到新浪微博"窗口
			_this._contentsArea.find('.gamePop03 #closeShareBtn').click(function() {
				_this._contentsArea.find('.gamePop03').hide();
			});
			// 弹出"分享到微信朋友圈"窗口
			_this._contentsArea.find('.gamePop03 #weixinShareBtn').click(function() {
				$('#qrcode').qrcode({width:120,height:120,text:window.location.href});
				_this._contentsArea.find('.gamePop04').show();
			});
			// 关闭"分享到微信朋友圈"窗口
			_this._contentsArea.find('.gamePop04 #closeWeixinShareBtn').click(function() {
				$('#qrcode').html('');
				_this._contentsArea.find('.gamePop04').hide();
			});
			// 下次再说
			_this._contentsArea.find('.gamePop01 #nextShareBtn').click(function() {
				_this._contentsArea.find('.gamePop02').show();
			});
			// "绿茶生活，远离雾霾，拒绝烟花，2014新年快乐"确认事件
			_this._contentsArea.find('.gamePop02 #nextShareConfirmBtn').click(function() {
				_this._initIndex();
				_this._bindIndexEvent();
			});
			// "分享成功!您已获得一次抽奖机会，现在抽奖？"取消事件
			_this._contentsArea.find('.success #lotteryCancelBtn').click(function() {
				_this._initIndex();
				_this._bindIndexEvent();
			});
			// "分享成功!您已获得一次抽奖机会，现在抽奖？"确认事件
			_this._contentsArea.find('.success #lotteryOkBtn').click(function() {
				_this._initLottery();
			});
		},
		// 绑定抽奖事件
		_bindLotteryEvent : function() {
			var _this = this;
			_this._contentsArea.find('.lottery .redPaper li').click(function() {
				$.ajax({
					url: '/p/p',
					type: 'get',
					dataType: 'json',
					cache: false,
					success: function(data) {
						if (data.reason == 'ERROR') {
							alert('请刷新页面，重新登录！');
						} else if(data.reason == 'OVER_MAX_NEXT_PRIZE') {
							alert('每人每天有5次抽奖机会！');
							_this._initPrizePool();
						} else if(data.reason == 'NOT_HAVE_PRIZE_CHANCE') {
							alert('你的抽奖机会不足，快去做游戏获得红包吧！');
							_this._initGame();
						} else {
							if (data.prizeId == 100) {
								_this._contentsArea.find('.lottery .notWin').show();
							} else {
								var imgUrl = '';
								if (data.prizeId == 1) {
									imgUrl = 'images/txt_win01.gif';
								} else if (data.prizeId == 2) {
									imgUrl = 'images/txt_win02.gif';
								} else if (data.prizeId == 3) {
									imgUrl = 'images/txt_win03.gif';
								} else if (data.prizeId == 4) {
									imgUrl = 'images/txt_win04.gif';
								} else if (data.prizeId == 5) {
									imgUrl = 'images/txt_win05.gif';
								}
								_this._contentsArea.find('.lottery .win .winTxt img').attr('src',imgUrl);
								_this._contentsArea.find('.lottery .win').show();
							}
						}
					}
				});
			});
			_this._contentsArea.find('.lottery .btnList #nextBtn').click(function() {
				_this._contentsArea.find('.lottery .notWin').hide();
			});
			_this._contentsArea.find('.lottery .btnList #againBtn').click(function() {
				_this._contentsArea.find('.num').html('');
				$.ajax({
					url: '/p/c',
					type: 'get',
					dataType: 'text',
					cache: false,
					success: function(data) {
						_this._contentsArea.find('.num').html(data);
					}
				});
				_this._contentsArea.find('.again').show();
			});
			_this._contentsArea.find('.again .btnList #againConfirmBtn').click(function() {
				_this._initLottery();
			});
			_this._contentsArea.find('.win .btnList #prizeBtn').click(function() {
				_this._initPrizePool();
			});
			_this._contentsArea.find('.lottery .close').click(function() {
				_this._initIndex();
				_this._bindIndexEvent();
			});
		},
		// 绑定奖池事件
		_bindPrizePoolEvent : function() {
			var _this = this;
			_this._contentsArea.find('.prizePool .close').click(function() {
				_this._initIndex();
				_this._bindIndexEvent();
			});
		},
		// 奖池的进度条以及背景
		_loadPrizePool : function() {
			var _this = this;
			$.ajax({
				url: '/p/pp',
				type: 'get',
				dataType: 'json',
				cache: false,
				success: function(data) {
					var percent = data.percent * 100 + '%';
					console.log(data);
					_this._contentsArea.find('.prizePool li').addClass('on');
					_this._contentsArea.find('.prizePool li .bar img').css('width',0);
					if (data.prizePoolLevel == 5) {
						_this._contentsArea.find('.prizePool li.rating05 .bar img').css('width',percent);
						_this._contentsArea.find('.prizePool li.rating05').attr('title','奖品：2份竹叶青12月量茶包。');
					} else if (data.prizePoolLevel == 4) {
						_this._contentsArea.find('.prizePool li.rating05').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating04 .bar img').css('width',percent);
						_this._contentsArea.find('.prizePool li.rating04').attr('title','奖品：10台车载净化器，还差' + data.nextHongBaoCount + '人可打开下级奖池；未解锁第五级，2份竹叶青12月量茶包。');
					} else if (data.prizePoolLevel == 3) {
						_this._contentsArea.find('.prizePool li.rating04').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating05').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating03 .bar img').css('width',percent);
						_this._contentsArea.find('.prizePool li.rating03').attr('title','奖品：2000个3M环保口罩，还差' + data.nextHongBaoCount + '人可打开下级奖池；未解锁第四级，奖品为10台车载净化器。');
					} else if (data.prizePoolLevel == 2) {
						_this._contentsArea.find('.prizePool li.rating03').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating04').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating05').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating02 .bar img').css('width',percent);
						_this._contentsArea.find('.prizePool li.rating02').attr('title','奖品：3000份竹叶青品饮小铁盒，还差' + data.nextHongBaoCount + '人可打开下级奖池；未解锁第三级，奖品为2000个3M环保口罩。');
					} else if (data.prizePoolLevel == 1) {
						_this._contentsArea.find('.prizePool li.rating02').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating03').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating04').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating05').removeClass('on');
						_this._contentsArea.find('.prizePool li.rating01 .bar img').css('width',percent);
						_this._contentsArea.find('.prizePool li.rating01').attr('title','奖品：5000份绿色植物盆栽，还差' + data.nextHongBaoCount + '人可打开下级奖池；未解锁第二级，奖品为3000份竹叶青品饮小铁盒。');
					}
				}
			});
		},
		// 初始化记数器
		_initCounter : function () {
			$.ajax({
				url: '/c',
				type: 'get',
				dataType: 'text',
				cache: false,
				success: function(data) {
					if (data != null) {
						$('.counter').html('');
						var padZeroCnt = data;
						if (data.length < 6) {
							padZeroCnt = Array(6-(''+data).length+1).join(0)+data;
						}
						var countHtml = '<ul>';
						var arrCnt = padZeroCnt.split('');
						for (var i = 0; i < arrCnt.length; i++) {
							countHtml += '<li>' + arrCnt[i] + '</li>';
						}
						$('.counter').append(countHtml + '</ul>');
					}
				}
			});
		},
		// 绑定查询奖品事件
		_bindSearchPrizeEvent : function() {
			var _this = this;
			_this._contentsArea.find('.search').click(function() {
				$.ajax({
					url: '/p/rpl',
					type: 'get',
					dataType: 'json',
					cache: false,
					success: function(data) {
						var prizeInfo = '';
						if ($(data).length > 0) {
							var isFirst = true;
							$(data).each(function(i,e) {
								if (isFirst) {
									prizeInfo += ('恭喜您已获得' + e.prizeName + '奖品' + e.prizeCount + '份，\n');
									isFirst = false;
								} else {
									prizeInfo += (e.prizeName + '奖品' + e.prizeCount + '份，\n');
								}
							});
							prizeInfo += '请前往竹叶青茶指定店铺领取奖品。\n';
							prizeInfo += '我们将通过\n';
							prizeInfo += '1、您的获奖截图；\n';
							prizeInfo += '2、中奖查询页面。\n';
							prizeInfo += '来核实您的获奖信息。';
						} else {
							prizeInfo = '未查到您的获奖信息。'
						}
						alert(prizeInfo);
					}
				});
			});
		},
		_showWeiboCount : function () {
			$.ajax({
				url: '/g/wb_cont',
				type: 'get',
				dataType: 'json',
				cache: false,
				success: function(data) {
					$('.num01').text('');
					$('.num02').text('');
					if (data != null) {
						$('.num01').text(data.hongBaoCount);
						$('.num02').text(data.prizePoolLevel);
					}
				}
			});
		}
	});
})(jQuery);
new com.sinaapp.zhuyeqingtea.Index();
</script>
</body>
</html>
