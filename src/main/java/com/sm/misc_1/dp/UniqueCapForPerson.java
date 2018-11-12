package com.sm.misc_1.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCapForPerson {
  int wayCnt = 0;

  public int numberOfWays(List<List<Integer>> collections) {
    wayCnt = 0;
    int cnt = collections.size();
    boolean[] usage = new boolean[101];
    Arrays.fill(usage, false);

    numberOfWaysInt(collections, cnt, usage);

    return wayCnt;

  }

  private void numberOfWaysInt(List<List<Integer>> collections, int cnt, boolean[] usage) {

    if (cnt == 0) {
      wayCnt++;
      return;
    }

    for(int ind: collections.get(cnt - 1)) {
      if (usage[ind] == false) {
        usage[ind] = true;
        numberOfWaysInt(collections, cnt - 1, usage);
        usage[ind] = false;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(">>>> UniqueCap ...");
    List<List<Integer>> collections = new ArrayList<>();
    collections.add(Arrays.asList(new Integer[]{5, 100, 1}));
    collections.add(Arrays.asList(new Integer[]{2}));
    collections.add(Arrays.asList(new Integer[]{5, 100}));
    UniqueCapForPerson cap = new UniqueCapForPerson();

    System.out.println(">>>> number of ways: " + cap.numberOfWays(collections));
  }
}
