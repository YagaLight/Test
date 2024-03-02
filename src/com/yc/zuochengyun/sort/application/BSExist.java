package com.yc.zuochengyun.sort.application;

/**
 * 二分查找(有序)
 */
public class BSExist {

    public static boolean exist(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length<1){
            return  false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;
        while(L<R){
            mid = L + ((R-L) >>1);
            if(sortedArr[mid] == num){
                return true;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            }else{
                R = mid -1;
            }
        }

        return sortedArr[L] == num;
    }
}
