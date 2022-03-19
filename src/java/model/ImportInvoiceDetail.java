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
    private ImportInvoice importInvoice;
    private Medicine medicine;
    private int quantity;

    public ImportInvoiceDetail() {
    }

    public ImportInvoiceDetail(int imInvoiceDetailId, ImportInvoice importInvoice, Medicine medicine, int quantity) {
        this.imInvoiceDetailId = imInvoiceDetailId;
        this.importInvoice = importInvoice;
        this.medicine = medicine;
        this.quantity = quantity;
    }

    public int getImInvoiceDetailId() {
        return imInvoiceDetailId;
    }

    public void setImInvoiceDetailId(int imInvoiceDetailId) {
        this.imInvoiceDetailId = imInvoiceDetailId;
    }

    public ImportInvoice getImportInvoice() {
        return importInvoice;
    }

    public void setImportInvoice(ImportInvoice importInvoice) {
        this.importInvoice = importInvoice;
    }

    public ImportInvoiceDetail(ImportInvoice importInvoice, Medicine medicine, int quantity) {
        this.importInvoice = importInvoice;
        this.medicine = medicine;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "ImportInvoiceDetail{" + "imInvoiceDetailId=" + imInvoiceDetailId + ", importInvoice=" + importInvoice + ", medicine=" + medicine + ", quantity=" + quantity + '}';
    }

   
    

    
    

    
    
    
}
