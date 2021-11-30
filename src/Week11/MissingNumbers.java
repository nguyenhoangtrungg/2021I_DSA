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

public class MissingNumbers {

  static class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
      List<Integer> ans = new ArrayList<>();
      int[] cnt1 = new int[10005];
      int[] cnt2 = new int[10005];
      for (int i = 0; i < 10005; i++)
        cnt1[i] = cnt2[i] = 0;
      for (int i = 0; i < arr.size(); i++) {
        int here = arr.get(i);
        cnt1[here]++;
      }
      for (int i = 0; i < arr.size(); i++) {
        int here = brr.get(i);
        cnt2[here]++;
      }
      for (int i = 0; i < 10005; i++) {
        if (cnt2[i] == 0 || cnt1[i] >= cnt2[i])
          continue;
          ans.add(i);
      }
      return ans;
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
      List<Integer> ans = new ArrayList<>();
      Hashtable<Integer, Integer> hashtableArr = new Hashtable<Integer, Integer>();
      for (int i = 0; i < arr.size(); i++) {
        int here = arr.get(i);
        Integer hereInt = hashtableArr.putIfAbsent(here, 1);
        if(hereInt == null) continue;
        hashtableArr.replace(here, hereInt + 1);
      }

      Hashtable<Integer, Integer> hashtableBrr = new Hashtable<Integer, Integer>();
      for (int i = 0; i < brr.size(); i++) {
        int here = brr.get(i);
        Integer hereInt = hashtableBrr.putIfAbsent(here, 1);
        if(hereInt == null) continue;
        hashtableBrr.replace(here, hereInt + 1);
      }

      for (Map.Entry<Integer, Integer> e : hashtableBrr.entrySet()) {
        int here = e.getKey();
        Integer dataArr = hashtableArr.get(here);
        Integer dataBrr = hashtableBrr.get(here);
        if(dataArr == null || dataArr < dataBrr) ans.add(here);
      }

      Collections.reverse(ans);
      return ans;
    }
  }

  public static class Solution {
    public static void main(String[] args) throws IOException {
      List<Integer> arr = new ArrayList<>(); //203 204 205 206 207 208 203 204 205 206
      arr.add(203); arr.add(204); arr.add(205); arr.add(206); arr.add(207); arr.add(208);
      arr.add(203); arr.add(204); arr.add(205); arr.add(206);
      List<Integer> brr = new ArrayList<>(); //203 204 204 205 206 207 205 208 203 206 205 206 204
      brr.add(203); brr.add(204); brr.add(204); brr.add(205); brr.add(206); brr.add(207);
      brr.add(205); brr.add(208); brr.add(203); brr.add(206); brr.add(205); brr.add(206); brr.add(204);
      List<Integer> hi = Result.missingNumbers2(arr, brr);
    }
  }

}
