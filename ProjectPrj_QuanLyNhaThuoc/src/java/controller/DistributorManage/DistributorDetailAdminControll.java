package controller.DistributorManage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.OutputInvoice.OutputInvoiceControll;
import dal.AccountDBContext;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author cloudy_place
 */
public class DistributorDetailAdminControll extends HttpServlet {

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

                //distributor detail
                request.setAttribute("DistributorDetail", new DistributorDBContext().getDistributorById(Integer.parseInt(request.getParameter("id"))));

                //total medicine
                request.setAttribute("TotalTypeMidicine", new DistributorDBContext().getTotalMedicineOfDistributor((Integer.parseInt(request.getParameter("id")))));

                //total Import Invoice
                request.setAttribute("TotalImportInvoice", new DistributorDBContext().getTotalImInvoiceOfDistributor(Integer.parseInt(request.getParameter("id"))));

                //total money of Im Invoice
                request.setAttribute("TotalMoneyIInvoice", new DistributorDBContext().getTotalMoneyImInvoiceByDisId(Integer.parseInt(request.getParameter("id"))));

                request.getRequestDispatcher("view/Manage/DistributorManage/DistributorDetailAdmin.jsp").forward(request, response);
            }
        }
    }

    /**
     *
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
