package com.sm.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Complexity: E LogV
 */
public class DijkstraShortestPath {
  private List<Edge>[] adjList;
  private int[] edgeTo;
  private double[] distTo;
  private boolean[] marked;
  private int count;
  private PriorityQueue<Dist> pq;

  public DijkstraShortestPath(int count) {
    this.count = count;

    pq = new PriorityQueue<>();

    adjList = new LinkedList[count];
    edgeTo = new int[count];
    distTo = new double[count];
    marked = new boolean[count];

    for (int i = 0; i < count; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public Collection<Integer> findPathTo(int src, int dest) {
    // Initialize resources.
    Arrays.fill(distTo, Double.POSITIVE_INFINITY);
    Arrays.fill(edgeTo, -1);
    Arrays.fill(marked, false);

    // TODO: Cycle detection.

    // Calculate shortest paths to all vetices.
    distTo[src] = 0;
    pq.add(new Dist(0, 0.0));
    for (int i = 0; i < count; i++) {
      if (!pq.isEmpty()) {
        relax(pq.poll().vertex);
      }
    }

    // Reconstruct path to target vertex.
    Deque path = new ArrayDeque<>();
    for (int vertex = dest; vertex != src && vertex != -1; vertex = edgeTo[vertex]) {
      path.push(vertex);
    }
    path.push(src);

    return path;
  }

  public void addEdge(int src, int dest, double weight) {
    adjList[src].add(new Edge(src, dest, weight));
  }

  private void relax(int src) {
    if (!marked[src]) {
      marked[src] = true;
      for (Edge edge : adjList[src]) {
        double dist = distTo[edge.src] + edge.weight;
        if (dist < distTo[edge.dest]) {
          distTo[edge.dest] = dist;
          edgeTo[edge.dest] = src;
          pq.add(new Dist(edge.dest, dist));
        }
      }
    }
  }

  private static class Dist implements Comparable<Dist> {
    private int vertex;
    private double dist;

    public Dist(int vertex, double dist) {
      this.vertex = vertex;
      this.dist = dist;
    }

    @Override
    public int compareTo(Dist other) {
      if (this.dist < other.dist) {
        return 1;
      } else if (this.dist > other.dist) {
        return -1;
      }

      return 0;
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
    DijkstraShortestPath shortestPath = new DijkstraShortestPath(8);
    shortestPath.addEdge(4, 5, 0.35);
    shortestPath.addEdge(5, 4, 0.35);
    shortestPath.addEdge(4, 7, 0.37);
    shortestPath.addEdge(5, 7, 0.28);
    shortestPath.addEdge(7, 5, 0.28);
    shortestPath.addEdge(5, 1, 0.32);
    shortestPath.addEdge(0, 4, 0.38);
    shortestPath.addEdge(0, 2, 0.26);
    shortestPath.addEdge(7, 3, 0.39);
    shortestPath.addEdge(1, 3, 0.29);
    shortestPath.addEdge(2, 7, 0.34);
    shortestPath.addEdge(6, 2, 0.40);
    shortestPath.addEdge(3, 6, 0.52);
    shortestPath.addEdge(6, 0, 0.58);
    shortestPath.addEdge(6, 4, 0.93);

    System.out.println(shortestPath.findPathTo(0, 6));

  }
}
