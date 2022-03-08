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
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class MedicineDB extends DBContext {

    public List<Medicine> getAllMedicine() {
        List<Medicine> list = new ArrayList<>();
        try {
            String sql = "select * from Medicine";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7),
                        rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

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

    //phan trang
    public List<Medicine> pagingMedicine(int index) {
        List<Medicine> list = new ArrayList<>();
        String sql = "select * from Medicine\n"
                + "Order by MedicineId\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 10);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7),
                        rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        MedicineDB medicine = new MedicineDB();
        List<Medicine> list = medicine.pagingMedicine(2);
        for (Medicine o : list) {
            System.out.println(o);
        }
    }
}
