package com.sm.algorithms.tree;


import java.util.ArrayDeque;
import java.util.Queue;

public class TreeVisualizer {
  public void printByLine(Node root) {
    Queue<Node> queue = new ArrayDeque<>();
    Node cursor = root;
    int levelNumber = 0;
    queue.add(cursor);
    while (!queue.isEmpty()) {
      System.out.print(levelNumber + " : ");

      int levelLength = queue.size();
      for (int i = 0; i < levelLength; i++) {
        cursor = queue.poll();
        System.out.print(cursor.getValue() + " ");
        if (cursor.getLeft() != null) {
          queue.add(cursor.getLeft());
        }
        if (cursor.getRight() != null) {
          queue.add(cursor.getRight());
        }
      }
      levelNumber++;
      System.out.println("");

    }
  }

  public static void main(String[] args) {
    Node root = new Node(5);
    root.addLeft(3);
    root.addRight(17);

    root.getLeft().addLeft(1);
    root.getLeft().addRight(4);

    root.getRight().addLeft(16);
    root.getRight().addRight(18);

    root.getLeft().getLeft().addLeft(7);
    root.getLeft().getLeft().addRight(11);

    TreeVisualizer treeVisualizer = new TreeVisualizer();
    treeVisualizer.printByLine(root);
  }
}
