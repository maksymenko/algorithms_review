package com.sm.misc_3;

import java.util.Arrays;

public class QuickSort1 {

  public String sort(String str) {
    char[] seq = str.toCharArray();

    partition(seq, 0, seq.length - 1);

    return new String(seq);
  }

  private void partition(char[] arr, int start, int end) {
    int pivot = start;
    int startCursor = start + 1;
    int endCursor = end;

    if (start >= end) {
      return;
    }

    while (startCursor <= endCursor) {
      while (startCursor <= end && arr[startCursor] <= arr[pivot]) {
        startCursor++;
      }

      while (endCursor > start && arr[endCursor] > arr[pivot]) {
        endCursor--;
      }

      if (startCursor < endCursor) {
        swap(arr, startCursor, endCursor);
        startCursor++;
        endCursor--;
      }
    }

    swap(arr, pivot, endCursor);

    partition(arr, start, endCursor - 1);
    partition(arr, endCursor + 1, end);

  }

  private void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }


  public static void main(String[] args) {
    QuickSort1 quickSort1 = new QuickSort1();
    System.out.println(">>> " + quickSort1.sort("87396753429"));
    System.out.println(">>> " + quickSort1.sort("8739675429"));
  }

}
