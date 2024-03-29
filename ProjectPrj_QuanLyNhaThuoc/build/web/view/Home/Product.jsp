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
        <link rel="stylesheet" href="css/HomeStyle/productStyle.css" type="text/css">
        <link href="css/HomeStyle/PageStyle.css" rel="stylesheet" type="text/css"/>
        <style>
            .hihi:hover{
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <!-- CONTENT SECTION -->
        <div id="mainContainer">
            <h1></h1>
            <div id="containerClothing">
                <c:forEach items="${listMedPage}" var="o">

                    <div id="box"><a href="meddetail?id=${o.medicineId}">
                            <img style="height: 230px" src="${o.image}">
                            <div id="details">
                                <h3 style="font-size: 28px">${o.medicineName}</h3>
                                <h4>Vị trí: ${o.box.boxName}</h4>
                                <h2 style="font-size: 18px">Giá ${o.unit}: ${o.price}VND</h2>
                            </div>
                        </a>
                            <form action="AddMedicineOutInvocie" method="GET">
                                <input type="hidden" name="medicineId" value="${o.medicineId}">
                            <div  class="addToInvoice" style="text-align: center; margin-bottom: 5px">
                                <a href="OutputInvoice"><input class="hihi" style="border-radius: 10px; background-color: greenyellow; padding: 8px 10px
                                                               ;font-size:16px" 
                                                               type="submit" value="Thêm vào hóa đơn"></a>
                            </div>
                        </form>


                    </div>
                </c:forEach>

            </div>
        </div>
        <div class="tagPage">
            <div class="tag">
                <c:forEach begin="1" end="${endPage}" var="i">
                    <a class="${tagPage==i?"active":""}" href="home?indexPage=${i}"> ${i}</a> <!--chon the nao thi the aay mang active-->
                </c:forEach>
            </div>
        </div>


    </body>
</html>
