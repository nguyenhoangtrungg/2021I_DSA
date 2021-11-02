package Coursera.Week4;

import java.util.ArrayList;

public class Board {

  private final int[][] board;
  private final int number;

  // create a board from an n-by-n array of tiles,
  // where tiles[row][col] = tile at (row, col)
  public Board(int[][] tiles) {
    if (tiles == null) {
      throw new IllegalArgumentException();
    }
    number = tiles.length;
    board = new int[number][number];
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
        if (dataInBoard == 0) {
          continue;
        }
        if (dataInBoard != realData(i, j)) {
          int realX = (dataInBoard - 1) / number;
          int realY = (dataInBoard - 1) % number;
          cnt += Math.abs(i - realX) + Math.abs(j - realY);
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
          return i == number - 1 && j == number - 1;
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
      for (int j = 0; j < board.length; j++) {
        if (this.board[i][j] != that.board[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  // all neighboring boards
  public Iterable<Board> neighbors() {
    int u = 0, v = 0;
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        if (board[i][j] == 0) {
          u = i;
          v = j;
        }
      }
    }

    ArrayList<Board> arrayList = new ArrayList<>();

    if (u > 0) {
      arrayList.add(swap(u, v, u - 1, v));
    }

    if (u < number - 1) {
      arrayList.add(swap(u, v, u + 1, v));
    }

    if (v > 0) {
      arrayList.add(swap(u, v, u, v - 1));
    }

    if (v < number - 1) {
      arrayList.add(swap(u, v, u, v + 1));
    }
    return arrayList;
  }

  // a board that is obtained by exchanging any pair of tiles
  public Board twin() {
    if (board[0][0] != 0 && board[0][1] != 0) {
      return swap(0, 0, 0, 1);
    } else {
      return swap(1, 0, 1, 1);
    }
  }

  private Board swap(int u, int v, int U, int V) {
    int[][] tmpBoard = new int[number][number];
    for (int i = 0; i < number; i++) {
      System.arraycopy(board[i], 0, tmpBoard[i], 0, number);
    }
    tmpBoard[u][v] = board[U][V];
    tmpBoard[U][V] = board[u][v];
    return new Board(tmpBoard);
  }

  private int realData(int u, int v) {
    return u * number + (v + 1);
  }

  // unit testing (not graded)
  public static void main(String[] args) {
    int[][] a = {{3, 0, 2}, {8, 1, 6}, {7, 5, 4}};
    int[][] b = {{3, 0, 2}, {8, 1, 6}, {7, 5, 4}};
    Board board1 = new Board(a);
    Board board2 = new Board(b);
    System.out.println(board1.equals(board2));
  }
}
