package com.main.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * getFields 包括父类与接口的属性   getDeclaredFields 本类中声明的属性
 */
public class GetClass_02 {
    public static void main(String[] args) throws Exception {
        // getClazz();
        //getInstance();
        getField();


    }

    public static void getClazz() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // To get Class
        class1 = Class.forName("net.xsoftlab.baike.TestReflect");
        class2 = new BaseClass_01().getClass();
        class3 = BaseClass_01.class;
        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());

        //get superClass， get interfaces
        System.out.println("父类名称   " + class1.getSuperclass());
        System.out.println("实现名称   " + class1.getInterfaces()[0]);
    }

    public static void getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        Class<?> class1 = null;
        class1 = Class.forName("com.main.Reflect.BaseClass_01");
        // 第一种方法，实例化默认构造方法，调用set赋值
        BaseClass_01 user = (BaseClass_01) class1.newInstance();
        user.setPassword("123");
        user.setName("Rollen");
        System.out.println(user);
        // 结果 User [age=20, name=Rollen]


        // 第二种方法 取得全部的构造函数 使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }
        // 结果
        // cons[0] (java.lang.String)
        // cons[1] (int,java.lang.String)
        // cons[2] ()
        user = (BaseClass_01) cons[0].newInstance("Rollen");
        System.out.println(user);
        // 结果 User [age=0, name=Rollen]
        user = (BaseClass_01) cons[1].newInstance(20, "Rollen");
        System.out.println(user);
        // 结果 User [age=20, name=Rollen]
    }

    public static void getField() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.main.Reflect.BaseClass_01");
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    public static void getMethods() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.main.Reflect.BaseClass_01");
        //Method类包含了   参数，返回值的类型，异常类型
        Method method[] = clazz.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}

