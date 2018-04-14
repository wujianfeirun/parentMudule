package com.main.Reflect;

public class BaseClass_01 {
    private String name;
    private String password;

    public static void main(String[] args) throws Exception {
        BaseClass_01 testBaseClass = new BaseClass_01();
        System.out.println(testBaseClass.getClass().getName());
        // 结果 net.xsoftlab.baike.TestReflect
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}