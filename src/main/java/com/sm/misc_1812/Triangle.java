package com.sm.misc_1812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
  private Integer[][] dp;
  public int minimumTotal(List<List<Integer>> triangle) {
    dp = new Integer[triangle.size()][triangle.size()];
    return getMinSum(triangle, 0, 0);
  }

  private int getMinSum(List<List<Integer>> triangle, int i, int j) {
    if (triangle.size() <= i) {
      return 0;
    }
    if (triangle.get(i).size() <= j) {
      return Integer.MAX_VALUE;
    }


    int val = triangle.get(i).get(j);

    int sum = 0;
    if (dp[i][j] != null) {
      sum = dp[i][j];
    } else {
      sum = Math.min(getMinSum(triangle, i+1, j), getMinSum(triangle, i+1, j + 1));
      dp[i][j] = sum;
    }

    return val + sum;
  }

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();

    triangle.add(Arrays.asList(new Integer[]{2}));
    triangle.add(Arrays.asList(new Integer[]{3, 4}));
    triangle.add(Arrays.asList(new Integer[]{6, 5, 7}));
    triangle.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));


    Triangle t = new Triangle();
    System.out.println(t.minimumTotal(triangle));
  }
}
