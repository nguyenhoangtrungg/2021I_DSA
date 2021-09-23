package Week3;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class ThreeSum {

  public static void main(String[] args) {
    In in = new In("E:\\GitHub\\2021I_DSA\\src\\Week2\\8Kints.txt");
    int[] a = in.readAllInts();
    int n = a.length;

    Arrays.sort(a, 0, n);

    for(int i = 0; i < n; i++) {
      int l = i, r = n - 1;
      while (l <= r) {
        if (a[l] + a[r] + a[i] == 0) {
          System.out.println(a[i] + " " + a[l] + " " + a[r]);
          l++;
          r--;
        } else if (a[l] + a[r] + a[i] > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
  }
}