package com.yc.javase_du.reflect;

public class ReflectTest04 {

    public static void main(String[] args) {
        try {
            Class.forName("com.yc.javase_du.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

class MyClass{
    static {
        System.out.println("MyClass类的静态代码块执行了！");
    }

}

