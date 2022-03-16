/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.MedicineManage;

import dal.AccountDBContext;
import dal.MedicineDB;
import dal.ProductDBGetById;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Distributor;
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineEditControll extends HttpServlet {

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

            request.setAttribute("MedicineDetail", new ProductDBGetById().getMedicineByIdAdmin(Integer.parseInt(request.getParameter("id"))));


            request.setAttribute("AllTypeMedicine", new MedicineDB().getAllTypeMedicine());


            request.setAttribute("AllDistributor", new DistributorDBContext().getAllDistributor());

            request.setAttribute("AllMedicalBox", new MedicineDB().getAllMedicalBox());

            request.getRequestDispatcher("view/Manage/MedicineManage/MedicineEditAdmin.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_typeId = request.getParameter("typeId");
        String raw_distributorId = request.getParameter("disId");
        String raw_ManufactureDate = request.getParameter("ManufactureDate");
        String raw_OutOfDate = request.getParameter("OutOfDate");
        String raw_InputPrice = request.getParameter("InputPrice");
        String raw_Price = request.getParameter("Price");
        String raw_Unit = request.getParameter("Unit");
        String raw_BoxId = request.getParameter("boxId");
        String raw_Quantity = request.getParameter("Quantity");
        String raw_image = request.getParameter("image");
        String raw_Note = request.getParameter("Note");

        int id = Integer.parseInt(raw_id);
        String name = raw_name; //check length
        int typeId = Integer.parseInt(raw_typeId);
        int distributorId = Integer.parseInt(raw_distributorId);
        Date manufactureDate = Date.valueOf(raw_ManufactureDate);
        Date outOfDate = Date.valueOf(raw_OutOfDate);
        int inputPrice = Integer.parseInt(raw_InputPrice);
        int price = Integer.parseInt(raw_Price);
        String unit = raw_Unit;
        int boxId = Integer.parseInt(raw_BoxId);
        int quantity = Integer.parseInt(raw_Quantity);
        String image = raw_image;
        String note = raw_Note;

        Distributor d = new Distributor();
        d.setDistributorId(distributorId);
        TypeMedicine t = new TypeMedicine();
        t.setTypeId(typeId);
        MedicalBox b = new MedicalBox();
        b.setBoxId(boxId);

        Medicine m = new Medicine();
        m.setMedicineId(id);
        m.setMedicineName(name);
        m.setType(t);
        m.setDistributor(d);
        m.setManufactureDate(raw_ManufactureDate);
        m.setOutOfDate(raw_OutOfDate);
        m.setInputPrice(inputPrice);
        m.setPrice(price);
        m.setUnit(unit);
        m.setBox(b);
        m.setQuantityInStock(quantity);
        m.setImage(image);
        m.setNote(note);

        MedicineDB db = new MedicineDB();
        db.updateMedicine(m);

        response.sendRedirect("medicineDetailAdmin?id="+id);

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
