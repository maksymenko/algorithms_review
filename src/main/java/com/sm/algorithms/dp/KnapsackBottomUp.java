package com.sm.algorithms.dp;

import java.util.Arrays;

public class KnapsackBottomUp {
  public int findMax(int capacity, int[] v, int[] w) {
    if (v == null || w == null || v.length != w.length) {
      return -1;
    }

    System.out.println(">>> total capacity " + capacity +
        " values " + Arrays.toString(v) +
        " weights: " + Arrays.toString(w));

    int[][] dp = new int[v.length][capacity + 1];

    for (int i = 0; i < v.length; i++) {
      Arrays.fill(dp[i], 0);
      for (int j = 0; j <= capacity; j += 1 ) {
        int leftCapacity = j - w[i];
        if (leftCapacity >= 0) {
           if (i > 0) {
            dp[i][j] = Math.max(dp[i - 1][leftCapacity] + v[i], dp[i-1][j]);
          } else {
            dp[i][j] = v[i];
          }
        }
      }
    }

    return dp[v.length - 1][capacity];
  }

  public static void main(String[] args) {
    System.out.println(">> KnapsackBottomUp staring..");
    KnapsackBottomUp knapsack = new KnapsackBottomUp();
    System.out.println(knapsack.findMax(50, new int[]{60, 100, 120}, new int[]{10, 20, 30}));
  }
}
