package DSA.stack;

import java.util.Stack;

public class BalanceParantheses {

  /**
   * @desc Check if the paranthese are balanced
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach
   * - Push any opening bracket to the stack
   * - If there is no opening bracket then check if the same type of closing bracket is present
   *   - Yes then pop the bracket from the stack
   *   - No then return false
   * - If the stack is empty that means the brackets is not balanced
   */

  public static boolean areBracketsBalanced(String expr) {
    Stack<Character> st = new Stack<>();

    for (int i=0; i<expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '(' || ch == '{' || ch == '[') {
        // Push any opening bracket to stack
        st.push(ch);
      } else if (ch == ')') {
        // If closing bracket is found then the bracket present on top
        //    should be a matching opening bracket 
        if (!handleClosingBracket(st, '(')) {
          return false;
        }
      } else if (ch == '}') {
        if (!handleClosingBracket(st, '{')) {
          return false;
        }
      } else if (ch == ']') {
        if (!handleClosingBracket(st, '[')) {
          return false;
        }
      }
    }

    return st.isEmpty();
  }

  public static boolean handleClosingBracket(Stack<Character> st, char openBracket) {
    if (st.size() == 0) {
      // There is a closing bracket but the stack is empty
      return false;
    } else if (st.peek() != openBracket) {
      // There is a closing bracket but the opening bracket on top of stack 
      //    does not match
      return false;
    } else {
      // The current bracket and top of stack character matches so pop the opening bracket
      st.pop();
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println("Are parantheses balanced: " + areBracketsBalanced("{(a+b)}[c*x]"));
  }
}
