package com.sm.algorithms.graph;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.google.common.truth.Truth.assertThat;

public class BfsTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void shouldThrowExceptionIfVertexIndexMoreThenGraphSize() throws Exception {
    Bfs bfs = new Bfs(3);
    thrown.expect(IllegalArgumentException.class);
    bfs.addEdge(5, 2);
  }

  @Test
  public void shouldFindPath() throws Exception {
    Bfs bfs = new Bfs(8);
    bfs.addEdge(5, 1);
    bfs.addEdge(5, 7);
    bfs.addEdge(5, 4);
    bfs.addEdge(1, 3);
    bfs.addEdge(3, 7);
    bfs.addEdge(3, 6);
    bfs.addEdge(2, 6);
    bfs.addEdge(2, 7);
    bfs.addEdge(0, 2);
    bfs.addEdge(4, 6);
    bfs.addEdge(4, 0);

    bfs.bfs(5);

    assertThat(bfs.getPathTo(2)).containsExactly(5, 7, 2).inOrder();
    assertThat(bfs.getTraverse()).containsExactly(5, 1, 7, 4, 3, 2, 6, 0).inOrder();
  }
}
