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

public class IntrotoTutorialChallenges {

  static class Result {

    /*
     * Complete the 'introTutorial' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER V
     *  2. INTEGER_ARRAY arr
     */

    public static int introTutorial(int V, List<Integer> arr) {
      int[] a = new int[arr.size()];
      for (int i = 0; i < a.length; i++) {
        a[i] = arr.get(i);
      }
      int n = a.length;
      int l = 0, r = n - 1;
      while (l <= r) {
        int mid = (l + r) / 2;
        if (a[mid] == V) {
          return mid;
        }
        if (a[mid] < V) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return n;
    }

  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter(System.getenv("OUTPUT_PATH")));

      int V = Integer.parseInt(bufferedReader.readLine().trim());

      int n = Integer.parseInt(bufferedReader.readLine().trim());

      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      int result = Result.introTutorial(V, arr);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }


}
