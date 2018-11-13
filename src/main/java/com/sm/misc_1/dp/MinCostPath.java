package com.sm.misc_1.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostPath {
  Map<String, Integer> dp = new HashMap<>();

  public int calcMinPath(int[][] matrix, int n, int m) {
    dp.clear();
    int minPath = calcMinTopDown(matrix, n, m);
    System.out.println(">>> topDown: " + minPath);
    minPath = calcMinPathBottomUp(matrix, n, m);
    System.out.println(">>> bottomUp: " + minPath);

    return minPath;
  }

  private int calcMinTopDown(int[][] matrix, int n, int m) {
    if (n < 0 || m < 0) {
      return Integer.MAX_VALUE;
    }

    if (n == 0 && m == 0) {
      return matrix[n][m];
    }

    if (dp.containsKey(n + "-" + m)) {
      return dp.get(n + "-" + m) + matrix[n][m];
    }

    int cost = calcMinTopDown(matrix, n - 1, m);
    cost = Math.min(cost, calcMinTopDown(matrix, n - 1, m - 1));
    cost = Math.min(cost, calcMinTopDown(matrix, n, m - 1));

    dp.put(n + "-" + m, cost);

    return cost + matrix[n][m];
  }


  public int calcMinPathBottomUp(int[][] matrix, int n, int m) {

    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        int cost = Integer.MAX_VALUE;
        if (i > 0) {
          cost = Math.min(cost, dp[i - 1][j]);
        }
        if (j > 0) {
          cost = Math.min(cost, dp[i][j - 1]);
        }
        if (i > 0 && j > 0) {
          cost = Math.min(cost, dp[i - 1][j - 1]);
        }
        dp[i][j] = matrix[i][j] + ((cost < Integer.MAX_VALUE) ? cost: 0);
      }
    }
    return dp[n][m];

  }


  public static void main(String[] args) {
    System.out.println(">>>> Min cost path starting...");
    MinCostPath minCostPath = new MinCostPath();
    minCostPath.calcMinPath(new int[][]{{1, 2, 3}, {4, 8, 2}, {1, 5, 3}}, 2, 2);

  }
}
