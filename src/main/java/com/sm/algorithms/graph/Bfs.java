package com.sm.algorithms.graph;

import com.google.common.base.Preconditions;


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Bi-directed graph
public class Bfs {
  private int count;
  private List<Integer>[] adjList;
  private boolean[] marked;
  private int[] edgeTo;
  private List<Integer> traverse = new LinkedList<>();

  public Bfs(int count) {
    this.count = count;

    adjList = new LinkedList[count];
    edgeTo = new int[count];
    marked = new boolean[count];
    for (int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
      edgeTo[i] = -1;
    }
  }

  public void addEdge(int first, int second) {
    Preconditions.checkArgument(first < count);
    Preconditions.checkArgument(second < count);
    adjList[first].add(second);
    adjList[second].add(first);
  }


  public void bfs(int src) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(src);
    marked[src] = true;
    while(!queue.isEmpty()) {
      int vertex = queue.poll();
      visit(vertex);
      for(int adj: adjList[vertex]) {
        if (!marked[adj]) {
          marked[adj] = true;
          edgeTo[adj] = vertex;
          queue.add(adj);
        }
      }
    }
  }

  public Collection<Integer> getPathTo(int dest) {
    Deque<Integer> pathStack = new ArrayDeque<>();
    int cursor = dest;
    for(; edgeTo[cursor] != -1; cursor = edgeTo[cursor]) {
      pathStack.push(cursor);
    }
    pathStack.push(cursor);
    return pathStack;
  }

  public List getTraverse() {
    return traverse;
  }

  private void visit(int vertex) {
    traverse.add(vertex);
  }


  public static void main(String[] args) {
    Bfs bfs = new Bfs(8);
    bfs.addEdge(5, 1);
    bfs.addEdge(5, 7);
    bfs.addEdge(5, 4);
    bfs.addEdge(1, 3);
    bfs.addEdge(3, 7);
    bfs.addEdge(3, 6);
    bfs.addEdge(2, 6);
    bfs.addEdge(2, 7);
    bfs.addEdge(0, 2);
    bfs.addEdge(4, 6);
    bfs.addEdge(4, 0);

    bfs.bfs(5);
    System.out.println("Traverse: " + bfs.getTraverse());
  }
}
