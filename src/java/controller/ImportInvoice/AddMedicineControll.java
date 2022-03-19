/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ImportInvoice;

import dal.AccountDBContext;
import dal.MedicineDB;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Distributor;
import model.ImportInvoiceDetail;
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class AddMedicineControll extends HttpServlet {

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
            //profileUser
            request.setAttribute("profileUser", new AccountDBContext().getUser(session.getAttribute("username").toString(), session.getAttribute("password").toString()));

            request.setAttribute("AllMedicalBox", new MedicineDB().getAllMedicalBox());

            request.setAttribute("AllTypeMedicine", new MedicineDB().getAllTypeMedicine());

            request.getRequestDispatcher("view/Invoice/ImportInvoice/AddMedicine.jsp").forward(request, response);

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
    public static final List<ImportInvoiceDetail> LISTMEDICINE = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String raw_name = request.getParameter("name");
        String raw_typeId = request.getParameter("typeId");
        String raw_ManufactureDate = request.getParameter("ManufactureDate");
        String raw_OutOfDate = request.getParameter("OutOfDate");
        String raw_InputPrice = request.getParameter("InputPrice");
        String raw_Price = request.getParameter("Price");
        String raw_Unit = request.getParameter("Unit");
        String raw_BoxId = request.getParameter("boxId");
        String raw_Quantity = request.getParameter("Quantity");
        String raw_image = request.getParameter("image");
        String raw_Note = request.getParameter("Note");

        String name = raw_name; //check length
        int typeId = Integer.parseInt(raw_typeId);
        String manufactureDate = raw_ManufactureDate;
        String outOfDate = raw_OutOfDate;
        int inputPrice = Integer.parseInt(raw_InputPrice);
        int price = Integer.parseInt(raw_Price);
        String unit = raw_Unit;
        int boxId = Integer.parseInt(raw_BoxId);
        int quantity = Integer.parseInt(raw_Quantity);
        String image = raw_image;
        String note = raw_Note;

        TypeMedicine t = new TypeMedicine();
        t.setTypeId(typeId);
        MedicalBox b = new MedicalBox();
        b.setBoxId(boxId);

        Medicine m = new Medicine();
        m.setMedicineName(name);
        m.setType(t);
        m.setManufactureDate(manufactureDate);
        m.setOutOfDate(outOfDate);
        m.setInputPrice(inputPrice);
        m.setPrice(price);
        m.setUnit(unit);
        m.setBox(b);
        m.setImage(image);
        m.setNote(note);

        ImportInvoiceDetail i = new ImportInvoiceDetail();
        i.setMedicine(m);
        i.setQuantity(quantity);

        LISTMEDICINE.add(i);

        HttpSession session = request.getSession();
        session.setAttribute("listImInvoiceDetail", LISTMEDICINE);

        response.sendRedirect("ImportInvoice");

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