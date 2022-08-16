/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.OutputInvoiceManage;

import controller.OutputInvoice.OutputInvoiceControll;
import dal.AccountDBContext;
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
import model.OutputInvoice;

/**
 *
 * @author cloudy_place
 */
public class OutputInvoiceEdit extends HttpServlet {

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
            if (account.getRole().getRoleId() == 2) {
                response.sendRedirect("AccessDenied");
            } else {
                //profileUser
                request.setAttribute("profileUser", account);

                //listOutInvoiceDetail size
                int size = 0;
                try {
                    List<OutputInvoiceControll> listOutInvoiceDetail = (List<OutputInvoiceControll>) session.getAttribute("listOutInvoiceDetail");
                    size = listOutInvoiceDetail.size();

                } catch (Exception e) {
                }
                request.setAttribute("outInvoiceDetailSize", size);

                //distributor
                request.setAttribute("OutInvoiceAndAccount", new OutputInvoiceDBContext().getOutInvoiceAndAccountByOutInvoiceId(Integer.parseInt(request.getParameter("id"))));

                //invoice detail
                request.setAttribute("ListOutInvoiceDetail", new OutputInvoiceDBContext().getListOutInvoiceDetailById(Integer.parseInt(request.getParameter("id"))));

//            //medice detail
//            request.setAttribute("MedicineDetail", new ProductDBGetById().getMedicineById(Integer.parseInt(request.getParameter("id"))));
                request.getRequestDispatcher("view/Manage/OutputInvoiceManage/OutInvoiceEdit.jsp").forward(request, response);

            }
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

        int id = Integer.parseInt(request.getParameter("outInvoiceId"));
        String raw_name = request.getParameter("customerName");
        String raw_phone = request.getParameter("customerPhone");
        String raw_date = request.getParameter("saleDate");
        String raw_note = request.getParameter("note");

        OutputInvoice o = new OutputInvoice();
        o.setOutInvoiceId(id);
        o.setCustomerName(raw_name);
        o.setCustomerPhone(Integer.parseInt(raw_phone));
        o.setSaleDate(raw_date);
        o.setNote(raw_note);

        OutputInvoiceDBContext db = new OutputInvoiceDBContext();
        db.updateOutputInvoice(o);

        System.out.println("-------------------------------");
        System.out.println(id);
        response.sendRedirect("outInvoiceDetail?id=" + id);

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
