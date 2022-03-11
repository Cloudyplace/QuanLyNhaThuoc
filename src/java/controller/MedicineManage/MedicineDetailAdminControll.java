/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.MedicineManage;

import dal.AccountDBContext;
import dal.ProductDBGetById;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineDetailAdminControll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check session
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            //profileUser
            request.setAttribute("profileUser", new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString()));

            request.setAttribute("MedicineDetail", new ProductDBGetById().getMedicineById(Integer.parseInt(request.getParameter("id"))));
            int typeId = ((Medicine) request.getAttribute("MedicineDetail")).getTypeId();
            request.setAttribute("typeName", new ProductDBGetById().getTypeNameByTypeId(typeId));
            int distributorId = ((Medicine) request.getAttribute("MedicineDetail")).getDistributorId();
            request.setAttribute("distributorName", new ProductDBGetById().getDistributorNameByDistributorId(distributorId));
            int boxId = ((Medicine) request.getAttribute("MedicineDetail")).getBoxId();
            request.setAttribute("boxName", new ProductDBGetById().getBoxNameByBoxId(boxId));
            request.getRequestDispatcher("view/Manage/MedicineManage/MedicineDetailAdmin.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
