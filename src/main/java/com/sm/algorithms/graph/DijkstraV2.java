package com.sm.algorithms.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraV2 {
  private Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
  private Map<Integer, Integer> dist = new HashMap<>();

  public void addEdge(int src, int dst, int weight) {
    if (graph.get(src) == null) {
      graph.put(src, new HashMap<>());
    }
    graph.get(src).put(dst, weight);
  }

  public void traverse(int src, int dst) {
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
    pq.add(new int[]{src, 0});

    while(!pq.isEmpty()) {
      int[] top = pq.poll();

      if (dist.getOrDefault(top[0], Integer.MAX_VALUE)  < top[1]){
        continue;
      }

      graph.getOrDefault(top[0], new HashMap<>()).forEach((vertex, weight) -> {
        int newDist = top[1] + weight;
        if (dist.getOrDefault(vertex, Integer.MAX_VALUE) > newDist) {
          dist.put(vertex, newDist);
          pq.add(new int[]{vertex, top[1] + weight});
        }
      });
    }

  }


  public static void main(String[] args) {
    DijkstraV2 path = new DijkstraV2();

    path.addEdge(0, 1, 5);
    path.addEdge(0, 7, 8);
    path.addEdge(0, 4, 9);
    path.addEdge(1, 7, 4);
    path.addEdge(1, 2, 12);
    path.addEdge(1, 3, 15);

    path.addEdge(2, 3, 3);
    path.addEdge(2, 6, 11);

    path.addEdge(3, 6, 9);

    path.addEdge(4, 7, 5);
    path.addEdge(4, 5, 4);
    path.addEdge(4, 6, 20);

    path.addEdge(5, 6, 13);
    path.addEdge(7, 2, 7);
    path.addEdge(7, 5, 6);

    path.traverse(0, 6);
  }
}


