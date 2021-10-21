package Week5;

import java.util.List;
import java.util.Stack;

public class EqualStacks {

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    Stack<Integer> stack3 = new Stack<Integer>();
    for (int i = h1.size() - 1; i >= 0; i++) {
      int data = h1.get(i);
      if (stack1.isEmpty()) {
        stack1.push(data);
      } else {
        stack1.push(stack1.peek() + data);
      }
    }

    for (int i = h2.size() - 1; i >= 0; i++) {
      int data = h2.get(i);
      if (stack2.isEmpty()) {
        stack2.push(data);
      } else {
        stack2.push(stack2.peek() + data);
      }
    }

    for (int i = h3.size() - 1; i >= 0; i++) {
      int data = h3.get(i);
      if (stack3.isEmpty()) {
        stack3.push(data);
      } else {
        stack3.push(stack3.peek() + data);
      }
    }

    while(!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
      int data1 = stack1.peek();
      int data2 = stack2.peek();
      int data3 = stack3.peek();
      int Max = Math.max(data1,Math.max(data2,data3));
      if(data1 == data2 && data2 == data3) {
        return data1;
      }
      if(data1 == Max) {
        stack1.pop();
      }
      else if(data2 == Max) {
        stack2.pop();
      }
      else {
        stack3.pop();
      }
    }
    return 0;
  }
}
