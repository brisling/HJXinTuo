/*验证手机号码*/
jQuery.validator.addMethod("isMobile", function(value, element) {   
    var tel = /^1[3|4|5|7|8][0-9]{9}$/;
    return this.optional(element) || (tel.test(value));
}, "请输入正确格式的手机号码");

jQuery.validator.addMethod("isEmailOrMobile", function(value, element) {   
    var tel = /^^1[3|4|5|7|8][0-9]{9}$/;
    var mail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    return this.optional(element) || (tel.test(value)) || (mail.test(value));
}, "请输入正确格式的手机号码或邮箱");