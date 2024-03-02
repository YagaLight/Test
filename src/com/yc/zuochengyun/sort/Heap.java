package com.yc.zuochengyun.sort;

public class Heap {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public boolean isFull(){
            return heapSize == limit;
        }

        public void push(int value){
            if(heapSize == limit){
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        public void pop(){
            int ans = heap[0];
            swap(heap,0,--heapSize);
            //
        }

        private void heapInsert(int[] arr,int index){
            while(arr[index] > arr[(index - 1) / 2]){
                swap(arr,index,(index - 1)/2 );
                index = (index - 1) / 2;
            }
        }

        private void heapify(int[] arr,int index, int heapSize){
            int left = 2 * index + 1;
            while(left < heapSize){
                int largest = left + 1 <  heapSize && arr[left] > arr[left + 1] ? left : left + 1;
                largest = arr[left] > arr[largest] ? left : largest;
                if(largest == index){
                    break;
                }
                swap(arr,index,largest);
                index = largest;
                left = 2 * index + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
