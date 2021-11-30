package Week5;

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedBrackets {

  public static String isBalanced(String s) {
    ArrayList<Character> arr = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      arr.add(x);
      if (arr.size() == 1 && (x == '}' || x == ']' || x == ')')) {
        return "INVALID";
      }
      if (arr.size() == 1) {
        continue;
      }
      if (arr.get(arr.size() - 2) == '(' && arr.get(arr.size() - 1) == ')') {
        arr.remove(arr.size() - 1);
        arr.remove(arr.size() - 1);
      } else if (arr.get(arr.size() - 2) == '[' && arr.get(arr.size() - 1) == ']') {
        arr.remove(arr.size() - 1);
        arr.remove(arr.size() - 1);
      } else if (arr.get(arr.size() - 2) == '{' && arr.get(arr.size() - 1) == '}') {
        arr.remove(arr.size() - 1);
        arr.remove(arr.size() - 1);
      } else if (arr.get(arr.size() - 1) == ')' && arr.get(arr.size() - 2) != '(') {
        return "INVALID";
      } else if (arr.get(arr.size() - 1) == ']' && arr.get(arr.size() - 2) != '[') {
        return "INVALID";
      } else if (arr.get(arr.size() - 1) == '}' && arr.get(arr.size() - 2) != '{') {
        return "INVALID";
      }
    }
    //ystem.out.println(arr.size());
    if (arr.size() > 0) {
      return "INVALID";
    }
    return "VALID";
  }

  public static boolean isTrue(String s) {
    int[] dau = new int[3];
    dau[0] = dau[1] = dau[2] = 0;
    for(int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      boolean ok = false;
      if(x == '(') {
        dau[0]++;
        ok = true;
      }
      if(x == '[') {
        dau[1]++;
        ok = true;
      }
      if(x == '{') {
        dau[2]++;
        ok = true;
      }
      if(ok) continue;
      if(x == '}') {
        if(dau[1] > 0) return false;
        else dau[2]--;
      }
      else if(x == ']') {
        if(dau[0] > 0) return false;
        else dau[1]--;
      }
      else if(x == ')') dau[0]--;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    String check = isBalanced(input);
    if(check == "VALID") {
      if(isTrue(input)) System.out.print("VALID");
      else System.out.print("INVALID");
    }
    else System.out.print("INVALID");
  }

}
