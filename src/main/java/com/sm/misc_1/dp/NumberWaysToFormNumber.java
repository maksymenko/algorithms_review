package com.sm.misc_1.dp;

import java.util.Arrays;


//Given 3 numbers {1, 3, 5}, we need to tell
//the total number of ways we can form a number 'N'
//using the sum of the given three numbers.
public class NumberWaysToFormNumber {
  private int[] digits = new int[]{3, 5};
  private int[] dp;

  public int countBottopmUpOrTabulation(int n) {
    dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int d : digits) {
        if (i - d == 0) {
          dp[i] += 1;
        } else if (i - d > 0) {
          dp[i] += dp[i - d];
        }
      }
    }
    return dp[n];
  }


  public int countTopDownAndMemoization(int n) {
    dp = new int[n + 1];
    Arrays.fill(dp, -1);

    return countTopDownRec(n);
  }

  private int countTopDownRec(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    if (dp[n] != -1) {
      return dp[n];
    }

    int cnt = 0;
    for (int d : digits) {
      cnt += countTopDownRec(n - d);
    }
    dp[n] = cnt;
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(">>>> starting... ");
    NumberWaysToFormNumber inst = new NumberWaysToFormNumber();

    System.out.println(">>>> bottom up " + inst.countBottopmUpOrTabulation(42));
    System.out.println(">>>>  top down " + inst.countTopDownAndMemoization(6));
  }
}
