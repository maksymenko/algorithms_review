package com.sm.algorithms.dp;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostPathDijksta {
  public void findPath(int[][] grid) {
    Queue<Dist> pq = new PriorityQueue<>();
    char[][] solution = new char[grid.length][grid[0].length];
    int[][] cost = new int[grid.length][grid[0].length];


    for (int i = 0; i < grid.length; i++) {
      Arrays.fill(solution[i], ' ');
      Arrays.fill(cost[i], Integer.MAX_VALUE);
    }

    pq.add(new Dist(grid[0][0], 0, 0));
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        relax(pq.poll(), grid, pq, solution, cost);
      }
    }

    System.out.println(">>>> min cost: " + cost[grid.length - 1][grid[0].length - 1]);

    // Reconstruct path.
    int curR = 0;
    int curC = 0;
    while(curR + 1 < grid.length || curC + 1 < grid[0].length) {
      System.out.println("" + curR + ":" + curC);
      if (solution[curR][curC] == 'r') {
        curC++;
      } else if (solution[curR][curC] == 'd') {
        curR++;
      } else if (solution[curR][curC] == 'c'){
        curR++;
        curC++;
      } else {
        System.out.println(">>>> " + curR + ":" + curC + "  moved '" + solution[curR][curC] + "'");
        return;
      }
    }
    System.out.println("" + curR + ":" + curC);
  }

  private void relax(Dist dist, int[][] grid, Queue<Dist> pq, char[][] solution, int[][] cost) {
    int min = Integer.MAX_VALUE;
    if (dist.row + 1 < grid.length) {
      int newDistCost = grid[dist.row + 1][dist.col] + dist.dist;
      if (cost[dist.row + 1][dist.col] > newDistCost) {
        cost[dist.row + 1][dist.col] = newDistCost;
        Dist newDist = new Dist(newDistCost, dist.row + 1, dist.col);
        pq.add(newDist);

        if (min > newDistCost) {
          solution[dist.row][dist.col] = 'd';
          min = newDistCost;
        }
      }
    }

    if (dist.col + 1 < grid[0].length) {
      int newDistCost = grid[dist.row][dist.col + 1] + dist.dist;
      if (cost[dist.row][dist.col + 1] > newDistCost) {
        cost[dist.row][dist.col + 1] = newDistCost;
        Dist newDist = new Dist(newDistCost, dist.row, dist.col + 1);
        pq.add(newDist);
        if (min > newDistCost) {
          solution[dist.row][dist.col] = 'r';
          min = newDistCost;
        }
      }
    }

    if (dist.row + 1 < grid.length && dist.col + 1 < grid[0].length) {
      int newDistCost = grid[dist.row + 1][dist.col + 1] + dist.dist;
      if (cost[dist.row + 1][dist.col + 1] > newDistCost) {
        cost[dist.row + 1][dist.col + 1] = newDistCost;
        Dist newDist = new Dist(newDistCost, dist.row + 1, dist.col + 1);
        pq.add(newDist);

        if (min > newDistCost) {
          solution[dist.row][dist.col] = 'c';
        }
      }
    }
  }

  private static class Dist implements Comparable<Dist> {
    int dist;
    int row;
    int col;

    public Dist(int dist, int row, int col) {
      this.dist = dist;
      this.row = row;
      this.col = col;
    }

    @Override
    public int compareTo(Dist other) {
      if (other == null) {
        return 1;
      }
      if (this.dist < other.dist) {
        return -1;
      } else if (this.dist > other.dist) {
        return 1;
      }
      return 0;
    }
  }


  public static void main(String[] args) {
    MinCostPathDijksta minCostPath = new MinCostPathDijksta();
    minCostPath.findPath(new int[][]{
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}
    });
  }
}
