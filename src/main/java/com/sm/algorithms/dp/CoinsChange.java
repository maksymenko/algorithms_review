package com.sm.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinsChange {

  public int[] getOptimalChange(int sum, int price, int[] options) {
    Map<Integer, Integer> resultByCoin = new HashMap<>();
    int[] result = new int[options.length];
    int change = sum - price;
    Map<Integer, Integer> dp = new HashMap<>();
    Map<Integer, Integer> solution = new HashMap<>();

    for (int amount = 1; amount <= change; amount++) {
      int min = Integer.MAX_VALUE;
      for (int coin : options) {
        if (amount > coin) {
          int newMax = 1 + dp.getOrDefault(amount - coin, 0);
          if (newMax < min) {
            min = newMax;
            solution.put(amount, coin);
          }
        }
      }
      dp.put(amount, min);
    }

    System.out.print(">>> min count: " + dp.get(change));

    //Reconstruction
    int curAmount = change;
    while (curAmount > 0) {
      int coin = solution.getOrDefault(curAmount, -1);
      if (coin < 0) {
        break;
      }
      curAmount -= coin;
      resultByCoin.put(coin, 1 + resultByCoin.getOrDefault(coin, 0));
    }

    // Build result array
    for (int i = 0; i < options.length; i++) {
      result[i] = resultByCoin.getOrDefault(options[i], 0);
    }

    return result;
  }


  public static void main(String[] args) {
    System.out.println(">>> starting..");
    CoinsChange coinsChange = new CoinsChange();
//    System.out.println(" 4 [1, 3] or [2, 2] >> " + Arrays.toString(coinsChange.getOptimalChange(10, 6, new int[]{1, 2, 3})));
//    System.out.println(" 30 [25, 5] >> " + Arrays.toString(coinsChange.getOptimalChange(30, 0, new int[]{25, 10, 5})));
    System.out.println(" 11 [6, 5] >> " + Arrays.toString(coinsChange.getOptimalChange(11, 0, new int[]{9, 6, 5, 1})));
//    System.out.println(" 10 [5, 5] >> " + Arrays.toString(coinsChange.getOptimalChange(10, 0, new int[]{2, 5, 3, 6})));
//    System.out.println(" 37 [25 + 10 + 1 + 1]>> " + Arrays.toString(coinsChange.getOptimalChange(37, 0, new int[]{1, 5, 10, 25})));
  }
}
