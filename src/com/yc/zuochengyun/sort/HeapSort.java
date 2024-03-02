package com.yc.zuochengyun.sort;

public class HeapSort {


    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && arr[left] > arr[left + 1]  ? left :left +1;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = 2 * index + 1;
        }
    }


    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
