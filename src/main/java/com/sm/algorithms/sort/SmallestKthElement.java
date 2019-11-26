package com.sm.algorithms.sort;

import java.util.Random;

public class SmallestKthElement {
    private Random rnd = new Random();
    // K from 1 - arr.length
    public int find(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException();
        }

        quick(arr, 0, arr.length - 1, k);

        return arr[k - 1];
    }

    private void quick(int[] arr, int start, int end, int k) {
        if (start == end) {
            return;
        }

        int pivotInd = partition(arr, start, end);

        if (pivotInd == k) {
            return;
        }

        if (pivotInd < k) {
            quick(arr, pivotInd + 1, end, k);
        } else {
            quick(arr, start, pivotInd - 1, k);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivotInd = start + rnd.nextInt(end - start);
        int pivot = arr[pivotInd];
        int cursor = start;
        swap(arr, pivotInd, end);

        // Move smaller elements to start.
        for(int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, cursor++);
            }
        }

        // Put pivot to right position
        swap(arr, end, cursor);

        return cursor;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
