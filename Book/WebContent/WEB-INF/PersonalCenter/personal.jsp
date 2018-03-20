<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/fuckscript/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/vue/style/vue.css">
<title>图书管理系统</title>
<!-- <script type="text/javascript">
function loadXMLDoc()
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			
		}
	}
	xmlhttp.open("GET","${pageContext.request.contextPath }/index.alone",true);
	xmlhttp.send();
}
</script> -->
</head>
<body>
	<div class="container">
	    <div class="left-col" style="background-image: url(${pageContext.request.contextPath}/fuckscript/img/left.png);">
	        <header id="header">
	            <div class="profilepic"><a href="${pageContext.request.contextPath }/PersonalCenter.alone" style="background-image: url(${pageContext.request.contextPath}/fuckscript/img/photo.png);"></a></div>
	            <h1><a href="${pageContext.request.contextPath }/PersonalCenter.alone">Book System</a></h1>
	            <p class="subtitle">
	            <c:if test="${empty userInformation.name }"> 路人甲</c:if>
	            <c:if test="${not empty userInformation.name }">
	            		${userInformation.name }
	            </c:if>
	            </p>
	            <c:if test="${empty userInformation.name }">
	           	 	<p class="subtitle"><a href="${pageContext.request.contextPath }/login.alone">您还未登录</a></p>
	            </c:if>
	            <c:if test="${not empty userInformation.name }">
	            		<p class="subtitle"><a href="${pageContext.request.contextPath }/LoginOut.alone">注销身份</a></p>
	            </c:if>
	            	<nav id="main-nav">
	                <ul>
	                  <li><a href="${pageContext.request.contextPath}/index.alone"><i class="iconfont icon-home"></i>进入首页</a></li>
	                  <li><a href="${pageContext.request.contextPath}/PersonalCenter.alone"><i class="iconfont icon-aboutus"></i>借阅记录</a></li>
	                  <li><a href="${pageContext.request.contextPath}/PersonalCenter.alone?user=${userInformation.name }"><i class="iconfont icon-collect"></i>个人信息</a></li>
	                  <li><a href=""><i class="iconfont icon-collect"></i>意见反馈</a></li>
	                  <li><a href=""><i class="iconfont icon-links"></i>友情链接</a></li>
			        	</ul>
			     </nav>
			        	<!-- 微博 等等... -->
			     <nav id="sub-nav">
	                <div class="social">
	                         <a class="social rss" target="blank" href="#"><i class="iconfont icon-rss"></i></a>
	                         <a class="social weibo" target="blank" href="#"><i class="iconfont icon-weibo"></i></a>
	                         <a id="search-toggle" class="social search" href="#"><i class="iconfont icon-sousuo"></i></a>
	                </div>
	             <nav>
	        </header>
		</div>
		<!-- 以上是左侧栏 以下是右侧 -->
		
		
		<!-- 书籍简略内容 -->
		<div class="mid-col">
			<div class="mid-col-container">
			<!-- 图书所属类名称 -->
	            <article class="post post-list">
	                <div class="meta">
	                    <div class="date">
						</div>
						<div class="comment">
							<a href=""> Fuck everybody </a>
						</div>
					</div>
					<h1 class="title">
					<a href="${pageContext.request.contextPath }"/></a>
					</h1>
					<!--简略内容-->
					<c:if test="${not empty information }">
						<div class="entry-content">
							<div class="entry-content" itemprop="articleBody">
								<h3>用户名: &nbsp<a>${information.name }</a></h3>
								<h3>电话号码: &nbsp<a>${information.tel }</a></h3>
								<h3>身份证号码: &nbsp${information.cardId }</h3>
								<h3>注册日期: &nbsp${information.registerDate }</h3>
							</div>							
								<p><a href="${pageContext.request.contextPath }/PersonalCenter.alone?user=${information.name }" class="more-link">完善资料 »</a></p>
						</div>
					</c:if>
					
					<c:if test="${empty information }">
						个人中心首页开发中....
					</c:if>
				</article>
			<footer id="footer" class="inner">
			© 2018 <a href="http://alone.rocks/">Alone's BookSystem</a>
			</footer>
		</div>
	</div>
</div>

</body>
</html>