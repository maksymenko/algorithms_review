package com.sm.algorithms.graph;

import com.google.common.base.Preconditions;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DigraphDfsCycleDetection {
  private int count;
  private List<Integer>[] adjList;
  private boolean[] visited;
  private int edgeTo[];
  private boolean[] onStack;
  private Deque<Integer> cycle = new ArrayDeque<>();
  private Deque<Integer> traverse = new ArrayDeque<>();


  public DigraphDfsCycleDetection(int count) {
    this.count = count;
    adjList = new LinkedList[count];
    visited = new boolean[count];
    edgeTo = new int[count];
    onStack = new boolean[count];
    for (int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
      edgeTo[i] = -1;
    }
  }

  public void addEdge(int src, int dest) {
    Preconditions.checkArgument(src < count);
    Preconditions.checkArgument(dest < count);
    adjList[src].add(dest);
  }

  public void dfs(int src) {
    onStack[src] = true;
    visit(src);
    visited[src] = true;
    for (int adj : adjList[src]) {
      if (!visited[adj]) {
        edgeTo[adj] = src;
        dfs(adj);
      } else  if (onStack[adj]) { //Cycle detected.
        cycle(src, adj);
      }
    }
    onStack[src] = false;
  }

  private void cycle(int src, int vertex) {
    cycle.clear();
    cycle.push(vertex);
    for(int cursor = src; cursor != vertex; cursor = edgeTo[cursor]) {
      cycle.push(cursor);
    }
    cycle.push(vertex);
  }

  public Collection<Integer> getPathTo(int destVertex) {
    Deque<Integer> path = new ArrayDeque<>();
    int cursor;
    for(cursor = destVertex; edgeTo[cursor] != -1; cursor = edgeTo[cursor]) {
      path.push(cursor);
    }
    path.push(cursor);
    return path;
  }

  private void visit(int vertex) {
    traverse.push(vertex);
  }

  public Deque<Integer> getCycle() {
    return cycle;
  }

  public Deque<Integer> getTraverse() {
    return traverse;
  }

  public static void main(String[] args) {
    DigraphDfsCycleDetection dfsCycleDetection = new DigraphDfsCycleDetection(8);
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
    dfsCycleDetection.addEdge(7, 4);

    dfsCycleDetection.dfs(5);

    System.out.println("Traverse : " + dfsCycleDetection.getTraverse());
    System.out.println("Cycle : " + dfsCycleDetection.getCycle());
    System.out.println("Path to 2 : " + dfsCycleDetection.getPathTo(2));
  }
}

