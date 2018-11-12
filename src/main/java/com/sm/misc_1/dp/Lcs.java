package com.sm.misc_1.dp;

public class Lcs {

  public int calc(String s1, String s2) {
    char[] seq1 = s1.toCharArray();
    char[] seq2 = s2.toCharArray();
    int[][] dp = new int[seq1.length][seq2.length];


    for(int i = 0; i < seq1.length; i++) {
      for(int j = 0; j < seq2.length; j++) {
        if (seq1[i] == seq2[j]) {
          dp[i][j] = (i == 0 || j == 0) ? 1: dp[i -1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(i == 0 ? 0 : dp[i-1][j], j == 0 ? 0 : dp[i][j-1]);
        }
      }
    }
    return dp[seq1.length - 1][seq2.length - 1];
  }

  public static void main(String[] args) {
    Lcs lcs = new Lcs();
    System.out.println(">>>> " + lcs.calc("AGGTAB", "GXTXAYB"));
  }
}
