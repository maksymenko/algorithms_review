package com.sm.misc_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindEditDataStructure {
    private Map<String, Node> keyToNode = new HashMap<>();
    private Node first;
    private Node last;

    private class Node {
        int value;
        Set<String> keys = new HashSet<>();
        Node next;
        Node prev;
    }

    public void inc(String key) {
        Node node = keyToNode.get(key);
        if (node == null && first != null && first.value == 1) {
            first.keys.add(key);
            keyToNode.put(key, first);
        } else if (node == null && first == null) {
            first = new Node();
            first.value = 1;
            first.keys.add(key);
            keyToNode.put(key, first);
            last = first;
        } else if (node == null && first != null && first.value != 1) {
            Node newNode = new Node();
            newNode.value = 1;
            newNode.keys.add(key);

            Node tmp = first;
            first = newNode;
            newNode.next = tmp;

            keyToNode.put(key, first);
        } else {
            int newValue = node.value + 1;
            node.keys.remove(key);
            if (node.next != null) {
                if (node.next.value == newValue) {
                    node.next.keys.add(key);
                    keyToNode.put(key, node.next);
                } else {
                    Node newNode = new Node();
                    newNode.value = newValue;
                    newNode.keys.add(key);

                    Node tmp = node.next;
                    node.next = newNode;
                    newNode.next = tmp;
                    newNode.prev = node;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(">>>> starting...");
    }
}
