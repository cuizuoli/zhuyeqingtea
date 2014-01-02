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
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<!--=========wrapper=========-->
<div id="wrapper">
<!--====contentsArea====-->
<div id="contentsArea" class="haze" style="display:none;">
<div class="scratch">
<p><img src="images/img_scratch02.png" alt="" /></p>
<p><img src="images/img_scratch01.png" alt="" /></p>
</div>
<div class="gamePop01" style="display:none;">
<p class="gameTxt"><img src="images/txt_game01.png" alt="你已经成功为成都送出一个红包，感谢您的参与!再为成都送出XXX个红包即可打开茶弈基金第一关。是否邀请朋友继续参与活动或将活动分享到朋友圈" /></p>
<ul class="btnList">
<li><a id="nextShareBtn" href="javascript:void(0);"><img src="images/btn_no.png" alt="下次再说" /></a></li>
<li><a id="shareBtn" href="javascript:void(0);"><img src="images/btn_yes.png" alt="是" /></a></li>
</ul>
</div>

<p class="success" style="display:none;"><img src="images/img_success.png" alt="分享成功!" /></p>

<div class="gamePop02" style="display:none;">
<p class="gameTxt"><img src="images/txt_game02.gif" alt="绿茶生活，远离雾霾，拒绝烟花 2014新年快乐" /></p>
<ul class="btnList">
<li><a id="nextShareConfirmBtn" href="javascript:void(0);"><img src="images/btn_confirm.gif" alt="确定" /></a></li>
</ul>
</div>

<div class="gamePop03" style="display:none;">
<p class="textCont"><textarea name="textCont" rows="2" cols="" id="textCont"></textarea></p>
<ul class="btnList">
<li><a id="shareConfirmBtn" href="javascript:void(0);"><img src="images/btn_share01.png" alt="分享到新浪微博" /></a></li>
</ul>
<p class="weChat"><a id="weixinShareBtn" href="javascript:void(0);"><img src="images/btn_wechat.png" alt="" /></a></p>
<p class="close"><a id="closeShareBtn" href="javascript:void(0);"><img src="images/btn_close.png" alt="" /></a></p>
</div>

<div class="gamePop04" style="display:none;">
<p class="weChat"><span id="qrcode"></span></p>
<p class="close"><a id="closeWeixinShareBtn" href="javascript:void(0);"><img src="images/btn_close.png" alt="" /></a></p>
</div>
</div>
<!--====contentsArea end====-->
<!--====headerArea====-->
<div id="headerArea" style="display:none;">
<h1><img src="images/title.png" alt="绿茶生活，远离雾霾，拒绝烟花" /></h1>
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
			_this._initContent();
			_this._initCounter();
		},
		// 初始化首页
		_initIndex : function() {
			var _this = this;
			_this._headerArea.show();
			_this._headerArea.find('.explan').show();
			_this._contentsArea.hide();
		},
		// 初始化内容页
		_initContent : function() {
			var _this = this;
			_this._contentsArea.find('.scratch').show();
			_this._contentsArea.find('.gamePop01').hide();
			_this._contentsArea.find('.gamePop02').hide();
			_this._contentsArea.find('.gamePop03').hide();
			_this._contentsArea.find('.gamePop04').hide();
			_this._contentsArea.find('.success').hide();
			_this._sp.wScratchPad('reset');
		},
		// 绑定事件
		_bindEvent : function() {
			var _this = this;
			_this._bindIndexEvent();
			_this._bindGameEvent();
			_this._bindWeiboEvent();
		},
		// 绑定活动介绍事件
		_bindIndexEvent : function() {
			var _this = this;
			_this._root.mousemove(function(e) {
				_this._root.unbind('mousemove');
				_this._headerArea.find('.explan').fadeOut(4000);
				_this._contentsArea.fadeIn(1000);
			});
		},
		_bindGameEvent : function() {
			var _this = this;
			_this._sp = _this._contentsArea.find('.scratch').wScratchPad({
				width: 486,
				height: 364,
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
								if (data.count == 0 && data.hongBaoCount == 0 && data.prizePoolLevel == 0) {
									alert('每天只能参加五次活动！');
									_this._initIndex();
									_this._initContent();
									_this._bindIndexEvent();
								} else {
									_this._contentsArea.find('.scratch').fadeOut(500);
									// 弹出"你已经成功为成都送出一个红包"
									_this._contentsArea.find('.gamePop01').show();
									_this._initCounter();
								}
							}
						});
					}
				}
			});
		},
		_bindWeiboEvent : function() {
			var _this = this;
			// 弹出"分享到新浪微博"窗口
			_this._contentsArea.find('.gamePop01 #shareBtn').click(function() {
				$.ajax({
					url: '/g/wb_cont',
					type: 'get',
					dataType: 'json',
					success: function(data) {
						console.log(data);
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
						_this._contentsArea.find('.success').fadeIn(500, function() {
							_this._initIndex();
							_this._initContent();
							_this._bindIndexEvent();
						});
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
				$('#qrcode').qrcode({width: 120,height: 120,text: window.location.href});
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
				_this._initContent();
				_this._bindIndexEvent();
			});
		},
		_initCounter : function () {
			$.ajax({
				url: '/c',
				type: 'get',
				dataType: 'text',
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
		}
	});
})(jQuery);
new com.sinaapp.zhuyeqingtea.Index();
</script>
</body>
</html>
