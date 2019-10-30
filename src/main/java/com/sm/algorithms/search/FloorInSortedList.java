package com.sm.algorithms.search;

public class FloorInSortedList {

    private int floorIndex(int target, int[] arr){
        int low = 0;
        int high = arr.length - 1;

        return floorIndex(target, low, high,  arr);
    }
    private int floorIndex(int target, int low, int high, int[] arr) {
        while(low <= high) {
            if (target >= arr[high]) {
                return high;
            }
            if (target < arr[low]) {
                return -1;
            }
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return mid;
            }

            if (target > arr[mid]) {
                low = mid + 1;
                if (target < arr[low]) {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        FloorInSortedList floorInSortedList = new FloorInSortedList();
        System.out.println(">>>> " + floorInSortedList.floorIndex(5, new int[]{1, 3, 4, 6, 11}));
    }
}
