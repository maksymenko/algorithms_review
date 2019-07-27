package com.sm.algorithms.find_union;


import java.util.HashMap;
import java.util.Map;

// Weighted quick union. Connects smaller tree to bigger.
// Negative value of root element represents size of tree.
public class FindUnion {
    private Map<Integer, Integer> uf = new HashMap<>();

    public void union(int src, int dst) {
        int srcRoot = find(src);
        int dstRoot = find(dst);

        if (srcRoot != dstRoot || (srcRoot < 0 && dstRoot < 0)) {
            uf.put(srcRoot, uf.getOrDefault(srcRoot, -1) + uf.getOrDefault(dstRoot, -1));
            uf.put(dstRoot, srcRoot);
        }
    }

    public int find(int node) {
        int n = node;
        int parent = uf.getOrDefault(n, -1);
        if (parent == -1) {
            uf.put(node, -1);
        }
        while (parent >= 0 && parent != n) {
            n = parent;
            parent = uf.getOrDefault(n, -1);
        }

        return n;
    }

    public boolean isConnected(int src, int dst) {
        return find(src) == find(dst);
    }

    public static void main(String[] args) {
        FindUnion findUnion = new FindUnion();

        System.out.println("   >>>> " + findUnion.isConnected(1, 2));
        System.out.println("   >>>> " + findUnion.isConnected(1, 4));
        System.out.println("   >>>> " + findUnion.isConnected(2, 4));

        findUnion.union(1, 4);
        findUnion.union(4, 5);
        findUnion.union(2, 3);
        findUnion.union(2, 6);
        findUnion.union(6, 3);
        findUnion.union(7, 3);

        System.out.println("   >>>> " + findUnion.isConnected(0, 6));
        System.out.println("   >>>> " + findUnion.isConnected(1, 2));
        System.out.println("   >>>> " + findUnion.isConnected(1, 4));
        System.out.println("   >>>> " + findUnion.isConnected(2, 7));
    }
}
