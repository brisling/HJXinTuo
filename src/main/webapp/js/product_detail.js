// JavaScript Document

$(document).ready(function () {
	
	$("#sub_button").click(function () {
      var num = parseFloat($("#invest_amount").val());
      num -= 1000;
      if (num < 0) {
    	  num = 0;
      }
      $("#invest_amount").val(num);
      calcProfit();
    });
	
	$("#plus_button").click(function () {
      var num = parseFloat($("#invest_amount").val());
      num += 1000;
      $("#invest_amount").val(num);
      calcProfit();
    });
	
	// 输入投资额
	$("#invest_amount").keyup(function() {
		var value = $(this).val();
		value = value.replace(/[^\d]/g,'');
		$(this).val(value);
		calcProfit();
	});
	
	$("#invest_amount").focus(function() {
		$("#plus_button").css("margin-left", "0");
	});
	
	$("#invest_amount").blur(function() {
		$("#plus_button").css("margin-left", "-1px");
		var value = parseFloat( $(this).val() );
		$(this).val(value);
	});
	
	// 计算收益
	function calcProfit() {
		var invest_amount = parseInt( $("#invest_amount").val() );
		var minBuy = parseInt( $("#min_buy").html() );
		if (invest_amount < minBuy) {
			$("#invest_profile_tips").html("最小投资额："+minBuy+"元");
			return;
		}
		var rate = parseFloat($("#rate").html());
		var profit = invest_amount * rate / 100;
		profit = profit.toFixed(2);
		$("#invest_profile_tips").html("预期获得收益："+profit+"元");
	}
	
	// 提交购买订单
	$("#invest_now").click(function() {
		// submit form
		$('#invest_form').ajaxSubmit(function(data) {
			if (data.status == 0) {
				// success
				alert(data.message);
				window.location.href = data.redirectUrl;
			} 
			else if (data.status == 1)
			{
				alert(data.message);
			}
		});
		
		return false;
	});
	
	// 设置当前导航项的颜色
	$('#index').attr("class", "");
	$('#invests').attr("class", "nav_li_focus");
	
});