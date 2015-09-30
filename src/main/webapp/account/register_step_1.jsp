<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/additional_methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register_step_1.js"></script>

<!-- main body -->
<div class="login_background">
  <div class="container">
    <!-- background text-->
    <div class="login_background_text">
      <img src="${pageContext.request.contextPath}/images/account/shouxuan.png" alt="稳健投资的首选">
    </div>
    
    <!-- login form -->
    <div class="login_form_container register_form_container">
      <form action="${pageContext.request.contextPath}/do_register_step_1" method="post" id="register_form">
        <div class="login_form_title_container">
            <span class="login_form_title">10秒快速注册</span>
        </div>
        <!-- phone -->
        <div class="login_form_item">
          <label class="login_form_item_lable"><span class="error_tip">*</span>手机号：</label>
          <div class="login_form_item_control">
            <input type="text" class="default" id="phone" value="" name="phone" placeholder="请填写电话号码" autocomplete="false">
            <span id="reg_err_phone" class="error_tip"></span>
          </div>
        </div>
        <!-- verify code -->
        <div class="login_form_item">
          <label class="login_form_item_lable"><span class="error_tip">*</span>校验码：</label>
          <div class="login_form_item_control">
            <input type="text" class="default verify_code" id="verifyCode"  name="verifyCode" placeholder="请填写校验码" autocomplete="false">
            <img class="verify_code_img" src="${pageContext.request.contextPath}/verification_code" width="70px", height="35px"><br>
            <span id="reg_err_verify_code" class="error_tip"></span>
          </div>
        </div>
        <!-- invite code -->
        <div class="login_form_item">
          <label class="login_form_item_lable">邀请码：</label>
          <div class="login_form_item_control">
            <input type="text" class="default" id="invite_code" value="" name="inviteCode" placeholder="请填写邀请码(选填)" autocomplete="false">
            <span id="reg_err_invite_code" class="error_tip"></span>
          </div>
        </div>
        <!-- check user protocol -->
        <div class="login_form_item_control">
          <input type="checkbox" class="default check_protocol" id="check_protocol" value="" name="checkProtocol" checked>
           我已阅读并同意
           <a class="protocol" href="#">《用户注册协议》</a>
          <span id="reg_err_check_protocol" class="error_tip"><br>&nbsp;</span>
        </div>
        <!-- submit button -->
        <input type="submit" class="button login" value="下一步">
        <!-- login now -->
        <a href="${pageContext.request.contextPath}/login" class="login_form_login_now_link">已有账号？登录</a>
      </form>
    </div>
    
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
