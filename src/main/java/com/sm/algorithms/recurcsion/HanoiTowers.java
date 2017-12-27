package com.sm.algorithms.recurcsion;

import java.util.ArrayDeque;
import java.util.Deque;

public class HanoiTowers {
    Deque<Integer> origin = new ArrayDeque<>();
    Deque<Integer> aux = new ArrayDeque<>();
    Deque<Integer> target = new ArrayDeque<>();

  public void move(int diskCount) {
    for (int i = 0; i < diskCount; i++) {
      origin.push(i);
    }


    moveVariantOne(5, 1, origin, 2, aux, 3, target);

    moveVariantTwo(0, 1, 2, 3);

  }

  private void moveVariantTwo(int diskCount, int origin, int aux, int target) {
    if (diskCount == 1) {
      System.out.println(" move " + diskCount + " : " + origin + " -> " + target);
    } else {
      moveVariantTwo(diskCount - 1, origin, target, aux);
      System.out.println(" move " + diskCount + " : " + origin + " -> " + target);
      moveVariantTwo(diskCount - 1, aux, origin, target);
    }
  }

  private void moveVariantOne(int diskNum, int originNum, Deque<Integer> origin, int auxNum, Deque<Integer> aux, int targetNum, Deque<Integer> target) {
    if (diskNum > 0) {
      moveVariantOne(diskNum - 1, originNum, origin, targetNum, target, auxNum, aux);

      int disk = origin.pop();
      target.push(disk);
      System.out.println("> " + disk + " move " +  originNum + " -> " + targetNum);

      moveVariantOne(diskNum - 1, auxNum, aux, originNum, origin, targetNum, target);
    }
  }

  public static void main(String[] args) {
    HanoiTowers towers = new HanoiTowers();

    towers.move(5);
  }
}
