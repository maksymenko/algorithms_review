package com.sm.algorithms.dp;

/**
 * Top Down solution with memoization
 */
public class MinCostPathTopDown {
  public void findPath(int[][] grid) {
    PathPoint[][] costGrid = new PathPoint[grid.length][grid[0].length];
    int destR = grid.length - 1;
    int destC = grid[0].length - 1;

    move(costGrid, destR, destC, 0,'f', grid);

    // Reconstruction
    int curR = 0;
    int curC = 0;
    while(costGrid[curR][curC].direction != 'f') {
      System.out.println("" + curR + ":" + curC);
      if (costGrid[curR][curC].direction == 'd') {
        curR++;
        curC++;
      } else if (costGrid[curR][curC].direction == 't') {
        curR++;
      } else {
        curC++;
      }
    }
    System.out.println("" + curR + ":" + curC);
  }

  private void move(PathPoint[][] costGrid, int destR, int destC, int srcCost, char direction, int[][] grid) {
    if (destR < 0 || destC < 0) {
      return;
    }

    int newCost = grid[destR][destC] + srcCost;
    PathPoint pathPoint = costGrid[destR][destC];
    if (pathPoint == null) {
      costGrid[destR][destC] = new PathPoint(newCost, direction);
    } else {
      if (newCost < pathPoint.cost) {
        pathPoint.cost = newCost;
        pathPoint.direction = direction;
      }
    }

    pathPoint = costGrid[destR][destC];

    if(destR > 0) {
      move(costGrid, destR - 1, destC, pathPoint.cost, 't', grid);
    }

    if(destC > 0) {
      move(costGrid, destR, destC - 1, pathPoint.cost, 'l', grid);
    }

    if(destC > 0 && destR > 0) {
      move(costGrid, destR - 1, destC - 1, pathPoint.cost, 'd', grid);
    }
  }

  private static class PathPoint{
    int cost = -1;
    char direction = ' ';

    public PathPoint(int cost, char direction) {
      this.cost = cost;
      this.direction = direction;
    }
  }

  public static void main(String[] args) {
    MinCostPathTopDown minCostPath = new MinCostPathTopDown();
    minCostPath.findPath(new int[][]{
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}
    });
  }

}
