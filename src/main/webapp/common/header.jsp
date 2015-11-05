<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>迅雷金融，稳健投资者首选</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/top_bar.js"></script>

</head>
<body>

<!-- top bar -->
<div class="top_bar">
	<div class="container">
		<!-- 社交分享-->
		<ul>
			<li>
				<a href="" class="top_bar_weixin_btn">
					<em class="ban2 ban2_3_0">&nbsp;</em>
				</a>
				<!-- 弹出框 -->
				<div class="top_bar_weixin_btn_box" style="display: none;">
					<em class="top_bar_btn_box_arrow"></em>
					<p class="top_bar_btn_box_title">HJ信托微信号：xintuo</p>
					<div class="pic_box">
						<img src="${pageContext.request.contextPath}/images/common/wx2wm.jpg" class="top_bar_btn_box_img" alt="信托微信号" />
					</div>
				</div>
			</li>
			<li>
				<span class="top_bar_btn_seperator">|</span>
			</li>
			<li>
				<a href="" class="top_bar_app_btn">
					<em class="ban2 ban2_4_0">&nbsp;</em>
				</a>
				<!-- 弹出框 -->
				<div class="top_bar_app_btn_box" style="display: none;">
					<em class="top_bar_btn_box_arrow"></em>
					<p class="top_bar_btn_box_title">扫描下载App</p>
					<div class="pic_box">
						<img src="${pageContext.request.contextPath}/images/common/51xintuo_qr_code.jpg" class="top_bar_btn_box_img" alt="手机客户端" title="手机客户端" />
					</div>
				</div>
			</li>
			<li>
				<span class="top_bar_btn_seperator">|</span>
			</li>
			<li>
				<a href="" class="top_bar_sina_btn">
					<em class="ban2 ban2_1_0">&nbsp;</em>
				</a>
				<!-- 弹出框 -->
				<div class="top_bar_sina_btn_box" style="display: none;">
					<em class="top_bar_btn_box_arrow"></em>
					<p class="top_bar_btn_box_title">新浪官方微博</p>
					<div class="pic_box">
						<img src="${pageContext.request.contextPath}/images/common/sina2wm.png" class="top_bar_btn_box_img" alt="新浪官方微博" title="新浪官方微博" />
					</div>
				</div>
			</li>
			<li>
				<span class="top_bar_btn_seperator">|</span>
			</li>
			<li>
				<a href="" class="top_bar_qq_btn">
					<em class="ban2 ban2_5_0">&nbsp;</em>
				</a>
				<!-- 弹出框 -->
				<div class="top_bar_qq_btn_box" style="display: none;">
					<em class="top_bar_btn_box_arrow"></em>
					<p class="top_bar_btn_box_title">官方QQ群</p>
					<div class="pic_box">
						<img src="${pageContext.request.contextPath}/images/common/qq2wm7.png" class="top_bar_btn_box_img" alt="官方QQ群" title="官方QQ群" />
					</div>
				</div>
			</li>
			<li>
				<span class="top_bar_btn_seperator">|</span>
			</li>
		</ul>
		<!-- 客服电话 -->
		<p class="sm_top_tel">
			<em class="ban2">&nbsp;</em>
			<span>400-9951-051</span>
		</p>
		<!-- 注册，登录 -->
		<p class="sm_top_help">
			<span>
				<!-- unlogin user -->
				<c:if test="${sessionScope.user == null}">
				<a rel="nofollow" id="login-panel" href="${pageContext.request.contextPath}/login">迅雷金融欢迎您，请登录</a>&nbsp;｜&nbsp;
				<a rel="nofollow" id="create-account" href="${pageContext.request.contextPath}/register" class="btn-register">注册账户</a>
				</c:if>
				
				<!-- login user -->
				<c:if test="${sessionScope.user != null}">
				<a rel="nofollow" id="login-panel" href="${pageContext.request.contextPath}/account">欢迎您，${sessionScope.user.userName}</a>&nbsp;｜&nbsp;
				<a rel="nofollow" id="create-account" href="${pageContext.request.contextPath}/logout" class="btn-register">安全退出</a>
				</c:if>
        
        &nbsp;|&nbsp; <a href="javascript:void(0);">新手指引</a>
			</span>
		</p>
	</div>
</div>
<div style="clear"></div>

<!-- main navigator -->
<div class="nav">
	<div class="container">
		<div class="logo">
			<a href="/" title="返回首页"><h1>互联网金融理财平台</h1></a>
		</div>
		<div class="nav_right">
			<ul class="">
				<li id="help">
					<a class="main-link" href="${pageContext.request.contextPath}/aboutUs">
						<span class="main-link-text">关于我们</span>
					</a>
				</li>
				
				<li id="acountHome">
					<!--<a class="main-link" href="/help/index?typeId=13">-->
					<a class="main-link" href="${pageContext.request.contextPath}/account">
						<span class="main-link-text">我的账户</span>
					</a>
				</li>
			  <!--  
				<li id="claim">
					<a class="main-link" href="${pageContext.request.contextPath}/debt">
						<span class="main-link-text">转让市场</span>
					</a>
				</li>
			  -->
				<li id="invests">
					<a class="main-link" href="${pageContext.request.contextPath}/invest">
						<span class="main-link-text">我要投资</span>
					</a>
				</li>

				<li id="index" class="nav_li_focus">
					<a class="" href="${pageContext.request.contextPath}/">
						首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<div class="clear"></div>