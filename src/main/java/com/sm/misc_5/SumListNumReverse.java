package com.sm.misc_5;

import com.sm.algorithms.tree.Node;

import java.util.Stack;

public class SumListNumReverse {
    private static Node sumNumsWihStack(Node n1, Node n2) {
        Stack<Integer> s1 = toStack(n1);
        Stack<Integer> s2 = toStack(n2);
        int rest = 0;
        Node res  = null;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            rest += s1.isEmpty() ? 0 : s1.pop();
            rest += s2.isEmpty() ? 0 : s2.pop();
            Node node = new Node(rest % 10);
            if (res == null) {
                res = node;
            } else {
                node.next = res;
                res = node;
            }
            rest /= 10;
        }
        if (rest > 0) {
            Node node = new Node(1);
            node.next = res;
            res = node;
        }

        return res;
    }

    private  static Stack toStack(Node n) {
        Stack<Integer> s = new Stack<>();

        while(n != null) {
            s.push(n.getValue());
            n = n.next;
        }

        return s;
    }

    /////////////////

    private static Node sumNums(Node n1, Node n2) {
        int size1 = getSize(n1);
        int size2 = getSize(n2);

        if (size1 > size2) {
            n2 = addNodes(n2, size1 - size2);
        } else {
            n1 = addNodes(n1, size2 - size1);
        }

        Node res = new Node(-1);
        if(recSum(res, n1, n2) == 1) {
            Node node = new Node(1);
            node.next = res;
            res = node;
        }

        return res;
    }

    private static int recSum(Node res, Node n1, Node n2) {
        int sum = n1.getValue() + n2.getValue();
        if (n1.next == null && n2.next == null) {
            res.setValue(sum % 10);
            return sum / 10;
        }
        res.next = new Node(-1);
        sum += recSum(res.next, n1.next, n2.next);
        res.setValue(sum % 10);

        return sum / 10;
    }

    private static Node addNodes(Node n1, int cnt) {
        for(int i = 0; i < cnt; i++) {
            Node n = new Node(0);
            n.next = n1;
            n1 = n;
        }
        return n1;
    }

    private static int getSize(Node n) {
        int cnt = 0;
        while(n != null) {
            cnt++;
            n = n.getNext();
        }
        return cnt;
    }


    public static void main(String[] args) {
        Node n1 = new Node(9);
        n1.addNext(4).addNext(1); // 941

        Node n2 = new Node(6);
        n2.addNext(3); // 63

        Node sum = sumNums(n2, n1);
        while(sum != null) {
            System.out.print(" > " + sum.getValue());
            sum = sum.getNext();
        }
        System.out.println();


        sum = sumNumsWihStack(n2, n1);
        while(sum != null) {
            System.out.print(" > " + sum.getValue());
            sum = sum.getNext();
        }
        System.out.println();
    }
}
