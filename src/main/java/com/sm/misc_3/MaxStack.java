package com.sm.misc_3;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxStack {
    private LinkedList<Node> stack = new LinkedList<>();
    private PriorityQueue<Node> pq = new PriorityQueue<>((x1, x2) -> Integer.compare(x1.value, x2.value) * (-1));

    private class Node {
        int value;
        boolean isActive;
        Node(int value) {
            this.value = value;
            this.isActive = true;
        }
    }

    public MaxStack() {

    }

    public void push(int x) {
        Node node = new Node(x);
        stack.addFirst(node);
        pq.add(node);

    }

    public int pop() {
        while(!stack.isEmpty()) {
            Node node = stack.removeFirst();
            if(node.isActive) {
                node.isActive = false;
                return node.value;
            }
        }
        return -1;
    }

    public int top() {
        while(!stack.isEmpty()) {
            Node node = stack.removeFirst();
            if (node.isActive) {
                stack.addFirst(node);
                return node.value;
            }
        }
        return -1;
    }

    public int peekMax() {
        while(!pq.isEmpty()) {
            Node node = pq.peek();
            if (node.isActive == false) {
                pq.poll();
            } else {
                return node.value;
            }
        }
        return -1;
    }

    public int popMax() {
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (node.isActive) {
                node.isActive = false;
                return node.value;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MaxStack  maxStack = new MaxStack();

        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        System.out.println(">>> top:  " + maxStack.top());
        System.out.println(">>> popMax:  " + maxStack.popMax());
        System.out.println(">>> top:  " + maxStack.top());
        System.out.println(">>> peekMax:  " + maxStack.peekMax());
        System.out.println(">>> pop:  " + maxStack.pop());
        System.out.println(">>> top:  " + maxStack.top());
    }
}
