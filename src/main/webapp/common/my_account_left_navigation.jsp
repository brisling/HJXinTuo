<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

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
		<a id="accountOverview" class="home_nav_3_item home_nav_3_title" href="${pageContext.request.contextPath}/account/home">
		  <div id="accountOverviewIcon" class="home_nav_3_icon home_nav_3_icon_1"></div>账户总览
		</a>
	  </li>
	  <li>
		<a id="" class="home_nav_3_item home_nav_3_title" href="${pageContext.request.contextPath}/account/home">
		  <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_8"></div>站内通知
		</a>
	  </li>
	  <li class="home_nav_3_header">我的投资</list>
	  <li>
		<a id="investRecord" class="home_nav_3_item home_nav_3_title" href="${pageContext.request.contextPath}/account/home">
		  <div id="investRecordIcon" class="home_nav_3_icon home_nav_3_icon_3"></div>投资记录
		</a>
	  </li>
	  <li class="home_nav_3_header">理财分享</list>
	  <li>
		<a id="" class="home_nav_3_item home_nav_3_title" href="${pageContext.request.contextPath}/account/home">
		  <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_6"></div>邀请好友
		</a>
	  </li>
	  <li>
		<a id="" class="home_nav_3_item home_nav_3_title" href="${pageContext.request.contextPath}/account/home">
		  <div id="inviteFriendsIcon" class="home_nav_3_icon home_nav_3_icon_7"></div>邀请记录
		</a>
	  </li>
	</ul>
  </div>
</div>