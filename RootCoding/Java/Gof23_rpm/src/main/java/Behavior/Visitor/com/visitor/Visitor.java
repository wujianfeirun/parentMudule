package Behavior.Visitor.com.visitor;

import Behavior.Visitor.com.element.MedicineA;
import Behavior.Visitor.com.element.MedicineB;

public abstract class Visitor {
    protected String name;  
  
    public void setName(String name) {  
        this.name = name;  
    }  
      
      
    public abstract void visit(MedicineA a);
      
    public abstract void visit(MedicineB b);
} 