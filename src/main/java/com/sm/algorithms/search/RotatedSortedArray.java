package com.sm.algorithms.search;

public class RotatedSortedArray {
    public int findTarget(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            // split array in two , only one of them contains rotation point.
            if (arr[left] <= arr[mid] ){ // if left part sorted , no rotation point
                if (arr[left] <= target && arr[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // if left part contains rotation point
                if (arr[right] >= target && arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr[left] <= arr[right]) {
            return arr[left];
        }

        while(left <= right) {
            int mid = (left + right) /2;
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            if (arr[left] <= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left];
    }
}
