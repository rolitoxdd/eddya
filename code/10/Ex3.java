import java.util.Stack;

public class Ex3 {

  static boolean checkBalancedParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(checkBalancedParentheses("()")); // true
    System.out.println(checkBalancedParentheses("()[]{}")); // true
    System.out.println(checkBalancedParentheses("(]")); // false
    System.out.println(checkBalancedParentheses("([)]")); // false
    System.out.println(checkBalancedParentheses("{[]}")); // true
  }

}
