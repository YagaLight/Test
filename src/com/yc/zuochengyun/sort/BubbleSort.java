package com.yc.zuochengyun.sort;

public class BubbleSort {

    public void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
