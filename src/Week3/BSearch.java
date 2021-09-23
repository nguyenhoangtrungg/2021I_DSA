package Week3;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BSearch {

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
    int n = StdIn.readInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = StdIn.readInt();
    }
    Arrays.sort(arr, 0, n);
//    for (int i = 0; i < n; i++) {
//      StdOut.print(arr[i] + " ");
//    }
    int key = StdIn.readInt();
    StdOut.println(binarySearch(arr, key));
  }
}
