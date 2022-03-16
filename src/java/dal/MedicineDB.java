/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Distributor;
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineDB extends DBContext {

//    public List<Medicine> getAllMedicine() {
//        List<Medicine> list = new ArrayList<>();
//        try {
//            String sql = "select * from Medicine";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                list.add(new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3),
//                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7),
//                        rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
//                        rs.getInt(12), rs.getString(13)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return list;
//    }
    //Đếm số lượng product trong db
    public int getTotalMedicine() {
        String sql = "select count(*) from Medicine";
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

    //phan trang home
    public List<Medicine> pagingMedicine(int index) {
        List<Medicine> list = new ArrayList<>();
        String sql = "select m.MedicineId, m.MedicineName, b.BoxName, m.Price, m.image\n"
                + "from Medicine m inner join MedicalBox b on m.BoxId = b.BoxId\n"
                + "Order by MedicineId\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt(1), rs.getString(2), new MedicalBox(rs.getString(3)), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Medicine> pagingMedicineManage(int index) {
        List<Medicine> list = new ArrayList<>();
        String sql = "select MedicineId, MedicineName, t.TypeName, b.BoxName, d.DistributorName, Unit,InputPrice, Price, ManufactureDate, OutOfDate, m.image, m.QuantityInStock, m.Note\n"
                + "from Medicine m inner join TypeOfMedicine t on m.TypeId = t.TypeId\n"
                + "inner join MedicalBox b on m.BoxId = b.BoxId\n"
                + "inner join Distributor d on m.DistributorId = d.DistributorId\n"
                + "Order by MedicineId\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                list.add(new Medicine(, new MedicalBox(rs.getString(3)), rs.getInt(4), rs.getString(5)));
                list.add(new Medicine(rs.getInt(1), rs.getString(2),
                        new TypeMedicine(rs.getString(3)), new MedicalBox(rs.getString(4)),
                        new Distributor(rs.getString(5)), rs.getString(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //get all type medicine
    public List<TypeMedicine> getAllTypeMedicine() {
        List<TypeMedicine> list = new ArrayList<>();
        String sql = "select * from TypeOfMedicine\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new TypeMedicine(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //get all medical box
    public List<MedicalBox> getAllMedicalBox() {
        List<MedicalBox> list = new ArrayList<>();
        String sql = "select * from MedicalBox\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new MedicalBox(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //update medicine
    public void updateMedicine(Medicine m) {
        String sql = "UPDATE [Medicine]\n"
                + "   SET [MedicineName] = ?\n"
                + "      ,[TypeId] = ?\n"
                + "      ,[BoxId] = ?\n"
                + "      ,[DistributorId] = ?\n"
                + "      ,[Unit] = ?\n"
                + "      ,[InputPrice] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[ManufactureDate] = ?\n"
                + "      ,[OutOfDate] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[QuantityInStock] = ?\n"
                + "      ,[Note] = ?\n"
                + " WHERE MedicineId=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(13, m.getMedicineId());
            stm.setString(1, m.getMedicineName());
            stm.setInt(2, m.getType().getTypeId());
            stm.setInt(3, m.getBox().getBoxId());
            stm.setInt(4, m.getDistributor().getDistributorId());
            stm.setString(5, m.getUnit());
            stm.setInt(6, m.getInputPrice());
            stm.setInt(7, m.getPrice());
            stm.setString(8, m.getManufactureDate());
            stm.setString(9, m.getOutOfDate());
            stm.setString(10, m.getImage());
            stm.setInt(11, m.getQuantityInStock());
            stm.setString(12, m.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println("dfasdfdas");
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("aaaaa");
                }
            }
        }

    }

    public static void main(String[] args) {
        MedicineDB medicine = new MedicineDB();
        List<Medicine> list = medicine.pagingMedicine(1);
        for (Medicine o : list) {
            System.out.println(o);
        }
    }
}
