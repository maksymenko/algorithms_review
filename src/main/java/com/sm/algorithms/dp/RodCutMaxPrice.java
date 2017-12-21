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

  public int findBottomUp(int len) {
    dp.put(1, prices[0]);
    System.out.println(">> bottomUp for " + 1 + "  max: " + dp.get(1));
    for(int i = 2; i <= len; i++) {
      int maxP = prices[i-1];
      for(int j = 1; j < i; j++) {
        maxP = Math.max(maxP, prices[i - j - 1] + dp.get(j));
      }
      dp.put(i, maxP);
      System.out.println(">> bottomUp for " + i + "  max: " + dp.get(i));
    }
    return dp.get(len);
  }

  public static void main(String[] args) {
    RodCutMaxPrice rodCutMaxPrice = new RodCutMaxPrice();
    System.out.println(">>> starting...");
    System.out.println(">> max by TopDown for 4 is: " + rodCutMaxPrice.findTopDown(4));

    System.out.println(">> max by BottomUp for 4 is: " + rodCutMaxPrice.findBottomUp(4));
  }

}
