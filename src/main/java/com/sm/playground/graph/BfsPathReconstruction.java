package com.sm.playground.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class BfsPathReconstruction {
  private List<Integer>[] adjacencyList;
  private int size = 0;
  private boolean[] visited;
  private int[] pathTo;

  public BfsPathReconstruction(int size) {
    this.size = size;
    this.visited = new boolean[size];
    this.pathTo = new int[size];
    Arrays.fill(this.pathTo, -1);
    Arrays.fill(this.visited, false);
    this.adjacencyList = new ArrayList[size];
    for (int i = 0; i < size; i++) {
      this.adjacencyList[i] = new ArrayList<>();
    }

  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("wrong node index");
    }
  }

  public void addEdge(int first, int second) {
    checkIndex(first);
    checkIndex(second);

    adjacencyList[first].add(second);
  }

  public void bfs(int start) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;
    while(!queue.isEmpty()) {
      int vertex = queue.poll();
      for(int adj: adjacencyList[vertex]) {
        if (!visited[adj]) {
          visited[adj] = true;
          queue.add(adj);
          pathTo[adj] = vertex;
        }
      }
    }
  }

  public Collection<Integer> reconstructPathTo(int dest) {
    Deque<Integer> stack = new ArrayDeque<>();
    int vertex = pathTo[dest];
    stack.push(dest);
    while(vertex != -1) {
      stack.push(vertex);
      vertex = pathTo[vertex];
    }
    return stack;
  }


  public static void main(String[] args) {
    BfsPathReconstruction bfs = new BfsPathReconstruction(8);
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

    bfs.bfs(0);
    for(int v: bfs.reconstructPathTo(3)) {
      System.out.print( v + " > ");
    }
    System.out.println("end");
  }
}
