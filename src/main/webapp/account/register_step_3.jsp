<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register_step_3.js"></script>

<!-- main body -->
<div class="login_background">
  <div class="container">
    <!-- background text-->
    <div class="login_background_text">
      <img src="${pageContext.request.contextPath}/images/account/shouxuan.png" alt="稳健投资的首选">
    </div>
    
    <!-- login form -->
    <div class="login_form_container register_form_container">
      <form action="" method="post">
        <div class="login_form_title_container">
            <span class="login_form_title">用户注册</span>
        </div>
        <div class="register_result">恭喜您，注册成功！</div>
        <!-- button -->
        <input type="button" class="button login" value="开通个人托管账户" id="openAccount"><br /><br />
				<input type="button" class="button login" value="返回首页" id="backToHome">
				<input type="hidden" value="${pageContext.request.contextPath}" id="context_path">
        <!-- 
        <a href="/login" class="login_form_login_now_link">已有账号？登录</a>
				-->
      </form>
    </div>
    
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
