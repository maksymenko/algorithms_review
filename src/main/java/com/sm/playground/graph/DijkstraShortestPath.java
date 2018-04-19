package com.sm.playground.graph;

import java.util.List;

public class DijkstraShortestPath {
  private List<Edge>[] adjList;
  private int size;





  private static class Edge {
    int src;
    int dest;
    double weight;

    public Edge(int src, int dest, double weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }
  }
}
