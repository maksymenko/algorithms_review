package com.sm.misc_5;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RoomBooker {
    private Set<Range> reserved = new TreeSet<>();
    public boolean add(int startTime, int endTime) {
        return true;
    }

    private static class Range  {
        int start;
        int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
