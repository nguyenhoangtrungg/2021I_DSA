package Week6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InsertionSortPart2 {


  static class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
      int[] a = new int[arr.size()];
      for (int i = 0; i < a.length; i++) {
        a[i] = arr.get(i);
      }
      int i, j;
      for (i = 1; i < n; i++) {
        int data = a[i];
        for (j = i - 1; j >= 0 && a[j] > data; j--) {
          a[j + 1] = a[j];
        }
        a[j + 1] = data;
        for (int k = 0; k < n; k++) {
          System.out.print(a[k] + " ");
        }
        System.out.println("");
      }
    }

  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(bufferedReader.readLine().trim());

      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      Result.insertionSort2(n, arr);

      bufferedReader.close();
    }
  }


}
