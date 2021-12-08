package Week13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dijkstra {

  public static class Edge {

    public int y;
    public int s;

    public Edge(int y, int s) {
      this.y = y;
      this.s = s;
    }
  }

  public static int findMin(int[] distance, boolean[] visited) {
    int Min = Integer.MAX_VALUE, ans = -1;
    for (int i = 0; i < distance.length; i++) {
      if (visited[i] || Min <= distance[i]) {
        continue;
      }
      Min = distance[i];
      ans = i;
    }
    return ans;
  }

  public static List<List<Edge>> toGraph(int n, List<List<Integer>> input) {
    List<List<Edge>> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ans.add(new ArrayList<>());
    }
    for (List<Integer> integers : input) {
      int x = integers.get(0);
      int y = integers.get(1);
      int s = integers.get(2);
      if(x == y) continue;
      ans.get(x).add(new Edge(y, s));
      ans.get(y).add(new Edge(x, s));
    }
    return ans;
  }

  public static ArrayList<Integer> dijkstra(int start, int n, List<List<Integer>> input) {
    ArrayList<Integer> ans = new ArrayList<>();

    List<List<Edge>> graph = toGraph(n, input);
    int[] distance = new int[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[start] = 0;

    for (int turn = 0; turn < n; turn++) {
      int x = findMin(distance, visited);
      if(x == -1) continue;
      visited[x] = true;
      for (int i = 0; i < graph.get(x).size(); i++) {
        int y = graph.get(x).get(i).y;
        int s = graph.get(x).get(i).s;
        if (visited[y] || distance[y] <= distance[x] + s) continue;
        distance[y] = distance[x] + s;
      }
    }

    for(int i = 0; i < n; i++) {
      if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
      ans.add(distance[i]);
    }

    return ans;
  }

  public static void printAns(ArrayList<Integer> input, int s) {
    for(int i = 0; i < input.size(); i++) {
      if(i == s) continue;
      System.out.print(input.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {

      List<List<Integer>> graph = new ArrayList<>();

      int n = sc.nextInt();
      int m = sc.nextInt();

      for (int i = 0; i < m; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int s = sc.nextInt();

        graph.get(i).add(x);
        graph.get(i).add(y);
        graph.get(i).add(s);
      }

      int s = sc.nextInt() - 1;

      printAns(dijkstra(s, n, graph), s);
    }
  }
}
