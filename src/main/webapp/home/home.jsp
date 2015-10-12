<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/home.js"></script>

<!-- banner && register box-->
<div class="banner">
	<div class="container home_login">
		<div class="int-wrapper">
			<div class="i1">优选产品预期年化收益率</div>
			<div class="i2">6%-12%</div>
			<div class="i3">挂钩信托&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刚性兑付</div>
			<div class="i4"><a href="${pageContext.request.contextPath}/register"><button  class="button button-hover">立即注册</button></a></div>
			<div class="i5"><a href="/login">已有账号？立即登录</a></div>
		</div>
	</div>
</div>

<!-- guide banner -->
<div class="container">
	<div class="banner2">
		<div class="title">HJ信托&nbsp;&nbsp;稳健投资者的首选</div>
		<div class="subtitle" style="color:#78868b">资产真实性已经公证机构证实</div>
		<div class="item">
			<div class="i1"><a href="${pageContext.request.contextPath}/aboutUs" target="_blank"><img src="${pageContext.request.contextPath}/images/banner/icon-profit.png" /></a></div>
			<div class="i2">低门槛，高收益</div>
			<div class="i3">1000元起投；收益与信托产品挂钩</div>
		</div>
		<div class="item">
			<div class="i1"><a href="${pageContext.request.contextPath}/aboutUs" target="_blank"><img src="${pageContext.request.contextPath}/images/banner/security.png" /></a></div>
			<div class="i2">保障措施</div>
			<div class="i3">刚性兑付，收益安全；第三方托管，资金安全</div>
		</div>
		<div class="item">
			<div class="i1"><a href="${pageContext.request.contextPath}/aboutUs" target="_blank"><img src="${pageContext.request.contextPath}/images/banner/convenient.png" /></a></div>
			<div class="i2">交易便捷、流动性强</div>
			<div class="i3">产品期限多样化；已生息资产可转让</div>
		</div>
	</div>
</div>

<!-- hot products -->
<div class="hot_products_list">
	<div class="container">
		<div class="hot_products_list_title">我们只提供精心挑选的产品 </div>
		<div class="hot_products_list_subtitle">高标准筛选 | 本金收益安全保障</div>
		
		<c:forEach items="${hotProducts}" var="product">
			<!-- product ## -->
			<c:set var="productCategory" value="xin"/>
			<c:choose>
				<c:when test="${product.category == 0}">
				   <c:set var="productCategory" value="xin"/>
				</c:when>
				<c:when test="${product.category == 1}">
				   <c:set var="productCategory" value="an"/>
				</c:when>
				<c:when test="${product.category == 2}">
				   <c:set var="productCategory" value="zhi"/>
				</c:when>
				<c:otherwise>
				   <c:set var="productCategory" value="an"/>
				</c:otherwise>
			</c:choose>
			<div class="hot_product">
				<div class="hot_product_rate_container ${productCategory}">
				  <div class="hot_product_new_user">&nbsp;</div>
					<div class="hot_product_rate">
						<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.rateOfReturn}" />%
					</div>
					<div class="hot_product_expect">预期年化收益率</div>
				</div>
				
				<div class="hot_product_title">${product.title}</div>
				<div class="hot_product_seperator"></div>
	
				<div class="hot_product_detail">
					<div class="hot_product_time_limit">
						<div class="hot_product_time_limit_icon">期限</div>
						<div class="hot_product_time_limit_days">${product.days}<span style="font-size:14px;">&nbsp;&nbsp;天</span></div>
					</div>
					
					<div class="hot_product_min_invest">
	          <div class="hot_product_min_invest_icon">起投金额</div>
	          <div class="hot_product_min_invest_num">
	          	<fmt:formatNumber type="number" maxFractionDigits="0" value="${product.minBuy}" />
	          	<span style="font-size:14px;">&nbsp;&nbsp;元</span>
	          </div>
	        </div>
				</div>
				     
	      <div class="hot_product_invest_now_btn">
	        <a class="button" href="${pageContext.request.contextPath}/invest/product?id=${product.id}">立即投资</a>
	      </div>  
			</div>
		</c:forEach>
		
	</div>
</div>


<!-- gong gao -->
<div class="gong_gao_area">
  <div class="container">
    <div class="gong_gao_title">HJ信托公告 </div>
    <div class="gong_gao_subtitle">信托最新资讯，行业前沿信息。</div>
  </div>
</div>


<%@ include file="../common/footer.jsp" %>
