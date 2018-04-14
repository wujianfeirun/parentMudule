package Behavior.Visitor.com.visitor;

import Behavior.Visitor.com.element.MedicineA;
import Behavior.Visitor.com.element.MedicineB;

public class MedicineSeller extends Visitor{
  
    public void visit(MedicineA a) {
        System.out.println("药房工作者：" + name + "拿药 ：" + a.getName());  
    }  
  
    public void visit(MedicineB b) {
        System.out.println("药房工作者：" + name + "拿药 ：" + b.getName());  
    }  
      
}  