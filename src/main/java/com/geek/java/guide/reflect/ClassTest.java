package com.geek.java.guide.reflect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 基于JDK 1.8 讲解 Class API
 * @author: Geek Wang
 * @createDate: 2019/1/21 15:13
 * @version: 1.0
 */
public class ClassTest {

    static {
        System.out.println("static");
    }

    private static class Inner{

    }



    public static void main(String[] args) {

        String toString = ClassTest.class.toString();
        System.out.println("toString ======>>" + toString);

        String toGenericString = Iterator.class.toGenericString();
        System.out.println("toGenericString ======>>" + toGenericString);

        try {
            Class class_forName = Class.forName("com.geek.java.guide.reflect.ClassTest");
            System.out.println("forName =========>>" + class_forName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class class_forName = Class.forName("com.geek.java.guide.reflect.ClassTest",true,ClassLoader.getSystemClassLoader());
            System.out.println("forName =========>>" + class_forName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ClassTest classTest = ClassTest.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("isInstance =====>>" + LinkedList.class.isInstance(new ArrayList<>()));

        System.out.println("isAssignableFrom =======>>" + List.class.isAssignableFrom(LinkedList.class));

        new Inner ();
        try {
            System.out.println("isSynthetic =====>>" + Class.forName("com.geek.java.guide.reflect.ClassTest$1").isSynthetic());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("getName =====>>" + ClassTest.class.getName());

        System.out.println("getClassLoader =====>>" + ClassTest.class.getClassLoader().getResource(""));

        System.out.println("getTypeParameters ====>>" + List.class.getTypeParameters()[0].getTypeName());

        System.out.println("getSuperclass ====>>" + LinkedList.class.getSuperclass().toString());

        System.out.println("getGenericSuperclass ====>>" + LinkedList.class.getGenericSuperclass().toString());

        System.out.println("getPackage ====>>" + ClassTest.class.getPackage().toString());

        System.out.println("getInterfaces ====>>" + LinkedList.class.getInterfaces()[0].toString());

        System.out.println("getGenericInterfaces ====>>" + LinkedList.class.getGenericInterfaces()[0].toString());

        String[] str = new String[]{"123"};
        System.out.println("getComponentType ========>>" + str.getClass().getComponentType());

        System.out.println("getModifiers ========>>" + str.getClass().getModifiers());

        System.out.println("getSigners ========>>" + LinkedList.class.getSigners());

        System.out.println("getDeclaringClass ========>>" + LinkedList.class.getDeclaringClass());

        System.out.println("getSimpleName ========>>" + ClassTest.class.getSimpleName());

        System.out.println("getCanonicalName ========>>" + ClassTest.class.getCanonicalName());


    }
}
