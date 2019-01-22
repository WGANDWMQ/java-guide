package com.geek.java.guide.reflect;

/**
 * @author: wanggang
 * @createDate: 2019/1/18 14:52
 * @version: 1.0
 */
public class Person {

    private String name;

    private int age;

    public int sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
