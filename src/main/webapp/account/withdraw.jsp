<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/withdraw.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/withdraw.js"></script>


<!-- main body -->
<div class="main_body_background">
  <div class="container">
  	<!-- 左侧导航区 -->
    <%@ include file="../common/my_account_left_navigation.jsp" %>
    
    <!-- 右侧内容区 -->
    <div class="right_area_container">
      <!-- 充值-->
      <div class="invest_record">
        <form method="post" action="">
			<div>提取金额:<input value="0.01" />&nbsp;<span style="color:#FF0000;font-weight:100;">*</span></div>
			<div><input type="button" id="withdraw_submit" value="提交" /></div>
		</form>
      </div>
    </div>
      
    <div class="clear"></div>
  </div>
</div>

<div class="clear"></div>


<%@ include file="../common/footer.jsp" %>