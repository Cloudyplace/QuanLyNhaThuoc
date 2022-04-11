<%-- 
    Document   : MedicineEditAdmin
    Created on : Mar 9, 2022, 12:33:44 PM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/Manage/DistributorManage/DistributorEdit.css" rel="stylesheet" />

        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../../Home/Header.jsp"></jsp:include>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>



            <div class="container">
                <div class="main-body">
                    <!-- Breadcrumb -->
                    <nav aria-label="breadcrumb" class="main-breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="distributormanage">Quản lý nhà phân phối</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Tạo mới nhà phân phối</li>
                    </ol>
                </nav>
                <div class="row">

                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                <form action="DistributorInsert" method="POST">
                                    
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Tên nhà phân phối</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" required name="name">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Địa chỉ</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" required name="address">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Email</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" required name="email">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Số điện thoại</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="number" class="form-control" required  name="phone" VND>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Chú ý</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control"  name="note" VND>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3"></div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="submit" class="btn btn-primary px-4" value="Tạo">
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>




                </div>
            </div>
        </div>
    </body>
</html>
