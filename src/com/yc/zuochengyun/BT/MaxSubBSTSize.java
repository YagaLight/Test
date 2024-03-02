package com.yc.zuochengyun.BT;

import java.util.ArrayList;

public class MaxSubBSTSize {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }


    public static int largestBSTSubtree(TreeNode head){
        if(head == null){
            return 0;
        }
        return process(head).maxBSTSubtreeSize;
    }


    public static class Info {
        public int maxBSTSubtreeSize;
        public int allSize;
        public int max;
        public int min;

        public Info(int m, int a, int ma, int mi) {
            maxBSTSubtreeSize = m;
            allSize = a;
            max = ma;
            min = mi;
        }
    }

    public static Info process(TreeNode x){
        if(x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        int allSize = 1;
        //更新最大值，最小值和大小
        if(leftInfo != null){
            max = Math.max(max,leftInfo.max);
            min = Math.min(min,leftInfo.min);
            allSize += leftInfo.allSize;
        }
        if(rightInfo != null){
            max = Math.max(max,rightInfo.max);
            min = Math.min(min,rightInfo.min);
            allSize += rightInfo.allSize;
        }
        //继承现有的最大二叉搜索树的节点数
        int p1 = -1;
        if(leftInfo != null){
            p1 = leftInfo.maxBSTSubtreeSize;
        }
        int p2 = -1;
        if (rightInfo != null){
            p2 = rightInfo.maxBSTSubtreeSize;
        }
        //判断是否为二叉搜索树
        int p3 = -1;
        boolean leftBST = leftInfo == null ? true : (leftInfo.maxBSTSubtreeSize == leftInfo.allSize);
        boolean rightBST = rightInfo == null ? true : (rightInfo.maxBSTSubtreeSize == rightInfo.allSize);
        //更新最新的二叉搜索树的节点数
        if(leftBST && rightBST){
            boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
            boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
            if(leftMaxLessX && rightMinMoreX){
                int leftSize = leftInfo == null ? 0:leftInfo.allSize;
                int rightSize = rightInfo == null ? 0:rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(p1,Math.max(p2,p3)),allSize,max,min);
    }

    public static TreeNode generateRandomBST(int maxLevel,int maxValue){
        return generate(1,maxLevel,maxValue);
    }

    public static TreeNode generate(int level,int maxLevel,int maxValue){
        if(level > maxLevel || Math.random() < 0.5){
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1,maxLevel, maxValue);
        head.right= generate(level + 1,maxLevel, maxValue);
        return head;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr){
        if(head == null){
            return;
        }
        in(head.left,arr);
        arr.add(head);
        in(head.right,arr);
    }

    public static int getBSTSize(TreeNode head){
        if(head == null){
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head,arr);
        for (int i = 1;i< arr.size();i++){
            if(arr.get(i).val <= arr.get(i-1).val){
                return 0;
            }
        }
        return arr.size();
    }

    public static int right(TreeNode head){
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if(h != 0){
            return h;
        }
        return Math.max(right(head.left),right(head.right));
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("=============测试开始============");
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel,maxValue);
            if(largestBSTSubtree(head) != right(head)){
                System.out.println("Ops");
            }
        }
        System.out.println("=========测试结束=========");
    }

}
