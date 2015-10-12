$(document).ready(function () {
	
	// 等待60秒，重新发送验证码
	var timeout = 0;
	$("#get_phone_code").click(function () {
		if (timeout > 0) {
			return;
		}	
		
		$.post( $(this).attr("href") );
		
		timeout = 60;
		$("#get_phone_code_button_text").html("已发送(60)");
	   
	    var id = setInterval(function () {
	    	--timeout;
  
	    	if (timeout == 0) {
	    		$("#get_phone_code_button_text").html("重新获取");
	    		clearInterval(id);
	    		return;
	        }
	  
	        $("#get_phone_code_button_text").html("已发送("+timeout+")");
	    }, 1000);
	    
	    return false;
	});
	
	
	$("#register_form").validate({
		rules: {
			password: {
            	required: true,
            	rangelength: [6, 16]
            },
			passwordConfirm: {
            	required: true,
            	rangelength: [6, 16],
            	equalTo:"#password"
            }
		},
		
		//error message
        messages:{
        	password: {
            	required: "请输入密码",
            	rangelength: "密码长度为6-16位"
            },
        	passwordConfirm:{
            	required: "请再次输入密码",
            	rangelength: "密码长度为6-16位",
            	equalTo: "两次密码不匹配"
            }
        },
        
        submitHandler: function() {
    		// md5 password
    		var password = $("#password").val();
    		var md5 = hex_md5(password);
    		$("#passwordMD5").val(md5);
    		
    		// clean up
    		$("#password").val("");
    		$("#passwordConfirm").val("");

    		// submit form
    		$('#register_form').ajaxSubmit(function(data) {
    			if (data.status == 0) {
    				// success
    				window.location.href = data.redirectUrl;
    			} 
    			else if (data.status == 1)
    			{
    				// mismatch
    				//alert("usrname or password mismatch !");
    				$("#reg_err_password_confirm").html("<label>" + data.message + "</label>");
    			}
    		});
    	},
        
        // where to display error message
        errorPlacement: function (error, element) {
        	error.appendTo(element.parent().children(".error_tip"));
        }
	});
    
	$('#index').attr("class", "");
})