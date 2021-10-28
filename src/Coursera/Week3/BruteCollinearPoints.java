package Coursera.Week3;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BruteCollinearPoints {

  private int numberOfSegments;
  private LineSegment[] lineSegments;

  public BruteCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException();
    }
    for (Point point : points) {
      if (point == null) {
        throw new IllegalArgumentException();
      }
    }

    Point[] tempPoints = points.clone();
    Arrays.sort(tempPoints);

    int number = points.length;
    ArrayList<LineSegment> temp = new ArrayList<>();

    if (hasDuplicate(tempPoints)) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < number - 3; i++) {
      for (int j = i + 1; j < number - 2; j++) {
        double ijSlope = tempPoints[i].slopeTo(tempPoints[j]);
        for (int k = j + 1; k < number - 1; k++) {
          for (int l = k + 1; l < number; l++) {
            double klSlope = tempPoints[k].slopeTo(tempPoints[l]);
            if (check(tempPoints[i],tempPoints[j],tempPoints[k],tempPoints[l])) {
              temp.add(new LineSegment(tempPoints[i], tempPoints[l]));
              numberOfSegments++;
            }
          }
        }
      }
    }
    lineSegments = temp.toArray(new LineSegment[0]);
  }

  private boolean check(Point point, Point point1, Point point2, Point point3) {
    double slop1 = point.slopeTo(point1);
    double slop2 = point.slopeTo(point2);
    double slop3 = point.slopeTo(point3);
    return slop1 == slop2 && slop1 == slop3;
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
    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      StdOut.println(segment);
      segment.draw();
    }
    StdDraw.show();
    System.out.println(collinear.numberOfSegments);
  }

}
