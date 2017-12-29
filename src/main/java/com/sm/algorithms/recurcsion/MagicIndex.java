package com.sm.algorithms.recurcsion;

import java.util.Arrays;

public class MagicIndex {
  public int find(int[] arr) {
    System.out.println("arr: " + Arrays.toString(arr));
    if (arr == null || arr.length < 1) {
      return -1;
    }

    return find(0, arr.length - 1, arr);
  }

  private int find(int start, int end, int[] arr) {
    if (start > end) {
      return -1;
    }

    int index = (start + end) / 2;
    if (arr[index] == index) {
      return index;
    } else if (arr[index] > index) {
      return find(start, index - 1, arr);
    } else {
      return find(index + 1, end, arr);
    }
  }

  public static void main(String[] args) {
    MagicIndex magicIndex = new MagicIndex();
    System.out.println(magicIndex.find(new int[]{-1, 0, 1, 3, 17, 68}));
  }
}
