package com.sm.misc_2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/*
Uses Dijcstra's shortest path  alg, but calculates all possible dist to each node by different number of stops.
PQ always returns min dist , so once dst reached it is min dist to dst.
 */
public class CheapestFlightWithStops {
  private Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
  private Map<Integer, Map<Integer, Integer>> distTo = new HashMap<>(); // vertex -> Map<stops, cost>

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    buildGraph(flights);

    return traverse(src, dst, K);
  }

  private int traverse(int src, int dst, int maxStops) {
    // queue of [node , stops, dist] by dist
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
    pq.add(new int[]{src, -1, 0});
    while (!pq.isEmpty()) {
      int[] top = pq.poll();
      if (top[1] > maxStops) {
        continue;
      }
      if (top[0] == dst) {
        return top[2];
      }
      Map<Integer, Integer> child = graph.getOrDefault(top[0], new HashMap<>());
      int stop = top[1] + 1;
      child.forEach((node, cost) -> {
        int newCost = top[2] + cost;

        pq.add(new int[]{node, stop, newCost});

        Map<Integer, Integer> distByStops = distTo.getOrDefault(node, new HashMap<>());
        distTo.put(node, distByStops);
        int curCost = distByStops.getOrDefault(stop, Integer.MAX_VALUE);
        distByStops.put(stop, Math.min(newCost, curCost));
      });
    }

    return -1;
  }

  private void buildGraph(int[][] flights) {
    for (int[] flight : flights) {
      Map<Integer, Integer> edges = graph.getOrDefault(flight[0], new HashMap<>());
      graph.put(flight[0], edges);
      edges.put(flight[1], flight[2]);
    }
  }

  public static void main(String[] args) {
    CheapestFlightWithStops cheapestFlightWithStops = new CheapestFlightWithStops();

    int res = cheapestFlightWithStops.findCheapestPrice(3,
        new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1);

    System.out.println(">>>>> " + res);

  }
}
