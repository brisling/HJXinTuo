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
  
});