package com.yc.javase_du.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReflectTest05 {

    public static void main(String[] args) throws IOException {
//        String path = Thread.currentThread().getContextClassLoader().getResource("com.yc.javase_du/classinfo.properties").getPath();
//        System.out.println(path);

        /**
         * 方法一：读文件的方式
         */

        String path = Thread.currentThread().getContextClassLoader().getResource("javase_du/classinfo.properties").getPath();
        FileReader fileReader = new FileReader(path);
        Properties pt1 = new Properties();
        pt1.load(fileReader);
        fileReader.close();

        String className1 = pt1.getProperty("className");
        System.out.println(className1);


        /**
         * 以流的方式读取
         */
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream("javase_du/classinfo.properties");
        Properties pt2 = new Properties();
        pt2.load(reader);
        reader.close();
        String className2 = pt2.getProperty("className");
        System.out.println(className2);
    }

}
