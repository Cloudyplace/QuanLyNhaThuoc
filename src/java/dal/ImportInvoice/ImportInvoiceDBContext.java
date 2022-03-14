/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.ImportInvoice;

import dal.AccountDBContext;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Distributor;
import model.ImportInvoice;
import model.ImportInvoiceDetail;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class ImportInvoiceDBContext extends DBContext {
    //Đếm số lượng ImportInvoice trong db

    public int getTotalImportInvoice() {
        String sql = "select count(*) from ImportInvoice";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //phan trang
    public List<ImportInvoice> pagingImportInvoice(int index) {
        List<ImportInvoice> list = new ArrayList<>();
        String sql = "select i.ImInvoiceId, i.ImDate, i.TotalMoney,i.Note,d.DistributorName "
                + "from ImportInvoice i inner join Distributor d on i.DistributorId=d.DistributorId\n"
                + "Order by ImInvoiceId offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new ImportInvoice(rs.getInt("imInvoiceId"), new Distributor(rs.getString("distributorName")), rs.getString("imDate"), rs.getString("totalMoney"), rs.getString("note")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // get importInvoiceDetail by id
    public List<ImportInvoiceDetail> getImInvoiceDetailById(int importInvoiceId) {
        List<ImportInvoiceDetail> list = new ArrayList<>();
        String sql = "select ii.ImDetailId,ii.ImInvoiceId, ii.Quantity, ii.Money, m.MedicineName, m.Unit, m.InputPrice "
                + "from ImportInvoiceDetail ii inner join Medicine m "
                + "on ii.MedicineId=m.MedicineId where ImInvoiceId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, importInvoiceId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new ImportInvoiceDetail(rs.getInt("imDetailId"), rs.getInt("ImInvoiceId"),
                        new Medicine(rs.getString("medicineName"), rs.getString("unit"),
                                rs.getInt("inputPrice")), rs.getInt("quantity"), rs.getInt("money")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // get importInvoice by id
    public ImportInvoice getImInvoiceById(int importInvoiceId) {
        try {
            String sql = "select * from ImportInvoice where ImInvoiceId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, importInvoiceId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ImportInvoice importInvoice = new ImportInvoice(rs.getInt("imInvoiceId"), rs.getString("imDate"), rs.getString("totalMoney"), rs.getString("note"));
                return importInvoice;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public Distributor getDistributorByImInvoiceId(int imInvoiceId) {
        try {
            String sql = "select d.*\n"
                    + "from ImportInvoice ii inner join Distributor d on d.DistributorId=ii.DistributorId\n"
                    + "where ii.ImInvoiceId= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, imInvoiceId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Distributor distributor = new Distributor(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return distributor;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public static void main(String[] args) {
        ImportInvoiceDBContext imInvoice = new ImportInvoiceDBContext();
        List<ImportInvoiceDetail> list = imInvoice.getImInvoiceDetailById(1);
        for (ImportInvoiceDetail o : list) {
            System.out.println(o);
        }
        //       System.out.println(imInvoice.getImInvoiceById(3));
    }
}
