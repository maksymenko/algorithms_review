package com.sm;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    private Map<String, Integer> cache = new TreeMap<>();
    private Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((b, a) -> Integer.compare(a.getValue(), b.getValue()));
    private String phrase = "";

    public Runner(String[] sentences, int[] times) {
        if (sentences == null || times == null || sentences.length != times.length) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < times.length; i++) {
            cache.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        Set<Map.Entry<String, Integer>> res = new TreeSet<>(
                Comparator.<Map.Entry<String, Integer>>comparingInt(a->a.getValue())
                        .reversed()
                        .thenComparing((a, b)->a.getKey().compareTo(b.getKey())));
        if (c == '#' && phrase.length() > 0) {
            int freq = cache.getOrDefault(phrase, 0);
            freq++;
            cache.put(phrase, freq);
            phrase = "";
            q.clear();
            return new ArrayList<>();
        }
        phrase += c;
        q.clear();
        System.out.println(">>> cache: " + cache);
        if (q.isEmpty()) {
            for(Map.Entry<String, Integer> entry: cache.entrySet()) {
                if (entry.getKey().startsWith(phrase)) {
                    res.add(entry);
                    //q.add(entry);
                } else if (res.size() > 0) {
                    break;
                }
            }
//            while(!q.isEmpty() && res.size() < 3) {
//                res.add(q.poll());
//            }
//            for(Map.Entry entry: res) {
//                q.add(entry);
//            }
        }
        else {
            Queue<Map.Entry<String, Integer>> tmpQ = new PriorityQueue<>((b, a) -> Integer.compare(a.getValue(), b.getValue()));
            while(!q.isEmpty()) {
                Map.Entry<String, Integer> entry = q.poll();
                if (entry.getKey().startsWith(phrase)) {
                    tmpQ.add(entry);
                    if (res.size() < 3) {
                        res.add(entry);
                    }
                }
            }
            q = tmpQ;
        }


        return res.stream().map(x -> x.getKey()).limit(3).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println(">>>> start.......");

        Runner r = new Runner(new String[]{"abc","abbc","a"},
                new int[]{3,3,3});
        System.out.println(">> b: " + r.input('b'));
        System.out.println(">> 'c': " + r.input('c'));
        System.out.println(">> '#': " + r.input('#'));
        System.out.println(">> 'b': " + r.input('b'));
        System.out.println(">> c: " + r.input('c'));


    }

}
