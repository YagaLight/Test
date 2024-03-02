package com.yc.lanqiaobei.chapt01;

import java.io.*;

public class MainTemplate{
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static double Double(){
        try {
            st.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st.nval;
    }

    public static String Line(){
        String s = "";
        try {
            s = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return s;
    }

    public static int Int(){
        try {
            st.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (int)st.nval;
    }

    public static long Long(){
        try {
            st.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (long)st.nval;
    }

    public static void main(String[] args) {

    }
}
