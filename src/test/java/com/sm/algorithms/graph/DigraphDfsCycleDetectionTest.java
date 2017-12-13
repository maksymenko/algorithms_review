package com.sm.algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DigraphDfsCycleDetectionTest {
  DigraphDfsCycleDetection dfsCycleDetection;

  @Before
  public void setUp() throws Exception {
    dfsCycleDetection = new DigraphDfsCycleDetection(8);
    dfsCycleDetection.addEdge(5, 1);
    dfsCycleDetection.addEdge(5, 7);
    dfsCycleDetection.addEdge(5, 4);
    dfsCycleDetection.addEdge(1, 3);
    dfsCycleDetection.addEdge(3, 7);
    dfsCycleDetection.addEdge(3, 6);
    dfsCycleDetection.addEdge(2, 6);
    dfsCycleDetection.addEdge(2, 7);
    dfsCycleDetection.addEdge(0, 2);
    dfsCycleDetection.addEdge(4, 6);
    dfsCycleDetection.addEdge(4, 0);
    dfsCycleDetection.addEdge(7, 4);
  }

  @Test
  public void shouldDetectCycle() throws Exception {
    dfsCycleDetection.dfs(5);
    assertThat(dfsCycleDetection.getCycle()).containsExactly(7, 4, 0, 2, 7).inOrder();
  }
}
