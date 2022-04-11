<%-- 
    Document   : ImInvoiceDetail
    Created on : Mar 13, 2022, 11:44:27 AM
    Author     : cloudy_place
--%>

<%@page import="model.Medicine"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Invoice/ImportInvoice/ImportInvoice.css">
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


            <form action="ImportInvoice" method="POST">

                <div class="container px-0">
                    <div class="row mt-4">
                        <div class="col-12 col-lg-12">
                            <div class="page-content container">
                                <div class="page-header text-blue-d2">
                                    <h1 class="page-title text-secondary-d1">
                                        Tạo Hóa đơn nhập
                                        <small class="page-info">
                                            <i class="fa fa-angle-double-right text-80"></i>
                                        </small>
                                    </h1>
                                </div>

                                <hr class="row brc-default-l1 mx-n1 mb-4" />

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div>
                                            <span class="text-sm text-grey-m2 align-middle">Nhà phân phối:</span>
                                            <span class="text-600 text-90 text-blue align-middle">
                                                <select name="disId">
                                                <c:forEach items="${AllDistributor}" var="d">
                                                    <option 
                                                        value="${d.distributorId}">${d.distributorName}</option> 
                                                </c:forEach>
                                            </select>
                                        </span>
                                    </div>
                                        <a href="DistributorInsert">Thêm mới nhà phân phối</a>

                                </div>
                                <!-- /.col -->

                                <div class="text-95 col-sm-6 align-self-start d-sm-flex justify-content-end">
                                    <hr class="d-sm-none" />
                                    <div class="text-grey-m2">
                                        <div class="mt-1 mb-2 text-secondary-m1 text-600 text-125">
                                            Hóa đơn
                                        </div>


                                        <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> <span class="text-600 text-90">Ngày phát hành:</span><input type="date" name="imDate" required=""/></div>

                                    </div>
                                </div>
                                <!-- /.col -->
                            </div>


                            <div class="mt-4">
                                <div class="row text-600 text-white bgc-default-tp1 py-25">
                                    <div class="d-none d-sm-block col-1">STT</div>
                                    <div class="col-7 col-sm-2">Tên sản phẩm</div>
                                    <div class="d-none d-sm-block col-4 col-sm-2">Đơn vị</div>
                                    <div class="d-none d-sm-block col-4 col-sm-2">Số lượng</div>
                                    <div class="d-none d-sm-block col-sm-2">Đơn giá</div>
                                    <div class="col-2">Tiền</div>
                                    <div class="col-2"></div>
                                </div>
                                <%
                                    int i = 1;
                                    request.setAttribute("i", i);
                                %>

                                <c:forEach items="${listImInvoiceDetail}" var="m">
                                    <div class="text-95 text-secondary-d3">
                                        <div class="row mb-2 mb-sm-0 py-25">
                                            <div class="d-none d-sm-block col-1">${i}</div>
                                            <div class="col-7 col-sm-2" >${m.medicine.medicineName}</div>
                                            <div class="d-none d-sm-block col-2">${m.medicine.unit}</div>
                                            <div class="d-none d-sm-block col-2">${m.quantity}</div>
                                            <div class="d-none d-sm-block col-2 text-95">${m.medicine.inputPrice}</div>
                                            <div class="col-1 text-secondary-d2 price">${m.quantity*m.medicine.inputPrice}</div>
                                            <div class="d-none d-sm-block col-2">

                                                <a href="ChangeImInvoiceDetail?action=edit&index=${i}" class="table-link">
                                                    <span class="fa-stack">
                                                        <i class="fa fa-square fa-stack-2x"></i>
                                                        <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                                    </span>
                                                </a>
                                                <a href="ChangeImInvoiceDetail?action=delete&index=${i}" class="table-link danger">
                                                    <span class="fa-stack">
                                                        <i class="fa fa-square fa-stack-2x"></i>
                                                        <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                                    </span>
                                                </a>
                                            </div>

                                        </div>
                                    </div>
                                    <hr/>
                                    <%
                                        i = i + 1;
                                        request.setAttribute("i", i);
                                    %>
                                </c:forEach>
                                <br/>

                                <a href="AddMedicine?listImInvoiceDetail=${listImInvoiceDetail}">Thêm thuốc</a>

                                <br/>
                                <hr/>
                                <br/>
                                <a href="ClearMedicine">Xóa tất cả thuốc</a>

                                <div class="row border-b-2 brc-default-l2"></div>

                                <div class="row mt-3">
                                    <div class="col-12 col-sm-7 text-grey-d2 text-95 mt-2 mt-lg-0">
                                        <input type="text" id="input" name="note" placeholder="Ghi chú khi thanh toán:">
                                    </div>

                                    <div class="col-12 col-sm-5 text-grey text-90 order-first order-sm-last">
                                        <div class="row my-2">
                                            <div class="totalPrice col-7 text-right">
                                                Tổng
                                            </div>
                                            <div class="col-5">
                                                <span class="text-120 text-secondary-d1">${ImInvoice.totalMoney} VND</span>
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

                                        <div class="row my-2 align-items-center bgc-primary-l3 p-2">
                                            <div class="col-7 text-right"">
                                                Tổng số tiền
                                            </div>
                                            <div class="col-5">
                                                <input style="display: none" class="text-150 totalPrice text-success-d3 opacity-2" name="totalMoney" value="test">
                                                <span class="text-150 totalPrice text-success-d3 opacity-2" >VND</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <hr />

                                <div>
                                    <input type="submit" class="btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0" value="Tạo">
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
        <script>

            var price = document.getElementsByClassName('price');
            var totalPrice = document.getElementsByClassName('totalPrice');
            var sum = 0;
            for (var i = 0; i < price.length; i++) {
                sum += price[i].innerHTML * 1;
            }
            totalPrice[0].innerHTML = sum;
            totalPrice[1].value = sum;
            totalPrice[2].innerHTML = sum + ' VND';
        </script>

    </body>
</html>
