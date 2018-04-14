用于创建多个与原型完全一样的对象。 
 
Cloneable只是标记接口，没有任何接口方法，给虚拟机提示对象可以克隆
 
浅度克隆：  只需实现Cloneable接口，return super.clone();就可以实现
   

深度克隆:  除了super.clone()之外，还需要把对象手动添加或者也clone一下。
