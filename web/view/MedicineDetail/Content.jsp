<%-- 
    Document   : Product
    Created on : Mar 4, 2022, 8:56:16 PM
    Author     : cloudy_place
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/HomeStyle/productStyle.css">
    </head>
    <body>
        <!-- CONTENT SECTION -->
        <div id="mainContainer">
            <h1></h1>
            <div style="box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px; display: flex; justify-content: space-evenly;" id="containerClothing">
                <div><img style="width: 400px;height: 400px;" src="${MedicineDetail.image}"></div>
                <div><hr style="height: 383px;"></div>
                <div >


                    <div id="details">
                        <h3 style="font-size: 28px;">
                            Tên thuốc: ${MedicineDetail.medicineName}</h3>
                        <h4>Loại thuốc: ${typeName}</h4>
                        <h4>Nhà phân phối: ${distributorName}</h4>
                        <h4>Số lượng còn lại: ${MedicineDetail.quantityInStock}</h4>
                        <h4>NSX: ${MedicineDetail.manufactureDate}  HSD: ${MedicineDetail.outOfDate}</h4>
                        <h4>Vị trí: ${boxName}</h4>
                        <h2>Giá: ${MedicineDetail.price} VND</h2>
                        <h4>Đơn vị: ${MedicineDetail.unit}</h4>
                        <h4>Ghi chú: ${MedicineDetail.note}</h4>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
