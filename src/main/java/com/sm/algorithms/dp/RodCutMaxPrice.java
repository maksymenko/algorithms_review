package com.sm.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class RodCutMaxPrice {
  private int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  private Map<Integer, Integer> dp = new HashMap<>();
  private Map<Integer, Integer> dpSolution = new HashMap<>();

  public int findTopDown(int len) {
    if (len < 1) {
      return 0;
    }
    Integer maxP = dp.get(len);
    if (maxP == null) {
      maxP = prices[len - 1];
      for (int i = 0; i < len; i++) {
        maxP = Math.max(maxP, prices[i] + findTopDown(len - i - 1));
      }
      dp.put(len, maxP);
      System.out.println(">> topDown for " + len + "  max: " + dp.get(len));
    }
    return maxP;
  }

  public int findSolutionByTopDown(int len) {
    if (len < 1) {
      return 0;
    }

    if (dp.get(len) != null) {
      return dp.get(len);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      int newMax = prices[i] + findSolutionByTopDown(len - i - 1);
      if (newMax > max) {
        max = newMax;
        dpSolution.put(len, i + 1);
      }
    }
    System.out.println(">> findSolutionByTopDown for " + len + " max: " + max);
    dp.put(len, max);
    return max;
  }

  public int findBottomUp(int len) {
    dp.put(0, 0);

    for (int i = 1; i <= len; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        max = Math.max(max, prices[j] + dp.get(i - j - 1));
      }
      dp.put(i, max);
      System.out.println(">> bottomUp for " + i + "  max: " + max);
    }
    return dp.get(len);
  }

  public int findSolutionBottomUp(int len) {
    dp.put(0, 0);
    for (int i = 1; i <= len; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        int newMax = prices[j] + dp.get(i - j - 1);
        if (newMax > max) {
          max = newMax;
          dpSolution.put(i, j + 1);
        }
      }
      dp.put(i, max);
      System.out.println(">> findSolutionBottomUp for " + i + " max: " + max);
    }

    return dp.get(len);
  }

  private void reconstructSolution(int len) {
    int cursor = len;
    System.out.print(">> Solution ");
    while(cursor > 0) {
      int step = dpSolution.get(cursor);
      System.out.print(" " + step);
      cursor -= step;
    }
    System.out.println();
  }

  private void init() {
    dp.clear();
    dpSolution.clear();
  }

  public static void main(String[] args) {
    RodCutMaxPrice rodCutMaxPrice = new RodCutMaxPrice();
    System.out.println(">>> starting...");

    rodCutMaxPrice.init();
    System.out.println(">> max by TopDown for 4 is: " + rodCutMaxPrice.findTopDown(4));

    rodCutMaxPrice.init();
    System.out.println(">> max by BottomUp for 4 is: " + rodCutMaxPrice.findBottomUp(4));

    rodCutMaxPrice.init();
    System.out.println(">> max by FindSolutionBottomUp for 9 is: " + rodCutMaxPrice.findSolutionBottomUp(9));
    rodCutMaxPrice.reconstructSolution(9);

    rodCutMaxPrice.init();
    System.out.println(">> max by findSolutionByTopDown for 9 is: " + rodCutMaxPrice.findSolutionByTopDown(9));
    rodCutMaxPrice.reconstructSolution(9);
  }
}
