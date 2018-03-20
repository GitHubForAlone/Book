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
</head>
<body>
	<div class="container">
	    <div class="left-col" style="background-image: url(${pageContext.request.contextPath}/fuckscript/img/left.png);">
	        <header id="header">
	            <div class="profilepic"><a href="" style="background-image: url(${pageContext.request.contextPath}/fuckscript/img/photo.png);"></a></div>
	            <h1><a href="">Book System</a></h1>
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
	                  <li><a href="${pageContext.request.contextPath}/PersonalCenter.alone"><i class="iconfont icon-aboutus"></i>个人中心</a></li>
	                  <li><a href=""><i class="iconfont icon-collect"></i>图书借阅</a></li>
	                  <li><a href=""><i class="iconfont icon-collect"></i>购买图书</a></li>
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
							<a href="#"> Fuck everybody </a>
						</div>
					</div>
					<h1 class="title">
					<!-- 查看更多 根据id跳转 -->
					${bookClassNameAndBooklist.className }
					</h1>
					<!-- 图书列表 -->
					<div class="entry-content">
					<!-- <div class="entry-content" itemprop="articleBody"><h3></h3></div> -->
					<table border="1">
						<tr>
							<th><center>序号</center></th>
	   	 					<th><center>书名</center></th>
	    						<th><center>作者</center></th>
	    						<th><center>出版社</center></th>
	    						<th><center>发行日期</center></th>
	    						<th><center>剩余数量</center></th>
	    						<th><center>操作</center></th>
  						</tr>
  					
						<c:forEach items="${bookClassNameAndBooklist.booklist }" var="booklist" varStatus="status">
							 <tr>
							 	<td><center>${status.count }</center></td>
							 	<td><center>${booklist.name }</center></td>
							 	<td><center>${booklist.author }</center></td>
							 	<td><center>${booklist.press }</center></td>
							 	<td><center>${booklist.publishTime }</center></td>
							 	<td><center>${booklist.num }</center></td>
							 	<td><center><a href="${pageContext.request.contextPath }/PersonalCenter.alone?bookId=${booklist.bookId }">借阅</a></center></td>
							 </tr>
						</c:forEach>
					</table>
					</div>
				</article>
				<!-- 分页插件 -->
				  <div id="app">
				    <div>
				      <div class="page"  v-show="show">
				        <div class="pagelist">
				      	  <span class="jump" :class="{disabled:pstart}" @click="{current_page--}" onclick="beforePage()">上一页</span>
				          <!-- <span v-show="current_page>5" class="jump" @click="jumpPage(1)">1</span> -->
				          <span class="ellipsis"  v-show="efont">...</span>
				          <span class="jump" v-for="num in indexs" :class="{bgprimary:current_page==num}" @click="jumpPage(num)">{{num}}</span>
				          <span class="ellipsis"  v-show="ebehind">...</span>
				
				          <span :class="{disabled:pend}" class="jump" @click="{current_page++}" onclick="afterPage()">下一页</span>
				          <span v-show="current_page<pages-4" class="jump" @click="jumpPage(pages)">{{pages}}</span>
					
						  <span class="jumppoint">显示数量：</span>
						  <span class="jumpinp"><input type="text" value="" onchange="pageSize(this.value)"></span>
				
				          <span class="jumppoint">跳转到：</span>
				          <span class="jumpinp"><input type="text" v-model="changePage"></span>
				          <span class="jump gobtn" @click="jumpPage(changePage)">GO</span> 
				        </div>
				      </div>
				    </div>
				  </div>
				
				  <script src="${pageContext.request.contextPath }/vue/style/vue.js"></script>
				  <script>
				    var newlist = new Vue({
				      el: '#app',
				      data: {
				    	  current_page: ${bookListPageNumber }, //当前页
					        pages: ${bookListAllPageNumber }, //总页数
					        changePage:'',//跳转页
					        nowIndex:0
					      },
					      computed:{
					         show:function(){
					             return this.pages && this.pages !=1
					         },
				         pstart: function() {
				           return this.current_page == 1;
				         },
				         pend: function() {
				           return this.current_page == this.pages;
				         },
				         efont: function() {
				           if (this.pages <= 7) return false;
				           return this.current_page > 5
				         },
				         ebehind: function() {
				           if (this.pages <= 7) return false;
				           var nowAy = this.indexs;
				           return nowAy[nowAy.length - 1] != this.pages;
				         },
				         indexs: function() {
				
				           var left = 1,
				             right = this.pages,
				             ar = [];
				           if (this.pages >= 7) {
				             if (this.current_page > 5 && this.current_page < this.pages - 4) {
				               left = Number(this.current_page) - 3;
				               right = Number(this.current_page) + 3;
				             } else {
				               if (this.current_page <= 5) {
				                 left = 1;
				                 right = 7;
				               } else {
				                 right = this.pages;
				
				                 left = this.pages - 6;
				               }
				             }
				           }
				           while (left <= right) {
				             ar.push(left);
				             left++;
				           }
				           return ar;
				         },
				       },
				      methods: {
				        jumpPage: function(id) {
					       if(id>this.pages){
			        		  		alert("  不存在此页");
			        		  		return;
			        	  	   }else if(id == ""){
			        	  		 alert("  填写跳转页");
			        		  		return;
			        	  	   }
				          this.current_page = id;
				          window.open("${pageContext.request.contextPath }/Booklist.alone?pageNumber="+id+"&classId=${classId }&className=${className }",'_self');
				          
				        },
				        
				      },
						
				    })
				    /* 显示条数 */
				    function pageSize(size) {
					       if(size > 20){
			        		  		alert("显示数值太大");
			        		  		return;
			        	  	   }else{
						      window.open("${pageContext.request.contextPath }/Booklist.alone?pageSize="+size+"&classId=${classId }&className=${className }",'_self');
			        	  	   }
				        }
				    /* 上一页 */
				    function beforePage() {
				    		window.open("${pageContext.request.contextPath }/Booklist.alone?pageNumber="+(${bookListPageNumber }-1)+"&classId=${classId }&className=${className }",'_self');
					}
				    /* 下一页 */
				    function afterPage() {
				    		window.open("${pageContext.request.contextPath }/Booklist.alone?pageNumber="+(${bookListPageNumber }+1)+"&classId=${classId }&className=${className }",'_self');
					}
				  </script>
				  <!-- 分页插件  -->
			
			<footer id="footer" class="inner">
			© 2018 <a href="http://alone.rocks/">Alone's BookSystem</a>
			</footer>
		</div>
	</div>
</div>

</body>
</html>