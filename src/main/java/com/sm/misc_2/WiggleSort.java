package com.sm.misc_2;

import java.util.Arrays;

public class WiggleSort {
  int partition(int[] arr, int start, int end, int kth) {
    System.out.println(">>> start: " + Arrays.toString(arr) + "    start: " + start + "  end: " + end);
    int pivot = arr[start];
    int startInd = start + 1;
    int endInd  = end;

    while(startInd < endInd) {
      while(startInd < endInd && arr[startInd] <= pivot) {
        startInd++;
      }
      while(startInd < endInd  && arr[endInd] > pivot) {
        endInd--;
      }

      if (startInd < endInd) {
        swap(arr, startInd, endInd);
        startInd++;
        endInd--;
      }
    }

    swap(arr, endInd, start);

    System.out.println(">>> end: " + Arrays.toString(arr));


    return endInd;

  }

  private void swap(int[] arr, int first, int second) {
    int tmp = arr[first];
    arr[first] = arr[second];
    arr[second] = tmp;
  }

  public static void main(String[] args) {
    WiggleSort wiggleSort = new WiggleSort();
//    System.out.println(">>>> " + wiggleSort.partition(new int[]{1, 1, 6, 1, 5, 4}, 0, 5, 4));
    System.out.println(">>>> " + wiggleSort.partition(new int[]{6, 5}, 0, 1, 4));

  }
}
