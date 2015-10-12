<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/additional_methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register_step_2.js"></script>


<!-- main body -->
<div class="login_background">
  <div class="container">
    <!-- background text-->
    <div class="login_background_text">
      <img src="${pageContext.request.contextPath}/images/account/shouxuan.png" alt="稳健投资的首选">
    </div>
    
    <!-- login form -->
    <div class="login_form_container register_form_container">
      <form action="${pageContext.request.contextPath}/do_register_step_2" method="post" id="register_form">
        <div class="login_form_title_container">
            <span class="login_form_title">注册</span><span class="">（短信验证码已发送到手机）</span>
        </div>
        <!-- verify code -->
        <div class="login_form_item">
          <label class="login_form_item_lable login_form_item_lable2"><span class="error_tip">*</span>短信验证码：</label>
          <div class="login_form_item_control">
            <input type="text" class="default verify_code" id="verify_code" value="" name="verifyCode" placeholder="演示版，随便填" autocomplete="false">
            <a id="get_phone_code" class="get_phone_code_button" href="${pageContext.request.contextPath}/SMSCode"><span id="get_phone_code_button_text">重新发送</span></a>
            <span id="reg_err_verify_code" class="error_tip"></span>
          </div>
        </div>
        <!-- password -->
        <div class="login_form_item">
          <label class="login_form_item_lable login_form_item_lable2"><span class="error_tip">*</span>设置密码：</label>
          <div class="login_form_item_control">
            <input type="password" class="default" id="password" value="" name="password" placeholder="请输入密码" autocomplete="false">
            <span id="reg_err_password" class="error_tip"></span>
            <input type="hidden" class="default" id="passwordMD5" name="passwordMD5" value="" >
          </div>
        </div>
        <!-- confirm password -->
        <div class="login_form_item">
          <label class="login_form_item_lable login_form_item_lable2"><span class="error_tip">*</span>确认密码：</label>
          <div class="login_form_item_control">
            <input type="password" class="default" id="passwordConfirm" value="" name="passwordConfirm" placeholder="请再次输入密码" autocomplete="false">
            <span id="reg_err_password_confirm" class="error_tip"></span>
          </div>
        </div>
        <!-- submit button -->
        <input type="submit" class="button login" value="下一步" id="submit_button">
        <!-- login now -->
        <a href="${pageContext.request.contextPath}/login" class="login_form_login_now_link">已有账号？登录</a>
      </form>
    </div>
    
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
