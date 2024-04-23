import java.util.Stack;

public class Ex3 {

  static boolean checkBalancedParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        stack.push(s.charAt(i));
      } else {
        char top = stack.pop();
        if (s.charAt(i) == ')' && top == '(') {
        } else if (s.charAt(i) == ']' && top == '[') {
        } else if (s.charAt(i) == '}' && top == '{') {
        } else {
          return false;
        }
      }
    }
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(check("{()")); // true
    System.out.println(check("()[]{}")); // true
    System.out.println(check("(]")); // false
    System.out.println(check("([)]")); // false
    System.out.println(check("{[]}")); // true
  }

}
