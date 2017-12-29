package com.sm.algorithms.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DijkstraShortestPathTest {

  @Test
  public void shouldFindPath() throws Exception {
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

   assertThat(shortestPath.findPathTo(0, 6)).containsExactly(0, 2, 7, 3, 6).inOrder();
  }
}
