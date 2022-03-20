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
public class OutputInvoice {
    private int outInvoiceId;
    private Account account;
    private String customerName;
    private String customerPhone;
    private String saleDate;
    private String totalMoney;
    private String Note;

    public OutputInvoice() {
    }

    public OutputInvoice(int outInvoiceId, Account account, String customerName, String customerPhone, String saleDate, String totalMoney, String Note) {
        this.outInvoiceId = outInvoiceId;
        this.account = account;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.saleDate = saleDate;
        this.totalMoney = totalMoney;
        this.Note = Note;
    }

    public int getOutInvoiceId() {
        return outInvoiceId;
    }

    public void setOutInvoiceId(int outInvoiceId) {
        this.outInvoiceId = outInvoiceId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "OutputInvoice{" + "outInvoiceId=" + outInvoiceId + ", account=" + account + ", customerName=" + customerName + ", customerPhone=" + customerPhone + ", saleDate=" + saleDate + ", totalMoney=" + totalMoney + ", Note=" + Note + '}';
    }

    
    
}
