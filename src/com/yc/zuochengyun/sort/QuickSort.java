package com.yc.zuochengyun.sort;

public class QuickSort {


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int partition(int[] arr,int L ,int R){
        if(L>R){
            return -1;
        }

        if(L==R){
            return L;
        }

        int lessEqual = L-1;
        int index = L;
        while(lessEqual < R ){
            if(arr[index] <= arr[R]){
                swap(arr,++lessEqual, index++);
            }else{
                index++;
            }
        }
        swap(arr,++lessEqual,R);
        return lessEqual;
    }

    public static int[] netherlandsFlag(int[] arr,int L,int R){
        if(L > R){
            return new int[]{-1,-1};
        }

        if(L==R){
            return new int[]{L,R};
        }

        int less = L-1;
        int more = R;
        int index = L;
        while(less < more){
            if(arr[index] < arr[R]){
                swap(arr,++less,index++);
            }else if(arr[index] == arr[R]){
                index++;
            }else{
                swap(arr,--more,index);
            }
        }
        swap(arr,more,index);
        return new int[]{less+1,more};
    }


    /**
     * 快排1.0版本
     * @param arr
     */
    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length-1);
    }

    public static void process1(int[] arr,int L,int R){
        if(L>=R){
            return;
        }
        int M = partition(arr,L,R);
        process1(arr,L,M);
        process1(arr,M+1,R);
    }


    /**
     * 快排2.0版本
     */
    public static void quickSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process2(arr,0,arr.length-1);
    }

    public static void process2(int[] arr,int L,int R){
        if(L>=R){
            return;
        }
        int[] equalArea = netherlandsFlag(arr,L,R);
        process1(arr,L,equalArea[0]-1);
        process1(arr,equalArea[1]+1,R);
    }

    /**
     * 快排3.0版本
     */
    public static void quickSort3(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process3(arr,0,arr.length-1);
    }

    public static void process3(int[] arr,int L,int R){
        if(L>=R){
            return;
        }
        swap(arr,L+(int)(Math.random()*(R-L+1)),R);
        int[] equalArea = netherlandsFlag(arr,L,R);
        process3(arr,L,equalArea[0]-1);
        process3(arr,equalArea[1]+1,R);
    }


}
