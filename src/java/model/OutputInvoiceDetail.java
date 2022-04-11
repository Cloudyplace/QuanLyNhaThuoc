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
public class OutputInvoiceDetail {

    private int outDetailId;
    private OutputInvoice outputInvoice;
    private Medicine medicine;
    private int quantity;

    public OutputInvoiceDetail() {
    }
    
    

    public OutputInvoiceDetail(int outDetailId, OutputInvoice outputInvoice, Medicine medicine, int quantity) {
        this.outDetailId = outDetailId;
        this.outputInvoice = outputInvoice;
        this.medicine = medicine;
        this.quantity = quantity;
    }

    public OutputInvoiceDetail(int quantity) {
        this.quantity = quantity;
    }

    public int getOutDetailId() {
        return outDetailId;
    }

    public void setOutDetailId(int outDetailId) {
        this.outDetailId = outDetailId;
    }

    public OutputInvoice getOutputInvoice() {
        return outputInvoice;
    }

    public void setOutputInvoice(OutputInvoice outputInvoice) {
        this.outputInvoice = outputInvoice;
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
        return "OutputInvoiceDetail{" + "outDetailId=" + outDetailId + ", outputInvoice=" + outputInvoice + ", medicine=" + medicine + ", quantity=" + quantity + '}';
    }

}
