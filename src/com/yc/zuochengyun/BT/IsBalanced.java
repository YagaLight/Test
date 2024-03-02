package com.yc.zuochengyun.BT;

public class IsBalanced {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value=value;
        }

    }

    public static boolean isBalanced1(Node head){
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head,ans);
        return ans[0];
    }

    public static int process1(Node head,boolean[] ans){
        if(!ans[0] || head == null){
            return -1;
        }
        int leftHeight = process1(head.left,ans);
        int rightHeight = process1(head.right,ans);
        if(Math.abs(leftHeight - rightHeight) > 1){
            ans[0] = false;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced2(Node head){
        return process2(head).isBalanced;
    }

    private static Info process2(Node head) {
        if (head == null){
            return new Info(true,0);
        }
        Info leftInfo = process2(head.left);
        Info rightInfo = process2(head.right);

        int height =  Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isBalanced = true;
        if (!leftInfo.isBalanced){
            isBalanced = false;
        }
        if (!rightInfo.isBalanced){
            isBalanced = false;
        }
        if(Math.abs(leftInfo.height - rightInfo.height) > 1){
            isBalanced = false;
        }
        return new Info(isBalanced,height);
    }


}
