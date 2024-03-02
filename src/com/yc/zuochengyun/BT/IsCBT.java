package com.yc.zuochengyun.BT;

import java.util.LinkedList;

public class IsCBT {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT1(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //是否遇到过左右两个孩子不双全的结点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((leaf && (l != null && r != null)) || l == null && r != null){
                return false;
            }
            if(l!= null){
                queue.add(l);
            }
            if(r!= null){
                queue.add(r);
            }
            if(l == null && r == null){
                leaf = true;
            }
        }
        return true;
    }


}
