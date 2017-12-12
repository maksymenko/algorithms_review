package com.sm.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dfs {
  private List<Integer>[] adjacencyList;
  private boolean[] visited;
  private int[] edgeTo;
  private int count;
  private List<Integer> traverse = new LinkedList<>();

  public Dfs(int count) {
    this.count = count;
    this.adjacencyList = new LinkedList[count];
    this.visited = new boolean[count];
    this.edgeTo = new int[count];
    for (int i = 0; i < count; i++) {
      this.adjacencyList[i] = new LinkedList<>();
      this.visited[i] = false;
      this.edgeTo[i] = -1;
    }
  }

  public void addEdge(int first, int second) {
    adjacencyList[first].add(second);
    adjacencyList[second].add(first);
  }

  public void dfs() {
    for(int vertex = 0; vertex < count; vertex++) {
      if (!visited[vertex]) {
        dfs(vertex);
      }
    }
  }

  public void dfs(int src) {
    visit(src);
    visited[src] = true;
    for (int adj : adjacencyList[src]) {
      if (!visited[adj]) {
        dfs(adj);
        edgeTo[adj] = src;
      }
    }
  }

  public Collection<Integer> getPathTo(int destVertex) {
    Deque<Integer> path = new ArrayDeque<>();
    int cursor;
    for(cursor = destVertex; edgeTo[cursor] != -1; cursor = edgeTo[cursor]) {
      path.push(cursor);
    }
    path.add(cursor);
    return path;
  }

  public List<Integer> getTraverse() {
    return traverse;
  }

  private void visit(int vertex) {
    traverse.add(vertex);
  }

  public static void main(String[] args) {
    Dfs dfs = new Dfs(13);
    dfs.addEdge(0, 6);
    dfs.addEdge(0, 2);
    dfs.addEdge(0, 1);
    dfs.addEdge(0, 5);
    dfs.addEdge(0, 5);
    dfs.addEdge(5, 3);
    dfs.addEdge(5, 4);
    dfs.addEdge(6, 4);

    dfs.addEdge(7, 8);

    dfs.addEdge(9, 10);
    dfs.addEdge(9, 11);
    dfs.addEdge(9, 12);
    dfs.addEdge(11, 12);

    dfs.dfs();

    System.out.println(dfs.getTraverse());

    System.out.println(dfs.getPathTo(3));
  }
}
