package DSA.stack;

import java.util.Stack;

public class DuplicateBrackets {

  /**
   * @param expr
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   * Approach
   * - Push every character to the stack unless it is a closing bracket
   * - If closing bracket is encountered
   *   - Pop until we get an opening bracket
   *   - Else continue
   * - If an opening bracket is found after doing the popping 
   *   - Duplicate bracket is present
   *   - No duplicate brackets found
   */
  public static boolean hasDuplicateBrackets(String expr) {
    Stack<Character> st = new Stack<>();

    for (int i=0; i<expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == ')') {
        if (st.peek() == '(') {
          return true;
        } else {
          while (st.peek() != '(') {
            st.pop();
          }

          // Remove the "("
          st.pop();
        }
      } else {
        // Keep pushing chars except alphabets or ")"
        st.push(ch);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String expr = "((a+b) * (c+d))";
    System.out.println("Has duplicate brackets: " + hasDuplicateBrackets(expr));
  }
}
