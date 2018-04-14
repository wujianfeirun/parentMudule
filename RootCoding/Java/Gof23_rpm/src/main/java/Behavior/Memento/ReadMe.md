在备忘录模式中：
Memento模式也叫备忘录模式，是行为模式之一，它的作用是保存对象的内部状态，
并在需要的时候（undo/rollback）恢复对象以前的状态。




角色：
Originator： 需要保存状态的对象， 持有createMemento()  和recover() 方法。
Memento：    保存状态的外部对象。
Caretaker：  用来管理备份的内容，  持有Memento，需要的时候返回Memento来回复状态。

