package com.sm.algorithms.tree;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BstCheckerTest {
  @Test
  public void shouldBeBst() throws Exception {
    Node root = new Node(5);
    root.addLeft(3);
    root.addRight(17);

    root.getLeft().addLeft(1);
    root.getLeft().addRight(4);

    root.getRight().addLeft(17);
    root.getRight().addRight(18);

    BstChecker bstChecker = new BstChecker();

    assertThat(bstChecker.isBst(root)).isTrue();
  }

  @Test
  public void shouldNotBst() throws Exception {
    Node root = new Node(5);
    root.addLeft(3);
    root.addRight(19);

    root.getLeft().addLeft(1);
    root.getLeft().addRight(4);

    root.getRight().addLeft(16);
    root.getRight().addRight(18);

    BstChecker bstChecker = new BstChecker();

    assertThat(bstChecker.isBst(root)).isFalse();
  }
}
