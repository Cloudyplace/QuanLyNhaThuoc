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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Medicine;
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
            stm.setInt(3, o.getCustomerPhone());
            stm.setString(4, o.getSaleDate());
            stm.setInt(5, o.getTotalMoney());
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

    // get OutInvoice have OutInvoice Id max
    public OutputInvoice getOutInvoiceIdMaxId() {
        try {
            String sql = "select *\n"
                    + "from OutputInvoice where OutInvoiceId = (select max(OutInvoiceId) from OutputInvoice)";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                OutputInvoice importInvoice = new OutputInvoice(rs.getInt(1),
                        new Account(rs.getInt(2)), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
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

    //phan trang
    public List<OutputInvoice> pagingOutputInvoice(int index) {
        List<OutputInvoice> list = new ArrayList<>();
        String sql = "select OutInvoiceId, CustomerName, SaleDate, TotalMoney, Note\n"
                + "from OutputInvoice\n"
                + "Order by OutInvoiceId offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new OutputInvoice(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalOutportInvoice() {
        String sql = "select count(*) from OutputInvoice";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public OutputInvoice getOutInvoiceAndAccountByOutInvoiceId(int outInvoiceId) {
        try {
            String sql = "select OutInvoiceId, a.FullName, CustomerName, CustomerPhone, SaleDate, TotalMoney, Note\n"
                    + "from OutputInvoice o inner join Account a on o.AccId = a.AccId\n"
                    + "where OutInvoiceId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, outInvoiceId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                OutputInvoice outputInvoice = new OutputInvoice(rs.getInt(1),
                        new Account(rs.getString(2)), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getInt(6), rs.getString(7));
                return outputInvoice;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    // get importInvoiceDetail by id
    public List<OutputInvoiceDetail> getListOutInvoiceDetailById(int outputInvoiceId) {
        List<OutputInvoiceDetail> list = new ArrayList<>();
        String sql = "select oid.OutDetailId,oi.OutInvoiceId, m.MedicineId, m.MedicineName, m.Unit,m.InputPrice, m.Price, oid.Quantity \n"
                + "from OutputInvoiceDetail oid inner join Medicine m on oid.MedicineId=m.MedicineId \n"
                + "inner join OutputInvoice oi on oi.OutInvoiceId = oid.OutInvoiceId \n"
                + "where oi.OutInvoiceId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, outputInvoiceId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new OutputInvoiceDetail(rs.getInt(1), new OutputInvoice(rs.getInt(2)), new Medicine(rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateOutputInvoice(OutputInvoice o) {
        String sql = "UPDATE [OutputInvoice]\n"
                + "   SET [CustomerName] = ?\n"
                + "      ,[CustomerPhone] = ?\n"
                + "      ,[SaleDate] = ?\n"
                + "      ,[Note] = ?\n"
                + " WHERE OutInvoiceId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(5, o.getOutInvoiceId());
            stm.setString(1, o.getCustomerName());
            stm.setInt(2, o.getCustomerPhone());
            stm.setString(3, o.getSaleDate());
            stm.setString(4, o.getNote());
            
            System.out.println(o.getOutInvoiceId()+","+o.getCustomerName()+" "+o.getCustomerPhone()+" "+o.getSaleDate()+" "+o.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(OutputInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (stm != null) {
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                }
//            }
        }

    }

    public static void main(String[] args) {
        List<OutputInvoiceDetail> list = new OutputInvoiceDBContext().getListOutInvoiceDetailById(1);
        for (OutputInvoiceDetail outputInvoiceDetail : list) {
            System.out.println(outputInvoiceDetail);
        }
    }

}
