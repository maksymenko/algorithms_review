package com.sm.playground.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.BiConsumer;

public class Bfs {
  private List<Integer>[] adjacencyList;
  private int size = 0;
  private boolean[] visited;

  public Bfs(int size) {
    this.size = size;
    this.visited = new boolean[size];
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

  public void traverse(IntConsumer handler, int startInd) {
    Arrays.fill(visited, false);
    Deque<Integer> handleQueue = new ArrayDeque<>();

    handleQueue.add(startInd);
    visited[startInd] = true;
    while (!handleQueue.isEmpty()) {
      int curIndex = handleQueue.poll();
      handler.accept(curIndex);
      for (int adj : adjacencyList[curIndex]) {
        if (!visited[adj]) {
          visited[adj] = true;
          handleQueue.add(adj);
        }
      }
    }
  }

  public void traverseByDepth(BiConsumer<Integer, Integer> handler, int start, int depth) {
    Arrays.fill(visited, false);
    Deque<int[]> handleQueue = new ArrayDeque<>();

    handleQueue.add(new int[]{start, 0});
    visited[start] = true;

    while (!handleQueue.isEmpty()) {
      int[] node = handleQueue.poll();
      handler.accept(node[0], node[1]);
      for (int adjInd : adjacencyList[node[0]]) {
        int curDepth = node[1] + 1;
        if (curDepth <= depth && !visited[adjInd]) {
          visited[adjInd] = true;
          handleQueue.add(new int[]{adjInd, curDepth});
        }
      }
    }
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

    bfs.traverse(x -> System.out.println(x), 5);


    bfs.traverseByDepth((ind, depth) -> System.out.println(" node: " + ind + "  depth: " + depth), 5, 2);

  }
}
