package com.sm.misc_1.dp;

import java.util.Arrays;

// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
public class LongestIncSeq {
  int dp[] = new int[100];
  static int cnt = 0;

  public int lis(int[] arr, int end) {
    if (end < 0) {
      return 0;
    }

    if (dp[end] > 0) {
      cnt++;
      return dp[end];
    }

    int max = 1;
    for (int i = end - 1; i >= 0; i--) {
      if (arr[i] < arr[end]) {
        max = Math.max(max, lis(arr, i) + 1);
      }
    }
    dp[end] = max;
    return max;
  }

  public static void main(String[] args) {
    LongestIncSeq handler = new LongestIncSeq();
    int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
    Arrays.fill(handler.dp, 0);
    System.out.println(">>> lis expected 6: " + handler.lis(arr, arr.length - 1));

    arr = new int[]{3, 10, 2, 1, 20};
    Arrays.fill(handler.dp, 0);
    System.out.println(">>> lis expected 3: " + handler.lis(arr, arr.length - 1));

    arr = new int[]{3, 2};
    Arrays.fill(handler.dp, 0);
    System.out.println(">>> lis expected 1: " + handler.lis(arr, arr.length - 1));

    arr = new int[]{50, 3, 10, 7, 40, 80};
    Arrays.fill(handler.dp, 0);
    System.out.println(">>> lis expected 4: " + handler.lis(arr, arr.length - 1));

  }
}
