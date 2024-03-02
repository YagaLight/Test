package com.yc.zuochengyun.sort.application;

/**
 * 无序数组找局部最小值
 */

public class BSAwesome {
    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }

        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }

        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }

        int L = 1;
        int R = arr.length-2;
        int Mid = 0;
        while(L < R){
            Mid = (L + R)/2; //测试L+(R-L)/2
            if(arr[Mid] > arr[Mid-1]){
                R = Mid - 1;
            }else if(arr[Mid] > arr[Mid + 1]){
                L = Mid + 1;
            }else{
                return Mid;
            }
        }

        return L;
    }
}
