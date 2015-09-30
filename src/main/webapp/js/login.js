// JavaScript Document

$(document).ready(function () {

	$("#login_form").validate({
		rules: {
            userName: {
            	required: true,
            	isMobile: true
            }, 
            password: {
                required: true,
                rangelength: [6, 16]
            }
		},
		
		//error message
        messages:{
            userName:{
            	required: "请输入手机号"
            },
            password:{
                required: "请输入密码",
                rangelength: "请输入6-16位的密码"
            }
        },
        
        // where to display error message
        errorPlacement: function (error, element) {
        	 error.appendTo(element.next(".error_tip"));
        }
	});
	
	$("#submit_button").click(function() {
		// md5 password
		var password = $("#password").val();
		var md5 = hex_md5(password);
		$("#passwordMD5").val(md5);
		
		// clean up
		$("#password").val("");

		// submit form
		$('#login_form').ajaxSubmit(function(data) {
			if (data.status == 0) {
				// success
				window.location.href = data.redirectUrl;
			} 
			else if (data.status == 1)
			{
				// mismatch
				//alert("usrname or password mismatch !");
				$("#login_error_tip").html("<label>" + data.message + "</label>");
			}
		});
	});
	
	$("#userName").focus(function () {
		$("#login_error_tip").html("");
	});
	
	$("#password").focus(function () {
		$("#login_error_tip").html("");
	});
	
});