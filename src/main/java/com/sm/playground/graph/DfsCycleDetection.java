package com.sm.playground.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DfsCycleDetection {
  private List<Integer>[] adjList;
  private int size;
  private boolean[] visited;
  private boolean[] visitedOnPath;
  private Deque<Integer> stack = new ArrayDeque<>();

  public DfsCycleDetection(int size) {
    this.size = size;
    this.adjList = new ArrayList[size];
    for(int i = 0; i < size; i++) {
      adjList[i] = new ArrayList();
    }
    visited = new boolean[size];
    visitedOnPath = new boolean[size];
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index");
    }
  }

  public void addEdge(int first, int second) {
    checkIndex(first);
    checkIndex(second);
    adjList[first].add(second);
  }

  public void findCycle(int start) {
    stack.clear();
    Arrays.fill(visitedOnPath, false);
    Arrays.fill(visited, false);

    dfs(start);
  }

  private void dfs(int current) {
    System.out.println(">>> handle: " + current);
    visited[current] = true;
    stack.push(current);

    visitedOnPath[current] = true;

    for(int ind: adjList[current]) {
      if (!visited[ind]) {
        dfs(ind);
      } else if (visitedOnPath[ind]) {//cycle detected
        printCycle(stack, ind);
        return;
      }
    }
    visitedOnPath[current] = false;
    stack.pop();
  }

  private void printCycle(Deque stack, int loopStartIndex) {
    System.out.println(">>> cycle  " + loopStartIndex + " " + stack);
  }


  public static void main(String[] args) {
    DfsCycleDetection dfsCycleDetection = new DfsCycleDetection(8);
    dfsCycleDetection.addEdge(5, 1);
    dfsCycleDetection.addEdge(5, 7);
    dfsCycleDetection.addEdge(5, 4);
    dfsCycleDetection.addEdge(1, 3);
    dfsCycleDetection.addEdge(3, 7);
    dfsCycleDetection.addEdge(3, 6);
    dfsCycleDetection.addEdge(2, 6);
    dfsCycleDetection.addEdge(2, 7);
    dfsCycleDetection.addEdge(0, 2);
    dfsCycleDetection.addEdge(4, 6);
    dfsCycleDetection.addEdge(4, 0);

    dfsCycleDetection.addEdge(0, 5);

    dfsCycleDetection.findCycle(5);

    System.out.println(">>>> finish");
  }
}
