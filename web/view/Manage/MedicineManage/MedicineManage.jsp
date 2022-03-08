<%-- 
    Document   : MedicineManage
    Created on : Mar 7, 2022, 12:35:08 AM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Manage/MedicineManage/MedicineManageStyle.css">
        <link rel="stylesheet" href="css/HomeStyle/PageStyle.css">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>Quản lý thuốc</title>
    </head>
    <body>

        <jsp:include page="../../Home/Header.jsp"></jsp:include>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="header-title pb-3 mt-0">Quản lý thuốc</h5>
                                <div class="table-responsive">
                                    <table class="table table-hover mb-0">
                                        <thead>
                                            <tr class="align-self-center">
                                                <th>Tên thuốc</th>
                                                <th>Giá nhập</th>
                                                <th>Giá bán</th>
                                                <th>Hạn sử dụng</th>
                                                <th>Số lượng tồn</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listMedPage}" var="o">
                                            <tr>
                                                <td>${o.medicineName}</td>
                                                <td>${o.inputPrice}</td>
                                                <td>${o.price}</td>
                                                <td>${o.outOfDate}</td>
                                                <td>${o.quantityInStock}</td>
                                                <td><a class="table-link" href="medicineDetailAdmin?id=${o.medicineId}">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="#" class="table-link danger">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <!--end table-responsive-->
                        </div>
                    </div>
                </div>
            </div>
            <div class="tagPage">
                <div class="tag">
                    <a class="" href="medicinemanage?indexPage=${tagPage==i?"active":""}"><</a> 
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a class="${tagPage==i?"active":""}" href="medicinemanage?indexPage=${i}"> ${i}</a> <!--chon the nao thi the aay mang active-->
                    </c:forEach>
                    <a class="" href="medicinemanage?indexPage=${i}">></a> 
                </div>
            </div>
        </div>
    </body>
</html>
