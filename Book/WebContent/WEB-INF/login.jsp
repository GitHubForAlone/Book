<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>
        <meta charset="utf-8">
        <title>Library management Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">
		<script type="text/javascript">
			function ajax(sum) {
/* 				var xmlhttp;
				if (window.XMLHttpRequest)
				{
				    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				    xmlhttp=new XMLHttpRequest();
				}
				else
				{
				    // IE6, IE5 浏览器执行代码
				    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				} */
				//xmlhttp.open("GET","demo_get.asp",true);
				//xmlhttp.send();
				/* var user = document.getElementById(sum);
				var pass = document.getElementById(sum);
				document.write(user+" "+pass); */
			}
		</script>
    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="${pageContext.request.contextPath }/Login.alone" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
            <a href="${pageContext.request.contextPath}/register.alone"><button type="submit">Reguster</button></a>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
        <div align="center">Collect from <a  href="http://alone.rocks/">Alone</a></div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>

