package com.sm.misc_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RangeUtils {
    public List<int[]> buildRanges(int[] arr) {
        List<int[]> res = new ArrayList<>();
        int start = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                res.add(new int[]{start, arr[i - 1]});
                start = arr[i];
            }
        }
        if (start == arr[arr.length - 1]) {
            res.add(new int[]{start, arr[arr.length - 1]});
        }

        return res;
    }

    public List<int[]> buildRanges(List<int[]> r1, List<int[]> r2) {
        if (r1 == null && r2 == null) {
            return new ArrayList<>();
        }
        if (r1 == null || r2 == null) {
            return r1 == null? r2:r1;
        }

        Iterator<int[]> itr = new Iterator<int[]>() {
            int cursor1 = 0;
            int cursor2 = 0;
            @Override
            public boolean hasNext() {
                return cursor1 < r1.size() || cursor2 < r2.size();
            }

            @Override
            public int[] next() {
                if (cursor1 < r1.size() && cursor2 < r2.size()) {
                    return (r1.get(cursor1)[0] < r2.get(cursor2)[0]) ? r1.get(cursor1++) : r2.get(cursor2++);
                }
                if (cursor1 < r1.size()) {
                    return r1.get(cursor1++);
                }
                if (cursor2 < r2.size()) {
                    return r2.get(cursor2++);
                }
                throw new NoSuchElementException();
            }
        };

        List<int[]> res = new ArrayList<>();
        int[] arr = itr.next();
        while(itr.hasNext()) {
            int[] arrNext = itr.next();
            if (arrNext[0] - arr[1] > 1) {
                res.add(arr);
                arr = arrNext;
            } else {
                arr[1] = Math.max(arr[1], arrNext[1]);
            }
        }
        res.add(arr);

        return res;
    }


    public static void main(String[] args) {
        System.out.println(">>> start...");
        RangeUtils ru = new RangeUtils();
        List<int[]> r1 = ru.buildRanges(new int[]{1, 2, 3, 5, 8, 10, 11});
        List<int[]> r2 = ru.buildRanges(new int[]{ 2, 3, 4, 5, 6, 14});
        r1.forEach(x -> System.out.print("[" + x[0] +
                "-" + x[1] + "] "));
        System.out.println();
        r2.forEach(x -> System.out.print("[" + x[0] +
                "-" + x[1] + "] "));

        System.out.println();
        ru.buildRanges(r1, r2).forEach(x -> System.out.print("[" + x[0] +
                "-" + x[1] + "] "));

    }
}
