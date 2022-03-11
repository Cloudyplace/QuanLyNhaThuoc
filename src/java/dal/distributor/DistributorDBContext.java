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
    
    // get distributor by id
        public Distributor getDistributorById(int distributorId) {
        try {
            String sql = "select * from Distributor WHERE distributorId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, distributorId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Distributor distributor = new Distributor(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
                return distributor;
            }
        } catch (SQLException ex) {
            
        }
        return null;
    }

    public static void main(String[] args) {
        DistributorDBContext medicine = new DistributorDBContext();
        System.out.println(medicine.getDistributorById(2));
    }
}
