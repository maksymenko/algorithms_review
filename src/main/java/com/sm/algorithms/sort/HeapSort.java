package com.sm.algorithms.sort;

import java.util.Arrays;

public class HeapSort {
  public int[] sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return arr;
    }

    int last = arr.length - 1;
    // Build heap.
    for (int i = last / 2; i >= 0; i--) {
      sink(arr, i, last);
    }

    // Sort.
    while(last > 0) {
      exchange(arr, last, 0);
      last--;
      sink(arr, 0, last);
    }

    return arr;
  }

  private void sink(int[] arr, int i, int last) {
    int cursor = i;
    while (cursor <= last / 2) {
      int left = cursor * 2 + 1;
      int right = cursor * 2 + 2;
      int largest = cursor;
      if (left <= last && arr[left] > arr[cursor]) {
        largest = left;
      }
      if (right <= last && arr[right] > arr[largest]) {
        largest = right;
      }
      if (largest != cursor) {
        exchange(arr, cursor, largest);
        cursor = largest;
      } else {
        break;
      }
    }
  }

  private void exchange(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    HeapSort heapSort = new HeapSort();

    System.out.println(">>> starting ...");

    System.out.println(">> " + Arrays.toString(heapSort.sort(new int[]{2, 7, 6, 15, 10, 4, 5, 1, 3, 8})));
  }
}
