// JavaScript Document

$(document).ready(function () {
	
	var contextPath = $('#context_path').val();

	$("#openAccount").click(function() {
		alert('已开通演示版模拟账户！');
		window.location.href = contextPath + "/account/";
	});
	
	$("#backToHome").click(function() {
		window.location.href = contextPath + "/";
	});
	
	$('#index').attr("class", "");
});