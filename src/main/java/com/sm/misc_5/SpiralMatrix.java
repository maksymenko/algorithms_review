package com.sm.misc_5;


public class SpiralMatrix {
    public void fillMatrix(int[][] m, int x, int y, int[] vals) {
        int cursor = 0;
        int right = y;
        int left = y;
        int top = x;
        int bottom = x;
        while (cursor < vals.length) {
            cursor = moveRight(m, vals, cursor, left, right, x);
            right++;
            y = right;

            cursor = moveDown(m, vals, cursor, top, bottom, y);
            bottom++;
            x = bottom;

            cursor = moveLeft(m, vals, cursor, left, right, x);
            left--;
            y = left;

            cursor = moveUp(m, vals, cursor, top, bottom, y);
            top--;
            x = top;
        }
        show(m);
    }

    private int moveRight(int[][] m, int[] vals, int cursor, int left, int right, int x) {
        for (int j = left; j <= right; j++) {
            if (checkPosition(m, vals, x, j, cursor)) {
                m[x][j] = vals[cursor++];
            }
        }
        return cursor;
    }

    private int moveDown(int[][] m, int[] vals, int cursor, int top, int bottom, int y) {
        for (int i = top; i <= bottom; i++) {
            if (checkPosition(m, vals, i, y, cursor)) {
                m[i][y] = vals[cursor++];
            }
        }
        return cursor;
    }

    private int moveLeft(int[][] m, int[] vals, int cursor, int left, int right, int x) {
        for (int j = right; j >= left; j--) {
            if (checkPosition(m, vals, x, j, cursor)) {
                m[x][j] = vals[cursor++];
            }
        }
        return cursor;
    }

    private int moveUp(int[][] m, int[] vals, int cursor, int top, int bottom, int y) {
        for (int i = bottom; i >= top; i--) {
            if (checkPosition(m, vals, i, y, cursor)) {
                m[i][y] = vals[cursor++];
            }
        }
        return cursor;
    }

    private boolean checkPosition(int[][] m, int[] vals, int x, int y, int cursor) {
        return y >= 0 && y < m.length && x >= 0 && x < m.length && cursor < vals.length;
    }


    public void show(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf(" %02d", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println(">>>> starting...");

        SpiralMatrix s = new SpiralMatrix();
        s.fillMatrix(new int[5][5], 1, 2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20
                , 21, 22, 23, 24, 25, 26});
    }

}
