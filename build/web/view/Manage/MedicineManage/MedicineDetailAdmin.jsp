<%-- 
    Document   : profileEdit
    Created on : Mar 6, 2022, 12:57:18 AM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/Manage/MedicineManage/MedicineDetailAdmin.css" rel="stylesheet" />

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
                                <li class="breadcrumb-item"><a href="medicinemanage">Quản lý thuốc</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Chi tiết thuốc</li>
                            </ol>
                        </nav>
                        <!-- /Breadcrumb -->
                        <div class="row gutters-sm">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="${MedicineDetail.image}" alt="Ảnh"
                                                  width="300">
                                            <div class="mt-3">
                                                <h4>${profileUser.fullName}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Tên thuốc</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.medicineName}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Loại thuốc</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${typeName}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Nhà phân phối</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${distributorName}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Ngày sản xuất</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.manufactureDate}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">  
                                            <h6 class="mb-0">Hạn sử dụng</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.outOfDate}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Giá nhập</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.inputPrice} VND
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Giá bán</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.price} VND
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Đơn vị</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.unit}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Vị trí</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${boxName}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Số lượng</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.quantityInStock}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Chú ý</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${MedicineDetail.note}
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
