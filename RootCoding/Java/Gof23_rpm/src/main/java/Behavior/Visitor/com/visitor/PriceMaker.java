package Behavior.Visitor.com.visitor;

import Behavior.Visitor.com.element.MedicineA;
import Behavior.Visitor.com.element.MedicineB;

public class PriceMaker extends Visitor{
  
    public void visit(MedicineA a) {
        System.out.println("划价员：" + name +"给药" + a.getName() +"划价:" + a.getPrice());  
    }  
  
    public void visit(MedicineB b) {
        System.out.println("划价员：" + name +"给药" + b.getName() +"划价:" + b.getPrice());  
    }  
      
} 