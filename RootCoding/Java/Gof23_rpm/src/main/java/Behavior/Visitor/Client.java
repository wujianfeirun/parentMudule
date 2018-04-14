package Behavior.Visitor;

import Behavior.Visitor.com.element.Medicine;
import Behavior.Visitor.com.element.MedicineA;
import Behavior.Visitor.com.element.MedicineB;
import Behavior.Visitor.com.elementCollection.MedicineBill;
import Behavior.Visitor.com.visitor.MedicineSeller;
import Behavior.Visitor.com.visitor.PriceMaker;
import Behavior.Visitor.com.visitor.Visitor;

public class Client {
    public static void main(String[] args) {  
        Medicine a = new MedicineA("板蓝根", 11.0);
        Medicine b = new MedicineB("感康", 14.3);
          
        MedicineBill medicineBill = new MedicineBill();
        medicineBill.addMedicine(a);
        medicineBill.addMedicine(b);
          
        Visitor priceMaker = new PriceMaker();
        priceMaker.setName("张三");
          
        Visitor workerOfPharmacy = new MedicineSeller();
        workerOfPharmacy.setName("李四");  
          
        medicineBill.accept(priceMaker);
        System.out.println("-------------------------------------");  
        medicineBill.accept(workerOfPharmacy);
    }  
  
}