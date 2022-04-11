/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DistributorManage;

import controller.OutputInvoice.OutputInvoiceControll;
import dal.AccountDBContext;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Distributor;

/**
 *
 * @author cloudy_place
 */
public class DistributorManageControll extends HttpServlet {

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

                //dung de phan trang
                String indexPage = request.getParameter("indexPage");
                if (indexPage == null) {
                    indexPage = "1";
                }
                int indexP = Integer.parseInt(indexPage);
                //get total Distributor
                DistributorDBContext Distributor = new DistributorDBContext();
                int count = Distributor.getTotalDistributor();
                int endPage = count / 10;
                if (count % 10 != 0) {
                    endPage++;
                }
                request.setAttribute("endPage", endPage);
                List<Distributor> listDistributorPage = Distributor.pagingDistributor(indexP);
                request.setAttribute("listDistributorPage", listDistributorPage);

                //style tag page
                request.setAttribute("tagPage", indexP);

                request.getRequestDispatcher("view/Manage/DistributorManage/DistributorManage.jsp").forward(request, response);
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
