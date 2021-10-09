package Week5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
  public static void main(String[] args) throws IOException {
    InputStreamReader inputStream = new InputStreamReader(System.in);
    BufferedReader scan = new BufferedReader(inputStream);
    int Q = Integer.parseInt(scan.readLine());
    String S = "";
    Stack<String> stack = new Stack<String>();
    stack.add("");
    for(int i = 0; i < Q; i++) {
      String input = scan.readLine();
      String[] inputArray = input.split(" ");
      if(inputArray[0].equals("1")) {
        String append = inputArray[1];
        S = S + append;
        stack.push(S);
      }
      else if(inputArray[0].equals("2")) {
        int delete = Integer.parseInt(inputArray[1]);
        S = S.substring(0,S.length()-delete);
        stack.push(S);
      }
      else if(inputArray[0].equals("3")) {
        int print = Integer.parseInt(inputArray[1]);
        System.out.println(S.charAt(print-1));
      }
      else if(inputArray[0].equals("4")) {
        stack.pop();
        S = stack.peek();
      }
    }
  }
}
