/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DistributorManage;

import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ImportInvoice;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class ImInvoiceOfDistributor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     *
     * //
     * <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     * /**
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
        
        //dung de phan trang
        String indexPage = request.getParameter("indexPage");
        if (indexPage == null) {
            indexPage = "1";
        }
        int indexP = Integer.parseInt(indexPage);
        //get total medicine of Distributor
        DistributorDBContext distributor = new DistributorDBContext();
        int count = distributor.getTotalImInvoiceOfDistributor(Integer.parseInt(request.getParameter("id")));
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }
        request.setAttribute("endPage", endPage);
        List<ImportInvoice> listImInvoicePageOfDis = distributor.pagingImInvoiceOfDistributor(Integer.parseInt(request.getParameter("id")), indexP);
        request.setAttribute("listImInvoicePageOfDis", listImInvoicePageOfDis);

        //style tag page
        request.setAttribute("tagPage", indexP);

        //distributor detail
        request.setAttribute("DistributorDetail", new DistributorDBContext().getDistributorById(Integer.parseInt(request.getParameter("id"))));

        request.getRequestDispatcher("view/Manage/DistributorManage/ImInvoiceOfDistributor.jsp").forward(request, response);

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
