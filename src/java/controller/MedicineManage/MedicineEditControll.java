/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.MedicineManage;

import dal.ProductDBGetById;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineEditControll extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("MedicineDetail", new ProductDBGetById().getMedicineById(Integer.parseInt(request.getParameter("id"))));
        int typeId = ((Medicine) request.getAttribute("MedicineDetail")).getTypeId();
        request.setAttribute("typeName", new ProductDBGetById().getTypeNameByTypeId(typeId));
        int distributorId = ((Medicine) request.getAttribute("MedicineDetail")).getDistributorId();
        request.setAttribute("distributorName", new ProductDBGetById().getDistributorNameByDistributorId(distributorId));
        int boxId = ((Medicine) request.getAttribute("MedicineDetail")).getBoxId();
        request.setAttribute("boxName", new ProductDBGetById().getBoxNameByBoxId(boxId));
        request.getRequestDispatcher("view/Manage/MedicineManage/MedicineEditAdmin.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
