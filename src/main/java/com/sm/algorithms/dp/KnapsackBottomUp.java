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

    int[][] dp = new int[v.length + 1][capacity + 1];
    int[] solution = new int[capacity + 1];
    Arrays.fill(solution, 0);
    Arrays.fill(dp[0], 0);

    for (int i = 1; i <= v.length; i++) {
      Arrays.fill(dp[i], 0);
      for (int j = 0; j <= capacity; j += 10) {
        int leftCapacity = j - w[i - 1];
        if (leftCapacity >= 0) {
          int newMax = dp[i - 1][leftCapacity] + v[i - 1];
          if (newMax > dp[i - 1][j]) {
            dp[i][j] = newMax;
            solution[j] = w[i - 1 ];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    int curWeight = capacity;
    while(solution[curWeight] > 0 ) {
      System.out.println(">> " + solution[curWeight]);
      curWeight -= solution[curWeight];
    }

    return dp[v.length - 1][capacity];
  }

  public static void main(String[] args) {
    System.out.println(">> KnapsackBottomUp staring..");
    KnapsackBottomUp knapsack = new KnapsackBottomUp();
    System.out.println(knapsack.findMax(50, new int[]{100, 120, 60}, new int[]{20, 30, 10}));
  }
}
