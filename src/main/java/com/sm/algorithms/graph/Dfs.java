package com.sm.algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dfs {
  private Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

  public void addEdge(int first, int second) {
    Set<Integer> firstAdjacents = adjacencyList.getOrDefault(first, new HashSet<>());
    firstAdjacents.add(second);

    Set<Integer> secondAdjacents = adjacencyList.getOrDefault(second, new HashSet<>());
    secondAdjacents.add(first);
  }

  public void dfs() {
    adjacencyList.forEach((vertex, adjacents) -> {
      for(int adj)
    });
  }
}
