package com.sm.playground.sorting;

public class QuickSort {
  public String sort(String src) {
    if (src == null || src.length() < 2 ) {
      return src;
    }
    char[] seq = src.toCharArray();

    partition(seq, 0, src.length() - 1);

    return new String(seq);
  }

  // 2 7 3 6 4 9      start=1  end=5
  // pivot: [1]=7
  // i = [2]
  // j = [5]
  private void partition(char[] seq, int start, int end) {
    int i = start + 1;
    int j = end;

    if (start >= end) {
      return;
    }

    while(i <= j) {
      while (i <= j && seq[i] <= seq[start]) {
        i++;
      }

      while (j >= i && seq[j] > seq[start]) {
        j--;
      }
      if (i < j) {
        swap(seq, i, j);
      } else {
        swap(seq, j, start);
      }
    }

    partition(seq, start, j);
    partition(seq, j+1, end);

  }

  private void swap(char[] seq, int j, int start) {
    char tmp = seq[j];
    seq[j] = seq[start];
    seq[start] = tmp;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    System.out.println(quickSort.sort("273649"));

  }
}
