package com.sm.algorithms.dp;

import java.util.Arrays;

public class RobotInGrid {

  public void findPath(boolean[][] grid) {
    if (grid == null || grid.length < 1 || grid[0].length < 1 || grid[grid.length - 1][grid[0].length - 1] == false) {
      System.out.println(">> solution does not exist");
    }

    int destR = grid.length - 1;
    int destC = grid[0].length - 1;
    char solution[][] = new char[grid.length][grid[0].length];
    for (int i = 0; i < solution.length; i++) {
      Arrays.fill(solution[i], ' ');
    }

    move(grid, 0, 0, 'r', solution);
    //move(grid, 1, 0, 'd', solution);

    if (solution[destR][destC] == ' ') {
      System.out.println(">>> Solution doesn't exist");
      return;
    }
    int curR = destR;
    int curC = destC;
    while (curR >= 0 && curC >= 0) {
      System.out.println(" " + curR + ":" + curC);
      if (solution[curR][curC] == 'r') {
        curC--;
      } else if ((solution[curR][curC] == 'd')) {
        curR--;
      } else {
        return;
      }
    }
  }

  private void move(boolean[][] grid, int destR, int destC, char direction, char[][] solution) {
    if (destR == solution.length || destC == solution[0].length) {
      return;
    }

    if (grid[destR][destC] && solution[destR][destC] == ' ') {
      solution[destR][destC] = direction;

      move(grid, destR + 1, destC, 'd', solution);
      move(grid, destR, destC + 1, 'r', solution);

    }
  }

  public static void main(String[] args) {
    RobotInGrid robotInGrid = new RobotInGrid();
    robotInGrid.findPath(new boolean[][]{
        {true, true, true, false},
        {true, true, false, true},
        {true, true, true, true},
        {false, true, false, true},
        {true, true, true, true}
    });
  }
}
