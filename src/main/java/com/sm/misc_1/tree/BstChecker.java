package com.sm.misc_1.tree;


public class BstChecker {
  public boolean isBst(Node root)  {
      return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBst(Node node, int min, int max) {
    boolean res = false;
    if (node == null) {
      return true;
    }
    if (node.value <= min && node.value >= max) {
      res = true;
      if (node.left != null) {
        res &= isBst(node.left, min, node.value);
      }
      if (node.right != null) {
        res &= isBst(node.right, node.value, max);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    BstChecker bst = new BstChecker();

    Node root = new Node(5);
    root.addLeft(3);
    root.addRight(17);

    root.getLeft().addLeft(1);
    root.getLeft().addRight(4);

    root.getRight().addLeft(17);
    root.getRight().addRight(18);

    System.out.println("isBst: " + bst.isBst(root));
  }

  private static class Node {
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

    public void setValue(int value) {
      this.value = value;
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

    @Override
    public String toString() {
      return " " + value ;
    }
  }
}
