/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ImportInvoice;

import static controller.ImportInvoice.AddMedicineControll.LISTMEDICINE;
import dal.AccountDBContext;
import dal.ImportInvoice.ImportInvoiceDBContext;
import dal.MedicineDB;
import dal.distributor.DistributorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Distributor;
import model.ImportInvoice;
import model.ImportInvoiceDetail;
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class ImportInvoiceControll extends HttpServlet {

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

            //distributor
            request.setAttribute("AllDistributor", new DistributorDBContext().getAllDistributor());

            // get invoice id max
            request.setAttribute("IdMax", new ImportInvoiceDBContext().getImInvoiceIdMax());
//            // get medicine id max
//            request.setAttribute("MedicineIdMax", new MedicineDB().getMedicineIdMax());

            List<ImportInvoiceDetail> listImInvoiceDetail = (List<ImportInvoiceDetail>) session.getAttribute("listImInvoiceDetail");
            request.setAttribute("listImInvoiceDetail", listImInvoiceDetail);

            request.getRequestDispatcher("view/Invoice/ImportInvoice/ImportInvoice.jsp").forward(request, response);

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

        // set Distributor
        String raw_distributorId = request.getParameter("disId");
        int distributorId = Integer.parseInt(raw_distributorId);
        Distributor d = new Distributor();
        d.setDistributorId(distributorId);

        //set import invoice
        String imDate = request.getParameter("imDate");
        String totalMoney = request.getParameter("totalMoney");
        String note = request.getParameter("note");

        ImportInvoice i = new ImportInvoice();
        i.setDistributor(d);
        i.setImDate(imDate);
        i.setTotalMoney(totalMoney);
        i.setNote(note);

        //set Medicine
        HttpSession session = request.getSession();
        List<ImportInvoiceDetail> listImInvoiceDetail = (List<ImportInvoiceDetail>) session.getAttribute("listImInvoiceDetail");
        List<Medicine> listMedicine = new ArrayList<>();

        for (ImportInvoiceDetail importInvoiceDetail : listImInvoiceDetail) {
            //set thêm những cái thiếu trong Medicine
            int quantityInStock = importInvoiceDetail.getQuantity();
            Medicine medicine = importInvoiceDetail.getMedicine();
            medicine.setQuantityInStock(quantityInStock);
            medicine.setDistributor(d);
            listMedicine.add(medicine);

        }

        MedicineDB medicineDB = new MedicineDB();
        medicineDB.insertManyMedicine(listMedicine);

        ImportInvoiceDBContext importInvoiceDB = new ImportInvoiceDBContext();
        importInvoiceDB.insertImportInvoice(i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ImportInvoiceControll.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImportInvoice ii = new ImportInvoiceDBContext().getImInvoiceMaxId();
        int size = listImInvoiceDetail.size();
        List<Integer> listMedicineId = medicineDB.getListMedicineIdInsertedNearest(size);

        int k = listMedicineId.size();
        for (ImportInvoiceDetail importInvoiceDetail : listImInvoiceDetail) {
            //set invoiceId in detail
            importInvoiceDetail.setImportInvoice(ii);
            //set medicineId in detail
            Medicine m = importInvoiceDetail.getMedicine();
            m.setMedicineId(listMedicineId.get(k - 1));

            k--;
        }

        importInvoiceDB.insertManyImInvoiceDetail(listImInvoiceDetail);

        session.removeAttribute("listImInvoiceDetail");
        AddMedicineControll.LISTMEDICINE.removeAll(LISTMEDICINE);
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
