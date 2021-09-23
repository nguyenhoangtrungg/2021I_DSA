package Week3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n + 5];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr, 0, n);
    int Min = (int) 1e9;
    for (int i = 1; i < n; i++) {
      Min = Math.min(Min, Math.abs(arr[i - 1] - arr[i]));
    }
    for (int i = 1; i < n; i++) {
      if(Math.abs(arr[i - 1] - arr[i]) == Min) StdOut.print(arr[i-1] + " " + arr[i] + " ");
    }
  }
}
