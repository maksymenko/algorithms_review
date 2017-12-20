package com.sm.algorithms.tree;

public class BstChecker {

  public boolean isBst(Node root) {
    return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBst(Node node, int minValue, int maxValue) {
    if (node == null) {
      return true;
    }

    if (node.getValue() >= minValue && node.getValue() <= maxValue ) {
      return isBst(node.getLeft(), minValue, node.getValue())
          && isBst(node.getRight(), node.getValue(), maxValue);
    }

    return false;
  }

  public static void main(String[] args) {
    Node root = new Node(5);
    root.addLeft(3);
    root.addRight(17);

    root.getLeft().addLeft(1);
    root.getLeft().addRight(4);

    root.getRight().addLeft(17);
    root.getRight().addRight(18);

    BstChecker bstChecker = new BstChecker();
    System.out.println("isBst: " + bstChecker.isBst(root));
  }
}
