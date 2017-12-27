package com.sm.algorithms.linkedlist;

import java.util.Stack;

public class SumLists {
  /**
   * 7->1->6  + 5->9 = 2->1->7
   * 617     +   95  = 217
   *
   * @param first  e.g. 7->1->6
   * @param second e.g. 5->9
   * @return 2->1->7
   */
  public Node sum(Node first, Node second) {
    System.out.println(">> direct");
    showList(first, second);

    if (first == null && second == null) {
      return null;
    }

    Node root = new Node(-1);
    Node cursor = root;
    int leftOver = 0;
    while (cursor != null) {
      int resSum = (first == null ? 0 : first.value) + (second == null ? 0 : second.value) + leftOver;
      cursor.value = resSum % 10;
      leftOver = resSum / 10;

      if ((first != null && first.next != null) || (second != null && second.next != null)) {
        cursor.next = new Node(-1);
      }

      if (cursor.next == null) {
        cursor = cursor.next(leftOver);
      }
      cursor = cursor.next;

      if (first != null) {
        first = first.next;
      }
      if (second != null) {
        second = second.next;
      }
    }

    showList(root);
    return root;
  }

  public Node sumBackward(Node first, Node second) {
    System.out.println(">> backward");
    showList(first, second);
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    while (first != null || second != null) {
      if (first != null) {
        firstStack.push(first.value);
        first = first.next;
      }
      if (second != null) {
        secondStack.push(second.value);
        second = second.next;
      }
    }

    int leftOver = 0;
    Node node = null;
    while (!firstStack.isEmpty() || !secondStack.isEmpty()) {
      int resSum = (firstStack.isEmpty() ? 0 : firstStack.pop()) + (secondStack.isEmpty() ? 0 : secondStack.pop());
      resSum += leftOver;
      leftOver = (resSum > 9) ? 1:0;
      Node newNode = new Node(resSum % 10);
      newNode.next = node;
      node = newNode;
    }
    if (leftOver > 0) {
      Node newNode = new Node(leftOver);
      newNode.next = node;
      node = newNode;
    }

    showList(node);
    return node;
  }

  void showList(Node... node) {
    for(int i = 0; i < node.length; i++) {
      Node cursor = node[i];
      while (cursor != null) {
        System.out.print(cursor.value + "->");
        cursor = cursor.next;
      }
      if (i+1 < node.length) {
        System.out.print(" + ");
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    SumLists sumLists = new SumLists();

    sumLists.sum(Node.create(7, 1, 6), Node.create(5, 9));
    sumLists.sum(Node.create(9, 9, 9), Node.create(9, 9, 9));
    sumLists.sum(Node.create(9, 9, 9), null);
    sumLists.sumBackward(Node.create(7, 1, 6), Node.create(5, 9));
    sumLists.sumBackward(Node.create(9, 9, 9), Node.create(9, 9, 9));
    sumLists.sumBackward(null, Node.create(5, 9));

  }


  private static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }

    static Node create(int... value) {
      Node root = new Node(value[0]);
      Node cursor = root;
      for(int i = 1; i < value.length; i++) {
        cursor = cursor.next(value[i]);
      }
      return root;
    }

    Node next(int value) {
      this.next = new Node(value);
      return this.next;
    }
  }
}
