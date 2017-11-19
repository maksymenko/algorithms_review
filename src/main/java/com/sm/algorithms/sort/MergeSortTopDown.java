package com.sm.algorithms.sort;

/**
 * recursive, stable, n Lg(n)
 */
public class MergeSortTopDown {
  public String sort(String str) {
    char[] arr = str.toCharArray();
    char[] aux = new char[arr.length];
    int end = arr.length;
    int start = 0;
    recSort(arr, start, end - 1, aux);

    return new String(arr);
  }

  private void recSort(char[] arr, int start, int end, char[] aux) {
    if (start < end) {
      int mid = start + (end - start)/2;
      recSort(arr, start, mid, aux);
      recSort(arr, mid + 1, end, aux);
      merge(arr, start, mid, end, aux);
    }
  }

  private void merge(char[] arr, int start, int mid, int end, char[] aux) {
    int firstCursor = start;
    int secondCursor = mid + 1;
    int auxCursor = 0;
    while(firstCursor <= mid && secondCursor <= end) {
      if (arr[firstCursor] < arr[secondCursor]) {
        aux[auxCursor++] = arr[firstCursor++];
      } else {
        aux[auxCursor++] = arr[secondCursor++];
      }
    }
    while(firstCursor <= mid) {
      aux[auxCursor++] = arr[firstCursor++];
    }
    while(secondCursor <= end) {
      aux[auxCursor++] = arr[secondCursor++];
    }
    auxCursor = 0;
    for(int i = start; i <= end; i++) {
      arr[i] = aux[auxCursor++];
    }
  }

  public static void main(String[] args) {
    MergeSortTopDown merge = new MergeSortTopDown();
    System.out.println(">>> " + merge.sort("asbcrtdsw"));
  }

}
