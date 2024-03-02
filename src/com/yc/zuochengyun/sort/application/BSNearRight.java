package com.yc.zuochengyun.sort.application;

public class BSNearRight {
    public static int nearestIndex(int[] arr, int value){
        if(arr == null || arr.length<1){
            return -1;
        }
        int L = 0;
        int R = arr.length-1;
        int index = -1;
        while(L<=R){
            int mid = L + ((R-L)<<1);
            if(arr[mid]<=value){
                index = mid;
                L = mid+1;
            }else{
                R = mid - 1;
            }
        }
        return index;
    }
}
