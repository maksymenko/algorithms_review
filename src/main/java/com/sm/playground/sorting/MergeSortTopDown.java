package com.sm.playground.sorting;


public class MergeSortTopDown {
  private char[] aux;
  public String sort(String src) {
    if (src == null || src.length() < 2) {
      return src;
    }
    aux = new char[src.length()];
    char[] seq = src.toCharArray();
    int start  = 0;
    int end =  seq.length - 1;
    sort(seq, start, end);

    return new String(seq);
  }

  private void sort(char[] seq, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    sort(seq, start, mid);
    sort(seq, mid + 1, end);
    merge(seq, start, mid, end);
  }

  private void merge (char[] seq, int start, int mid, int end) {
    int first = start;
    int second = mid + 1;
    int auxInd = 0;

    while (first <= mid && second <= end) {
      if (seq[first] < seq[second]) {
        aux[auxInd] = seq[first];
        first++;
      } else {
        aux[auxInd] = seq[second];
        second++;
      }
      auxInd++;
    }

    while(first <= mid) {
      aux[auxInd++] = seq[first++];
    }

    while(second <= end) {
      aux[auxInd++] = seq[second++];
    }

    System.arraycopy(aux, 0, seq, start, (end - start +1));
  }

  public static void main(String[] args) {
    MergeSortTopDown mergeSorter = new MergeSortTopDown();

    System.out.println(mergeSorter.sort("sdnjcir"));

  }
}
