package Week11;

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

  class Node implements Comparable<Node> {
    int key;
    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public double getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    @Override
    public int compareTo(Node node) {
      if(this.getKey() == node.getKey()) {
        return -(this.getValue() - node.getValue());
      }
      if(this.getKey() > node.getKey()) return 1;
      else return -1;
    }
  }

  static class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
      List<Double> ans = new ArrayList<>();

      int LIMIT = 10000005;

      TreeSet<Integer> treeSet = new TreeSet<>();

      treeSet.add(a.get(0));
      treeSet.add(a.get(1));

      ans.add(1.0 * a.get(0));
      ans.add((a.get(0) + a.get(1)) / 2.0);

      int higher = Math.max(a.get(0), a.get(1));
      int lower = Math.min(a.get(0), a.get(1));

      for (int i = 2; i < a.size(); i++) {
        int here = a.get(i);
        treeSet.add(here);
        int hiLo = treeSet.lower(higher);
        int loHi = treeSet.higher(lower);
        if (hiLo == lower && loHi == higher) {
          int Max = Math.max(higher, lower);
          int Min = Math.min(higher, lower);
          if (here >= Max) {
            lower = higher;
          } else {
            higher = lower;
          }
        } else if (lower == higher) {
          if (here >= lower) {
            higher = treeSet.higher(higher);
          }
          else {
            lower = treeSet.lower(lower);
          }
        }
        else {
          lower = higher = here;
        }
        ans.add((lower + higher) / 2.0);
      }

      return ans;
    }

  }

  public static class Solution {

    public static void main(String[] args) throws IOException {
      String url = "E:\\GitHub\\DSA_20020083_NguyenHoangTrung\\src\\Week11\\input.txt";
      FileInputStream fileInputStream = new FileInputStream(url);

      List<Integer> demo = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int i = 1; i <= n; i++) {
        int x = sc.nextInt();
        demo.add(x);
      }
      List<Double> ans = Result.runningMedian(demo);
      for (Double an : ans) {
        System.out.println(an);
      }
    }

  }
}
