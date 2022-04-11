/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.OutputInvoice;

import static controller.OutputInvoice.AddMedicineOutInvocie.LIST_MEDICINE_OUTINVOICE;
import dal.AccountDBContext;
import dal.MedicineDB;
import dal.OutputInvoice.OutputInvoiceDBContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Medicine;
import model.OutputInvoice;
import model.OutputInvoiceDetail;

/**
 *
 * @author cloudy_place
 */
public class OutputInvoiceControll extends HttpServlet {

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
            Account account = new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString());

            //profileUser
            request.setAttribute("profileUser", account);

            //listOutInvoiceDetail size
            int size = 0;
            try {
                List<OutputInvoiceDetail> listOutInvoiceDetail = (List<OutputInvoiceDetail>) session.getAttribute("listOutInvoiceDetail");
                size = listOutInvoiceDetail.size();

            } catch (Exception e) {
            }
            request.setAttribute("outInvoiceDetailSize", size);

            //list outInvoiceDetail
            List<OutputInvoiceDetail> listOutInvoiceDetail = (List<OutputInvoiceDetail>) session.getAttribute("listOutInvoiceDetail");
            request.setAttribute("listOutInvoiceDetail", listOutInvoiceDetail);

            request.setAttribute("ErrorQuantityMax", request.getAttribute("ErrorQuantityMax"));
            
            request.getRequestDispatcher("view/Invoice/OutputInvoice/OutputInvoice.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //set output invoice
        String customerName = request.getParameter("customerName");
        int customerPhone = Integer.parseInt(request.getParameter("customerPhone"));

        String saleDate = request.getParameter("saleDate");
        int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
        if (totalMoney == 0) {
            response.sendRedirect("home");
        } else {
            String note = request.getParameter("note");

            HttpSession session = request.getSession();
            Account account = new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString());

            OutputInvoice i = new OutputInvoice();
            i.setAccount(account);
            i.setCustomerName(customerName);
            i.setCustomerPhone(customerPhone);
            i.setSaleDate(saleDate);
            i.setTotalMoney(totalMoney);
            i.setNote(note);

            OutputInvoiceDBContext outInvoiceDB = new OutputInvoiceDBContext();
            outInvoiceDB.insertOutputInvoice(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OutputInvoiceControll.class.getName()).log(Level.SEVERE, null, ex);
            }

            //set output invoice detail
            OutputInvoice oi = new OutputInvoiceDBContext().getOutInvoiceIdMaxId();
            
            List<OutputInvoiceDetail> listOutInvoiceDetail = (List<OutputInvoiceDetail>) session.getAttribute("listOutInvoiceDetail");
            System.out.println("size: "+listOutInvoiceDetail.size());
            for (OutputInvoiceDetail detail : listOutInvoiceDetail) {
                detail.setOutputInvoice(oi);
                System.out.println(detail);
            }

            outInvoiceDB.insertManyOutInvoiceDetail(listOutInvoiceDetail);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OutputInvoiceControll.class.getName()).log(Level.SEVERE, null, ex);
            }

            //set quantityInStock of Medicine
            List<Medicine> listMedicine = new ArrayList<>();
            for (OutputInvoiceDetail detail : listOutInvoiceDetail) {
                Medicine medicine = detail.getMedicine();
                medicine.setQuantityInStock(medicine.getQuantityInStock() - detail.getQuantity());

                listMedicine.add(medicine);
            }
            MedicineDB medicineDB = new MedicineDB();
            medicineDB.updateManyQuantityMedicine(listMedicine);

            //clear out invoice
            session.removeAttribute("listOutInvoiceDetail");
            AddMedicineOutInvocie.LIST_MEDICINE_OUTINVOICE.removeAll(LIST_MEDICINE_OUTINVOICE);
            
            response.sendRedirect("home");
        }

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
