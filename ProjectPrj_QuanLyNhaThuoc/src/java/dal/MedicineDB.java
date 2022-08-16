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
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineDB extends DBContext {

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
        String sql = "select MedicineId, MedicineName, t.TypeName, b.BoxName, Unit,InputPrice, Price, ManufactureDate, OutOfDate, m.image, m.QuantityInStock, m.Note\n"
                + "from Medicine m inner join TypeOfMedicine t on m.TypeId = t.TypeId\n"
                + "inner join MedicalBox b on m.BoxId = b.BoxId\n"
                + "Order by MedicineId\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt(1), rs.getString(2),
                        new TypeMedicine(rs.getString(3)), new MedicalBox(rs.getString(4)),
                        rs.getString(5), rs.getInt(6), rs.getInt(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getInt(11), rs.getString(12)));
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

    //get id max
    public int getMedicineIdMax() {
        String sql = "select max(MedicineId)\n"
                + "from Medicine";
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

    //update medicine
    public void updateMedicine(Medicine m) {
        String sql = "UPDATE [Medicine]\n"
                + "   SET [MedicineName] = ?\n"
                + "      ,[TypeId] = ?\n"
                + "      ,[BoxId] = ?\n"
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

            stm.setInt(12, m.getMedicineId());
            stm.setString(1, m.getMedicineName());
            stm.setInt(2, m.getType().getTypeId());
            stm.setInt(3, m.getBox().getBoxId());
            stm.setString(4, m.getUnit());
            stm.setInt(5, m.getInputPrice());
            stm.setInt(6, m.getPrice());
            stm.setString(7, m.getManufactureDate());
            stm.setString(8, m.getOutOfDate());
            stm.setString(9, m.getImage());
            stm.setInt(10, m.getQuantityInStock());
            stm.setString(11, m.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    public void updateQuantityMedicine(Medicine m) {
        String sql = "UPDATE [Medicine]\n"
                + "   SET [QuantityInStock] = ?\n"
                + " WHERE MedicineId=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(2, m.getMedicineId());
            stm.setInt(1, m.getQuantityInStock());
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    //update many medicine
    public void updateManyQuantityMedicine(List<Medicine> list) {
        for (Medicine medicine : list) {
            updateQuantityMedicine(medicine);
        }
    }

    //insert 1 medicine
    public void insertMedicine(Medicine m) {
        String sql = "INSERT INTO [dbo].[Medicine]\n"
                + "           ([MedicineName]\n"
                + "           ,[TypeId]\n"
                + "           ,[BoxId]\n"
                + "           ,[Unit]\n"
                + "           ,[InputPrice]\n"
                + "           ,[Price]\n"
                + "           ,[ManufactureDate]\n"
                + "           ,[OutOfDate]\n"
                + "           ,[image]\n"
                + "           ,[QuantityInStock]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setString(1, m.getMedicineName());
            stm.setInt(2, m.getType().getTypeId());
            stm.setInt(3, m.getBox().getBoxId());
            stm.setString(4, m.getUnit());
            stm.setInt(5, m.getInputPrice());
            stm.setInt(6, m.getPrice());
            stm.setString(7, m.getManufactureDate());
            stm.setString(8, m.getOutOfDate());
            stm.setString(9, m.getImage());
            stm.setInt(10, m.getQuantityInStock());
            stm.setString(11, m.getNote());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        }
    }

    //insert many medicine
    public void insertManyMedicine(List<Medicine> list) {
        for (Medicine medicine : list) {
            insertMedicine(medicine);
        }
    }

    public List<Integer> getListMedicineIdInsertedNearest(int count) {
        List<Integer> list = new ArrayList<Integer>();
        String sql = "select top (?) MedicineId from Medicine order by MedicineId desc";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, count);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Medicine getMedicineById(int medicineId) {
        try {
            String sql = "select MedicineId, MedicineName, t.TypeName, b.BoxName, Unit, Price, ManufactureDate, OutOfDate, m.image, m.QuantityInStock, m.Note\n"
                    + "from Medicine m inner join TypeOfMedicine t on m.TypeId = t.TypeId\n"
                    + "				inner join MedicalBox b on m.BoxId = b.BoxId\n"
                    + "				where m.MedicineId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, medicineId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt(1), rs.getString(2),
                        new TypeMedicine(rs.getString(3)), new MedicalBox(rs.getString(4)), rs.getString(5), rs.getInt(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getInt(10), rs.getString(11));

                return medicine;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Medicine getMedicineByIdAdmin(int medicineId) {
        try {
            String sql = "select MedicineId, MedicineName,t.TypeId, t.TypeName,b.BoxId, b.BoxName, Unit,InputPrice, Price, ManufactureDate, OutOfDate, m.image, m.QuantityInStock, m.Note\n"
                    + "from Medicine m inner join TypeOfMedicine t on m.TypeId = t.TypeId\n"
                    + "				inner join MedicalBox b on m.BoxId = b.BoxId\n"
                    + "				where m.MedicineId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, medicineId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt(1), rs.getString(2),
                        new TypeMedicine(rs.getInt(3), rs.getString(4)), new MedicalBox(rs.getInt(5), rs.getString(6)),
                        rs.getString(7), rs.getInt(8), rs.getInt(9),
                        rs.getString(10), rs.getString(11), rs.getString(12),
                        rs.getInt(13), rs.getString(14));

                return medicine;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteMedicine(Integer m) {
        String sql = "DELETE FROM [Medicine]\n"
                + "      WHERE MedicineId = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, m);

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void main(String[] args) {
        MedicineDB medicine = new MedicineDB();
        //System.out.println(medicine.);
        List<Medicine> list = new MedicineDB().pagingMedicine(2);
        for (Medicine m : list) {
            System.out.println(m);
        }
    }

    public List<Medicine> searchByMedicineName(String txtSearch) {
        List<Medicine> list = new ArrayList<>();
        String sql = "select m.MedicineId, m.MedicineName, b.BoxName, m.Price, m.image\n"
                + "from Medicine m inner join MedicalBox b on m.BoxId = b.BoxId\n"
                + "where m.MedicineName like ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt(1), rs.getString(2), new MedicalBox(rs.getString(3)), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
