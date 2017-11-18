package com.sm.algorithms.sort;

/**
 * unstable, n Lg(n)
 */
//TODO: add shuffle
public class QuickSort {
  public String sort(String str) {
    char[] arr = str.toCharArray();

    sort(arr, 0, arr.length - 1);

    return new String(arr);
  }

  private void sort(char[] arr, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    char pivot = arr[startIndex];
    int leftCursor = startIndex + 1;
    int rightCursor = endIndex;
    while (leftCursor <= rightCursor) {
      while (leftCursor <= endIndex && arr[leftCursor] <= pivot) {
        leftCursor++;
      }

      while (rightCursor >= startIndex && arr[rightCursor] > pivot) {
        rightCursor--;
      }

      if (leftCursor < rightCursor) {
        char tmp = arr[leftCursor];
        arr[leftCursor] = arr[rightCursor];
        arr[rightCursor] = tmp;
        leftCursor++;
        rightCursor--;
      }
    }
    arr[startIndex] = arr[rightCursor];
    arr[rightCursor] = pivot;
    sort(arr, startIndex, rightCursor - 1);
    sort(arr, rightCursor + 1, endIndex);
  }

}
