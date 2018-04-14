在Mediator模式中，
不同子对象之间的**交互行为**被统一放在Mediator的对象中，
对象通过Mediator对象同其他对象交互，
Mediator对象起着控制器的作用。


角色：
Mediator：          中介者父类
concreteMediator：  具体中介者类
Colleague：         关联类抽象父类
concreteMediator：  关联类具体子类

中介保留人的信息
人保留中介的引用