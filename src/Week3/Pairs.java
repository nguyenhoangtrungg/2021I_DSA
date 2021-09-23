package Week3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

  public static int binarySearch(int[] a, int number) {
    int n = a.length;
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (a[mid] == number) {
        return mid;
      }
      if (a[mid] < number) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int ans = 0;
    Arrays.sort(arr, 0, n);
    for (int i = 0; i < n; i++) {
      int u = binarySearch(arr,arr[i] - k);
      if(u != -1) ans++;
    }
    StdOut.println(ans);
  }
}
