package com.sm.algorithms.graph;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class DfsTest {
  Dfs dfs = new Dfs(13);

  @Before
  public void setUp() throws Exception {
    dfs.addEdge(0, 6);
    dfs.addEdge(0, 2);
    dfs.addEdge(0, 1);
    dfs.addEdge(0, 5);
    dfs.addEdge(0, 5);
    dfs.addEdge(5, 3);
    dfs.addEdge(5, 4);
    dfs.addEdge(6, 4);

    dfs.addEdge(7, 8);

    dfs.addEdge(9, 10);
    dfs.addEdge(9, 11);
    dfs.addEdge(9, 12);
    dfs.addEdge(11, 12);
  }

  @Test
  public void shouldTraverseDfs() throws Exception {
    dfs.dfs();

    assertThat(dfs.getTraverse()).containsExactly(0, 6, 4, 5, 3, 2, 1, 7, 8, 9, 10, 11, 12);
  }

  @Test
  public void shouldFindPath() throws Exception {
    dfs.dfs(0);
    assertThat(dfs.getPathTo(3)).containsExactly(0, 6, 4, 5, 3);
  }
}
