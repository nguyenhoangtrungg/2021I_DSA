package Week7;

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

public class InsertionSortPart1 {


  static class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
      int[] a = new int[arr.size()];
      for (int i=0; i < a.length; i++)
      {
        a[i] = arr.get(i);
      }
      int data = a[n-1];
      int N = n;
      while(true) {
        if(N == 0 || (a[N] >= a[N-1])) {
          a[N] = data;
          for(int i = 0; i < n; i++) System.out.print(a[i] + " ");
          break;
        }
        else {
          a[N-1] = a[N];
          for(int i = 0; i < n; i++) System.out.print(a[i] + " ");
          N--;
        }
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
