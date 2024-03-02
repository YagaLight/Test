package com.yc.zuochengyun.sort.application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QuickSortRecursiveAndUnrecursive {
    /**
     * 荷兰国旗问题( <= 和  > )
     */

    public static int netherlandsFlag1_0(int[] arr,int L,int R){
        if(L>R){
            return -1;
        }
        int less = L-1;
        int index = L;
        while(index < R){
            if(arr[index]<=arr[R]){
                swap(arr,++less,index++);
            }else{
                index++;
            }
        }
        swap(arr,less+1,R);
        return less+1;
    }

    /**
     * 荷兰国旗问题( < ,=,  > )
     */

    public static int[] netherlandsFlag2_0(int[] arr,int L,int R){
        if(L > R){
            return new int[]{-1,-1};
        }
        if(L==R){
            return new int[]{L,R};
        }


        int less = L-1;
        int index = L;
        int more = R;
        while(index < more){
            if(arr[index] < arr[R]){
                swap(arr,++less,index++);
            }else if(arr[index] == arr[R]){
                index++;
            }else{
                swap(arr,--more,index);
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }

    // 快排递归版本
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag2_0(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }


    /**
     * 快排非递归版本
     */

    /**
     * 快排非递归版本需要的辅助类
     */
    public static class Op{
        public int l; //左边界
        public int r;//右边界

        public Op(int left,int right){
            l = left;
            r = right;
        }
    }


    //快排3.0非递归版本，用栈实现
    public static void quickSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        swap(arr,(int)(Math.random() * N),N-1);
        int[] equalArea = netherlandsFlag2_0(arr,0,N-1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0,el-1));
        stack.push(new Op(er+1,N-1));
        while(!stack.isEmpty()){
            Op op = stack.pop();
            if(op.l < op.r){
                swap(arr,op.l + (int)(Math.random()*(op.r - op.l + 1)),op.r);
                equalArea = netherlandsFlag2_0(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el-1));
                stack.push(new Op(er+1,op.r));
            }
        }
    }

    //快排3.0非递归版本，用队列实现
    public static void quickSort3(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        swap(arr,(int)(Math.random() * N),N-1);
        int[] equalArea = netherlandsFlag2_0(arr,0,N-1);
        int el = equalArea[0];
        int er = equalArea[1];
        Queue<Op> queue = new LinkedList<>();
        queue.offer(new Op(0,el-1));
        queue.offer(new Op(er+1,N-1));
        while(!queue.isEmpty()){
            Op op = queue.poll();
            if(op.l< op.r){
                swap(arr,op.l + (int)(Math.random() * (op.r - op.l + 1)),op.r);
                equalArea = netherlandsFlag2_0(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                queue.offer(new Op(op.l, el-1));
                queue.offer(new Op(er+1,op.r));
            }
        }
    }


}
