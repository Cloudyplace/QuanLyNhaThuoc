/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.AccountManage;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.packageMappingType;
import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class AccountManage extends HttpServlet {

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

                //get all Role
                request.setAttribute("listRole", new AccountDBContext().getListAllRole());
                //get all account
                request.setAttribute("listAccount", new AccountDBContext().getListAllAccount());

                request.getRequestDispatcher("view/Manage/AccountManage/AccountManage.jsp").forward(request, response);
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
        String[] roleId = request.getParameterValues("role");
        String[] accId = request.getParameterValues("accId");

        AccountDBContext accDB = new AccountDBContext();

        for (int i = 0; i < roleId.length; i++) {
            Account account = new Account(Integer.parseInt(accId[i]), new Role(Integer.parseInt(roleId[i])));
            accDB.updateRoleOfAccount(account);
        }

        response.sendRedirect("AccountManage");
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
