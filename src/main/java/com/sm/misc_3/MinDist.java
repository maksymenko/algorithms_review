package com.sm.misc_3;

public class MinDist {
  public int minDistance(int[] arr1, int[] arr2) {
    int cursor1 = 0;
    int cursor2 = 0;
    int min = Integer.MAX_VALUE;

    while(cursor1 < arr1.length && cursor2 < arr2.length) {
      min = Math.min(min, Math.abs(arr1[cursor1] - arr2[cursor2]));

      if (arr1[cursor1] == arr2[cursor2]) {
        return 0;
      } else if (arr1[cursor1] < arr2[cursor2]) {
        cursor1++;
      } else {
        cursor2++;
      }
    }
    return min;
  }


  public static void main(String[] args) {
    MinDist minDist = new MinDist();
    System.out.println(">>>> MinDist..." + minDist.minDistance(new int[] {1, 5, 11, 18}, new int[]{3, 11, 12}));
  }
}
