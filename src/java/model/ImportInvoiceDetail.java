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
public class ImportInvoiceDetail {
    private int imInvoiceDetailId;
    private int importInvoiceId;
    private Medicine medicine;
    private int quantity;
    private int money;

    public ImportInvoiceDetail() {
    }

    public ImportInvoiceDetail(int imInvoiceDetailId, int importInvoiceId, Medicine medicine, int quantity, int money) {
        this.imInvoiceDetailId = imInvoiceDetailId;
        this.importInvoiceId = importInvoiceId;
        this.medicine = medicine;
        this.quantity = quantity;
        this.money = money;
    }

    public int getImInvoiceDetailId() {
        return imInvoiceDetailId;
    }

    public void setImInvoiceDetailId(int imInvoiceDetailId) {
        this.imInvoiceDetailId = imInvoiceDetailId;
    }

    public int getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(int importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ImportInvoiceDetail{" + "imInvoiceDetailId=" + imInvoiceDetailId + ", importInvoiceId=" + importInvoiceId + ", medicine=" + medicine + ", quantity=" + quantity + ", money=" + money + '}';
    }

    
    

    
    
    
}
