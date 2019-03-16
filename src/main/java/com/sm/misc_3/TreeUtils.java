package com.sm.misc_3;


public class TreeUtils {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private TreeNode root;


  public TreeUtils(TreeNode root) {
    this.root = root;
  }

  public int floor(double x) {
    TreeNode floorNode = floor(root, x);
    return floorNode == null? -1 : floorNode.val;
  }

  private TreeNode floor(TreeNode node, double x) {
    if (node == null) {
      return null;
    }
    if (node.val == x) {
      return node;
    }
    if (node.val > x) {
      return floor(node.left, x);
    }
    TreeNode fNode = floor(node.right, x);
    return fNode == null ? node : fNode;
  }


  public int ceil(double x) {
    TreeNode ceilNode = ceil(root, x);
    return ceilNode == null? -1 : ceilNode.val;
  }

  private TreeNode ceil(TreeNode node, double x) {
    if (node == null) {
      return null;
    }
    if (node.val == x) {
      return node;
    }

    if (node.val < x) {
      return ceil(node.right, x);
    }

    TreeNode ceilNode = ceil(node.left, x);
    return ceilNode == null ? node : ceilNode;
  }

  public void inOrderSmaller(double value) {
    inOrderSmaller(root, 61);
  }

  private void inOrderSmaller(TreeNode node, double value) {
    if (node == null) {
      return;
    }

    if (node.val < value) {
      inOrderSmaller(node.left, value);
      System.out.println("> " + node.val);
      inOrderSmaller(node.right, value);
    } else {
      inOrderSmaller(node.left, value);
    }



  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(80);
    root.left = new TreeNode(50);
    root.right = new TreeNode(90);

    root.left.left = new TreeNode(30);
    root.left.right = new TreeNode(70);

    root.left.left.right = new TreeNode(40);

    root.left.right.left = new TreeNode(60);
    root.left.right.left.right = new TreeNode(65);

    TreeUtils treeFloor = new TreeUtils(root);

    System.out.println(">>>> floor: " + treeFloor.floor(72));

    System.out.println(">>>> ceil: " + treeFloor.ceil(72));

    System.out.println(">>>> inOrderSmaller: " );
    treeFloor.inOrderSmaller(72);


  }
}
