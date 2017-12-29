package com.sm.algorithms.recurcsion;

public class EightQueen {
  boolean[] markedRows = new boolean[8];
  boolean[] markedCols = new boolean[8];
  boolean[] markedLr = new boolean[15];
  boolean[] markedRl = new boolean[15];
  int count = 0;

  public void findOptions() {

    addQueen(0, new int[8]);
  }

  private void addQueen(int r, int[] columns) {
    if (r >= 8) {
      showDesk(columns);
      return;
    }

    for (int c = 0; c < 8; c++) {
      if (isNotBlocked(r, c)) {
        mark(r, c, true);
        columns[r] = c;
        addQueen(r + 1, columns);
        mark(r, c, false);
      }
    }
  }

  private void mark(int row, int col, boolean isSet) {
    markedRows[row] = isSet;
    markedCols[col] = isSet;
    markedLr[7 + col - row] = isSet;
    markedRl[col + row] = isSet;
  }

  private boolean isNotBlocked(int row, int col) {
    if (markedRows[row] == false
        && markedCols[col] == false
        && markedLr[7 + col - row] == false
        && markedRl[col + row] == false) {
      return true;
    }
    return false;
  }

  private void showDesk(int[] columns) {
    System.out.println(++count + " ==================");
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        System.out.print(columns[c] == r ? " x" : " *");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    EightQueen eightQueen = new EightQueen();
    eightQueen.findOptions();
  }
}
