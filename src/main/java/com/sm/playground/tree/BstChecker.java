package com.sm.playground.tree;

public class BstChecker {

  public boolean isBst(Node root) {
    if (root == null) {
      return true;
    }
    return isBst(root.left, Integer.MIN_VALUE, root.value)
        && isBst(root.right, root.value, Integer.MAX_VALUE);
  }

  private boolean isBst(Node node, int min, int max) {
    if (node == null) {
      return true;
    }
    if (node.value >= min && node.value < max) {
      return isBst(node.left, min, node.value)
          && isBst(node.right, node.value, max);
    }
    return false;
  }

  public static void main(String[] args) {
    BstChecker bstChecker = new BstChecker();

    Node root = new Node(15);
    root.left = new Node(13);
    root.right = new Node(17);


    root.left.left = new Node(11);
    root.left.right = new Node(14);

    root.left.left.left = new Node(7);
    root.left.left.right = new Node(12);

    root.right.left = new Node(16);
    root.right.right = new Node(18);

    root.right.left.left = new Node(7);


    System.out.println(">>> is bst: " + bstChecker.isBst(root));



  }



  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }
}
