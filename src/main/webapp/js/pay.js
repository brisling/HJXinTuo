// JavaScript Document

$(document).ready(function () {

  $("#notice1").hover(
    // move in 
    function () {
      $(".account-overview-box").fadeIn();
    },
    // move out
    function () {
      $(".account-overview-box").fadeOut();
    }
  );
  
  $("#notice2").hover(
    // move in 
    function () {
      $(".account-overview-box2").fadeIn();
    },
    // move out
    function () {
      $(".account-overview-box2").fadeOut();
    }
  );
  
//  $("#rechargeButton").click(function(){
//	  var href = $(this).attr("href");
//	  $.ajax({
//		   type: "POST",
//		   url: href,
//		   success: function(data){
//		     alert(data.msg);
//		     window.location.href = data.redirectUrl;
//		   }
//		});
//	  
//	  return false;
//  });
  
  
  $("#withdrawButton").click(function(){
    alert("亲，试用版不能提现哦~");
    return false;
  });
  
  
  $('#index').attr("class", "");
  $('#acountHome').attr("class", "nav_li_focus");
  
});