package com.sm.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BellmanFordShortestPath {
  private List<Edge>[] adjList;
  private double distTo[];
  private int edgeTo[];
  private int count;

  public BellmanFordShortestPath(int count) {
    this.count = count;
    this.distTo = new double[count];
    this.edgeTo = new int[count];

    adjList = new LinkedList[count];

    for(int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest, double weight) {
    adjList[src].add(new Edge(src, dest, weight));
  }

  /**
   * Calculates shortest pathes to all vertex from given src vertex.
   * @param src
   * @return false if negative cycle found;
   */
  public boolean pathFrom(int src) {
    Arrays.fill(distTo, Double.POSITIVE_INFINITY);
    Arrays.fill(edgeTo, -1);
    distTo[src] = 0;

    for (int i = 0; i < count -1; i++) {
      relaxAllEdges();
    }

    // Check if no negative cycles.
    for(List<Edge> adj: adjList) {
      for(Edge edge: adj) {
        if (distTo[edge.src] + edge.weight < distTo[edge.dest]) {
          return false;
        }
      }
    }
    return true;
  }

  public Collection<Integer> pathTo(int dest) {
    Deque<Integer> path = new ArrayDeque<>();

    for(int vertex = dest; vertex != -1; vertex = edgeTo[vertex]) {
      path.push(vertex);
    }
    return path;
  }

  private void relaxAllEdges() {
    for(List<Edge> adj: adjList) {
      for(Edge edge: adj) {
        relax(edge);
      }
    }
  }

  private void relax(Edge edge) {
    double newDist = distTo[edge.src] + edge.weight;
    if (newDist < distTo[edge.dest]) {
      distTo[edge.dest] = newDist;
      edgeTo[edge.dest] = edge.src;
    }
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

  public static void main(String[] args) {
    System.out.println(">> bellford starting...");
    BellmanFordShortestPath shortestPath = new BellmanFordShortestPath(5);
    shortestPath.addEdge(0, 1, -1);
    shortestPath.addEdge(0, 2, 4);
    shortestPath.addEdge(1, 2, 3);
    shortestPath.addEdge(1, 3, 2);
    shortestPath.addEdge(1, 4, 2);
    shortestPath.addEdge(3, 1, 1);
    shortestPath.addEdge(3, 2, 5);
    shortestPath.addEdge(4, 3, -3);


    if (shortestPath.pathFrom(0)) {
      System.out.println("path 0 to 3:  " + shortestPath.pathTo(3));
    }

  }
}
