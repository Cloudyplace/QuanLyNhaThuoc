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
import model.Role;
import model.Account;

/**
 *
 * @author cloudy_place
 */
public class AccountDBContext extends DBContext {

    public Account getAccount(String username, String password) {
        try {
            String sql = "select username, password from Account WHERE username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Account getUser(String username, String password) {
        try {
            String sql = "SELECT [AccId]"
                    + "      ,[FullName]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,r.roleId\n"
                    + "      ,r.RoleName\n"
                    + "  FROM [Account] a inner join RoleAccount r on a.RoleId = r.RoleId where Username=? and Password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6), rs.getString(7)));
                return account;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //update profile
    public void updateAccount(Account a) {
        String sql = "UPDATE [Account]\n"
                + "SET [FullName] = ?,\n"
                + "[Address] = ?,\n"
                + "[Email] = ?,\n"
                + "[Phone] = ?\n"
                + "where Username=? and Password=?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);

            stm.setString(5, a.getUsername());
            stm.setString(6, a.getPassword());
            stm.setString(1, a.getFullName());
            stm.setString(2, a.getAddress());
            stm.setString(3, a.getEmail());
            stm.setString(4, a.getPhone());

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

    public List<Role> getListAllRole() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from RoleAccount\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1), rs.getString(2)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Account> getListAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT [AccId]\n"
                + ",[FullName]\n"
                + ", r.roleId\n"
                + ",r.RoleName\n"
                + "FROM [Account] a inner join RoleAccount r on a.RoleId = r.RoleId";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), new Role(rs.getInt(3), rs.getString(4))));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        List<Role> list = new AccountDBContext().getListAllRole();
        for (Role role : list) {
            System.out.println(role);
        }
    }

    public void updateRoleOfAccount(Account account) {
        String sql = "UPDATE [Account]\n"
                + "   SET [RoleId] = ?\n"
                + " WHERE AccId = ?";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            
            stm.setInt(1, account.getRole().getRoleId());
            stm.setInt(2, account.getAccountID());

            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
