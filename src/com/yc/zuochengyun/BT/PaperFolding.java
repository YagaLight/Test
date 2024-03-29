package com.yc.zuochengyun.BT;


public class PaperFolding {
    public static void printAllFolds(int N){
        process(1,N,true);
        System.out.println();
    }

    public static void process(int i, int N,boolean down){
        if(i > N){
            return;
        }
        process(i+1,N,true);
        System.out.println(down?"凹":"凸");
        process(i+1,N,false);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
