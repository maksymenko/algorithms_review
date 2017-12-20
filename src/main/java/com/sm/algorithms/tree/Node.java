package com.sm.algorithms.tree;

public class Node {
  private Node left;
  private Node right;
  private int value;

  public Node(int value) {
    this.value = value;
  }

  public Node addLeft(int value) {
    left = new Node(value);
    return left;
  }

  public Node addRight(int value) {
    right = new Node(value);
    return right;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public int getValue() {
    return value;
  }
}
