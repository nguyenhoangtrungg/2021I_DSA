package Week5;

import java.util.ArrayList;

public class BalancedBrackets {

  public static String isBalanced(String s) {
    ArrayList<Character> arr = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      arr.add(x);
      if (arr.size() == 1 && (x == '}' || x == ']' || x == ')')) {
        return "NO";
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
        return "NO";
      } else if (arr.get(arr.size() - 1) == ']' && arr.get(arr.size() - 2) != '[') {
        return "NO";
      } else if (arr.get(arr.size() - 1) == '}' && arr.get(arr.size() - 2) != '{') {
        return "NO";
      }
    }
    System.out.println(arr.size());
    if (arr.size() > 0) {
      return "NO";
    }
    return "YES";
  }
  public static void main(String[] args) {
    String s = isBalanced("{[()]}");
    System.out.println(s);
  }

}
