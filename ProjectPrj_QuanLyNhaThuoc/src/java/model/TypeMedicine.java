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
public class TypeMedicine {
    private int typeId;
    private String typeName;
    private String note;

    public TypeMedicine() {
    }

    public TypeMedicine(int typeId) {
        this.typeId = typeId;
    }

    public TypeMedicine(String typeName) {
        this.typeName = typeName;
    }

    public TypeMedicine(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
    
    
    
    
    
    public TypeMedicine(int typeId, String typeName, String note) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.note = note;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TypeMedicine{" + "typeId=" + typeId + ", typeName=" + typeName + ", note=" + note + '}';
    }

    
    
    
     
    
}
