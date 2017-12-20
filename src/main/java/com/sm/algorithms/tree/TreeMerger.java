package com.sm.algorithms.tree;


public class TreeMerger {
  public void merge(Node result, Node first, Node second) {
    if (first == null && second == null) {
      return;
    }

    result.setValue(first != null ? first.getValue() : second.getValue());

    if ((first != null && first.getLeft() != null) || (second != null && second.getLeft() != null)) {
      result.addLeft(-1);
      merge(result.getLeft(), first != null ? first.getLeft() : null, second != null ? second.getLeft() : null);
    }

    if ((first != null && first.getRight() != null) || (second != null && second.getRight() != null)) {
      result.addRight(-1);
      merge(result.getRight(), first != null ? first.getRight(): null, second != null ? second.getRight():null);
    }
  }

  public static void main(String[] args) {
    Node first = new Node(11);
    first.addLeft(12);
    first.addRight(13);

    first.getLeft().addLeft(14);
    first.getLeft().addRight(15);

    first.getLeft().getLeft().addLeft(17);

    first.getRight().addLeft(16);

    first.getRight().getLeft().addLeft(18);
    first.getRight().getLeft().addRight(19);

    Node second = new Node(21);
    second.addLeft(22);
    second.addRight(23);

    second.getLeft().addRight(24);
    second.getLeft().getRight().addLeft(26);

    second.getRight().addRight(25);

    TreeMerger treeMerger = new TreeMerger();
    Node result = new Node(-1);
    treeMerger.merge(result, first, second);

    TreeVisualizer treeVisualizer = new TreeVisualizer();
    System.out.println("first");
    treeVisualizer.printByLine(first);
    System.out.println("second");
    treeVisualizer.printByLine(second);
    System.out.println("result");
    treeVisualizer.printByLine(result);
  }
}
