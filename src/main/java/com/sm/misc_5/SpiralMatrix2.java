package com.sm.misc_5;

public class SpiralMatrix2 {
    public int[][] create(int n) {
        int[][] arr = new int[n][n];
        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = n - 1;
        int val = 1;

        while(topRow <= bottomRow) {
            for(int col = leftCol; col <= rightCol; col++) {
                arr[topRow][col] = val++;
            }
            topRow++;

            for(int row = topRow; row <= bottomRow; row++) {
                arr[row][rightCol] = val++;
            }
            rightCol--;

            for(int col = rightCol; col >= leftCol; col--) {
                arr[bottomRow][col] = val++;
            }
            bottomRow--;

            for(int row = bottomRow; row >= topRow; row--) {
                arr[row][leftCol] = val++;
            }
            leftCol++;
        }

        return arr;
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

        SpiralMatrix2 s = new SpiralMatrix2();
        int[][] matrix = s.create(3);

        s.show(matrix);
    }
}
