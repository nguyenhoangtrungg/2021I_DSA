package Week8;

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

public class FindtheRunningMedian {


  static class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
      List<Double> ans = new ArrayList<>();
      PriorityQueue<Double> maxDouble = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Double> minDouble = new PriorityQueue<>();
      for (double x : a) {
        if (maxDouble.isEmpty()) {
          maxDouble.add(x);
        } else if (maxDouble.size() == minDouble.size()) {
          if (x > maxDouble.peek()) {
            minDouble.add(x);
            maxDouble.add(minDouble.remove());
          } else {
            maxDouble.add(x);
          }
        } else if (maxDouble.size() > minDouble.size()) {
          if (x > maxDouble.peek()) {
            minDouble.add(x);
          } else {
            maxDouble.add(x);
            minDouble.add(maxDouble.remove());
          }
        }
        if (maxDouble.isEmpty()) {
          ans.add(0.0);
        } else if (maxDouble.size() == minDouble.size()) {
          ans.add((maxDouble.peek() + minDouble.peek()) / 2.0);
        } else { // maxHeap must have more elements than minHeap
          ans.add(maxDouble.peek());
        }
      }
      return ans;
    }

  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter(System.getenv("OUTPUT_PATH")));

      int aCount = Integer.parseInt(bufferedReader.readLine().trim());

      List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
              return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
          })
          .map(String::trim)
          .map(Integer::parseInt)
          .collect(toList());

      List<Double> result = Result.runningMedian(a);

      bufferedWriter.write(
          result.stream()
              .map(Object::toString)
              .collect(joining("\n"))
              + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
    }
  }


}
