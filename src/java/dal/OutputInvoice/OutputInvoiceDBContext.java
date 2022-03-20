/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.OutputInvoice;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.OutputInvoice;
import model.OutputInvoiceDetail;

/**
 *
 * @author cloudy_place
 */
public class OutputInvoiceDBContext extends DBContext {

    //insert OutputInvoice
    public void insertOutputInvoice(OutputInvoice o) {
        String sql = "INSERT INTO [OutputInvoice]\n"
                + "           ([AccId]\n"
                + "           ,[CustomerName]\n"
                + "           ,[CustomerPhone]\n"
                + "           ,[SaleDate]\n"
                + "           ,[TotalMoney]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, o.getAccount().getAccountID());
            stm.setString(2, o.getCustomerName());
            stm.setString(3, o.getCustomerPhone());
            stm.setString(4, o.getSaleDate());
            stm.setString(5, o.getTotalMoney());
            stm.setString(6, o.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
//        } finally {
//            if (stm != null) {
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
    }

    // get ImInvoice have ImInvoice Id max
    public OutputInvoice getOutInvoiceIdMaxId() {
        try {
            String sql = "select *\n"
                    + "from OutputInvoice where OutInvoiceId = (select max(OutInvoiceId) from OutputInvoice)";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                OutputInvoice importInvoice = new OutputInvoice(rs.getInt(1),
                        new Account(rs.getInt(2)), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
                return importInvoice;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    //insert 1 outInvoice detail
    public void insertOutInvoiceDetail(OutputInvoiceDetail iod) {
        String sql = "INSERT INTO [OutputInvoiceDetail]\n"
                + "           ([OutInvoiceId]\n"
                + "           ,[MedicineId]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, iod.getOutputInvoice().getOutInvoiceId());
            stm.setInt(2, iod.getMedicine().getMedicineId());
            stm.setInt(3, iod.getQuantity());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    //insert many medicine
    public void insertManyOutInvoiceDetail(List<OutputInvoiceDetail> list) {
        for (OutputInvoiceDetail detail : list) {
            insertOutInvoiceDetail(detail);
        }
    }

//    public List<OutputInvoiceDetail> getListOutInvoiceDetailInsertedNearest(int count) {
//        List<OutputInvoiceDetail> list = new ArrayList<>();
//        String sql = "select top (?) OutInvoiceId from OutputInvoiceDetail order by OutInvoiceId desc";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//
//            stm.setInt(1, count);
//
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                list.add();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    public static void main(String[] args) {
        System.out.println(new OutputInvoiceDBContext().getOutInvoiceIdMaxId());
    }
}
