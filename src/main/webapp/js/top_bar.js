// JavaScript Document

$(document).ready(function () {
	// weixin
	$(".top_bar_weixin_btn").hover(
		// move in 
		function () {
			$(".ban2_3_0").css("background-position", "0px 4px");
			$(".top_bar_weixin_btn_box").show();
		},
		// move out
		function () {
			$(".ban2_3_0").css("background-position", "0px -30px");
			$(".top_bar_weixin_btn_box").hide();
		}
	);
	
	// App
	$(".top_bar_app_btn").hover(
		// move in 
		function () {
			$(".ban2_4_0").css("background-position", "-40px 3px");
			$(".top_bar_app_btn_box").show();
		},
		// move out
		function () {
			$(".ban2_4_0").css("background-position", "-40px -31px");
			$(".top_bar_app_btn_box").hide();
		}
	);
	
	// sina weibo
	$(".top_bar_sina_btn").hover(
		// move in 
		function () {
			$(".ban2_1_0").css("background-position", "-90px 4px");
			$(".top_bar_sina_btn_box").show();
		},
		// move out
		function () {
			$(".ban2_1_0").css("background-position", "-90px -30px");
			$(".top_bar_sina_btn_box").hide();
		}
	);
	
	// QQ
	$(".top_bar_qq_btn").hover(
		// move in 
		function () {
			$(".ban2_5_0").css("background-position", "-184px 0px");
			$(".top_bar_qq_btn_box").show();
		},
		// move out
		function () {
			$(".ban2_5_0").css("background-position", "-186px -32px");
			$(".top_bar_qq_btn_box").hide();
		}
	);
	

});