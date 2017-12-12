package com.sm.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

public class DfsCycleDetection {
  private int count;
  private List<Integer>[] adjList;
  private boolean[] onStack;
  private boolean[] visited;
  private int edgeTo[];


  public DfsCycleDetection(int count) {
    this.count = count;
    adjList = new LinkedList[count];
    for(int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void dfs(int src) {

  }
}
