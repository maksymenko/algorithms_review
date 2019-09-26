package com.sm.algorithms.tree;

public class Node {
  private Node left;
  private Node right;
  public Node next;
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

  public Node addNext(int value) {
    next = new Node(value);
    return next;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public Node getNext() {
    return next;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return " " + value ;
  }
}
