package com.sm.misc_5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MovieRanker {
    public List<Integer> rank(List<Integer> score1, List<Integer> score2, List<Integer> score3) {
        IntStream.range(0, 10).forEach(i->System.out.print(i + " "));
        System.out.println();
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(">>>> starting movie ranker");
        MovieRanker mr = new MovieRanker();
        mr.rank(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
}
