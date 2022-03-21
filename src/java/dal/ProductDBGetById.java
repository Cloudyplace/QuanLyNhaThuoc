/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Distributor;
import model.MedicalBox;
import model.Medicine;
import model.TypeMedicine;

/**
 *
 * @author cloudy_place
 */
public class ProductDBGetById extends DBContext {

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
                        new TypeMedicine(rs.getString(3)), new MedicalBox(rs.getString(4)),rs.getString(5), rs.getInt(6),
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
                        new TypeMedicine(rs.getInt(3),rs.getString(4)), new MedicalBox(rs.getInt(5), rs.getString(6)),
                         rs.getString(7), rs.getInt(8),rs.getInt(9),
                        rs.getString(10), rs.getString(11), rs.getString(12),
                        rs.getInt(13), rs.getString(14));

                return medicine;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


//    public String getDistributorNameByDistributorId(int DistributorId) {
//        try {
//            String sql = "select DistributorName from Distributor where DistributorId = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, DistributorId);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                return rs.getString(1);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public static void main(String[] args) {
        System.out.println(new ProductDBGetById().getMedicineByIdAdmin(3));
    }

}
