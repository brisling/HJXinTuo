// JavaScript Document

$(document).ready(function () {

	$("#register_form").validate({
		rules: {
            phone: {
            	required: true,
            	isMobile: true,
            	remote: {        //验证用户名是否存在
 	               type: "POST",
 	               url: "validate_phone",  
 	               dataType: "json"
 	            }
            },
            verifyCode: {
            	required: true,
            	remote: {        
  	               type: "POST",
  	               url: "verify_code",  
  	               dataType: "json"
  	            }
            }
		},
		
		//error message
        messages:{
        	phone:{
            	required: "请输入手机号",
            	remote: "手机号已注册"
            },
			verifyCode:{
            	required: "请输入验证码",
            	remote: "验证码错误"
            }
        },
        
        // where to display error message
        errorPlacement: function (error, element) {
        	 error.appendTo(element.parent().children(".error_tip"));
        }
	});
	
	$('#register_form').ajaxForm(function(data) {
		if (data.status == 0) {
			// success
			window.location.href = data.redirectUrl;
		} 
		else if (data.status == 1)
		{
			// mismatch
			//alert("usrname or password mismatch !");
			$("#username_error_tip").html("<label>" + data.message + "</label>");
		}
	});
	
	$(".verify_code_img").click(function() {
        var url = $(this).attr("src"); 
        var timestamp = (new Date()).valueOf();  
        var i = url.indexOf("?");
        if (i != -1) {
        	url = url.substring(0, i);
		}
        url = url + "?timestamp=" + timestamp; 
        $(this).attr("src", url);
	});
	
});