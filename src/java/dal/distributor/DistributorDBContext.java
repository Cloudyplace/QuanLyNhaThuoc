/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.distributor;

import dal.DBContext;
import dal.MedicineDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Distributor;
import model.ImportInvoice;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class DistributorDBContext extends DBContext {

    //Đếm số lượng Distributor trong db
    public int getTotalDistributor() {
        String sql = "select count(*) from Distributor";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //phan trang
    public List<Distributor> pagingDistributor(int index) {
        List<Distributor> list = new ArrayList<>();
        String sql = "select * from Distributor\n"
                + "Order by DistributorId\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Distributor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //get all distributor
    public List<Distributor> getAllDistributor() {
        List<Distributor> list = new ArrayList<>();
        String sql = "select * from Distributor\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Distributor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // get distributor by id
    public Distributor getDistributorById(int distributorId) {
        try {
            String sql = "select * from Distributor WHERE distributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, distributorId);
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

    //get total Medicine by disId
    public int getTotalMedicineOfDistributor(int disId) {
        try {
            String sql = "select COUNT(m.MedicineId)\n"
                    + "from Distributor d inner join ImportInvoice ii on d.DistributorId=ii.DistributorId\n"
                    + "                     inner join ImportInvoiceDetail iid on ii.ImInvoiceId=iid.ImInvoiceId\n"
                    + "                     inner join Medicine m on iid.MedicineId=m.MedicineId \n"
                    + "                     where d.DistributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, disId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    // get all invoice by disId
    public List<ImportInvoice> getListImInvoiceByDisId(int disId) {
        List<ImportInvoice> list = new ArrayList<>();
        try {
            String sql = "select i.ImInvoiceId, i.ImDate, i.TotalMoney,i.Note,d.DistributorName\n"
                    + "from Distributor d inner join ImportInvoice i on d.DistributorId=i.DistributorId\n"
                    + "                     where d.DistributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, disId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new ImportInvoice(rs.getInt("imInvoiceId"), new Distributor(rs.getString("distributorName")), rs.getString("imDate"), rs.getString("totalMoney"), rs.getString("note")));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DistributorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // get list medicine by disId
    public List<Medicine> pagingMedicineOfDistributor(int disId, int index) {
        List<Medicine> list = new ArrayList<>();
        try {
            String sql = "select m.MedicineId, m.MedicineName, m.InputPrice, m.Price,m.OutOfDate, m.QuantityInStock\n"
                    + "                                        from Distributor d inner join ImportInvoice ii on d.DistributorId=ii.DistributorId\n"
                    + "                                                           inner join ImportInvoiceDetail iid on ii.ImInvoiceId=iid.ImInvoiceId\n"
                    + "                                                          inner join Medicine m on iid.MedicineId=m.MedicineId \n"
                    + "                                                      where d.DistributorId = ?\n"
                    + "                                                          Order by MedicineId\n"
                    + "                                                     offset ? rows fetch next 10 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, disId);
            stm.setInt(2, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt("medicineId"), rs.getString("medicineName"), rs.getInt("inputPrice"), rs.getInt("price"), rs.getString("outOfDate"), rs.getInt("quantityInStock")));
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DistributorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //get total invoice by dis id
    public int getTotalImInvoiceByDisId(int disId) {
        try {
            String sql = "select count(*)"
                    + "from Distributor d inner join ImportInvoice i on d.DistributorId=i.DistributorId\n"
                    + "                     where d.DistributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, disId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    //get totalMoney all Import Invoice by Dis Id
    //get total invoice by dis id
    public int getTotalMoneyImInvoiceByDisId(int disId) {
        try {
            String sql = "select sum(i.TotalMoney)\n"
                    + "from Distributor d inner join ImportInvoice i on d.DistributorId=i.DistributorId\n"
                    + "where d.DistributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, disId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    //update Distributor
    public void updateDistributor(Distributor m) {
        String sql = "UPDATE [Distributor]\n"
                + "   SET [DistributorName] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Note] = ?\n"
                + " WHERE DistributorId=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(6, m.getDistributorId());
            stm.setString(1, m.getDistributorName());
            stm.setString(2, m.getAddress());
            stm.setString(3, m.getEmail());
            stm.setString(4, m.getPhone());
            stm.setString(5, m.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
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
        DistributorDBContext imInvoice = new DistributorDBContext();
        List<Medicine> list = imInvoice.pagingMedicineOfDistributor(1, 1);
        for (Medicine o : list) {
            System.out.println(o);
        }
        //      System.out.println(list.size());
    }
}
