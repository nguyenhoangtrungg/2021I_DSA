package Week3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;

public class SherlockandArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      T--;
      int n = sc.nextInt();
      int[] arr = new int[n];
      int[] sum = new int[n + 5];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      sum[0] = arr[0];
      for (int i = 1; i < n; i++) {
        sum[i] = sum[i - 1] + arr[i];
      }
      boolean present = false;
      for(int i = 1; i < n; i++)
        if(sum[i-1] == sum[n-1] - sum[i]) {
          StdOut.println("YES");
          present = true;
          break;
        }
      if(sum[n-1] - arr[0] == 0) {
        StdOut.println("YES");
        present = true;
      }
      if(!present) StdOut.println("NO");
    }
  }
}
