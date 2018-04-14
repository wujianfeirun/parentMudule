通过一种对客户端**透明**的方式来***扩展对象的功能***，是继承关系的一个替换方案。
给产品动态的添加功能。


角色：
父接口： 装饰类和被装饰类的父接口；                                 Car
被装饰角色： 具有最基本的功能，实现父接口                           RunCar
装饰抽象角色： 抽象类，实现父接口    CarDecorator
具体装饰角色：具有扩展功能，继承装饰抽象角色，组合父接口              FlyCarDecorator   SwimCarDecorator


Car car = new RunCar();
car = new FlyCarDecorator(car);
car = new SwimCarDecorator(car);
car.show();


与继承的区别是： 装饰的功能可层层叠加，灵活组合。
继承的话只能写死子类具有哪些功能，而不能将功能灵活组合。

