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
public class ImportInvoice {
    private int imInvoiceId;
    private Distributor distributor;
    private String imDate;
    private String totalMoney;
    private String note;

    public ImportInvoice() {
    }

    public ImportInvoice(int imInvoiceId, String imDate , String totalMoney , String note) {
        this.imInvoiceId = imInvoiceId;
        this.imDate = imDate;
        this.totalMoney = totalMoney;
        this.note = note;
    }

    public ImportInvoice(Distributor distributor, String imDate, String totalMoney, String note) {
        this.distributor = distributor;
        this.imDate = imDate;
        this.totalMoney = totalMoney;
        this.note = note;
    }
    
    

    public ImportInvoice(int imInvoiceId) {
        this.imInvoiceId = imInvoiceId;
    }
    
    
    
    

    public ImportInvoice(int imInvoiceId, Distributor distributor, String imDate, String totalMoney, String note) {
        this.imInvoiceId = imInvoiceId;
        this.distributor = distributor;
        this.imDate = imDate;
        this.totalMoney = totalMoney;
        this.note = note;
    }

    public int getImInvoiceId() {
        return imInvoiceId;
    }

    public void setImInvoiceId(int imInvoiceId) {
        this.imInvoiceId = imInvoiceId;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public String getImDate() {
        return imDate;
    }

    public void setImDate(String imDate) {
        this.imDate = imDate;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ImportInvoice{" + "imInvoiceId=" + imInvoiceId + ", distributor=" + distributor + ", imDate=" + imDate + ", totalMoney=" + totalMoney + ", note=" + note + '}';
    }

    
    
   
    
    
    
}
