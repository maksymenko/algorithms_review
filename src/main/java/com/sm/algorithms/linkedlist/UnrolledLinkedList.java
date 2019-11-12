package com.sm.algorithms.linkedlist;

public class UnrolledLinkedList {
    private static final int NODE_CAPACITY = 5;
    private int size = 0;
    private Node unRolledRoot = new Node();

    public void add(int value) {
        Node node = unRolledRoot;
        while(!node.add(value)){
            if (node.next == null) {
                node.next = new Node();
            }
            node = node.next;
        }
        size++;
    }

    public int get(int ind) {
        if (ind >= size) {
            throw new IndexOutOfBoundsException();
        }
        int nodeInd = ind / NODE_CAPACITY;
        int elementInd = ind % NODE_CAPACITY;

        Node node = unRolledRoot;
        for(int i = 0; i < nodeInd; i++) {
            if (node != null) {
                node = node.next;
            }
        }
        return node.arr[elementInd];
    }

    private static class Node {
        Node next;
        int ind = 0;
        private int arr[] = new int[NODE_CAPACITY];

        boolean add(int value) {
            if (ind == NODE_CAPACITY) {
                return false;
            }
            arr[ind++] = value;
            return true;
        }
    }

    public static void main(String[] args) {
        UnrolledLinkedList unrl = new UnrolledLinkedList();
        unrl.add(1);
        unrl.add(2);
        unrl.add(3);
        unrl.add(4);
        unrl.add(5);
        unrl.add(6);
        unrl.add(7);
        unrl.add(8);
        System.out.println(">>> unrl 0: " + unrl.get(0));
        System.out.println(">>> unrl 1: " + unrl.get(1));
        System.out.println(">>> unrl 2: " + unrl.get(2));
        System.out.println(">>> unrl 3: " + unrl.get(3));
        System.out.println(">>> unrl 4: " + unrl.get(4));
        System.out.println(">>> unrl 5: " + unrl.get(5));
        System.out.println(">>> unrl 6: " + unrl.get(6));
        System.out.println(">>> unrl 7: " + unrl.get(7));
    }
}
