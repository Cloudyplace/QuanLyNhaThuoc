/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.ImportInvoice;

import controller.ImportInvoiceManage.ImInvoiceDetailControll;
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
    public List<ImportInvoiceDetail> getListImInvoiceDetailById(int importInvoiceId) {
        List<ImportInvoiceDetail> list = new ArrayList<>();
        String sql = "select iid.ImDetailId,ii.ImInvoiceId, m.MedicineId, m.MedicineName, m.Unit, m.InputPrice,m.Price, iid.Quantity \n"
                + "from ImportInvoiceDetail iid inner join Medicine m on iid.MedicineId=m.MedicineId \n"
                + "inner join ImportInvoice ii on ii.ImInvoiceId = iid.ImInvoiceId \n"
                + "where ii.ImInvoiceId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, importInvoiceId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new ImportInvoiceDetail(rs.getInt(1), new ImportInvoice(rs.getInt(2)), new Medicine(rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ImportInvoice getImInvoiceAndDistributorByImInvoiceId(int imInvoiceId) {
        try {
            String sql = "select ii.ImInvoiceId,d.*, ii.ImDate, ii.TotalMoney, ii.Note\n"
                    + "from ImportInvoice ii inner join Distributor d on d.DistributorId=ii.DistributorId\n"
                    + "where ii.ImInvoiceId= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, imInvoiceId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ImportInvoice importInvoice = new ImportInvoice(rs.getInt(1),
                        new Distributor(rs.getInt(2), rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getString(7)),
                        rs.getString(8), rs.getString(9), rs.getString(10));
                return importInvoice;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

//    //get max import invoiceid
//    public int getImInvoiceIdMax() {
//        String sql = "select max(ImInvoiceId)\n"
//                + "from ImportInvoice";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
    // get ImInvoice have ImInvoice Id max
    public ImportInvoice getImInvoiceMaxId() {
        try {
            String sql = "select *\n"
                    + "from ImportInvoice where ImInvoiceId = (select max(ImInvoiceId) from ImportInvoice)";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ImportInvoice importInvoice = new ImportInvoice(rs.getInt(1),
                        new Distributor(rs.getInt(2)),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                return importInvoice;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public void insertImportInvoice(ImportInvoice i) {
        String sql = "INSERT INTO [ImportInvoice]\n"
                + "           ([DistributorId]\n"
                + "           ,[ImDate]\n"
                + "           ,[TotalMoney]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, i.getDistributor().getDistributorId());
            stm.setString(2, i.getImDate());
            stm.setString(3, i.getTotalMoney());
            stm.setString(4, i.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    //insert 1 imInvoice detail
    public void insertImInvoiceDetail(ImportInvoiceDetail iid) {
        String sql = "INSERT INTO [ImportInvoiceDetail]\n"
                + "           ([ImInvoiceId]\n"
                + "           ,[MedicineId]\n"
                + "           ,[Quantity])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, iid.getImportInvoice().getImInvoiceId());
            stm.setInt(2, iid.getMedicine().getMedicineId());
            stm.setInt(3, iid.getQuantity());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    //insert many medicine
    public void insertManyImInvoiceDetail(List<ImportInvoiceDetail> list) {
        for (ImportInvoiceDetail detail : list) {
            insertImInvoiceDetail(detail);
        }
    }

    //update imInvoice
    public void updateImportInvoice(ImportInvoice i) {
        String sql = "UPDATE [ImportInvoice]\n"
                + "   SET [DistributorId] = ?\n"
                + "      ,[ImDate] = ?\n"
                + "      ,[Note] = ?\n"
                + " WHERE ImInvoiceId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(4, i.getImInvoiceId());
            stm.setInt(1, i.getDistributor().getDistributorId());
            stm.setString(2, i.getImDate());
            stm.setString(3, i.getNote());
            
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(ImportInvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                }
            }
        }

    }

    public static void main(String[] args) {
        ImportInvoiceDBContext imInvoice = new ImportInvoiceDBContext();
        List<ImportInvoiceDetail> list = new ArrayList<>();
        list.add(new ImportInvoiceDetail(new ImportInvoice(18), new Medicine(8), 5));
        list.add(new ImportInvoiceDetail(new ImportInvoice(17), new Medicine(3000), 5));
        imInvoice.insertManyImInvoiceDetail(list);
    }
}
