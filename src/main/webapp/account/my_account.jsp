<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ include file="../common/header.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_account.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my_account.js"></script>


<!-- main body -->
<div class="main_body_background">
  <div class="container">
    <!-- 左边导航区 -->
    <div class="home_nav">
      <div class="home_nav_1"><span>试用版，欢迎 !</span></div>
      <div class="home_nav_2">
        <div class="home_nav_2_1">可用余额</div>
        <div class="home_nav_2_2"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${account.balance}" /></div>
        <a class="button button_recharge" id="rechargeButton" href="${pageContext.request.contextPath}/recharge">充&nbsp;&nbsp;&nbsp;值</a>
        <a class="button button_withdraw" id="withdrawButton">提&nbsp;&nbsp;&nbsp;现</a>
      </div>
      <div class="home_nav_3">
        <ul class="home_nav_3_list">
          <li class="home_nav_3_header">我的账户</list>
          <li>
            <a id="accountOverview" class="home_nav_3_item home_nav_3_title" href="/account/home">
              <div id="accountOverviewIcon" class="home_nav_3_icon home_nav_3_icon_1"></div>账户总览
            </a>
          </li>
          <li>
            <a id="" class="home_nav_3_item home_nav_3_title" href="/account/home">
              <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_8"></div>站内通知
            </a>
          </li>
          <li class="home_nav_3_header">我的投资</list>
          <li>
            <a id="investRecord" class="home_nav_3_item home_nav_3_title" href="/account/home">
              <div id="investRecordIcon" class="home_nav_3_icon home_nav_3_icon_3"></div>投资记录
            </a>
          </li>
          <li class="home_nav_3_header">理财分享</list>
          <li>
            <a id="" class="home_nav_3_item home_nav_3_title" href="/account/home">
              <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_6"></div>邀请好友
            </a>
          </li>
          <li>
            <a id="" class="home_nav_3_item home_nav_3_title" href="/account/home">
              <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_7"></div>邀请记录
            </a>
          </li>
        </ul>
      </div>
    </div>
    
    <!-- 右侧内容区 -->
    <div class="right_area_container">
      
      <!-- 资产和收益 -->
      <div class="accountView_top">
        <div class="accountView_top_left">
          <span class="accountView_title">总资产&nbsp;<br><br></span>
          <span class="accountView_number"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${account.balance}" /></span>
          <div class="accountView_top_left_notice">
            <img src="../images/other/notice.png" width="15px" height="15px" id="notice1">
            <div class="account-overview-box">
              <em class="arrow3"></em>
              <span class="arrow3-box">总资产=本金+收益+可用余额</span>
            </div>
          </div>
        </div>
 
        <div class="accountView_top_right">
          <span class="accountView_title">累计净收益<br><br></span>
          <span class="accountView_number">0.00</span>
          <div class="accountView_top_right_notice2">
            <img src="../images/other/notice.png" width="15px" height="15px" id="notice2">
            <div class="account-overview-box2">
              <em class="arrow4"></em>
              <span class="arrow4-box">累计收益=已结清的收益+当前收益+转让收入</span>
            </div>
          </div>
        </div>
      </div>
      
      <!-- 投资列表 -->
      <div class="invest_record">
        <table class="invest_record_table">
          <thead class="invest_record_thead">
            <tr>
              <th width="330px">名称</th>
              <th width="100px">年化收益率</th>
              <th width="109px">投资金额</th>
              <th width="91px">起息时间</th>
              <th width="91px">到期时间</th>
            </tr>
          </thead>
          <tr>
            <td>这是示例，如果是真的，你已经是世界首富了</td>
            <td>200.00%</td>
            <td>60,000</td>
            <td>1832-08-08</td>
            <td>2014-08-08</td>
          </tr>
          <c:forEach items="${investRecords}" var="investRecord">
          <tr>
            <td>${investRecord.product.title}</td>
            <td><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${investRecord.product.rateOfReturn}" />%</td>
            <td><fmt:formatNumber maxFractionDigits="2" value="${investRecord.investNum}" /></td>
            <td>${investRecord.product.startDate}</td>
            <td>${investRecord.product.endDate}</td>
          </tr>
          </c:forEach>
        </table>
      </div>
      
    <div class="clear"></div>
  </div>
</div>
<div class="clear"></div>


<%@ include file="../common/footer.jsp" %>