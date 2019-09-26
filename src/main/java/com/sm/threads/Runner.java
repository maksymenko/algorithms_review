package com.sm.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public void doAsync() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<String>> f = new ArrayList<>();
        f.add( es.submit(() -> {
            System.out.println(">>>" + Thread.currentThread().getId());
            return "done1";
        }));

        f.add( es.submit(() -> {
            System.out.println(">>>" + Thread.currentThread().getId());
            return "done2";
        }));

        f.add( es.submit(() -> {
            System.out.println(">>>" + Thread.currentThread().getId());
            return "done3";
        }));

        f.add( es.submit(() -> {
            System.out.println(">>>" + Thread.currentThread().getId());
            return "done4";
        }));


        f.forEach(ff-> {
            try {
                System.out.println(ff.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runner r = new Runner();
        r.doAsync();
    }
}
