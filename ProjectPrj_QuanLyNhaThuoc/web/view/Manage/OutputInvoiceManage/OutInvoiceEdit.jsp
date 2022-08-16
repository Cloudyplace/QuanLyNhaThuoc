<%-- 
    Document   : OutInvoiceDetail
    Created on : Mar 13, 2022, 11:44:27 AM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Manage/OutputInvoice/OutInvoiceDetail.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../../Home/Header.jsp"></jsp:include>
            <br/>
            <br/>
            <br/>
            <br/>

            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />


            <form action="outputInvoiceEdit" method="POST">
                <div class="container px-0">
                    <div class="row mt-4">
                        <div class="col-12 col-lg-12">
                            <!-- Breadcrumb -->
                            <nav aria-label="breadcrumb" class="main-breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="outputInvoiceManage">Quản lý hóa đơn bán</a></li>
                                    <li class="breadcrumb-item"><a href="outInvoiceDetail?id=${OutInvoiceAndAccount.outInvoiceId}">Chi tiết hóa đơn bán</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Chỉnh sửa hóa đơn bán</li>
                                </ol>
                            </nav>
                            <div class="page-content container">
                                <div class="page-header text-blue-d2">
                                    <h1 class="page-title text-secondary-d1">
                                        Hóa đơn
                                        <small class="page-info">
                                            <i class="fa fa-angle-double-right text-80"></i>
                                        ${OutInvoiceAndAccount.outInvoiceId}
                                    </small>
                                </h1>
                            </div>

                            <hr class="row brc-default-l1 mx-n1 mb-4" />

                            <div class="row">
                                <div class="col-sm-6">
                                    <div>
                                        <span class="text-sm text-grey-m2 align-middle">Nhân viên: </span> <!--lam get all acc -->
                                        <span class="text-600 text-90 text-blue align-middle">${OutInvoiceAndAccount.account.fullName}</span>
                                    </div>
                                </div>
                                <!-- /.col -->

                                <div class="text-95 col-sm-6 align-self-start d-sm-flex justify-content-end">
                                    <hr class="d-sm-none" />
                                    <div class="text-grey-m2">
                                        <div class="mt-1 mb-2 text-secondary-m1 text-600 text-125">
                                            Hóa đơn
                                        </div>

                                        <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">ID: </span> ${OutInvoiceAndAccount.outInvoiceId}<input type="hidden" name="outInvoiceId" value="${OutInvoiceAndAccount.outInvoiceId}"></div>
                                        <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Tên khách hàng: </span><input type="text" name="customerName" value="${OutInvoiceAndAccount.customerName}"> </div>
                                        <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Số điện thoại KH: </span><input  type="text" name="customerPhone" value="${OutInvoiceAndAccount.customerPhone}"> </div>

                                        <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Ngày phát hành: </span><input type="date" name="saleDate" value="${OutInvoiceAndAccount.saleDate}"></div>

                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>

                            <div class="mt-4">
                                <div class="row text-600 text-white bgc-default-tp1 py-25">
                                    <div class="d-none d-sm-block col-1">STT</div>
                                    <div class="col-9 col-sm-3">Tên sản phẩm</div>
                                    <div class="d-none d-sm-block col-4 col-sm-2">Đơn vị</div>
                                    <div class="d-none d-sm-block col-4 col-sm-2">Số lượng</div>
                                    <div class="d-none d-sm-block col-sm-2">Đơn giá</div>
                                    <div class="col-2">Tiền</div>
                                </div>
                                <%
                                    int i = 1;
                                    request.setAttribute("i", i);
                                %>
                                <c:forEach items="${ListOutInvoiceDetail}" var="o">
                                    <div class="text-95 text-secondary-d3">
                                        <div class="row mb-2 mb-sm-0 py-25">
                                            <div class="d-none d-sm-block col-1">${i}</div>
                                            <div class="col-9 col-sm-3">${o.medicine.medicineName}</div>
                                            <div class="d-none d-sm-block col-2">${o.medicine.unit}</div>
                                            <div class="d-none d-sm-block col-2">${o.quantity}</div>
                                            <div class="d-none d-sm-block col-2 text-95">${o.medicine.price}</div>
                                            <div class="col-2 text-secondary-d2">${o.quantity*o.medicine.price}</div>
                                        </div>
                                    </div>
                                    <hr/>
                                    <%
                                        i = i + 1;
                                        request.setAttribute("i", i);
                                    %>
                                </c:forEach>

                                <div class="row border-b-2 brc-default-l2"></div>

                                <div class="row mt-3">
                                    
                                    <div class="col-12 col-sm-7 text-grey-d2 text-95 mt-2 mt-lg-0">
                                         Ghi chú khi thanh toán: <input name="note" value="${OutInvoiceAndAccount.note}"> 
                                    </div>

                                    <div class="col-12 col-sm-5 text-grey text-90 order-first order-sm-last">
                                        <div class="row my-2">
                                            <div class="col-7 text-right">
                                                Tổng
                                            </div>
                                            <div class="col-5">
                                                <span class="text-120 text-secondary-d1">${OutInvoiceAndAccount.totalMoney} VND</span>
                                            </div>
                                        </div>

                                        <div class="row my-2">
                                            <div class="col-7 text-right">
                                                Thuế (0%)
                                            </div>
                                            <div class="col-5">
                                                <span class="text-110 text-secondary-d1">0</span>
                                            </div>
                                        </div>

                                        <div class="row my-2 align-items-center bgc-proutary-l3 p-2">
                                            <div class="col-7 text-right">
                                                Tổng số tiền
                                            </div>
                                            <div class="col-5">
                                                <span class="text-150 text-success-d3 opacity-2">${OutInvoiceAndAccount.totalMoney} VND</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <hr />

                                <div>
                                    <input type="submit" value="Update" class="btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0">
                                    <br/>
                                    <br/>
                                    <br/>
                                    <br/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>

    </body>
</html>
