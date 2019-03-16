package com.sm.algorithms.tree;


import java.util.ArrayDeque;
import java.util.Deque;

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


  /////////////////// Floor //////////////
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


  /////////////////// Ceil //////////////
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


  /////////////////// Sorted seq less then target //////////////
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

  /////////////////// Serialize //////////////

  public Deque<String> serialize() {
    Deque<String> q = new ArrayDeque<>();
    serialize(q, root);
    return q;
  }

  private void serialize(Deque<String> q, TreeNode node){
    if (node == null){
      q.add("null");
      return;
    }
    q.add(Integer.toString(node.val));
    serialize(q, node.left);
    serialize(q, node.right);
  }


  public TreeNode deserialize(Deque<String> q) {
    if (q.isEmpty()) {
      return null;
    }
    String nodeStr = q.poll();
    if (nodeStr == "null") {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(nodeStr));

    node.left = deserialize(q);
    node.right = deserialize(q);
    return node;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(80);
    root.left = new TreeNode(50);
    root.right = new TreeNode(90);

    root.left.left = new TreeNode(30);
    root.left.right = new TreeNode(70);

    root.left.left.right = new TreeNode(40);

    root.left.right.left = new TreeNode(60);
    root.left.right.right = new TreeNode(65);

    TreeUtils treeUtils = new TreeUtils(root);

    System.out.println(">>>> floor: " + treeUtils.floor(72));

    System.out.println(">>>> ceil: " + treeUtils.ceil(72));

    System.out.println(">>>> inOrderSmaller: " );
    treeUtils.inOrderSmaller(72);


    Deque<String> ser = treeUtils.serialize();
    System.out.println(">>>> serialize: " + ser);

    TreeNode node = treeUtils.deserialize(ser);

    System.out.println(">> des: " + node);

  }
}
