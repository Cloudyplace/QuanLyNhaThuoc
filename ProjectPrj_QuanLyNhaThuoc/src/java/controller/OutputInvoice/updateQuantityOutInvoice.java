/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.OutputInvoice;

import static controller.OutputInvoice.AddMedicineOutInvocie.LIST_MEDICINE_OUTINVOICE;
import dal.AccountDBContext;
import dal.MedicineDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
public class updateQuantityOutInvoice extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check session
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            Account account = new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString());

            //profileUser
            request.setAttribute("profileUser", account);

            String action = request.getParameter("action");
            int medicineId = Integer.parseInt(request.getParameter("medicineId"));
            Medicine m = new MedicineDB().getMedicineById(medicineId);

            if (action.equals("tang")) {
                for (int i = 0; i < LIST_MEDICINE_OUTINVOICE.size(); i++) {
                    OutputInvoiceDetail detail = LIST_MEDICINE_OUTINVOICE.get(i);
                    if (detail.getMedicine().getMedicineId() == medicineId) {
                        //check quantityInStock 
                        if (detail.getQuantity() < m.getQuantityInStock()) {
                            detail.setQuantity(detail.getQuantity() + 1);
                        } else {
                            request.setAttribute("ErrorQuantityMax", "Số lượng thuốc " + m.getMedicineName() + " chỉ còn: " + m.getQuantityInStock());
                        }
                    }
                }
            }
            if (action.equals("giam")) {
                for (int i = 0; i < LIST_MEDICINE_OUTINVOICE.size(); i++) {
                    OutputInvoiceDetail detail = LIST_MEDICINE_OUTINVOICE.get(i);
                    if (detail.getMedicine().getMedicineId() == medicineId) {
                        if (detail.getQuantity() == 1) {
                        } else {
                            detail.setQuantity(detail.getQuantity() - 1);
                        }
                    }
                }
            }
            session.setAttribute("listOutInvoiceDetail", LIST_MEDICINE_OUTINVOICE);

            request.getRequestDispatcher("OutputInvoice").forward(request, response);
        }

    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
