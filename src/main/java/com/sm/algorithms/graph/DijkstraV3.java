package com.sm.algorithms.graph;

import java.util.*;

public class DijkstraV3 {

    private Map<Integer, Set<int[]>> graph = new HashMap<>();

    public void addEdge(int src, int dst, int weight) {
        graph.computeIfAbsent(src, x -> new HashSet<>()).add(new int[]{src, dst, weight});
    }

    public void traverse(int src, int nodeCount) {
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));

        dist.put(src, 0);
        pq.add(new int[]{src, 0});

        while(!pq.isEmpty() && visited.size() != nodeCount) {
            int[] curDist = pq.poll();
            visited.add(curDist[0]);
            for(int[] edge: graph.getOrDefault(curDist[0], new HashSet<>())) {
                if (visited.contains(edge[1])) { // cycle handling
                    continue;
                }
                int newDist = curDist[1] + edge[2];
                pq.add(new int[]{edge[1], newDist});
                dist.put(edge[1], Math.min(dist.getOrDefault(edge[1], Integer.MAX_VALUE), newDist));
            }
        }
    }
}
