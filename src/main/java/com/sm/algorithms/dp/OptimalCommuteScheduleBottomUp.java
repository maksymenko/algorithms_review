package com.sm.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Looking for optimal commute schedule.
 * Commute not less then once per 3 days.
 * Each day commute time is different.
 * Find minim total commute time and days which gives minimal time.
 */
public class OptimalCommuteScheduleBottomUp {
  private int[] timeForDay;
  private Map<Integer, Integer> dp = new HashMap<>();
  private Map<Integer, Integer> solution = new HashMap<>();


  public Result findMinTimePath(int[] timePerDay) {
    this.timeForDay = timePerDay;
    Result result1 = findMinTimePathStartFrom(0);
    Result result2 = findMinTimePathStartFrom(1);
    Result result3 = findMinTimePathStartFrom(2);

    Result result = result1.minTime < result2.minTime ? result1 : result2;
    result = result.minTime < result3.minTime ? result : result3;

    System.out.println("schedule: " + Arrays.toString(timePerDay)
        + " min time: " + result.minTime
        + " with schedule: " + result.days);
    return result;
  }

  public Result findMinTimePathStartFrom(int startFrom) {
    dp.clear();
    solution.clear();
    dp.put(startFrom, timeForDay[startFrom]);

    // Build bottom up dp
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

    // Check min from possible finish day
    int iterationMin = Integer.MAX_VALUE;
    int finishBy = -1;
    for (int i = startFrom; i < 3; i++) {
      int newInterationMin = dp.get(timeForDay.length - i + startFrom - 1);
      if (newInterationMin < iterationMin) {
        iterationMin = newInterationMin;
        finishBy = timeForDay.length - i + startFrom - 1;
      }
    }

    Result result = new Result();
    result.minTime = dp.get(finishBy);

    // Reconstruction solution.
    int curDay = finishBy;
    while (curDay >= 0) {
      result.days.add(curDay);
      curDay = solution.getOrDefault(curDay, -1);
    }

    return result;
  }

  private static class Result {
    int minTime;
    List<Integer> days = new ArrayList<>();
  }

  public static void main(String[] args) {
    System.out.println(">>> min time schedule starting..");
    OptimalCommuteScheduleBottomUp schedule = new OptimalCommuteScheduleBottomUp();
    schedule.findMinTimePath(new int[]{10, 15, 7, 10, 5, 4, 8});
    schedule.findMinTimePath(new int[]{14, 17, 10, 27, 3, 29, 32});
  }
}
