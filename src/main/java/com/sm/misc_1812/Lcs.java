package com.sm.misc_1812;

public class Lcs {

  public int lcsLength(String s1, String s2) {
    int dp[][] = new int[s2.length() + 1][s1.length() + 1];
    for (int i = 0; i <= s2.length(); i++) {
      dp[i][0] = 0;
    }
    for(int j = 0; j < s1.length(); j++) {
      dp[0][j] = 0;
    }

    for(int i = 0; i < s2.length(); i++) {
      char ch2 = s2.charAt(i);
      for(int j = 0; j < s1.length(); j++) {
        char ch1 = s1.charAt(j);
        if (ch1 == ch2) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }

    return dp[s2.length()][s1.length()];
  }

  public static void main(String[] args) {
    Lcs lcs = new Lcs();
    System.out.println(">>> lsc: " + lcs.lcsLength("AGGTAB", "GXTXAYB"));
  }
}
