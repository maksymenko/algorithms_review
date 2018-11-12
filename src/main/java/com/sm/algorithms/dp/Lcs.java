package com.sm.algorithms.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lcs {
  public int findCommonSequence(String first, String second) {
    char firstSeq[] = first.toCharArray();
    char secondSeq[] = second.toCharArray();
    int[][] dp = new int[first.length() + 1][second.length() + 1];
    Map<Integer, Integer> solution = new HashMap<>();

    Arrays.fill(dp[0], 0);
    for (int i = 0; i < firstSeq.length; i++) {
    Arrays.fill(dp[i + 1], 0);
      for (int j = 0; j < secondSeq.length; j++) {
        if (firstSeq[i] == secondSeq[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
          solution.put(j+1, j);
        } else {
          if (dp[i + 1][j] > dp[i][j + 1]){
            solution.put(j+1, j);
          } else {
            solution.put(j+1, j + 1);
          }
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);


        }
      }
    }

    // Reconstruct.
    Deque<Character> sequence = new ArrayDeque<>();
    int i = firstSeq.length;
    int j = secondSeq.length;
    while(i > 0 && j > 0) {
      if (firstSeq[i - 1] == secondSeq[j - 1]) {
        sequence.push(firstSeq[i - 1]);
        i--;
        j--;
      }else if (dp[i][j - 1] > dp[i-1][j]) {
        j--;
      } else {
        i--;
      }
    }

    System.out.println(">> LCS solution: " + sequence);

    return dp[firstSeq.length][second.length()];
  }

  public static void main(String[] args) {
    Lcs lcs = new Lcs();
    System.out.println(">>> Lcs length " + lcs.findCommonSequence("BDCABA", "ABCBDAB"));
    System.out.println(">>> Lcs length " + lcs.findCommonSequence("ABCBDAB", "BDCABA"));

  }
}
