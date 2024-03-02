package com.yc.javase_du.reflect;

import java.util.ResourceBundle;

public class ReflectTest06 {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("javase_du/classinfo");
        String className = rb.getString("className");
        System.out.println(className);
    }
}
