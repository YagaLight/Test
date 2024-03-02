package com.yc.applica;

/**
 * 快速幂
 */
public class BinExp {

    //计算a^n
    public static long BinExp(int a,int n){

        long res = 1;
        while(n != 0){
            int b = n & 1;
            if( b != 0){
                res = a * res;
            }
            n /= 2;
            a = a * a;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 6;
        int n = 12;
        System.out.println(BinExp(a,n));
    }
}
