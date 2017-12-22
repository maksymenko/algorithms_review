package com.sm.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class MinTimePathSchedule {
  //private int[] timeForDay = new int[]{10, 15, 7, 10, 5, 4, 8};
  private int[] timeForDay= new int[]{14, 1, 100, 27, 3, 29, 32};
  private Map<Integer, Integer> dp = new HashMap<>();
  private Map<Integer, Integer> solution = new HashMap<>();


  public int findMinTimePath() {
    int min = Integer.MAX_VALUE;

    findMinTimePathStartFrom(0);
    findMinTimePathStartFrom(1);
    findMinTimePathStartFrom(2);

    return min;
  }

  public int findMinTimePathStartFrom(int startFrom) {
    dp.clear();
    solution.clear();
    dp.put(startFrom, timeForDay[startFrom]);

    for (int nextDay = startFrom + 1; nextDay < timeForDay.length; nextDay++) {
      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= 3; i++) {
        if (nextDay - i >= startFrom) {
          int newMin = timeForDay[nextDay] + dp.get(nextDay - i);
          if (newMin < min) {
            min = newMin;
            solution.put(nextDay, nextDay - i);
          }
        }
      }
      dp.put(nextDay, min);
    }

    int iterationMin = Integer.MAX_VALUE;
    int finishBy = -1;
    for (int i = startFrom; i < 3; i++) {
      int newInterationMin = dp.get(timeForDay.length - i + startFrom - 1);
      if (newInterationMin < iterationMin) {
        iterationMin = newInterationMin;
        finishBy = timeForDay.length - i + startFrom - 1;
      }
    }

    System.out.print(" start from " + startFrom + "  min time: " + dp.get(finishBy) + " days: ");

    // Reconstruction
    int curDay = finishBy;
    while (curDay >= 0) {
      System.out.print(" " + curDay);
      curDay = solution.getOrDefault(curDay, -1);
    }
    System.out.println();
    return dp.get(finishBy);
  }

  public static void main(String[] args) {
    System.out.println(">>> min time schedule starting..");
    MinTimePathSchedule schedule = new MinTimePathSchedule();
    System.out.println(">> " + schedule.findMinTimePath());
  }
}
