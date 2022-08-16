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
public class MedicalBox {

    private int boxId;
    private String boxName;
    private String note;

    public MedicalBox() {
    }

    public MedicalBox(String boxName) {
        this.boxName = boxName;
    }

    public MedicalBox(int boxId) {
        this.boxId = boxId;
    }

    public MedicalBox(int boxId, String boxName) {
        this.boxId = boxId;
        this.boxName = boxName;
    }
    
    
    
    

    public MedicalBox(int boxId, String boxName, String note) {
        this.boxId = boxId;
        this.boxName = boxName;
        this.note = note;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MedicalBox{" + "boxId=" + boxId + ", boxName=" + boxName + ", note=" + note + '}';
    }
    
    
}
