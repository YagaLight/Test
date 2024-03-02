package com.yc.javase_du.reflect;

public class ReflectTest02 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("com.yc.javase_du.reflect.User");
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
