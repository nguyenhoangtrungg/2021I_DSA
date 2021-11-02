package Coursera.Week3;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FastCollinearPoints {

  private int numberOfSegments;
  private LineSegment[] lineSegments;

  public FastCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException();
    }
    for (Point point : points) {
      if (point == null) {
        throw new IllegalArgumentException();
      }
    }

    int number = points.length;
    Point[] tempPoints = points.clone();
    Point[] head = new Point[100001];
    Arrays.sort(tempPoints);
    ArrayList<LineSegment> temp = new ArrayList<>();

    for (int i = 1; i < number; i++) {
      if (tempPoints[i].compareTo(tempPoints[i - 1]) == 0) {
        throw new IllegalArgumentException();
      }
    }

    if (hasDuplicate(tempPoints)) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < number; i++) {
      Point[] cmpPoints = tempPoints.clone();
      Arrays.sort(cmpPoints, i, number, tempPoints[i].slopeOrder());

      ArrayList<Double> slope = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        slope.add(0.0);
      }

      for (int j = i + 1; j < number; j++) {
        slope.add(cmpPoints[i].slopeTo(cmpPoints[j]));
      }
      double Here = slope.get(0);
      int Count = 0;
      for (int k = i + 1; k < slope.size(); k++) {
        if (Here == slope.get(k)) {
          Count++;
        } else if (Here != slope.get(k)) {
          if (Count >= 3) {
            boolean ok = true;
            for (int l = 0; l < numberOfSegments; l++) {
              Point cmpPo = head[l];
              double cmp = cmpPo.slopeTo(cmpPoints[i]);
              if (cmp == Here) {
                ok = false;
                break;
              }
            }
            if (ok) {
              temp.add(new LineSegment(cmpPoints[i], cmpPoints[k - 1]));
              head[numberOfSegments] = cmpPoints[i];
              numberOfSegments++;
            }
          }
          Here = slope.get(k);
          Count = 1;
        }
      }

      if (Count >= 3) {
        boolean ok = true;
        for (int l = 0; l < numberOfSegments; l++) {
          Point cmpPo = head[l];
          double cmp = cmpPo.slopeTo(cmpPoints[i]);
          if (cmp == Here) {
            ok = false;
            break;
          }
        }
        if (ok) {
          temp.add(new LineSegment(cmpPoints[i], cmpPoints[number - 1]));
          head[numberOfSegments] = cmpPoints[i];
          numberOfSegments++;
        }
      }

      if (numberOfSegments == number-1) break;
    }
    lineSegments = temp.toArray(new LineSegment[0]);
  }

  private boolean hasDuplicate(Point[] points) {
    for (int i = 0; i < points.length - 1; i++) {
      if (points[i].compareTo(points[i + 1]) == 0) {
        return true;
      }
    }
    return false;
  }

  public int numberOfSegments() {
    return numberOfSegments;
  }

  public LineSegment[] segments() {
    return lineSegments.clone();
  }

  public static void main(String[] args) {

    // read the n points from a file
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      points[i] = new Point(x, y);
    }

    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      StdOut.println(segment);
      segment.draw();
    }
    StdDraw.show();
    System.out.println(collinear.numberOfSegments);
  }
}
