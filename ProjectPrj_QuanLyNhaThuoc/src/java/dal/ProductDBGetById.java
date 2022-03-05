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
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class ProductDBGetById extends DBContext{

    public Medicine getMedicineById(int medicineId) {
        try {
            String sql = "select * from Medicine WHERE medicineId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, medicineId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine(rs.getInt(1), rs.getString(2), 
                        rs.getInt(3), rs.getInt(4), rs.getInt(5), 
                        rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), 
                        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
                
                return medicine;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getTypeNameByTypeId(int typeId) {
        try {
            String sql = "select TypeName from TypeOfMedicine where TypeId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, typeId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getDistributorNameByDistributorId(int DistributorId) {
        try {
            String sql = "select DistributorName from Distributor where DistributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, DistributorId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public static void main(String[] args) {
        System.out.println(new ProductDBGetById().getDistributorNameByDistributorId(1));
    }

}
