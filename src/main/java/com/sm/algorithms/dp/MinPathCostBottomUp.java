package com.sm.algorithms.dp;

public class MinPathCostBottomUp {
  public void findPath(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    char[][] solution = new char[grid.length][grid[0].length];

    for (int r = 0; r < grid.length; r++) {
      dp = new int[grid.length + 1][grid[0].length + 1];
    }

    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        int min = Integer.MAX_VALUE;
        int newMin;

        if (r > 0 && c > 0) {
          newMin = dp[r - 1][c - 1];
          if (newMin < min) {
            solution[r][c] = 'c';
            min = newMin;
          }
        }

        if (c > 0) {
          newMin = dp[r][c - 1];
          if (newMin < min) {
            solution[r][c] = 'r';
            min = newMin;
          }
        }

        if (r > 0) {
          newMin = dp[r - 1][c];
          if (newMin < min) {
            solution[r][c] = 'd';
            min = newMin;
          }
        }
        dp[r][c] = grid[r][c];
        if (min < Integer.MAX_VALUE) {
          dp[r][c] += min;
        }
      }
    }

    // Reconstruction.
    int curR = grid.length - 1;
    int curC = grid[0].length - 1;
    while (curR > 0 || curC > 0) {
      System.out.println(curR + ":" + curC);
      if (solution[curR][curC] == 'c') {
        curR--;
        curC--;
      } else if (solution[curR][curC] == 'r') {
        curC--;
      } else {
        curR--;
      }
    }
    System.out.println(curR + ":" + curC);
    System.out.println("min cost: " + dp[grid.length - 1][grid[0].length - 1]);
  }

  public static void main(String[] args) {
    MinPathCostBottomUp minPathCost = new MinPathCostBottomUp();
    minPathCost.findPath(new int[][]{
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}
    });
  }
}
