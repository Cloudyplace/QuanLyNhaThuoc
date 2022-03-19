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
        <link href="css/Manage/MedicineManage/MedicineEdit.css" rel="stylesheet" />

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
                            <li class="breadcrumb-item"><a href="ImportInvoice">Hóa đơn nhập</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Thêm thuốc</li>
                        </ol>
                    </nav>

                    
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <form action="AddMedicine" method="POST">
                                    <input type="hidden" name="id">
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Tên thuốc</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="name" >
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Loại thuốc</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <select name="typeId" >
                                            <option>---</option>
                                            <c:forEach items="${AllTypeMedicine}" var="t">
                                                <option 
                                                    value="${t.typeId}">${t.typeName}</option> 
                                            </c:forEach>

                                            <option><a href="dsfsd">Khác</a></option>

                                        </select>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Ngày sản xuất</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="ManufactureDate" >
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Hạn sử dụng</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="OutOfDate">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Giá nhập</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="InputPrice">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Giá bán</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="Price">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Đơn vị</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="Unit" >
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Vị trí</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <select name="boxId" >
                                            <c:forEach items="${AllMedicalBox}" var="b">
                                                <option 
                                                    <c:if test="${MedicineDetail.box.boxId eq b.boxId}">
                                                        selected="selected"
                                                    </c:if>
                                                    value="${b.boxId}">${b.boxName}</option> 
                                            </c:forEach>

                                            <option><a href="dsfsd">Khác</a></option>

                                        </select>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Số lượng</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control" name="Quantity">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Chú ý</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="Note"">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Địa chỉ ảnh</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="text" class="form-control"  name="image">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-9 text-secondary">
                                        <input type="submit" class="btn btn-primary px-4" value="Add">
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
