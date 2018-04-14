package Behavior.Visitor.com.elementCollection;

import Behavior.Visitor.com.element.Medicine;
import Behavior.Visitor.com.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MedicineBill {
    List<Medicine> list = new ArrayList<Medicine>();
      
    public void accept(Visitor visitor){
        Iterator<Medicine> iterator = list.iterator();
          
        while (iterator.hasNext()) {  
            iterator.next().accept(visitor);  
        }  
    }  
      
    public void addMedicine(Medicine medicine){  
        list.add(medicine);  
    }  
      
    public void removeMedicien(Medicine medicine){  
        list.remove(medicine);  
    }  
}  