package com.yc.zuochengyun.sort;

/**
 * 归并排序
 */
public class MergeSort {

    //递归
    public static void mergeSort1(int[] arr) {
        if(arr == null || arr.length<2){
            return;
        }

        process(arr,0,arr.length-1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L==R){
            return;
        }
        int mid = (R-L)>>1 + L;
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int Mid, int R) {
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = Mid +1;
        int i=0;
        while(p1<=Mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=Mid){
            help[i++] = arr[p1++];
        }
        while(p2<=R){
            help[i++] = arr[p2++];
        }

        for(i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }

    }

    //非递归版本
    public static void mergeSort2(int[] arr) {
        if(arr == null || arr.length<2){
            return;
        }
        int mergeSize = 1;
        int N = arr.length;
        while(mergeSize < N){
            int  L = 0;
            while(L < N){
                if(mergeSize >= N-L){
                    break;
                }
                 int Mid = L + mergeSize - 1;
                 int R = Mid + Math.min(mergeSize,N-Mid-1);
                 merge(arr,L,Mid,R);
                 L = R + 1;
            }
            //防止溢出
            if(L > N/2){
                break;
            }
            mergeSize <<= 1;
        }
    }
}
