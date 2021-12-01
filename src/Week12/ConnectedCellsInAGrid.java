package Week12;

import java.util.*;


public class ConnectedCellsInAGrid {

  class Cell {

    public int r, c;

    public Cell(int i, int j) {
      r = i;
      c = j;
    }
  }

  static int[] dx = {1, -1, 1, -1, 0, 0, 1, -1};
  static int[] dy = {1, -1, -1, 1, 1, -1, 0, 0};

  static int[][] grid;
  static boolean[][] visited;
  static int N, M;

  static boolean isIn(int u, int v) {
    return (u >= 0 && v >= 0 && u < N && v < M);
  }

  static int dfs(int row, int cow) {
    visited[row][cow] = true;
    int rank = 1;
    for (int i = 0; i < 8; i++) {
      int u = row + dx[i];
      int v = cow + dy[i];
      if (!visited[u][v] && grid[u][v] == 1 && isIn(u, v)) {
        rank += dfs(u, v);
      }
    }
    return rank;
  }

  static int count_connected(int row, int col) {
    int cnt = 0;
    cnt = dfs(row, col);
    return cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();
    M = scanner.nextInt();
    grid = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        grid[i][j] = scanner.nextInt();
        visited[i][j] = false;
      }
    }
    int max = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (grid[i][j] == 0 || visited[i][j]) {
          continue;
        }
        int cnt = count_connected(i, j);
        if (max < cnt) {
          max = cnt;
        }
      }
    }

    System.out.println(max);

  }
}
