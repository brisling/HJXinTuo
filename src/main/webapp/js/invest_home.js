// JavaScript Document

$(document).ready(function () {
	// product
	$(".product").hover(
    // move in 
    function () {
      $(this).css("-webkit-box-shadow", "0 3px 20px #8a8a8a");
      $(this).css("-moz-box-shadow", "0 3px 20px #8a8a8a");
      $(this).css("box-shadow", "0 3px 20px #8a8a8a");
    },
    // move out
    function () {
      $(this).css("-webkit-box-shadow", "");
      $(this).css("-moz-box-shadow", "");
      $(this).css("box-shadow", "");
    }
  );
  
  // 设置当前导航项的颜色
  $('#index').attr("class", "");
  $('#invests').attr("class", "nav_li_focus");
  
  $('#jumpPage').click(function(){
	 var pageIndex = $('#goPage').val();
	 var url = $('#jumpPage').attr("href") + "?page=" + pageIndex;
	 window.location.href = url;
	 return false;
  });
	
});