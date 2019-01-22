package com.geek.java.guide.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 以JDK 1.8为基础
 * @author: wanggang
 * @createDate: 2019/1/18 15:40
 * @version: 1.0
 */
public class Student extends Person {

    private String StudentId;

    public String role;

    protected String work;

    String job;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IntrospectionException, ClassNotFoundException, NoSuchFieldException {

        /**
         * 获取Class对象的方式1
         */
        Class student_forName = Class.forName("com.geek.java.guide.reflect.Student");

        /**
         * 获取Class对象的方式2
         */
        Class student_class = Student.class;

        /**
         * 获取Class对象的方式3
         */
        Student student = new Student();
        Class student_getClass = student.getClass();

        /**
         * 一个类在 JVM 中只会有一个 Class 实例
         */
        System.out.println("student_forName 与 student_class 比较：" + student_forName.equals(student_class) + "\nperson_class 与 person_getClass 比较：" + student_getClass.equals(student_getClass));

        /**
         * 获得类的完整名字。
         */
        String class_name = student_getClass.getName();
        System.out.println("类的完整名字："+class_name);


        /**
         *  获得类的public类型的属性
         */
        Field field_sex = student_getClass.getField("sex");
        System.out.println("sex:" + field_sex.getName());

        /**
         * 获得类的public类型的所有属性
         */
        Field[] fields_pub = student_getClass.getFields();
        for(Field field : fields_pub){
            System.out.println("获得类的public类型的所有属性:" + field.getName());//age
        }

        /**
         * 获得类的所有属性。包括private 声明的
         */
        Field[] fields = student_getClass.getDeclaredFields();

        /**
         * 获取
         */
        Field name_super_class = student_getClass.getSuperclass().getDeclaredField("name");

        /**
         * 获得类的public类型的方法。这里包括 Object 类的一些方法
         */
        Method [] methods = student_class.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        //获得类的所有方法,包括私有方法
        Method [] allMethods = student_class.getDeclaredMethods();
        for(Method method : allMethods){
            System.out.println(method.getName());
        }

        for (Field field : fields) {
            String key = field.getName();
            field.setAccessible(true);
            PropertyDescriptor descriptor = new PropertyDescriptor(key, student_getClass);
            Method method = descriptor.getWriteMethod();
            method.invoke(student,"adf");

            System.out.println(student.getName());

        }
    }
}
