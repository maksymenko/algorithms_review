package com.sm.algorithms.graph;

import java.util.*;

public class TopologicalSortV2_cycleDetection {
    private enum NodeState {NOT_VISITED, ON_STACK, PROCESSED};
    private Map<String, Set<String>> graph = new HashMap<>();

    public void addEdge(String src, String dst) {
        graph.computeIfAbsent(src, x -> new HashSet<>()).add(dst);
    }

    public List<String> computeSeqFrom(String src) {
        Stack<String> seq = new Stack<>();
        dfs(src, new HashMap<>(), seq);

        List<String> res = new ArrayList<>();
        while (!seq.isEmpty()) {
            res.add(seq.pop());
        }
        return res;
    }

    private void dfs(String src, HashMap<String, NodeState> visited, Stack<String> seq) {
        visited.put(src, NodeState.ON_STACK);
        for (String child: graph.getOrDefault(src, new HashSet<>())) {
            NodeState childState = visited.getOrDefault(child, NodeState.NOT_VISITED);
            if (childState == NodeState.ON_STACK) {
                //Cycle detected
                throw new IllegalArgumentException("Cycle detected");
            }
            if (childState == NodeState.NOT_VISITED) {
                dfs(child, visited, seq);
            }
        }
        seq.push(src);
        visited.put(src, NodeState.PROCESSED);
    }

    public static void main(String[] args) {
        TopologicalSortV2_cycleDetection topologicalSort = new TopologicalSortV2_cycleDetection();

        topologicalSort.addEdge("0", "5");
        topologicalSort.addEdge("0", "1");
        topologicalSort.addEdge("0", "6");
        topologicalSort.addEdge("5", "4");
        topologicalSort.addEdge("2", "0");
        topologicalSort.addEdge("0", "3");
        topologicalSort.addEdge("3", "5");
        topologicalSort.addEdge("6", "4");
        topologicalSort.addEdge("7", "6");
        topologicalSort.addEdge("6", "9");
        topologicalSort.addEdge("8", "7");
        topologicalSort.addEdge("9", "10");
        topologicalSort.addEdge("9", "11");
        topologicalSort.addEdge("9", "12");
        topologicalSort.addEdge("11", "12");

        // create cycle
        //topologicalSort.addEdge("4", "0");

        System.out.println(">>> seq: " + topologicalSort.computeSeqFrom("8"));


        System.out.println(">>>" + "123".substring(0, 1));
    }
}
