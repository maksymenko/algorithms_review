package com.sm.local_dev;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap();
    public int numIslands(int[][] grid) {
        int offset = grid.length * grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    union(i, offset + j);
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    union(i * grid.length + j, i);
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    union(j + 1, i);
                }
            }
        }
        System.out.println(" map size: " + map.size());
        map.forEach((k, v) -> {
            System.out.println(" " + k + " : " + v);
        });

        return 2;
    }

    private int find(int i) {
        int parent = map.computeIfAbsent(i, x->x);
        while(parent != i) {
            i = parent;
            parent = map.computeIfAbsent(i, x->x);
        }
        return parent;
    }

    private void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        map.put(iParent, jParent);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.numIslands(new int[][] {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}});
    }
}
