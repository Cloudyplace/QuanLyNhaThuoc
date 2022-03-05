<%-- 
    Document   : medicineDetail
    Created on : Mar 1, 2022, 10:49:36 PM
    Author     : cloudy_place
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/MedicineDetailStyle/MedDetail.css" type="text/css"
    </head>
    <body>
        <div class="card">
            <nav>
                <svg onclick="window.location = 'home'" class="arrow" version="1.1" viewBox="0 0 512 512" width="512px" xml:space="preserve"
                     xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <polygon points="352,115.4 331.3,96 160,256 331.3,416 352,396.7 201.5,256 " stroke="#727272" />
                </svg>
                Back to Home
            </nav>
            <div class="photo">
                <img src="${MedicineDetail.image}">
            </div>
            <div class="description">
                <h2>${MedicineDetail.medicineName}</h2>
                <h5>${typeName}</h5>
                <span style="display: flex;">
                    <div style="display: inline-block; margin-right: 20px" >Giá: ${MedicineDetail.price} VND</div>
                    <div>Đơn vị: ${MedicineDetail.unit}</div>
                </span>
                <div>
                    Nhà phân phối: ${distributorName}
                </div>
                <div>NSX-HSD: ${MedicineDetail.manufactureDate} - ${MedicineDetail.outOfDate}</div> 
                <div>Số lượng còn lại: ${MedicineDetail.quantityInStock}</div>
                <div>Note: ${MedicineDetail.note}</div>
            </div>

            <br/>
            <button class="addToHoaDonInDetail">Thêm vào hóa đơn</button>
        </div>
    </body>
</html>
