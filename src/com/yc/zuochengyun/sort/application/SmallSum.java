package com.yc.zuochengyun.sort.application;

/**
 * 最小和问题
 */
public class SmallSum {
    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }

        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if(L == R){
            return 0;
        }

        int M = L + ((R-L)>>1);

        return process(arr,L,M-1) + process(arr,M+1,R) + merge(arr, L ,M, R);
    }

    public static int merge(int[] arr,int L,int M,int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = M+1;
        int res = 0;
        int i = 0;
        while(p1<=M && p2<=R){
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 +1):0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }

        while(p1<=M){
            help[i++] = arr[p1++];
        }

        while(p2<=R){
            help[i++] = arr[p2++];
        }

        for(i=0;i<help.length;i++){
            arr[L+i] = help[i];
        }
        return res;
    }
}
