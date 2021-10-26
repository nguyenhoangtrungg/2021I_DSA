package Coursera.Week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private final double mean;
  private final double stddev;
  private final double confidenceLo;
  private final double confidenceHi;
  private static final double CONFIDENCE = 1.96;

  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }

    double[] res = new double[trials + 5];
    for (int i = 0; i < trials; i++) {
      Percolation percolation = new Percolation(n);
      while (!percolation.percolates()) {
        int x = StdRandom.uniform(1, n + 1);
        int y = StdRandom.uniform(1, n + 1);
        percolation.open(x, y);
      }
      res[i] = (double) percolation.numberOfOpenSites() / (n * n);
    }
    mean = StdStats.mean(res);
    stddev = StdStats.stddev(res);
    confidenceLo = mean - CONFIDENCE * stddev / Math.sqrt(trials);
    confidenceHi = mean + CONFIDENCE * stddev / Math.sqrt(trials);
  }

  public double mean() {
    return mean;
  }

  public double stddev() {
    return stddev;
  }

  public double confidenceLo() {
    return confidenceLo;
  }

  public double confidenceHi() {
    return confidenceHi;
  }

  public static void main(String[] args) {
    int n = 1, trial = 1;
    if (args.length >= 2) {
      n = Integer.parseInt(args[0]);
      trial = Integer.parseInt(args[1]);
    }

    PercolationStats percolationStats = new PercolationStats(n, trial);
    StdOut.println("mean                    = " + percolationStats.mean());
    StdOut.println("stddev                  = " + percolationStats.stddev());
    StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo()
        + ", " + percolationStats.confidenceHi() + "]");
  }

}
