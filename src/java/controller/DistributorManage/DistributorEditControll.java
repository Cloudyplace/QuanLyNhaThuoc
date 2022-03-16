/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DistributorManage;

import dal.AccountDBContext;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Distributor;

/**
 *
 * @author cloudy_place
 */
public class DistributorEditControll extends HttpServlet {



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
            //profileUser
            request.setAttribute("profileUser", new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString()));

            request.setAttribute("DistributorDetail", new DistributorDBContext().getDistributorById(Integer.parseInt(request.getParameter("id"))));

            request.setAttribute("AllDistributor", new DistributorDBContext().getAllDistributor());

            request.getRequestDispatcher("view/Manage/DistributorManage/DistributorEdit.jsp").forward(request, response);

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_address = request.getParameter("address");
        String raw_email = request.getParameter("email");
        String raw_phone = request.getParameter("phone");
        String raw_note = request.getParameter("note");

        int id = Integer.parseInt(raw_id);
        String name = raw_name; //check length
        String address = raw_address; 
        String email = raw_email; 
        String phone = raw_phone; 
        String note = raw_note;

        Distributor d = new Distributor();
        d.setDistributorId(id);
        d.setDistributorName(name);
        d.setAddress(address);
        d.setEmail(email);
        d.setPhone(phone);
        d.setNote(note);

        DistributorDBContext db = new DistributorDBContext();
        db.updateDistributor(d);

        response.sendRedirect("distributorDetailAdmin?id="+id);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
