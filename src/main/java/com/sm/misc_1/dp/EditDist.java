package com.sm.misc_1.dp;

import java.util.HashMap;
import java.util.Map;

public class EditDist {
  private Map<String, Integer> dp = new HashMap<>();

  public int getMinCnt(String str1, String str2) {
    System.out.print(str1 + "  " + str2);
    dp.clear();
    int chCnt = minCnt(str1, 0, str2, 0);
    System.out.println(" " + chCnt + "  changes");
    return chCnt;
  }

  private int minCnt(String str1, int n1, String str2, int n2) {

    if (n1 == str1.length() && n2 == str2.length()) {
      return 0;
    }

    if ((n1 >= str1.length() && n2 < str2.length())
      ||(n2 >= str2.length() && n1 < str2.length())) {
      return Math.abs(n1 - n2);
    }

    String pattern = str1.substring(n1) + "-" + str2.substring(n2);
    if (dp.containsKey(pattern)) {
      return dp.get(pattern);
    }

    int min = 0;
    if (str1.charAt(n1) == str2.charAt(n2)) {
      min = minCnt(str1, n1+1, str2, n2+1);
    } else {
      min = Math.min(minCnt(str1, n1+1, str2, n2+1)+1, minCnt(str1, n1+1, str2, n2)+1);
      min = Math.min(min, minCnt(str1, n1, str2, n2 + 1) + 1);
    }

    dp.put(pattern, min);

    return min;
  }

  public static void main(String[] args) {
    EditDist editDist = new EditDist();
    editDist.getMinCnt("geek", "gesek");
    editDist.getMinCnt("cat", "cut");
    editDist.getMinCnt("sunday", "saturday");
  }
}
