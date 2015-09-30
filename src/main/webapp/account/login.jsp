<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/additional_methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

<!-- main body -->
<div class="login_background">
  <div class="container">
  
    <!-- background text-->
    <div class="login_background_text">
      <img src="${pageContext.request.contextPath}/images/account/shouxuan.png" alt="稳健投资的首选">
    </div>
    
    <!-- login form -->
    <div class="login_form_container">
      <form action="${pageContext.request.contextPath}/do_login" method="post" id="login_form">
        <div class="login_form_title_container">
            <span class="login_form_title">用户登录</span>
        </div>
        <!-- phone -->
        <div class="login_form_item">
          <label class="login_form_item_lable"><span class="error_tip">*</span>手机号：</label>
          <div class="login_form_item_control">
            <input type="text" class="default" id="userName" name="userName" placeholder="请输入电话号码">
            <span class="error_tip" id="username_error_tip"></span>
            <span class="error_tip" id="login_error_tip"></span>
          </div>
        </div>
        <!-- password-->
        <div class="login_form_item">
          <label class="login_form_item_lable"><span class="error_tip">*</span>密&nbsp;&nbsp;&nbsp;码：</label>
          <div class="login_form_item_control">
            <input type="password" class="default" id="password" name="password" placeholder="请输入密码">
            <input type="hidden" id="passwordMD5" name="passwordMD5">
            <span class="error_tip"></span>
          </div>
        </div>
        <!-- submit button -->
        <input type="button" id="submit_button" class="button login" value="登录">
      </form>
			<!-- help -->
			<div class="forget_password">
			  <a href="javascript:void(0)" class="forget_password_link">忘记密码</a>
			  <span class="login_form_vertical_seperator">|</span>
			  <a href="${pageContext.request.contextPath}/register" class="forget_password_link">立即注册</a>
			</div>
    </div>
    
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
