package com.main.jmx.JMX101_SpringAutomaticMBean;

import com.main.jmx.JMX100_SpringJmx.IJmxTestBean;
import org.springframework.jmx.export.annotation.*;

@ManagedResource(
        objectName = "bean:name=testBean4",
        description = "My Managed Bean",
        log = true,
        logFile = "jmx.log",
        currencyTimeLimit = 15,
        persistPolicy = "OnUpdate",
        persistPeriod = 200,
        persistLocation = "foo",
        persistName = "bar")
public class AnnotationTestBean implements IJmxTestBean {

    private String name;
    private int age;

    @ManagedAttribute(description = "The Age Attribute", currencyTimeLimit = 15)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManagedAttribute(defaultValue = "foo", persistPeriod = 300)
    public String getName() {
        return name;
    }

    @ManagedAttribute(description = "The Name Attribute",
            currencyTimeLimit = 20,
            defaultValue = "bar",
            persistPolicy = "OnUpdate")
    public void setName(String name) {
        this.name = name;
    }

    @ManagedOperation(description = "Add two numbers")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "x", description = "The first number"),
            @ManagedOperationParameter(name = "y", description = "The second number")})
    public int add(int x, int y) {
        return x + y;
    }

    public void dontExposeMe() {
        throw new RuntimeException();
    }

}