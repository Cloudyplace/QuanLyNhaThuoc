<%-- 
    Document   : ImportInvoiceManage.jsp
    Created on : Mar 11, 2022, 3:27:35 PM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Manage/DistributorManage/DistributorManageStyle.css">
        <link rel="stylesheet" href="css/HomeStyle/PageStyle.css">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>Quản lý hóa đơn nhập</title>
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
                                <h5 class="header-title pb-3 mt-0">Quản lý hóa đơn nhập</h5>
                                <div class="table-responsive">
                                    <table class="table table-hover mb-0">
                                        <thead>
                                            <tr class="align-self-center">
                                                <th>Mã hóa đơn</th>
                                                <th>Nhà phân phối</th>
                                                <th>Ngày nhập</th>
                                                <th>Tổng tiền</th>
                                                <th>Note</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listImInvoicePage}" var="o">
                                            <tr>
                                                <td>${o.imInvoiceId}</td>
                                                <td>${o.distributor.distributorName}</td>
                                                <td>${o.imDate}</td>
                                                <td>${o.totalMoney}</td>
                                                <td>${o.note}</td>
                                                <td><a class="table-link" href="imInvoiceDetail?id=${o.imInvoiceId}">
                                                        <span class="fa-stack">
                                                            <i class="fa fa-square fa-stack-2x"></i>
                                                            <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
                                                        </span>
                                                    </a>
                                                    <a href="distributoredit?id=${o.imInvoiceId}" class="table-link">
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
            <br/>
            <br/>
            
            <!--phan trang-->
            <div class="tagPage">
                <div class="tag">
                    <a class="" href="distributormanage?indexPage=${tagPage==i?"active":""}"><</a> 
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <a class="${tagPage==i?"active":""}" href="distributormanage?indexPage=${i}"> ${i}</a> <!--chon the nao thi the aay mang active-->
                    </c:forEach>
                    <a class="" href="distributormanage?indexPage=${i}">></a> 
                </div>
            </div>
        </div>
    </body>
</html>
