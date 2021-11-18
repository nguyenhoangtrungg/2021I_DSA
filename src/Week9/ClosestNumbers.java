package Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

  static class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r) {
      // Find sizes of two subarrays to be merged
      int n1 = m - l + 1;
      int n2 = r - m;

      /* Create temp arrays */
      int[] L = new int[n1];
      int[] R = new int[n2];

      /*Copy data to temp arrays*/
      for (int i = 0; i < n1; ++i) {
        L[i] = arr[l + i];
      }
      for (int j = 0; j < n2; ++j) {
        R[j] = arr[m + 1 + j];
      }

      int i = 0, j = 0;

      int k = l;
      while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
          arr[k] = L[i];
          i++;
        } else {
          arr[k] = R[j];
          j++;
        }
        k++;
      }

      while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
      }

      while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
      }
    }

    void sort(int[] arr, int l, int r) {
      if (l < r) {
        // Find the middle point
        int m = l + (r - l) / 2;

        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
      }
    }
  }

  public static class Exercise7 {

    public static List<Integer> closestNumbers(List<Integer> arr) {
      // Write your code here
      int[] array = new int[arr.size()];
      for (int i = 0; i < arr.size(); i++) {
        array[i] = arr.get(i);
      }

      MergeSort ob = new MergeSort();
      ob.sort(array, 0, array.length - 1);

      List<Integer> result = new ArrayList<>();

      int min = Integer.MAX_VALUE;

      for (int i = 1; i < array.length; i++) {
        int diff = array[i] - array[i - 1];
        if (diff < min) {
          min = diff;
        }
      }

      for (int i = 1; i < array.length; i++) {
        int diff = array[i] - array[i - 1];
        if (diff == min) {
          result.add(array[i - 1]);
          result.add(array[i]);
        }
      }

      return result;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      List<Integer> arr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arr.add(sc.nextInt());
      }

      List<Integer> result = closestNumbers(arr);
      for (Integer integer : result) {
        System.out.print(integer + " ");
      }
    }
  }
}
