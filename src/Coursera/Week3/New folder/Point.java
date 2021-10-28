

import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void draw() {
    StdDraw.point(x, y);
  }


  public void drawTo(Point that) {
    StdDraw.line(this.x, this.y, that.x, that.y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public int compareTo(Point that)  {
    if (this.x == that.x && this.y == that.y) return 0;
    if (this.y > that.y || (this.y == that.y && this.x > that.x)) return 1;
    return -1;
  }

  public double slopeTo(Point that) {
    if(compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
    if (this.x == that.x) return Double.POSITIVE_INFINITY;
    if(this.y == that.y) return 0.0;
    double value = (double) (that.y - this.y) / (that.x - this.x);
    return value;

  }

  public Comparator<Point> slopeOrder() {
    return Comparator.comparingDouble(this::slopeTo);
  }
}
