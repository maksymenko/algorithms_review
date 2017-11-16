package com.sm.algorithms.sort;

public class MergeSortBottomUp {

  public String sort(String str) {
    char[] arr = str.toCharArray();
    char[] aux = new char[arr.length];

    for(int len = 2; len <= arr.length; len *= 2) {
      for(int start = 0; start <= arr.length - len; start+= len) {
        int end = start + len - 1;
        if (end >= arr.length) {
          end = arr.length - 1;
        }
        int mid = start + (end - start) /2;
        merge(arr, start, mid, end, aux);
      }
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
