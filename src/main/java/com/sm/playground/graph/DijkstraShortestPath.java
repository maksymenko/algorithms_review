package com.sm.playground.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
  private List<Edge>[] adjList;
  private int size;
  private boolean visited[];
  private int edgeTo[];
  private double distToVertex[];
  private PriorityQueue<Dist> priorityQueue;

  public DijkstraShortestPath(int size) {
    this.size = size;
    this.visited = new boolean[size];
    this.edgeTo = new int[size];
    this.distToVertex = new double[size];
    adjList = new List[size];
    for(int i = 0; i < size; i++) {
      adjList[i] = new ArrayList<>();
    }
    Arrays.fill(visited, false);
    Arrays.fill(edgeTo, -1);
    Arrays.fill(distToVertex, Integer.MAX_VALUE);
    priorityQueue = new PriorityQueue(new Comparator<Dist>() {
      @Override
      public int compare(Dist first, Dist second) {
        if (first.dist < second.dist) {
          return -1;
        } else if ((first.dist > second.dist)) {
          return 1;
        }
        return 0;
      }
    });
  }

  public void addEdge(int src, int dist, double weight) {
    Edge edge = new Edge(src, dist, weight);
    adjList[src].add(edge);
  }


  public void process(int start) {
    priorityQueue.add(new Dist(start, 0));
    distToVertex[start] = 0;
    int visitedCount = 0;
    while(visitedCount < size) {
      Dist dist = priorityQueue.poll();
      if (visited[dist.vertex]) {
        continue;
      }
      visited[dist.vertex] = true;
      visitedCount++;
      for(Edge edge: adjList[dist.vertex]) {
        double newDist = edge.weight + distToVertex[edge.src];
        if (distToVertex[edge.dest] > newDist) {
          distToVertex[edge.dest] = newDist;
          edgeTo[edge.dest] = edge.src;
          priorityQueue.add(new Dist(edge.dest, newDist));
        }
      }
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

    shortestPath.process(0);

    System.out.println(">>>> " + Arrays.toString(shortestPath.edgeTo));
  }

  private static class Dist {
    int vertex;
    double dist;

    public Dist(int vertex, double dist) {
      this.vertex = vertex;
      this.dist = dist;
    }
  }
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

