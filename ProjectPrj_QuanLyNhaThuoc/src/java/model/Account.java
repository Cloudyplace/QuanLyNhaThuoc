/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author cloudy_place
 */
public class Account {
    private int accountID;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private Role role;

    public Account() {
    }

    public Account(int accountID) {
        this.accountID = accountID;
    }

    public Account(String fullName) {
        this.fullName = fullName;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int accountID, String fullName, Role role) {
        this.accountID = accountID;
        this.fullName = fullName;
        this.role = role;
    }

    public Account(int accountID, Role role) {
        this.accountID = accountID;
        this.role = role;
    }

    
    
    public Account(int accountID, String username, String password, String fullName, String address, String email, String phone, Role role) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public Account(int accountId ,String fullName, String address, String email, String phone, Role role) {
        this.accountID = accountId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
    

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", username=" + username + ", password=" + password + ", fullName=" + fullName + ", address=" + address + ", email=" + email + ", phone=" + phone + ", role=" + role + '}';
    }

    

    
    
    
}
