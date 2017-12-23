package com.sm.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lcs {
  public int findCommonSequence(String first, String second) {
    char firstSeq[] = first.toCharArray();
    char secondSeq[] = second.toCharArray();
    int[][] dp = new int[first.length() + 1][second.length() + 1];

    Arrays.fill(dp[0], 0);
    for (int i = 0; i < firstSeq.length; i++) {
    Arrays.fill(dp[i + 1], 0);
      for (int j = 0; j < secondSeq.length; j++) {
        if (firstSeq[i] == secondSeq[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }

    return dp[firstSeq.length][second.length()];
  }

  public static void main(String[] args) {
    Lcs lcs = new Lcs();
    System.out.println(">>> lcs length " + lcs.findCommonSequence("BDCABA", "ABCBDAB"));
    System.out.println(">>> lcs length " + lcs.findCommonSequence("ABCBDAB", "BDCABA"));

  }
}
