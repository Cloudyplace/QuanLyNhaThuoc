/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.MedicineManage;

import controller.OutputInvoice.OutputInvoiceControll;
import dal.AccountDBContext;
import dal.MedicineDB;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
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

                request.setAttribute("MedicineDetail", new MedicineDB().getMedicineByIdAdmin(Integer.parseInt(request.getParameter("id"))));

                request.setAttribute("AllTypeMedicine", new MedicineDB().getAllTypeMedicine());

                request.setAttribute("AllDistributor", new DistributorDBContext().getAllDistributor());

                request.setAttribute("AllMedicalBox", new MedicineDB().getAllMedicalBox());

                request.getRequestDispatcher("view/Manage/MedicineManage/MedicineEditAdmin.jsp").forward(request, response);

            }
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
        m.setMedicineId(id);
        m.setMedicineName(name);
        m.setType(t);
        m.setManufactureDate(manufactureDate);
        m.setOutOfDate(outOfDate);
        m.setInputPrice(inputPrice);
        m.setPrice(price);
        m.setUnit(unit);
        m.setBox(b);
        m.setQuantityInStock(quantity);
        m.setImage(image);
        m.setNote(note);

        MedicineDB db = new MedicineDB();
        db.updateMedicine(m);

        response.sendRedirect("medicineDetailAdmin?id=" + id);

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
