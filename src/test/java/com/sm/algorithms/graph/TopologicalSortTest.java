package com.sm.algorithms.graph;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TopologicalSortTest {
  @Test
  public void shouldOrderVertices() throws Exception {
    TopologicalSort topologicalSort = new TopologicalSort(13);
    topologicalSort.addEdge(0, 5);
    topologicalSort.addEdge(0, 1);
    topologicalSort.addEdge(0, 6);
    topologicalSort.addEdge(5, 4);
    topologicalSort.addEdge(2, 0);
    topologicalSort.addEdge(0, 3);
    topologicalSort.addEdge(3, 5);
    topologicalSort.addEdge(6, 4);
    topologicalSort.addEdge(7, 6);
    topologicalSort.addEdge(6, 9);
    topologicalSort.addEdge(8, 7);
    topologicalSort.addEdge(9, 10);
    topologicalSort.addEdge(9, 11);
    topologicalSort.addEdge(9, 12);
    topologicalSort.addEdge(11, 12);

    topologicalSort.dfs();
    assertThat(topologicalSort.getSequence()).containsExactly(8, 7, 2, 0, 3, 6, 9, 11, 12, 10, 1, 5, 4).inOrder();
  }
}
