package com.sm.algorithms.sort;

import java.util.Random;

public class QuickSortV2 {
    private Random rnd = new Random();

    public String sort(String str) {
        char[] arr = str.toCharArray();

        quick(arr, 0, arr.length - 1);

        return new String(arr);
    }

    private void quick(char[] arr, int start, int end)  {
        if (start >= end) {
            return;
        }
        int pivotInd = partition(arr, start, end);
        quick(arr, start, pivotInd - 1);
        quick(arr, pivotInd + 1, end);
    }

    private int partition(char[] arr, int start, int end) {
        int pivotInd = start + rnd.nextInt(end - start);
        char pivot = arr[pivotInd];
        int cursor = start;

        // Move pivot to the end or array.
        swap(arr, pivotInd, end);

        // Move all smaller elements to start of array.
        for(int i = start; i < end; i++) {
            if(arr[i] < pivot) {
                swap(arr, cursor++, i);
            }
        }

        // Put pivot to right place.
        swap(arr, cursor, end);

        return cursor;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
