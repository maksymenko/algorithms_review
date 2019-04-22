package com.sm.misc_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysManipulations {
  public int[] union(int[] arr1, int[] arr2) {
    if (arr1 == null && arr2 == null) {
      return null;
    }
    if (arr1 == null || arr2 == null) {
      return arr1 == null ? arr2 : arr1;
    }

    List<Integer> res = new ArrayList<>();
    int cursor1 = 0;
    int cursor2 = 0;
    while (cursor1 < arr1.length && cursor2 < arr2.length) {
      if (arr1[cursor1] < arr2[cursor2]) {
        if (res.size() == 0 || res.get(res.size() - 1) != arr1[cursor1]) {
          res.add(arr1[cursor1]);
        }
        cursor1++;
      } else {
        if (res.size() == 0 || res.get(res.size() - 1) != arr2[cursor2]) {
          res.add(arr2[cursor2]);
        }
        cursor2++;
      }
    }

    while (cursor1 < arr1.length) {
      if (res.size() == 0 || res.get(res.size() - 1) != arr1[cursor1]) {
        res.add(arr1[cursor1]);
      }
      cursor1++;
    }

    while (cursor2 < arr2.length) {
      if (res.size() == 0 || res.get(res.size() - 1) != arr2[cursor2]) {
        res.add(arr2[cursor2]);
      }
      cursor2++;
    }

    int[] resArr = new int[res.size()];
    int i = 0;
    for (int n : res) {
      resArr[i++] = n;
    }

    return resArr;
  }

  public int[] intersection(int[] arr1, int[] arr2) {
    if (arr1 == null && arr2 == null) {
      return null;
    }
    if (arr1 == null || arr2 == null) {
      return arr1 == null ? arr2 : arr1;
    }

    List<Integer> res = new ArrayList<>();
    int cursor1 = 0;
    int cursor2 = 0;
    while (cursor1 < arr1.length && cursor2 < arr2.length) {
      if (arr1[cursor1] == arr2[cursor2]) {
        if (res.size() == 0 || res.get(res.size() - 1) != arr1[cursor1]) {
          res.add(arr1[cursor1]);
        }
        cursor1++;
        cursor2++;
        continue;
      }
      if (arr1[cursor1] < arr2[cursor2]) {
        cursor1++;
      } else {
        cursor2++;
      }
    }

    int[] resArr = new int[res.size()];
    int i = 0;
    for (int n : res) {
      resArr[i++] = n;
    }

    return resArr;
  }

  public static void main(String[] args) {
    ArraysManipulations arrayUtil = new ArraysManipulations();
    System.out.println(">> " +
        Arrays.toString(arrayUtil.union(
            new int[]{1, 3, 3, 3, 5, 7, 8, 9},
            new int[]{2, 3, 3, 4, 7, 8, 9, 10, 23, 27})));

    System.out.println(">> " +
        Arrays.toString(arrayUtil.intersection(
            new int[]{1, 3, 3, 3, 5, 7, 8, 9},
            new int[]{2, 3, 3, 4, 7, 8, 9, 10, 23, 27})));

  }
}
