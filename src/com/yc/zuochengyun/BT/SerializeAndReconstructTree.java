package com.yc.zuochengyun.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndReconstructTree {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head){
        Queue<String> queue = new LinkedList<>();
        pres(head,queue);
        return queue;
    }

    public static void pres(Node head,Queue<String>queue){
        if(head == null){
            queue.add(null);
        }else{
            queue.add(String.valueOf(head.value));
            pres(head.left,queue);
            pres(head.right,queue);
        }
    }

    public static Queue<String> inSerial(Node head){
        Queue<String> queue = new LinkedList<>();
        inS(head,queue);
        return queue;
    }

    public static void inS(Node head,Queue<String>queue){
        if(head == null){
            queue.add(null);
        }else{
            inS(head.left,queue);
            queue.add(String.valueOf(head.value));
            inS(head.right,queue);
        }
    }

    public static Queue<String> posSerial(Node head){
        Queue<String> queue = new LinkedList<>();
        posS(head,queue);
        return queue;
    }

    public static void posS(Node head,Queue<String>queue){
        if(head == null){
            queue.add(null);
        }else{
            posS(head.left,queue);
            posS(head.right,queue);
            queue.add(String.valueOf(head.value));
        }
    }

    public static Node buildByPreQueue(Queue<String> prelist){
        if(prelist == null || prelist.size()==0){
            return null;
        }
        return preb(prelist);
    }


    public static Node preb(Queue<String> prelist){
        String value = prelist.poll();
        if(value == null){
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    public static Node buildByPosQueue(Queue<String> poslist){
        if(poslist == null || poslist.size() == 0){
            return null;
        }
        Stack<String> stack = new Stack<>();
        while(!poslist.isEmpty()){
            stack.push(poslist.poll());
        }
        return posb(stack);
    }

    public static Node posb(Stack<String> posstack){
        String value = posstack.pop();
        if(value == null){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.right = posb(posstack);
        head.left = posb(posstack);
        return head;
    }


    public static Queue<String> levelSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        if(head == null){
            ans.add(null);
        }else{
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while(!queue.isEmpty()){
                head = queue.poll();
                if(head.left!=null){
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                }else{
                    ans.add(null);
                }

                if(head.right!=null){
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                }else{
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList){
        if(levelList == null || levelList.size() == 0){
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node>queue = new LinkedList<>();
        if(head != null){
            queue.add(head);
        }
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }

        }
        return head;

    }

    public static Node generateNode(String val){
        if(val == null){
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static Node generateRandomBST(int maxLevel,int maxValue){
        return generate(1,maxLevel,maxValue);
    }

    public static Node generate(int level,int maxLevel,int maxValue){
        if(level > maxLevel || Math.random() < 0.5){
            return  null;
        }
        Node head = new Node((int)(Math.random() * maxValue));
        head.left = generate(level + 1 , maxLevel,maxValue);
        head.right = generate(level + 1 , maxLevel,maxValue);
        return head;
    }


    public static boolean isSameValueStructure(Node head1,Node head2){
        if(head1 == null && head2 != null){
            return false;
        }
        if(head2 == null && head1 != null){
            return false;
        }
        if(head1 == null && head2 == null){
            return true;
        }
        if(head1.value != head2.value){
            return false;
        }
        return isSameValueStructure(head1.left,head2.left) && isSameValueStructure(head1.right,head2.right);
    }



    public static void main(String[] args){
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("===========test begin==============");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel,maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> pos = posSerial(head);
            Queue<String> level = levelSerial(head);
            Node preBuild = buildByPreQueue(pre);
            Node posBuild = buildByPosQueue(pos);
            Node levelBuild = buildByLevelQueue(level);
            if(!isSameValueStructure(preBuild,posBuild) || !isSameValueStructure(posBuild,levelBuild)){
                System.out.println("Oops!");
            }
        }
        System.out.println("==========test finish!===================");
    }

}
