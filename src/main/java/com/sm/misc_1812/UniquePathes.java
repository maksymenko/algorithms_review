package com.sm.misc_1812;

import java.util.Arrays;

public class UniquePathes {
  private int dp[][];
  private int d  = 0;
  public int uniquePathsWithObstacles(int[][] grid) {
    dp = new int[grid.length][grid[0].length];
    for(int i = 0; i < grid.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    return getCnt(grid, 0, 0);
  }

  private int getCnt(int[][] grid, int x, int y) {
    if ((x == grid.length - 1) && (y == grid[0].length - 1)) {
      return grid[x][y] == 0? 1: 0;
    }
    if (x >= grid.length || y >= grid[0].length || grid[x][y] == 1) {
      return 0;
    }

    if (dp[x][y] >= 0) {
      return dp[x][y];
    }

    int res = getCnt(grid, x + 1, y) + getCnt(grid, x, y + 1);

    dp[x][y] = res;

    return res;
  }

  public static void main(String[] args) {
    UniquePathes up = new UniquePathes();
    System.out.println(">>> " + up.uniquePathsWithObstacles(new int[][]{{0, 0, 0,}, {0, 1, 0}, {0, 0, 0}}));
      }
}
