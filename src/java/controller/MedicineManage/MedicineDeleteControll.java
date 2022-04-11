/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.MedicineManage;

import dal.AccountDBContext;
import dal.ImportInvoice.ImportInvoiceDBContext;
import dal.MedicineDB;
import dal.OutputInvoice.OutputInvoiceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.ImportInvoice;
import model.ImportInvoiceDetail;
import model.OutputInvoiceDetail;

/**
 *
 * @author cloudy_place
 */
public class MedicineDeleteControll extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        //check session
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            Account account = new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString());
            if (account.getRole().getRoleId() == 2) {
                response.sendRedirect("AccessDenied");
            } else {
                //profileUser
                request.setAttribute("profileUser", account);

                int medicineId = Integer.parseInt(request.getParameter("id"));

                //delete imInvoiceDetail have medId
                ImportInvoiceDBContext imInvoiceDB = new ImportInvoiceDBContext();
                List<ImportInvoiceDetail> listImInvoiceDetail = imInvoiceDB.getListImInvoiceByMedId(medicineId);

                imInvoiceDB.deleteManyImInvoiceDetail(listImInvoiceDetail);

                //delete imInvoiceDetail have medId
                OutputInvoiceDBContext outInvoiceDB = new OutputInvoiceDBContext();
                List<OutputInvoiceDetail> listOutInvoiceDetail = outInvoiceDB.getListOutInvoiceByMedId(medicineId);

                outInvoiceDB.deleteManyOutInvoiceDetail(listOutInvoiceDetail);

                MedicineDB medicineDB = new MedicineDB();
                medicineDB.deleteMedicine(medicineId);

                response.sendRedirect("medicinemanage");
            }
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
