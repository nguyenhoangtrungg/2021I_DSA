package Week11;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Pairs {

  static class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> a) {

      int n = a.size();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = a.get(i);
      }

      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
        set.add(arr[i]);
      }
      int ans = 0;
      for (int i : set) {
        ans += (set.contains(i + k)) ? 1 : 0;
      }
      return ans;
    }

  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int k = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      int result = Result.pairs(k, arr);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }

}
