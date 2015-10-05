<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/product_detail.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product_detail.js"></script>

<!-- main body -->
<div class="main_body_background">
	<div class="container">
		<!-- 面包屑导航 -->
		<div>
			<ul class="breadcrumb">
				<li><a href="../home/home.html">首页</a><span class="divider">&gt;</span></li>
				<li><a href="invest_home.html">我要投资</a><span class="divider">&gt;</span></li>
				<li class="active">${product.title}</li>
			</ul>
		</div>
		   
		<div class="product_main_info_container">
			<div class="product_main_info_left">
				<!-- profit rate -->
				<div class="product_profit_container ${productCategory}">
					<div class="product_for_new_user"></div>
					<div class="product_profit_rate">
						<span id="rate">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="1" value="${product.rateOfReturn}" />
						</span>%
					</div>
					<div class="product_profit_text">预期年化收益率</div>
				</div>
				<!-- product title -->
				<div class="product_title_container">
					<div class="product_title_icon ${productCategory}"></div>
					<div class="product_title">
						<a href="/invest/invest?bidId=1034" target="_blank">${product.title}</a>
					</div>
					<span class="tips_text">
						<a target="_blank" style="color: #18b160;" href="">投资1000元，即可得20元现金！</a>					</span>				</div>
				<!-- invest info -->
				<div class="product_invest_info_container">
					<div class="invest_info_col">
						<div class="title">累计投资人数</div>
						<div class="value">
							<fmt:formatNumber groupingUsed="false" value="${product.buyPeopleNum}" />人
						</div>
					</div>
					<div class="invest_info_col_seperator"></div>
					<div class="invest_info_col">
						<div class="title">累计投资金额数</div>
						<div class="value"><fmt:formatNumber maxFractionDigits="0" value="${product.alreadyBuyNum}" /> 元</div>
					</div>
					<div class="invest_info_col_seperator"></div>
					<div class="invest_info_col">
						<div class="title">起投金额数</div>
						<div class="value"><span id="min_buy"><fmt:formatNumber maxFractionDigits="0" groupingUsed="false" value="${product.minBuy}" /></span>元</div>
					</div>
				</div>
				<!-- invest date-->
				<div class="invest_date">
					<span style="margin-left: 15px;">起息时间 : 2015-09-15</span>
					<span style="margin-left: 125px;">到期时间 : 2015-09-30</span>
				</div>
			</div>
			
			<div class="product_main_info_right">
				<div class="product_main_info_right_row">
					可用余额&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- unlogin user -->
					<c:if test="${sessionScope.user == null}"> 
						<a href="${pageContext.request.contextPath}/login">登录查看</a>
					</c:if>
					<!-- login user -->
					<c:if test="${sessionScope.user != null}"> 
						<span id="userAmount"><fmt:formatNumber maxFractionDigits="2" value="${account.balance}" />元</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/account">充值</a>
					</c:if>
				</div>
				<div class="product_main_info_right_row">
					可投金额&nbsp;&nbsp;&nbsp;&nbsp; <span id="userAmount">256,450 元</span>
				</div>
				<div class="product_main_info_right_row">
					还款方式 &nbsp;&nbsp;&nbsp;&nbsp; <span id="userAmount">到期一次性分配本金和收益</span>
				</div>
				<form action="${pageContext.request.contextPath}/invest/buy" id="invest_form">
					<div class="invest_amount_container">
						<div id="sub_button" class="sub_amount_button">-</div>
						<input id="invest_amount" class="invest_amount_input"  name="investAmount" value="1000" type="text">
						<div id="plus_button" class="plus_amount_button">+</div>
						<div class="clear"></div>
					</div>
					<a class="invest_now_button" id="invest_now" href="">开始投资</a>
					<div class="clear"></div>
					<div><span id="invest_profile_tips">预期获得的收益：0.41元</span></div>
					<div class="check_protocol_container">
						<input id="checkbox_protocol" type="checkbox"  checked="checked">我已经阅读并同意
						<a target="_blank" href="">《信托收益权转让协议》</a>
					</div>
					<input name="productId" value="${product.id}" type="hidden">
				</form>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="product_introduction">
			<!-- introduction images -->
			<div class="bid_fluid_2"></div>
			<div class="bid_fluid_3"></div>
			<div class="bid_fluid_4"></div>
			<div class="bid_fluid_1"></div>
			<div class="clear"></div>
			
			<div class="product_introduction_head1">"${product.title}"产品介绍</div>
			<div class="product_introduction_content">
				<div class="product_introduction_title1">基本规则：</div>
				<div class="product_introduction_detail">
					新用户享有一次投资“新手专享”的机会。新手专享100元起购，单户最多只能购买5000元。投资1000元以上（含1000元），产品起息后奖励20元。
				</div>
			</div>
			
			<div class="product_introduction_content gray_background">
				<div class="product_introduction_title1">收益分配：</div>
				<div class="product_introduction_detail">
					产品期限届满后的2个工作日内将本金及收益一并划付给投资人。
				</div>
			</div>
			
			<div class="product_introduction_content">
				<div class="product_introduction_title1">基本规则：</div>
				<div class="product_introduction_detail">
					新用户享有一次投资“新手专享”的机会。新手专享100元起购，单户最多只能购买5000元。投资1000元以上（含1000元），产品起息后奖励20元。
				</div>
			</div>
		</div>
	
	</div>
</div>

<%@ include file="../common/footer.jsp" %>
