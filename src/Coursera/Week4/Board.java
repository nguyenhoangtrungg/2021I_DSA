package Coursera.Week4;

import java.util.ArrayList;

public class Board {

  private int[][] board;
  private int number;

  // create a board from an n-by-n array of tiles,
  // where tiles[row][col] = tile at (row, col)
  public Board(int[][] tiles) {
    if (tiles == null) {
      throw new IllegalArgumentException();
    }
    number = tiles.length;
    board = new int[number + 5][number + 5];
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        board[i][j] = tiles[i][j];
      }
    }
  }

  // string representation of this board
  public String toString() {
    StringBuilder result = new StringBuilder(number + "\n");
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        result.append(board[i][j]).append(" ");
      }
      result.append("\n");
    }
    return result.toString();
  }

  // board dimension n
  public int dimension() {
    return number;
  }

  // number of tiles out of place
  public int hamming() {
    int cnt = 0;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        if (board[i][j] != realData(i, j)) {
          cnt++;
        }
      }
    }
    return --cnt;
  }

  // sum of Manhattan distances between tiles and goal
  public int manhattan() {
    int cnt = 0;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        int dataInBoard = board[i][j];
        if (dataInBoard != realData(i, j)) {
          cnt += Math.abs(i - dataInBoard) + Math.abs(j - dataInBoard);
        }
      }
    }
    return cnt;
  }

  // is this board the goal board?
  public boolean isGoal() {
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        if (board[i][j] != realData(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  // does this board equal y?
  public boolean equals(Object y) {
    if (y == this) {
      return true;
    }
    if (y == null || y.getClass() != this.getClass()) {
      return false;
    }
    Board that = (Board) y;
    if (that.dimension() != this.dimension()) {
      return false;
    }
    for (int i = 0; i < board.length; i++) {
      if (this.board[i] != that.board[i]) {
        return false;
      }
    }
    return true;
  }

  // all neighboring boards
  public Iterable<Board> neighbors() {
    int u, v;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        if (board[i][j] == 0) {
          u = i;
          v = j;
        }
      }
    }

    ArrayList<Board> arrayList = new ArrayList<>();


    return null;
  }

  // a board that is obtained by exchanging any pair of tiles
  public Board twin() {
    return null;
  }

  private int realData(int u, int v) {
    return (u + 1) * (v + 1);
  }

  // unit testing (not graded)
  public static void main(String[] args) {
  }

}
