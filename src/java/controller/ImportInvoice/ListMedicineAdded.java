/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ImportInvoice;

import java.util.ArrayList;
import java.util.List;
import model.Medicine;

/**
 *
 * @author cloudy_place
 */
public class ListMedicineAdded {

    List<Medicine> list = new ArrayList<>();
    

    public List<Medicine> createNewList() {
        List<Medicine> list = new ArrayList<>();
        return list;
    }

    public List<Medicine> addMedicineToList(Medicine medicine) {
        list.add(medicine);
        return list;
    }

    public List<Medicine> removeList() {
        list.clear();
        return list;
    }
    
    public static void main(String[] args) {
//        ListMedicineAdded list = new ListMedicineAdded();
//        List<Medicine> listMedicine = list.createNewList();
//        listMedicine = list.addMedicineToList(new Medicine(1, "minh", "vi", 1000));
//        listMedicine = list.addMedicineToList(new Medicine(1, "hung ngu", "vi", 2000));
//        listMedicine = list.addMedicineToList(new Medicine(1, "minh dep trai", "hop", 3000));
//        
//        for (Medicine m : listMedicine) {
//            System.out.println(m);
//        }
//        
//        System.out.println("-----");
//        
//        listMedicine = list.removeList();
//        for (Medicine m : listMedicine) {
//            System.out.println(m);
//        }
//        System.out.println(listMedicine);
    }
    

}
