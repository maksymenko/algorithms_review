package com.sm.playground.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Pq {
    private List<Integer> pq = new ArrayList<>();

    public void add(int n) {
        System.out.println(">>> added: " + n);
        pq.add(n);
        reheapUp();
    }

    public int peek() {
        if (pq.isEmpty()) {
            throw new NoSuchElementException();
        }
        return pq.get(0);
    }

    public int poll() {
        if (pq.isEmpty()) {
            throw new NoSuchElementException();
        }
        int res = pq.get(0);
        pq.set(0, pq.get(pq.size() - 1));
        reheapDown();
        pq.remove(pq.size() - 1);
        return res;
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    private void reheapDown() {
        int parent = 0;
        int maxInd = 0;
        do {
            parent = maxInd;
            maxInd = reheap(parent);
        } while (maxInd != parent);
    }

    private void reheapUp() {
        if (pq.size() < 2) {
            return;
        }
        int parent = (pq.size() - 2) / 2;

        while (parent >= 0) {
            reheap(parent);
            parent--;
        }
    }

    private int reheap(int parent) {
        int maxInd = parent;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        if (left < pq.size() && pq.get(maxInd) < pq.get(left)) {
            maxInd = left;
        }
        if (right < pq.size() && pq.get(maxInd) < pq.get(right)) {
            maxInd = right;
        }
        if (maxInd != parent) {
            int tmp = pq.get(maxInd);
            pq.set(maxInd, pq.get(parent));
            pq.set(parent, tmp);
        }
        return maxInd;
    }

    public static void main(String[] args) {
        Pq pq = new Pq();

        pq.add(3);
        System.out.println(">> peek: " + pq.peek());
        pq.add(2);
        System.out.println(">> peek: " + pq.peek());
        pq.add(5);
        System.out.println(">> peek: " + pq.peek());
        pq.add(3);
        System.out.println(">> peek: " + pq.peek());
        pq.add(7);
        System.out.println(">> peek: " + pq.peek());
        pq.add(9);
        System.out.println(">> peek: " + pq.peek());
        pq.add(4);
        System.out.println(">> peek: " + pq.peek());
        pq.add(1);
        System.out.println(">> peek: " + pq.peek());

        while (!pq.isEmpty()) {
            System.out.print(" " + pq.poll());
        }
        System.out.println();
    }

}
