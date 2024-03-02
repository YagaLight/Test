package com.yc.javase_du.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReflectTest03 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/com.yc.javase_du/classinfo.properties");
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();

        String className = pro.getProperty("className");
//        System.out.println(className);

        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
