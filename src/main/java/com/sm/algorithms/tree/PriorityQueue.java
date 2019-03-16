package com.sm.algorithms.tree;

import java.util.Arrays;

public class PriorityQueue {
  private int[] arr;
  private int size = 0;
  private int capacity = 0;

  public PriorityQueue(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
  }

  public boolean add(int x){
    System.out.println(">>> add  " + x);
    if (size >= capacity){
      return false;
    }
    arr[size++] = x;
    swim(size - 1);

    System.out.println(">>> " + Arrays.toString(arr));
    return true;
  }


  /**
   * Get top element and remove it from queue.
   */
  public Integer poll() {
    if (size <= 0){
      return null;
    }
    int top = arr[0];
    arr[0] = arr[--size];
    arr[size] = -1;

    sink(0);
    return top;
  }

  private void sink(int n) {
    while(n < size / 2) {
      int leftInd = getLeftInd(n);
      int rightInd = getRightInd(n);

      int biggestInd = n;

      if (leftInd < size) {
        biggestInd = comp(arr[biggestInd], arr[leftInd]) ? leftInd : biggestInd;
      }

      if (rightInd < size) {
        biggestInd = comp(arr[biggestInd], arr[rightInd]) ? rightInd : biggestInd;
      }

      if (biggestInd != n) {
        swap(biggestInd, n);
        n = biggestInd;
      } else {
        break;
      }
    }
  }

  private void swim(int n) {
    while(n > 0) {
      int parentInd = getParent(n);
      if (comp(arr[parentInd], arr[n])) {
        swap(parentInd, n);
        n = parentInd;
      } else {
        break;
      }
    }
  }

  private boolean comp(int a, int b) {
    return a < b;
  }

  private int getLeftInd(int n) {
    return (n + 1) * 2 - 1;
  }

  private int getRightInd(int n) {
    return (n + 1) * 2;
  }

  private void swap(int n1, int n2) {
    int tmp = arr[n1];
    arr[n1] = arr[n2];
    arr[n2] = tmp;
  }

  private int getParent(int n) {
    return (n - 1) / 2;
  }

  public static void main(String[] args) {
    PriorityQueue pq = new PriorityQueue(10);
    pq.add(6);
    pq.add(2);
    pq.add(9);
    pq.add(3);
    pq.add(6);
    pq.add(7);
    pq.add(1);
    pq.add(8);
    pq.add(11);
    pq.add(18);
    pq.add(3);

    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
    System.out.println(pq.poll());
  }
}
