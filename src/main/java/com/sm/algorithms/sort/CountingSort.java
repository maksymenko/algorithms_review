package com.sm.algorithms.sort;

import java.util.Arrays;

public class CountingSort {
  /**
   * Expects array of chars , possible values are 'a'  ... 'a' + radix
   *
   * @param arr
   * @param radix
   * @return
   */
  public char[] sort(char[] arr, int radix) {
    int count[] = new int[radix];
    char[] aux = new char[arr.length];

    for (char ch : arr) {
      int index = ch - 'a';
      if (index >= radix) {
        return arr;
      }
      count[index]++;
    }

    int index = 0;
    for (int i = 0; i < radix; i++) {
      int tmp = count[i];
      count[i] = index;
      index += tmp;
    }

    for (char ch : arr) {
      int curCharIndex = count[ch - 'a'];
      aux[curCharIndex] = ch;
      count[ch - 'a']++;
    }

    return aux;
  }

  public static void main(String[] args) {
    CountingSort countingSort = new CountingSort();
    System.out.println(Arrays.toString(countingSort.sort(new char[]{'b', 'c', 'b', 'c', 'a', 'c', 'a', 'b'}, 3)));
  }
}
