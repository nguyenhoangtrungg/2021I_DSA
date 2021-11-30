package Week7.Survey;

import java.util.Scanner;

public class InsertionSort {

  public static void sort(int[] arr, int l, int r) {
    for (int i = l + 1; i < r - 1; ++i) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static void printArray(int[] arr) {
    int n = arr.length;
    for (int j : arr) {
      System.out.print(j + " ");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
    sort(arr, 1, n);
    printArray(arr);
  }
}
