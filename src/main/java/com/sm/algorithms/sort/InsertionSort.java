package com.sm.algorithms.sort;

/**
 * iterative, stable , n^2
 */
public class InsertionSort {

  public String sort(String str) {
    char[] chars = str.toCharArray();
    for(int i = 1; i < chars.length; i++) {
      char ch = chars[i];
      int j = i;
      while(j > 0 && ch < chars[j - 1]) {
        chars[j] = chars[j-1];
        j--;
      }
      chars[j] = ch;
    }
    return new String(chars);
  }
}
