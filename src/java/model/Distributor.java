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
public class Distributor {
    private int distributorId;
    private String distributorName;
    private String address;
    private String email;
    private String phone;
    private String note;

    public Distributor() {
    }

    public Distributor(int distributorId, String distributorName, String address, String email, String phone, String note) {
        this.distributorId = distributorId;
        this.distributorName = distributorName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.note = note;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Distributor{" + "distributorId=" + distributorId + ", distributorName=" + distributorName + ", address=" + address + ", email=" + email + ", phone=" + phone + ", note=" + note + '}';
    }

   

    
   

}
