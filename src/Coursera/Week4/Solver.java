package Coursera.Week4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Collections;

public class Solver {

  private class NodeBoard implements Comparable<NodeBoard> {

    private Board board;
    private NodeBoard parent;
    private int manhattan;
    private int fisrt;

    NodeBoard(Board initial, NodeBoard parent) {
      this.board = initial;
      this.manhattan = initial.manhattan();
      this.parent = parent;
      if (this.parent != null) {
        this.fisrt = parent.fisrt + 1;
      } else {
        this.fisrt = 0;
      }
    }

    @Override
    public int compareTo(NodeBoard o) {
      return Integer.compare(this.manhattan + this.fisrt, o.manhattan + o.fisrt);
    }
  }

  private boolean isSolve;
  private ArrayList<Board> solution;

  public Solver(Board initial) {
    if (initial == null) {
      throw new IllegalArgumentException();
    }
    isSolve = false;
    solution = new ArrayList<>();

    MinPQ<NodeBoard> pq = new MinPQ<>();
    MinPQ<NodeBoard> pqMin = new MinPQ<>();
    pq.insert(new NodeBoard(initial, null));
    pqMin.insert(new NodeBoard(initial.twin(), null));

    while (!pq.isEmpty()) {
      NodeBoard here = pq.delMin();
      NodeBoard hereMin = pqMin.delMin();

      if (here.board.isGoal()) {
        isSolve = true;
        while (here.parent != null) {
          solution.add(here.board);
          here = here.parent;
        }
        solution.add(initial);
        Collections.reverse(solution);
        return;
      }

      if (hereMin.board.isGoal()) {
        isSolve = false;
        while (hereMin.parent != null) {
          solution.add(hereMin.board);
          hereMin = hereMin.parent;
        }
        solution.add(initial);
        Collections.reverse(solution);
        return;
      }

      for (Board neighbor : here.board.neighbors()) {
        if (here.parent == null || !neighbor.equals(here.parent.board)) {
          pq.insert(new NodeBoard(neighbor, here));
        }
      }

      for (Board neighbor : hereMin.board.neighbors()) {
        if (hereMin.parent == null || !neighbor.equals(hereMin.parent.board)) {
          pqMin.insert(new NodeBoard(neighbor, hereMin));
        }
      }
    }
  }

  // is the initial board solvable? (see below)
  public boolean isSolvable() {
    return isSolve;
  }

  // min number of moves to solve initial board; -1 if unsolvable
  public int moves() {
    if(!isSolve) return -1;
    return solution.size() - 1;
  }

  // sequence of boards in a shortest solution; null if unsolvable
  public Iterable<Board> solution() {
    if (!isSolve) {
      return null;
    }
    return solution;
  }

  // test client (see below)
  public static void main(String[] args) {

    int[][] tiles = {{3, 2, 4, 8}, {1, 6, 0, 12}, {5, 10, 7, 11}, {9, 13, 14, 15}};
    Board initial = new Board(tiles);

    // solve the puzzle
    Solver solver = new Solver(initial);

    // print solution to standard output
    if (!solver.isSolvable()) {
      StdOut.println("No solution possible");
    } else {
      StdOut.println("Minimum number of moves = " + solver.moves());
      for (Board board : solver.solution()) {
        StdOut.println(board);
      }
    }
  }

}
