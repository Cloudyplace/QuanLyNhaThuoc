<%-- 
    Document   : login
    Created on : Feb 25, 2022, 10:06:41 PM
    Author     : cloudy_place
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>Online Login Form Responsive Widget Template :: w3layouts</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Online Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Meta tag Keywords -->
        <!-- css files -->
        <link rel="stylesheet" href="css/HomeStyle/LoginStyle.css" type="text/css" media="all" /> <!-- Style-CSS --> 
        <link rel="stylesheet" href="css/HomeStyle/fontLogin.css"> <!-- Font-Awesome-Icons-CSS -->
        <!-- //css files -->
        <!-- online-fonts -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext" rel="stylesheet">
        <!-- //online-fonts -->

    </head>
    <body>
        <!-- main -->
        <img style="position: absolute;width: 100%;top: 0;right: 0;z-index: -1; opacity: 0.85" src="image/anh-nen-login.jpg" alt="">

        <div class="center-container"s>
            <!--header-->
            <div class="header-w3l">
                <h1>Đăng nhập</h1>
            </div>
            <!--//header-->
            <div class="main-content-agile">

                <div class="sub-main-w3">	

                    <form class="formLogin" action="login" method="post">
                        <div class="pom-agile">
                            <input placeholder="Tài khoản" name="username" class="user" type="text" required="">
                            <span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span>
                        </div>
                        <div class="pom-agile">
                            <input  placeholder="Mật khẩu" name="password" class="pass" type="password" required="">
                            <span class="icon2"><i class="fa fa-unlock" aria-hidden="true"></i></span>
                        </div>
                        <h3 class="errorLogin">${ErrorLogin}</h3>
                        <div class="sub-w3l">
                            <div class="right-w3l">
                                <input type="submit" value="Đăng nhập">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!--//main-->
            <!--footer-->
            <div class="footer">
                <p>Design by Minh Dep Trai</p>
            </div>
            <!--//footer-->
        </div>
    </body>
</html>
