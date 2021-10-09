package Week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueusingTwoStacks {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    Queue<Integer> queue = new LinkedList<>();
    while(q > 0) {
      q--;
      int input = sc.nextInt();
      if(input == 1) {
        int n = sc.nextInt();
        queue.offer(n);
      }
      else if(input == 2) {
        queue.poll();
      }
      else if(input == 3) {
        System.out.println(queue.peek());
      }
    }
  }
}
