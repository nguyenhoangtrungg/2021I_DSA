package Week3;

import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;

public class NewYearChaos {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      T--;
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int ans = 0;
      boolean check = true;
      for (int i = n - 1; i >= 0; i--) {
        if (arr[i] - (i + 1) > 2) {
          check = false;
          break;
        }
        for (int j = i - 1; j >= Math.max(0, arr[i] - 2); j--){
          if (arr[j] > arr[i]) {
            ans++;
          }
        }
      }
      if (!check) {
        StdOut.println("Too chaotic");
      } else {
        StdOut.println(ans);
      }
    }
  }
}
