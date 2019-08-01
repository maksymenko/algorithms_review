package com.sm.misc_4;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> lru;

    public LRUCache(int capacity) {
        lru = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        int val = lru.getOrDefault(key, -1);
        if (val != -1) {
            lru.remove(key);
            lru.put(key, val);
        }
        return val;
    }

    public void put(int key, int value) {
        lru.remove(key);
        lru.put(key, value);
    }

    public void print() {
        lru.forEach((k, v) -> {
            System.out.print(k + ":" + v + "  ");
        });
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println(">>>>> lru");
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, 1);
        lruCache.print();
        lruCache.put(2, 2);
        lruCache.print();
        lruCache.put(3, 3);
        lruCache.print();
        lruCache.get(1);
        lruCache.print();
        lruCache.put(3, 3);
        lruCache.print();
        lruCache.put(4, 4);
        lruCache.print();
        lruCache.put(5, 5);
        lruCache.print();


    }
}
