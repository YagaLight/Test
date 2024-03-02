package com.yc.javase_du.reflect;

public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("java.lang.String");
        Class c2 = Class.forName("java.util.Date");
        Class c3 = Class.forName("java.lang.Integer");
        Class c4 = Class.forName("java.lang.System");



        String s = "a";
        Class x = s.getClass();
        System.out.println(c1==x);


        Class z = String.class;
        System.out.println(c1==z);
    }
}
