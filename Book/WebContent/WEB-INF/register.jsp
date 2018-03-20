<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>Library management register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

    </head>

    <body>
        <div class="page-container">
            <h1>Register</h1>
            <form action="${pageContext.request.contextPath }/Register.alone" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <input type="password" name="repassword" class="repassword" placeholder="Repeat password">
                <input type="text" name="telephone" class="password" placeholder="telephone 0816xxxxxxx or 151xxxxxxxx">
                <input type="text" name="cardId" class="repassword" placeholder="Card ID number">
                <button type="submit">Register</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
        <div align="center" >Collect from <a href="http://alone.rocks/" target="_blank" >Alone</a></div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
    </body>

</html>

