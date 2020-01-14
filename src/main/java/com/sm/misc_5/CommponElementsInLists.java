package com.sm.misc_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input is list of sorted arrays.
 * Return list og elements which present in each array.
 */

public class CommponElementsInLists {

    public List<Integer> getCommon(List<List<Integer>> input) {
        List<Integer> res = new ArrayList<>();
        int lstCnt = input.size();
        int[] indexes = new int[input.size()];
        int val = Integer.MIN_VALUE;
        int cnt = 0;

        while(true) {
            for (int i = 0; i < lstCnt; i++) {
                if (indexes[i] >= input.get(i).size()) {
                    return res;
                }
                int el = input.get(i).get(indexes[i]++);
                while (el < val) {
                    if (indexes[i] >= input.get(i).size()) {
                        return res;
                    }
                    el = input.get(i).get(indexes[i]++);
                }
                if (el == val) {
                    cnt++;
                } else {
                    val = el;
                    cnt = 1;
                }
                if (cnt == lstCnt) {
                    res.add(val);
                    val = Integer.MIN_VALUE;
                }
            }
        }
    }

    public static void main(String[] args) {
        CommponElementsInLists elements = new CommponElementsInLists();
        System.out.println(">>> test");
        List<Integer> a1 = Arrays.asList(3, 5, 6, 9, 11);
        List<Integer> a2 = Arrays.asList(1, 2, 4, 5, 6, 9, 11);
        List<Integer> a3 = Arrays.asList(4, 5, 8, 9, 11);
        List<Integer> a4 = Arrays.asList(1, 2, 3, 5, 9);

        List<List<Integer>> in = new ArrayList<>();
        in.add(a1);
        in.add(a2);
        in.add(a3);
        in.add(a4);

        System.out.println(">> " + elements.getCommon(in));
    }
}
