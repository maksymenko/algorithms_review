package com.sm.misc_1.sorting;

import java.util.Arrays;

public class HeapSort {

  public int[] sort(int[] arr) {
    construct(arr);
    intSort(arr);
    return arr;
  }

  private void intSort(int[] arr) {
    int size = arr.length - 1;
    while (size > 0) {
      exch(arr, 0, size);
      sink(arr, size - 1, 0);
      size--;
    }
  }

  private void construct(int[] arr) {
    int size = arr.length;
    for (int i = size / 2; i >= 0; i--) {
      sink(arr, size, i);
    }
  }

  private int[] sink(int[] arr, int size, int cur) {
    while (cur < size / 2) {
      int leftInd = cur * 2 + 1;
      int rightInd = leftInd + 1;
      int biggestInd = cur;
      if (leftInd < size && arr[biggestInd] < arr[leftInd]) {
        biggestInd = leftInd;
      }
      if (rightInd < size && arr[biggestInd] < arr[rightInd]) {
        biggestInd = rightInd;
      }
      if (biggestInd == cur) {
        break;
      }
      exch(arr, cur, biggestInd);
      cur = biggestInd;
    }

    return arr;
  }

  private void exch(int[] arr, int first, int second) {
    int tmp = arr[first];
    arr[first] = arr[second];
    arr[second] = tmp;
  }

  public static void main(String[] args) {
    System.out.println(">>> Heapsort start");
    HeapSort heapSort = new HeapSort();
    System.out.println(">>> " + Arrays.toString(
        heapSort.sort(new int[]{5, 6, 10, 12, 2, 11, 3})
    ));
    System.out.println(">>> end");
  }
}
