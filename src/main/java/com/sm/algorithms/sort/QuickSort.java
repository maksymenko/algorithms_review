package com.sm.algorithms.sort;

import java.util.Random;

/**
 * recursive, unstable, n Lg(n)
 */
public class QuickSort {
  public String sort(String str) {
    char[] arr = str.toCharArray();

    shuffle(arr);
    sortRec(arr, 0, arr.length - 1);

    return new String(arr);
  }

  private void shuffle(char[] arr) {
    Random rnd = new Random(System.currentTimeMillis());

    for(int i = 0; i < arr.length; i++) {
      int index = rnd.nextInt(arr.length);
      swap(arr, i, index);
    }
  }

  private void sortRec(char[] arr, int start, int end) {
    if (start < end) {
      int pivotIndex = partition(arr, start, end);
      sortRec(arr, start, pivotIndex - 1);
      sortRec(arr, pivotIndex + 1, end);
    }
  }

  private int partition(char[] arr, int start, int end) {
    char pivot = arr[start];
    int leftCursor = start + 1;
    int rightCursor = end;
    while(leftCursor <= rightCursor) {
      while (leftCursor <= end && arr[leftCursor] <= pivot) {
        leftCursor++;
      }
      while (rightCursor > start && arr[rightCursor] > pivot) {
        rightCursor--;
      }

      if (leftCursor < rightCursor) {
        swap(arr, leftCursor, rightCursor);
        leftCursor++;
        rightCursor--;
      }
    }
    swap(arr, start, rightCursor);
    return rightCursor;
  }

  private void swap(char[] arr, int first, int second) {
    char tmp = arr[first];
    arr[first] = arr[second];
    arr[second] = tmp;
  }

  public static void main(String[] args) {
    QuickSort quickSort1 = new QuickSort();
    System.out.println(">>>> quick sort");
    System.out.println(">>> " + quickSort1.sort("8739675429"));
  }
}
