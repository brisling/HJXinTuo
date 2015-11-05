<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/invest_home.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/invest_home.js"></script>


<!-- main body -->
<div class="main_body_background">
	<div class="container">
		<!-- product list -->
		<div class="product_list">
			<c:forEach items="${pagination.objectList}" var="product">
				<div class="product">
				<!-- 不同类型的产品显示不同的样式 -->
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
						<c:when test="${product.category == 3}">
						   <c:set var="productCategory" value="jie"/>
						</c:when>
						<c:otherwise>
						   <c:set var="productCategory" value="an"/>
						</c:otherwise>
					</c:choose>
					<!-- profit rate -->
					<div class="product_profit_container ${productCategory}">
						<div class="product_for_new_user"></div>
						<div class="product_profit_rate">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="1" value="${product.rateOfReturn}" />%
						</div>
						<div class="product_profit_text">预期年化收益率</div>
					</div>
					<!-- product title -->
					<div class="product_title_container">
						<div class="product_title_icon ${productCategory}"></div>
						<div class="product_title">
							<a href="${pageContext.request.contextPath}/invest/product?id=${product.id}" target="_blank">${product.title}</a>
						</div>
					</div>
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
							<div class="value"><fmt:formatNumber type="number" maxFractionDigits="0" value="${product.minBuy}" />元</div>
						</div>
					</div>
					<!-- invest button -->
					<div class="product_invest_button_container">
						<div class="invest_days_container">
							<div class="invest_days_icon"></div>
							<div class="invest_days_title">期限</div>
							<div class="invest_days">${product.days}<span style="font-size:16px;">&nbsp;天</span></div>
						</div>
						<div class="invest_button">
							<a class="button red invest" target="_blank" href="${pageContext.request.contextPath}/invest/product?id=${product.id}">投 资</a>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<!-- pagination -->
			<div class="page_list_container">
				<div class="page_list">
					<span class="page_count">共${pagination.pageCount}页</span>
					<c:if test="${pagination.isFirstPage == 0}" > 
						<a class="page_prev" href="${pageContext.request.contextPath}/invest?page=${pagination.currentPage-1}">&nbsp;</a>
					</c:if>
					<c:forEach items="${pagination.navigatePages}" var="pageIndex">
						<c:choose>
							<c:when test="${pagination.currentPage == pageIndex}" >
								<a class="page_no current_page" href="javascript:void(0)">${pageIndex}</a>
							</c:when>
							<c:otherwise>
								<a class="page_no" href="${pageContext.request.contextPath}/invest?page=${pageIndex}">${pageIndex}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pagination.isLastPage == 0}" > 
						<a class="page_next" href="${pageContext.request.contextPath}/invest?page=${pagination.currentPage+1}">&nbsp;</a>
					</c:if>
					<span class="page_text">到第</span>
					<input class="page_input" type="text" id="goPage" value="1">
					<span class="page_text">页</span>
					<a class="page_button" id="jumpPage" href="${pageContext.request.contextPath}/invest">确定</a>
				</div>
			</div>
		</div>
		
		<!-- right area -->
		<div class="invest_home_right">
			<!-- app 下载 -->
			<div class="app_info">
				<div class="header">
					<div class="title">迅雷金融APP</div>
					<div class="more_text">随时随地轻松理财</div>
				</div>
				<div class="app_info_img">&nbsp;</div>
			</div>
			<!-- 投资概览 -->
			<div class="invest_overview">
				<div class="header">
					<div class="title">投资概览</div>
				</div>
				<div class="bgimg"></div>
				<div class="items"></div>
			</div>
			<!-- 官方公告 -->
			<div class="notice">
				<div class="header">
					<div class="title">官方公告</div>
				</div>
				<div class="items">
					<div class="item">
						<a href="javascript:void(0)" target="_blank">HJ信托新手专享强势回归！</a>
					</div>
					<div class="item">
						<a href="javascript:void(0)" target="_blank">HJ信托新手专享强势回归！</a>
					</div>
					<div class="item">
						<a href="javascript:void(0)" target="_blank">HJ信托新手专享强势回归！</a>
					</div>
					<div class="item">
						<a href="javascript:void(0)" target="_blank">HJ信托新手专享强势回归！</a>
					</div>
					<div class="item">
						<a href="javascript:void(0)" target="_blank">HJ信托累计交易额突破100亿元！！！</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="clear"></div>
		   
	</div>
</div>

<%@ include file="../common/footer.jsp" %>

