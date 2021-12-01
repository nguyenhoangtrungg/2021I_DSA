package Week12;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class RoadsAndLibraries {

  static boolean[] visited;

  public static long dfs(int u, ArrayList<ArrayList<Integer>> cities) {
    long cnt = 0;
    visited[u] = true;
    for (int i = 0; i < cities.get(u).size(); i++) {
      int v = cities.get(u).get(i);
      if (!visited[v]) {
        cnt = cnt + 1 + dfs(v, cities);
      }
    }
    return cnt;
  }

  public static ArrayList<ArrayList<Integer>> toGraph(int n, List<List<Integer>> cities) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      result.add(new ArrayList<>());
    }
    for (List<Integer> city : cities) {
      int u = city.get(0);
      int v = city.get(1);
      result.get(u).add(v);
      result.get(v).add(u);
    }
    return result;
  }

  public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    if(c_road > c_lib) return (long) n * c_lib;
    long ans = 0;
    visited = new boolean[n+1];
    ArrayList<ArrayList<Integer>> graph = toGraph(n, cities);
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        long cnt = dfs(i, graph);
        ans += c_lib + c_road * cnt;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int Q = sc.nextInt();
    while (Q-- >= 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int c_lib = sc.nextInt();
      int c_road = sc.nextInt();

      List<List<Integer>> cities = new ArrayList<>();
      for(int i = 0; i < m; i++) cities.add(new ArrayList<>());

      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        cities.get(i).add(u);
        cities.get(i).add(v);
      }
    System.out.println(roadsAndLibraries(n, c_lib, c_road, cities));
    }
  }
}
