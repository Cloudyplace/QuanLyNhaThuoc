<%-- 
    Document   : Header
    Created on : Mar 3, 2022, 9:37:40 PM
    Author     : cloudy_place
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <title> E-COMMERCE WEBSITE BY EDYODA | CREATED BY PRIYANKA SHARMA </title>
        <!-- favicon -->

<!--        <link rel="icon"
              href="https://yt3.ggpht.com/a/AGF-l78km1YyNXmF0r3-0CycCA0HLA_i6zYn_8NZEg=s900-c-k-c0xffffffff-no-rj-mo"
              type="image/gif" sizes="16x16">-->
        <!-- header links -->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <!-- slider links -->
<!--        <script src="http://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>-->
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">-->
        <link rel="stylesheet" href="css/HomeStyle/headerStyle.css">
<!--        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">-->
        <link href="https://fonts.googleapis.com/css?family=Arvo&display=swap" rel="stylesheet">
        <style>
            .dropbtn {
                background: none;
                color: inherit;
                border: none;
                padding: 0;
                font: inherit;
                cursor: pointer;
                outline: inherit;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                right: -40px;
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #f1f1f1}

            .dropdown:hover .dropdown-content {
                display: block;
            }

        </style>
    </head>

</head>
<body>

    <header>
        <section>
            <!-- MAIN CONTAINER -->
            <div id="container">
                <!-- SHOP NAME -->
                <div style="color: black;
                     font-size: 20px; 
                     font-family: 'Lato', sans-serif;
                     font-weight: 600;
                     font: black;">
                    <a style=" text-decoration: none;"href="home"> <b>NHÀ THUỐC 304</b></a></div>
                <!-- COLLCETIONS ON WEBSITE -->
                <div id="collection" style="display: flex; justify-content: space-around">
                    <div class="dropdown">
                        <button class="dropbtn">Hóa đơn</button>
                        <div class="dropdown-content">
                            <a href="ImportInvoice">Hóa đơn nhập</a>
                            <a href="OutputInvoice">Hóa đơn xuất</a>
                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="dropbtn">Quản Lý</button>
                        <div class="dropdown-content">
                            <a href="medicinemanage">Quản lý thuốc</a>
                            <a href="distributormanage">Quản lý nhà phân phối</a>
                            <a href="importInvoiceManage">Quản lý hóa đơn nhập</a>
                            <a href="#">Quản lý nhân viên</a>
                        </div>
                    </div>
                    <div>Doanh Thu</div>
                </div>
                <!-- SEARCH SECTION -->
                <div id="search">
                    <i class="fas fa-search search"></i>
                    <input type="text" id="input" name="searchBox" placeholder="Search for Clothing and Accessories">
                </div>
                <!-- USER SECTION (CART AND USER ICON) -->
                <div id="user">
                    <a href="OutputInvoice"> <i class='fas fa-file-invoice-dollar' style="font-size:28px; margin-left: -50px">
                            <div style="margin-right: 38px"id="badge"> ${outInvoiceDetailSize} </div>
                        </i></a>
                    <a href="#"> <i class="fas fa-user-circle userIcon"></i> 
                        <div class="dropdown">
                            <button class="dropbtn">${profileUser.fullName}</button>
                            <div class="dropdown-content">
                                <a href="profile">Thông Tin Tài Khoản</a>
                                <a href="logout">Đăng xuất</a>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

        </section>
    </header>

</body>
</html>