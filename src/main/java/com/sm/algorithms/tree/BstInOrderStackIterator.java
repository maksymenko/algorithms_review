package com.sm.algorithms.tree;

import java.util.Stack;

public class BstInOrderStackIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BstInOrderStackIterator(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;

        node = node.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }

        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
