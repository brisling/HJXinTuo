// JavaScript Document

$(document).ready(function () {
	
	var contextPath = $('#context_path').val();

	$("#openAccount").click(function() {
		alert('【演示版】开通成功！');
		window.location.href = contextPath + "/account/";
	});
	
	$("#backToHome").click(function() {
		window.location.href = contextPath + "/";
	});
	
});