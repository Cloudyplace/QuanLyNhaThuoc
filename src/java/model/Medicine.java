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
public class Medicine {
    private int medicineId;
    private String medicineName;
    private int typeId;
    private int boxId;
    private int distributorId;
    private String unit;
    private int inputPrice;
    private int price;
    private String manufactureDate;
    private String outOfDate;
    private String image;
    private int quantityInStock;
    private String note;

    public Medicine() {
    }

    public Medicine(int medicineId, String medicineName, int typeId, int boxId, int distributor, String unit, int inputPrice, int price, String manufactureDate, String outOfDate, String image, int quantityInStock, String note) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.typeId = typeId;
        this.boxId = boxId;
        this.distributorId = distributor;
        this.unit = unit;
        this.inputPrice = inputPrice;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.outOfDate = outOfDate;
        this.image = image;
        this.quantityInStock = quantityInStock;
        this.note = note;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(int inputPrice) {
        this.inputPrice = inputPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getOutOfDate() {
        return outOfDate;
    }

    public void setOutOfDate(String outOfDate) {
        this.outOfDate = outOfDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Medicine{" + "medicineId=" + medicineId + ", medicineName=" + medicineName + ", typeId=" + typeId + ", boxId=" + boxId + ", distributor=" + distributorId + ", unit=" + unit + ", inputPrice=" + inputPrice + ", price=" + price + ", manufactureDate=" + manufactureDate + ", outOfDate=" + outOfDate + ", image=" + image + ", quantityInStock=" + quantityInStock + ", note=" + note + '}';
    }

    
    
    
    
    
}
