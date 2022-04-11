<%-- 
    Document   : AccountManage
    Created on : Mar 27, 2022, 4:12:50 AM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title>manage users - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>

        <style>
            body{
                background: #edf1f5;
                margin-top:20px;
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: 0;
            }
            .btn-circle.btn-lg, .btn-group-lg>.btn-circle.btn {
                width: 50px;
                height: 50px;
                padding: 14px 15px;
                font-size: 18px;
                line-height: 23px;
            }
            .text-muted {
                color: #8898aa!important;
            }
            [type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
                cursor: pointer;
            }
            .btn-circle {
                border-radius: 100%;
                width: 40px;
                height: 40px;
                padding: 10px;
            }
            .user-table tbody tr .category-select {
                max-width: 150px;
                border-radius: 20px;
            }
        </style>
    </head>
</head>
<body>
    <jsp:include page="../../Home/Header.jsp"></jsp:include>
        <br/>
        <br/>
        <br/>
        <br/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title text-uppercase mb-0">Quản Lý Nhân Viên</h5>
                        </div>
                        <form action="AccountManage" method="POST">
                            <div class="table-responsive">
                                <table class="table no-wrap user-table mb-0">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="border-0 text-uppercase font-medium pl-4">Mã nhân viên</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Tên nhân viên</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Chức vụ</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${listAccount}" var="a">
                                        <tr>
                                    <input type="hidden" name="accId" value="${a.accountID}">
                                    <td class="pl-4">${a.accountID}</td>
                                    <td>
                                        <h5 class="font-medium mb-0">${a.fullName}</h5>

                                    </td>
                                    <td>
                                        <select class="form-control category-select" id="exampleFormControlSelect1" name="role">
                                            <c:forEach items="${listRole}" var="r">

                                                <option
                                                    <c:if test="${a.role.roleId eq r.roleId}">
                                                        selected="selected"
                                                    </c:if>
                                                    value="${r.roleId}">${r.roleName}</option>

                                            </c:forEach>
                                        </select>
                                    </td>
                                    <!--<td></td>-->

                                    </tr>



                                </c:forEach>


                                </tbody>
                            </table>
                            <hr/>
                            <input style="float: right; padding: 8px 20px; margin-right: 30px ; background: greenyellow" type="submit" value="Lưu">
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
