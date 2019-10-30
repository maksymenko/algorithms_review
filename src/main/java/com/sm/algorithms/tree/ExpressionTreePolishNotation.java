package com.sm.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/contests/data-structure-tasks-binary-tree-union-find/challenges/binary-expression-tree

public class ExpressionTreePolishNotation {
    public static void main(String[] args) {
        List<String> tree = new ArrayList<>();
        tree.add("+");
        tree.add("L*");
        tree.add("R7");
        tree.add("LL+");
        tree.add("LR9");
        tree.add("LLL2");
        tree.add("LLR3");
        Node root = new Node(tree.get(0));

        for(int i = 1; i < tree.size(); i++) {
            String str = tree.get(i);
            Node node = root;
            for(int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'L') {
                    if (str.charAt(j + 1) != 'L' && str.charAt(j + 1) != 'R') {
                        node.left = new Node(str.substring(j + 1));
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (str.charAt(j) == 'R') {
                    if (str.charAt(j + 1) != 'L' && str.charAt(j + 1) != 'R') {
                        node.right = new Node(str.substring(j + 1));
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root, sb);

        System.out.println(sb.toString());
        System.out.println(postTrav(root));

    }

    private static void postOrderTraverse(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left, sb);
        postOrderTraverse(node.right, sb);
        sb.append(node.val);
        sb.append(" ");
    }

    private static int postTrav(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left != null && node.right != null) {
            int a = postTrav(node.left);
            int b = postTrav(node.right);
            switch(node.val) {
                case "+": return a+b;
                case "-": return a - b;
                case "*": return a * b;
                case "/": return a / b;
            }
        }
        return Integer.parseInt(node.val);

    }

    private static class Node {
        String val;
        Node left;
        Node right;
        Node(String val) {
            this.val = val;
        }
    }
}
