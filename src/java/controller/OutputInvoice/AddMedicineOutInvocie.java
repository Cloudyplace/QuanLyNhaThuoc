/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.OutputInvoice;

import dal.AccountDBContext;
import dal.MedicineDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Medicine;
import model.OutputInvoiceDetail;

/**
 *
 * @author cloudy_place
 */
public class AddMedicineOutInvocie extends HttpServlet {

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
    public static final List<OutputInvoiceDetail> LIST_MEDICINE_OUTINVOICE = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //check session
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            Account account = new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString());

            //profileUser
            request.setAttribute("profileUser", account);

            int medicineId = Integer.parseInt(request.getParameter("medicineId"));
            Medicine m = new MedicineDB().getMedicineById(medicineId);

            boolean isExist = false;
            for (OutputInvoiceDetail detail : LIST_MEDICINE_OUTINVOICE) {
                //check exist of medicine in outInvoice
                if (detail.getMedicine().getMedicineId() == medicineId) {
                    //check quantityInStock 
                    if (detail.getQuantity() < m.getQuantityInStock()) {
                        detail.setQuantity(detail.getQuantity() + 1);
                    } else {
                        request.setAttribute("ErrorQuantityMax", "Số lượng thuốc " + m.getMedicineName() + " chỉ còn: " + m.getQuantityInStock());
                    }
                    isExist = true;
                    break;
                }
            }
            if (isExist == false) {
                Medicine medicine = new MedicineDB().getMedicineById(medicineId);

                OutputInvoiceDetail outInvoiceDetail = new OutputInvoiceDetail();
                outInvoiceDetail.setMedicine(medicine);
                outInvoiceDetail.setQuantity(1);
                LIST_MEDICINE_OUTINVOICE.add(outInvoiceDetail);

            }

            session.setAttribute("listOutInvoiceDetail", LIST_MEDICINE_OUTINVOICE);

            //response.sendRedirect("OutputInvoice");
            request.getRequestDispatcher("OutputInvoice").forward(request, response);

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
