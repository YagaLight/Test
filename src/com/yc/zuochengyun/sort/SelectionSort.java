package com.yc.zuochengyun.sort;

public class SelectionSort {

    public void selectionSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i ;
            for(int j = i + 1;j<arr.length;j++){
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr,minIndex ,i);
        }
    }

    private void swap(int[] arr, int minIndex, int i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }


}
