package com.sm.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * n stairs, each step 1,2 or m stairs.
 * How many options.
 */
public class TripleStep {

  public int optionsCount(int n, int m) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, 0);
    dp[0] = 1;  // 0 stairs
    for (int i = 1; i <= n; i++) {
      for(int j = 1; j <= m && j <= i; j++) {
        dp[i] = dp[i - j] + dp[i];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    TripleStep tripleStep = new TripleStep();
    System.out.println("number of options: " + tripleStep.optionsCount(4, 2));
  }
}
