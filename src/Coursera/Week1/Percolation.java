package Coursera.Week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private final boolean[] sites;
  private final WeightedQuickUnionUF weightedQuickUnionUF;
  private final WeightedQuickUnionUF isFull;
  private final int number;
  private int numberOfOpenSites;

  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    sites = new boolean[n * n + 5];
    weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
    isFull = new WeightedQuickUnionUF(n * n + 2);
    number = n;
    numberOfOpenSites = 0;
  }

  public void open(int row, int column) {
    if (!isInSide(row, column)) {
      throw new IllegalArgumentException();
    }
    int pos = position(row, column);
    if (!sites[pos]) {
      numberOfOpenSites++;
      sites[pos] = true;
      if (row == 1) {
        weightedQuickUnionUF.union(0, pos);
        isFull.union(0, pos);
      } else if (sites[pos - number]) {
        weightedQuickUnionUF.union(pos, pos - number);
        isFull.union(pos,pos - number);
      }
      if (row == number) {
        weightedQuickUnionUF.union(number * number + 1, pos);
      } else if (sites[pos + number]) {
        weightedQuickUnionUF.union(pos, pos + number);
        isFull.union(pos,pos + number);
      }
      if (column > 1 && sites[pos - 1]) {
        weightedQuickUnionUF.union(pos, pos - 1);
        isFull.union(pos,pos - 1);
      }
      if (column < number && sites[pos + 1]) {
        weightedQuickUnionUF.union(pos, pos + 1);
        isFull.union(pos,pos + 1);
      }
    }
  }

  public boolean isOpen(int row, int column) {
    if (!isInSide(row, column)) {
      throw new IllegalArgumentException();
    }
    return sites[position(row, column)];
  }

  public boolean isFull(int row, int column) {
    if (!isInSide(row, column)) {
      throw new IllegalArgumentException();
    }
    int pos = position(row, column);
    return isFull.find(0) == isFull.find(pos);
  }

  public int numberOfOpenSites() {
    return numberOfOpenSites;
  }

  public boolean percolates() {
    return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(number * number + 1);
  }

  private int position(int row, int column) {
    return (row - 1) * number + column;
  }

  private boolean isInSide(int row, int column) {
    return row >= 1 && column >= 1 && row <= number && column <= number;
  }

  public static void main(String[] args) {
    Percolation percolation = new Percolation(6);
    percolation.open(1, 1);
    percolation.open(2, 1);
    //percolation.open(3, 1);
    percolation.open(4, 1);
    percolation.open(5, 1);
    percolation.open(6, 1);
    System.out.println(percolation.isFull(2,1));
  }
}
