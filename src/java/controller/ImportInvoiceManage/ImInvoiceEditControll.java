/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ImportInvoiceManage;

import controller.OutputInvoice.OutputInvoiceControll;
import dal.AccountDBContext;
import dal.ImportInvoice.ImportInvoiceDBContext;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Distributor;
import model.ImportInvoice;

/**
 *
 * @author cloudy_place
 */
public class ImInvoiceEditControll extends HttpServlet {

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

        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            //profileUser&
            request.setAttribute("profileUser", new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString()));

            //listOutInvoiceDetail size
            int size = 0;
            try {
                List<OutputInvoiceControll> listOutInvoiceDetail = (List<OutputInvoiceControll>) session.getAttribute("listOutInvoiceDetail");
                size = listOutInvoiceDetail.size();

            } catch (Exception e) {
            }
            request.setAttribute("outInvoiceDetailSize", size);

            //distributor
            request.setAttribute("ImvoiceAndDistributor", new ImportInvoiceDBContext().getImInvoiceAndDistributorByImInvoiceId(Integer.parseInt(request.getParameter("id"))));

            //invoice detail
            request.setAttribute("ListImInvoiceDetail", new ImportInvoiceDBContext().getListImInvoiceDetailById(Integer.parseInt(request.getParameter("id"))));

            //set all distributor
            request.setAttribute("AllDistributor", new DistributorDBContext().getAllDistributor());

            request.getRequestDispatcher("view/Manage/ImportInvoiceManage/ImInvoiceEdit.jsp").forward(request, response);

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

        int id = Integer.parseInt(request.getParameter("imInvoiceId"));
        int disId = Integer.parseInt(request.getParameter("disId"));
        String raw_date = request.getParameter("imDate");
        String raw_note = request.getParameter("note");
        
        //set distributor in imInvoice
        Distributor d = new Distributor();
        d.setDistributorId(disId);
        
        //set imInvoice
        ImportInvoice i = new ImportInvoice();
        i.setImInvoiceId(id);
        i.setDistributor(d);
        i.setImDate(raw_date);
        i.setNote(raw_note);
        
        ImportInvoiceDBContext imInvoiceDB = new ImportInvoiceDBContext();
        imInvoiceDB.updateImportInvoice(i);
        
        response.sendRedirect("imInvoiceDetail?id=" + id);
        
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
