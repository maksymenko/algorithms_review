package com.sm;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(7);
        set.add(3);
        set.add(5);
        set.add(9);
        set.add(2);

        while(!set.isEmpty()) {
            System.out.println(">>> " + set.pollFirst());
        }




    }

}
