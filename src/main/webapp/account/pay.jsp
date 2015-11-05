<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pay.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pay.js"></script>


<!-- main body -->
<div class="main_body_background">
  <div class="container">
  	<!-- 左侧导航区 -->
    <%@ include file="../common/my_account_left_navigation.jsp" %>
    
    <!-- 右侧内容区 -->
    <div class="right_area_container">
      <!-- 充值-->
      <div class="invest_record">
        <form method="post" action="${pageContext.request.contextPath}/yeepay/reqpay.jsp">
			<div>商家订单号:<input type="text" name="p2_Order" id="p2_Order" /></div>
			<div>支付金额:<input type="text" name="p3_Amt" id="p3_Amt" value="0.01" />&nbsp;<span style="color:#FF0000;font-weight:100;">*</span></div>
			<div>商品名称:<input type="text" name="p5_Pid" id="p5_Pid" value="Xunlei finance" /></div>
			<div>商品种类:<input type="text" name="p6_Pcat" id="p6_Pcat" value="producttype" /></div>
			<div>商品描述:<input type="text" name="p7_Pdesc" id="p7_Pdesc" value="productdesc" /></div>
			<div>商户接收支付成功数据的地址:<input type="text" name="p8_Url" id="p8_Url" value="http://localhost:8080${pageContext.request.contextPath}/yeepay/callback.jsp"/>&nbsp;<span style="color:#FF0000;font-weight:100;">*</span></div>
			<div>
				是否需要送货地址:<select name="p9_SAF" id="p9_SAF">
					<option value="0">不需要
					</option>
					<option value="1">需要
					</option>
				</select>
			</div>
			<div>商家扩展信息:<input type="text" name="pa_MP" id="pa_MP" value="userId or other" /></div>
			<div>支付通道编码:<input type="text" name="pd_FrpId" id="pd_FrpId" /><!--支付通道编码在易宝支付产品(HTML版)通用接口使用说明中--></div>
			<div><input type="submit" value="充值" /></div>
		</form>
      </div>
    </div>
      
    <div class="clear"></div>
  </div>
</div>

<div class="clear"></div>


<%@ include file="../common/footer.jsp" %>