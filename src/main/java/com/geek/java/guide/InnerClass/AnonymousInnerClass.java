package com.geek.java.guide.InnerClass;

/**
 * 匿名内部类
 * 定义：匿名内部类就是没有名字的内部类。
 * 问题：什么情况下需要使用匿名内部类？
 * 答案：1. 只用到类的一个实例。
 *       2. 类在定义后马上用到。
 *       3. 类非常小（SUN推荐是在4行代码以下）
 *       4. 给类命名并不会导致你的代码更容易被理解。
 * 在使用匿名内部类时，要记住以下几个原则：
 *       1. 匿名内部类不能有构造方法。
 *       2. 匿名内部类不能定义任何静态成员、方法和类。
 *       3. 匿名内部类不能是public,protected,private,static。
 *       4. 只能创建匿名内部类的一个实例。
 *       5. 一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。
 *       6. 因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。
 * @author: Geek Wang
 * @createDate: 2019/1/22 10:31
 * @version: 1.0
 */
public class AnonymousInnerClass {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination dest(final String name, String city) {
        return new Destination(name, city) {
            private String label = name;
            @Override
            public String getName() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        AnonymousInnerClass p = new AnonymousInnerClass();
        Destination d = p.dest("Tanzania", "gz");
    }

    abstract class Destination {
        Destination(String name, String city) {
            System.out.println(city);
        }

        abstract String getName();
    }
}
