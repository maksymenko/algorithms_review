package com.sm.playground.sorting;

public class InsertSort {

  public String sort(String str) {
    if (str == null || str.length() < 2) {
      return str;
    }
    char[] src = str.toCharArray();
    for(int i = 1; i < str.length(); i++) {
      char tmp = src[i];
      int j = i -1;
      while(j >=0 && src[j] > tmp) {
        src[j + 1] = src[j];
        j--;
      }
      j++;
      src[j] = tmp;
    }

    return new String(src);
  }

  public static void main(String[] args) {
    InsertSort insertSort = new InsertSort();
    System.out.println(">>>> " + insertSort.sort("sdfawe"));
  }
}
