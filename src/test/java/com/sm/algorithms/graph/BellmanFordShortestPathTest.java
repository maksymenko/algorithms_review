package com.sm.algorithms.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BellmanFordShortestPathTest {
  @Test
  public void shouldFindPath() throws Exception {
    BellmanFordShortestPath shortestPath = new BellmanFordShortestPath(5);

    shortestPath.addEdge(0, 1, -1);
    shortestPath.addEdge(0, 2, 4);
    shortestPath.addEdge(1, 2, 3);
    shortestPath.addEdge(1, 3, 2);
    shortestPath.addEdge(1, 4, 2);
    shortestPath.addEdge(3, 1, 1);
    shortestPath.addEdge(3, 2, 5);
    shortestPath.addEdge(4, 3, -3);

    assertThat(shortestPath.pathFrom(0)).isTrue();
    assertThat(shortestPath.pathTo(3)).containsExactly(0, 1, 4, 3).inOrder();
  }
}
