package com.sm.algorithms.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOfBoxesTopDown {
  public int maxStackHeight(int[][] boxes) {
    List<Integer> availableBoxIndexes = new ArrayList<>();
    Map<Integer, Integer> cache = new HashMap<>();
    for (int i = 0; i < boxes.length; i++) {
      availableBoxIndexes.add(i);
    }

    int[] initialBox = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    return maxHeight(0, initialBox, boxes, availableBoxIndexes, cache);
  }

  private int maxHeight(int baseHeight, int[] baseBox, int[][] boxes, List<Integer> availableBoxIndexes, Map<Integer, Integer> cache) {
    if (availableBoxIndexes.size() == 0) {
      return baseHeight;
    }

    int maxHeight = baseHeight;
    for (int i : availableBoxIndexes) {
      if (baseBox[0] > boxes[i][0] && baseBox[1] > boxes[i][1] && baseBox[2] > boxes[i][2]) {
        int newBaseHeight = baseHeight + boxes[i][1];
        List newAvailableIndexes = new ArrayList(availableBoxIndexes);
        newAvailableIndexes.remove(i);

        System.out.println(">>>> " + cache.get(i));
        int newHeight = cache.getOrDefault(i, maxHeight(newBaseHeight, boxes[i], boxes, newAvailableIndexes, cache));
        cache.put(i, newHeight);
        maxHeight = Math.max(maxHeight, newHeight);
      }
    }

    return maxHeight;
  }

  public static void main(String[] args) {
    StackOfBoxesTopDown stackOfBoxes = new StackOfBoxesTopDown();
    int maxStackHeight = stackOfBoxes.maxStackHeight(new int[][]{
        {3, 4, 5},
        {2, 3, 4},
        {1, 2, 3},
        {3, 3, 5}
    });
    System.out.println(">>> maxStackHeight: " + maxStackHeight);
  }
}
