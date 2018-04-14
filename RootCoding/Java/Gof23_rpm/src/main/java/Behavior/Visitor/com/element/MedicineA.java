package Behavior.Visitor.com.element;

import Behavior.Visitor.com.visitor.Visitor;

public class MedicineA extends Medicine{
  
    public MedicineA(String name, double price) {  
        super(name, price);  
    }  
  
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }  
}  