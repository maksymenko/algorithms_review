package com.sm.misc_3;

import sun.misc.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DfsBfs {

  private Map<Integer, Set<Integer>> adjList = new HashMap<>();
  private Map<Integer, Boolean> visited = new HashMap<>();

  public void addEdge(int src, int dst) {
    Set<Integer> adj = adjList.getOrDefault(src, new HashSet<>());
    adj.add(dst);
    adjList.put(src, adj);
  }

  public void dfs(int src) {
    visited.put(src, true);
    Set<Integer> adj = adjList.get(src);
    for(int v: adj) {
      if (!visited.getOrDefault(v, false)) {
        dfs(v);
      }
    }
  }

  public void bfs(int src) {
    Deque<Integer> q = new ArrayDeque<>();

    q.add(src);

    while(q.isEmpty()) {
      int v = q.poll();
      visited.put(v, true);
      Set<Integer> adj = adjList.get(v);
      for(int dst: adj) {
        if (!visited.getOrDefault(dst, false)) {
          q.add(dst);
        }
      }
    }

  }
}
