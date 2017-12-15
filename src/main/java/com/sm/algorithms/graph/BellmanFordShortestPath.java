package com.sm.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

public class BellmanFordShortestPath {
  private List<Edge>[] adjList;
  private int count;

  public BellmanFordShortestPath(int count) {
    this.count = count;

    adjList = new LinkedList[count];

    for(int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest, double weight) {
    adjList[src].add(new Edge(src, dest, weight));

  }


  private static class Edge {
    private int src;
    private int dest;
    private double weight;

    public Edge(int src, int dest, double weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }
  }
}
