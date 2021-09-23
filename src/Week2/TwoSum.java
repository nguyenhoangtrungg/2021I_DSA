package Week2;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class TwoSum {

  public static void main(String[] args) {
    In in = new In("E:\\GitHub\\2021I_DSA\\src\\Week2\\1Kints.txt");
    int[] a = in.readAllInts();
    int n = a.length;

    Arrays.sort(a, 0, n);

    int l = 0, r = n - 1;

    while (l <= r) {
      if (a[l] + a[r] == 0) {
        System.out.println(a[l] + " " + a[r]);
        l++; r--;
      }
      else if (a[l] + a[r] > 0) {
        r--;
      }
      else {
        l++;
      }
    }
  }
}