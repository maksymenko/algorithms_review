package com.sm.algorithms.strings;

import java.util.Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutation {
  public List<String> permutationsRecursive(String str) {
    List<String> permutationList = new ArrayList<>();

    permutationsRecursive("", str, permutationList);

    return permutationList;
  }

  private void permutationsRecursive(String option, String str, List<String> result) {
    if (str.isEmpty()) {
      result.add(option);
      return;
    }

    for(int i = 0; i < str.length(); i++) {
      StringBuilder sb = new StringBuilder(str);
      permutationsRecursive(option + str.charAt(i), sb.deleteCharAt(i).toString(), result);
    }
  }

  public List<String> permutationsIterative(String str) {
    Queue<PermOption> auxQueue = new ArrayDeque<>();
    List<String> permutationList = new ArrayList<>();

    auxQueue.add(new PermOption("", str));
    while(!auxQueue.isEmpty()) {
      for(int j = 0; j < auxQueue.size(); j++) {
        PermOption permOption = auxQueue.poll();
        for(int i = 0; i < permOption.rest.length(); i++) {
          StringBuilder restSb = new StringBuilder(permOption.rest);
          String result = permOption.result + permOption.rest.charAt(i);
          if (result.length() == str.length()) {
            permutationList.add(result);
          } else {
            auxQueue.add(new PermOption(result, restSb.deleteCharAt(i).toString()));
          }
        }
      }
    }
    return permutationList;
  }

  private static class PermOption {
    String result;
    String rest;

    public PermOption(String result, String rest) {
      this.result = result;
      this.rest = rest;
    }
  }

  public static void main(String[] args) {
    StringPermutation permutation = new StringPermutation();
    System.out.println("> Recursive: " + permutation.permutationsRecursive("abc"));
    System.out.println("> Iterative: " + permutation.permutationsIterative("abc"));

  }
}
