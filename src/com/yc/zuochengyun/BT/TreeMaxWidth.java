package com.yc.zuochengyun.BT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最大宽度
 */
public class TreeMaxWidth {
    public static class Node {
        int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curLevel + 1);
                queue.add(cur.left);
            }

            if (cur.right != null) {
                levelMap.put(cur.right, curLevel + 1);
                queue.add(cur.right);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWithNoMap(Node head) {
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                nextEnd = cur.left;
                queue.add(cur.left);
            }

            if(cur.right != null){
                nextEnd = cur.right;
                queue.add(cur.right);
            }
            curLevelNodes++;
            if(cur == curEnd){
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
