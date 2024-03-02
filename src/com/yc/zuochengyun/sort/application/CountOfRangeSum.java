package com.yc.zuochengyun.sort.application;

public class CountOfRangeSum {
    public static int countRangeSum(int[]arr,int lower,int upper){
        if(arr == null || arr.length == 0){
            return 0;
        }
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for(int i = 1;i < arr.length;i++){
            sum[i] = sum[i-1] + arr[i];
        }

        return process(sum,0,arr.length-1,lower,upper);
    }

    public  static int process(long[]sum,int L,int R,int lower,int upper){
        if(L==R){
            return sum[L] >= lower && sum[L] < upper ? 1 : 0;
        }

        int M = L + ((R-L)>>1);

        return process(sum,L,M,lower,upper) + process(sum,M+1,R,lower,upper) + merge(sum,L,M,R,lower,upper);
    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper){
        int res = 0;
        int windowL = L;
        int windowR = L;
        //[windowL,windowR)
        for(int i = M + 1;i <= R;i++){
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while(windowR <= M && arr[windowR] <= max){
                windowR++;
            }

            while(windowL <= M && arr[windowL] <= min){
                windowL++;
            }
            res += windowR - windowL;
        }
        long[] help = new long[R-L+1];
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        while(p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }

        while(p1 <= M){
            help[i++] = arr[p1++];
        }

        while(p2 <= R){
            help[i++] = arr[p2++];
        }

        for(i=0;i<help.length;i++){
            arr[L+i] = help[i];
        }

        return res;


    }
}
