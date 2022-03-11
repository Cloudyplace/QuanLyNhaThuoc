<%-- 
    Document   : distributorDetailAdmin
    Created on : Mar 9, 2022, 9:40:31 PM
    Author     : cloudy_place
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/Manage/DistributorManage/DistributorDetailAdmin.css" rel="stylesheet" />
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
                            <li class="breadcrumb-item active" aria-current="page">Chi tiết nhà phân phối</li>
                        </ol>
                    </nav>

                    <div class="row gutters-sm">
                        <div class="col-md-8 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <h6 class="mb-0">Thuốc đã nhập</h6>
                                        </div>
                                        <div class="col-sm-6 text-secondary">
                                            hihi
                                        </div>
                                    </div>                                 
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <h6 class="mb-0">Số lượng hóa đơn nhập </h6>
                                        </div>
                                        <div class="col-sm-6 text-secondary">
                                            1000
                                        </div>
                                    </div>                                 
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <h6 class="mb-0">Tổng số tiền nhập</h6>
                                        </div>
                                        <div class="col-sm-6 text-secondary">
                                            33242
                                        </div>
                                    </div>                                 
                                    <hr>
                                </div>
                            </div>
                        </div> 




                        <div class="col-md-4">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <h6 class="mb-0">Tên nhà phân phối</h6>
                                        </div>
                                        <div class="col-sm-8 text-secondary">
                                        ${DistributorDetail.distributorName}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <h6 class="mb-0">Địa chỉ</h6>
                                    </div>
                                    <div class="col-sm-8 text-secondary">
                                        ${DistributorDetail.address}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-8 text-secondary">
                                        ${DistributorDetail.email}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <h6 class="mb-0">Số điện thoại</h6>
                                    </div>
                                    <div class="col-sm-8 text-secondary">
                                        ${DistributorDetail.phone}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-4">  
                                        <h6 class="mb-0">Chú ý</h6>
                                    </div>
                                    <div class="col-sm-8 text-secondary">
                                        ${DistributorDetail.note}
                                    </div>
                                </div>

                                <hr>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <a class="btn btn-info " target="__blank"
                                           href="medicineedit?id=${MedicineDetail.medicineId}">Edit</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>



    </body>
</html>
