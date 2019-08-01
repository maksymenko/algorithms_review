package com.sm.misc_4;

import com.sm.algorithms.tree.TreeNode;

import java.util.*;

public class MyIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public MyIterator(TreeNode root) {
        TreeNode node = root;

        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next(){
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null ) {
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }



    public static void main(String[] args) {
        System.out.println(">>>> starting... ");

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(7);
        root.right = new TreeNode(14);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(9);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(8);

        root.right.left.left = new TreeNode(11);
        root.right.left.right = new TreeNode(13);

        root.right.right.left = new TreeNode(15);
        root.right.right.right = new TreeNode(19);


        MyIterator myIterator = new MyIterator(root);
        while(myIterator.hasNext()) {
            System.out.println(">>>> " + myIterator.next());
        }

    }

}
