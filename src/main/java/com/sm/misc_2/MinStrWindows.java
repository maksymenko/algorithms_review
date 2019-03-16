package com.sm.misc_2;

import java.util.HashMap;
import java.util.Map;

public class MinStrWindows {
  public String minWindow(String s, String t) {
    int min = 0;
    int max = 0;
    int diff = Integer.MAX_VALUE;

    if (s == null || t == null || s.length() < 1 || t.length() < 1 || t.length() > s.length()) {
      return "";
    }

    Map<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      int cnt = m.getOrDefault(t.charAt(i), 0);
      m.put(t.charAt(i), cnt + 1);
    }

    int left = 0;
    int right = -1;
    Map<Character, Integer> mCur = new HashMap<>();

    while (right < s.length() && (left <= right || right == -1)) {

      if (!isAllChars(mCur, m) && right < s.length() - 1) {
        right++;
        int cnt = mCur.getOrDefault(s.charAt(right), 0);
        mCur.put(s.charAt(right), cnt + 1);
        if (isAllChars(mCur, m)) {
          if (diff > right - left + 1) {
            diff = right - left + 1;
            min = left;
            max = right;
          }
        }
      } else if (left < right) {
        int cnt = mCur.getOrDefault(s.charAt(left), 0);
        mCur.put(s.charAt(left), cnt - 1);
        left++;
        if (isAllChars(mCur, m)) {
          if (diff > right - left + 1) {
            diff = right - left + 1;
            min = left;
            max = right;
          }
        }
      } else {
        break;
      }
    }

    if (diff < Integer.MAX_VALUE) {
      return s.substring(min, max + 1);
    }
    return "";
  }

  private boolean isAllChars(Map<Character, Integer> mCur, Map<Character, Integer> m) {
    for (Map.Entry<Character, Integer> entry : m.entrySet()) {
      int curCnt = mCur.getOrDefault(entry.getKey(), 0);
      if (curCnt < entry.getValue()) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    MinStrWindows solution = new MinStrWindows();
    System.out.println(">>> " + solution.minWindow("a", "a"));
  }
}

