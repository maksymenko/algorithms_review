package com.sm.algorithms.sort;

/**
 * stable, n Lg(n)
 */
public class MergeSortBottomUp {

  public String sort(String str) {
    char[] arr = str.toCharArray();
    char[] aux = new char[arr.length];

    int step = 1;
    while(step < arr.length) {
      int start = 0;
      while(start + step < arr.length) {
        int mid = start + step - 1;
        int end = start + 2 * step - 1;
        merge(arr, start, mid, Math.min(end, arr.length -1), aux);
        start += 2*step;
      }
      step *= 2;
    }
    return new String(arr);
  }

  private void merge(char[] arr, int start, int mid, int end, char[] aux) {
    int auxIndex = 0;
    int firstIndex = start;
    int secondIndex = mid +1;
    while(firstIndex <= mid && secondIndex <= end) {
      if (arr[firstIndex] < arr[secondIndex]) {
        aux[auxIndex++] = arr[firstIndex++];
      } else {
        aux[auxIndex++] = arr[secondIndex++];
      }
    }
    while(firstIndex <= mid) {
      aux[auxIndex++] = arr[firstIndex++];
    }
    while(secondIndex <= end) {
      aux[auxIndex++] = arr[secondIndex++];
    }
    auxIndex = 0;
    for(int i = start; i <= end; i++) {
      arr[i] = aux[auxIndex++];
    }
  }
}
