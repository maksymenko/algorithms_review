package com.sm.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadSum {
    public int sumRange(int start, int end, int chunkSize) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureRes = new ArrayList<>();

        for (int i = start; i < end; i += chunkSize) {
            final int n = i;
            futureRes.add(es.submit(() -> {
                int sum = 0;
                int rangeEnd = Math.min(end, n + chunkSize);
                for (int j = n; j < rangeEnd; j++) {
                    sum += j;
                }
                Thread.sleep(10);
                System.out.println(">>> thread: " + Thread.currentThread().getName() + " start " + n + " end: " + rangeEnd + " sum: " + sum);
                return sum;
            }));
        }

        es.shutdown();

        return futureRes.stream().map(a -> {
            try {
                return a.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return 0;
        }).reduce((a, b) -> a + b).get();

    }


    public static void main(String[] args) {
        MultiThreadSum mts = new MultiThreadSum();
        System.out.println(">>> " + mts.sumRange(2, 30, 3));

    }
}
