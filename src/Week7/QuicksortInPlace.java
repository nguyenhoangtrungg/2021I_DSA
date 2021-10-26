package Week7;

import java.util.Scanner;

public class QuicksortInPlace {

    public static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high, int n) {
      int pivot = arr[high];
      int i = (low - 1);

      for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
          i++;
          swap(arr, i, j);
        }
      }
      swap(arr, i + 1, high);
      printArray(arr,n);
      return (i + 1);
    }

    public static void sort(int[] arr, int low, int high, int n) {
      if (low < high) {
        int pi = partition(arr, low, high, n);
        sort(arr, low, pi - 1, n);
        sort(arr, pi + 1, high, n);
      }
    }

    public static void printArray(int[] arr, int size) {
      for (int i = 0; i < size; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] a = new int[n];
      for(int i = 0; i < n; i++) a[i] = sc.nextInt();
      sort(a,0,n-1, n);
      //printArray(a,n);
    }
}
