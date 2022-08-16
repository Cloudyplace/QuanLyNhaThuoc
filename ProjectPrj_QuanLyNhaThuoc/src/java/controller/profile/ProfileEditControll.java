/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.profile;

import dal.AccountDBContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.OutputInvoiceDetail;
import model.Role;

/**
 *
 * @author cloudy_place
 */
public class ProfileEditControll extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        //check session
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {// set login
            response.sendRedirect("login");
        } else {
            //profileUser
            request.setAttribute("profileUser", new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString()));

            //listOutInvoiceDetail size
            int size = 0;
            try {
                List<OutputInvoiceDetail> listOutInvoiceDetail = (List<OutputInvoiceDetail>) session.getAttribute("listOutInvoiceDetail");
                size = listOutInvoiceDetail.size();

            } catch (Exception e) {
            }
            request.setAttribute("outInvoiceDetailSize", size);

            request.getRequestDispatcher("view/Profile/profileEdit.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String raw_username = session.getAttribute("username").toString();
        String raw_password = session.getAttribute("password").toString();
        String raw_name = request.getParameter("name");
        String raw_email = request.getParameter("email");
        String raw_phone = request.getParameter("phone");
        String raw_address = request.getParameter("address");

        String username = raw_username;
        String password = raw_password;
        String name = raw_name; //check length
        String address = raw_address;
        String email = raw_email;
        String phone = raw_phone;

        Account a = new Account();
        a.setUsername(username);
        a.setPassword(password);
        a.setFullName(name);
        a.setAddress(address);
        a.setEmail(email);
        a.setPhone(phone);

        AccountDBContext db = new AccountDBContext();
        db.updateAccount(a);

        response.sendRedirect("profile");

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
