package DSA.stack.evaluation;

import java.util.Stack;

public class PrefixConversion {

  /**
   * @desc  Convert prefix expression to a postfix & infix expression
   * @param expr
   * 
   * Approach: 
   * - Maintain a value stack and push operators to it
   * - Start processing characters from the end of the string
   * - Incase if any operator is encountered
   *   - Pop 2 operands from the value stack and perform the operation with the current operator
   */
  public static void prefixEvaluation(String expr) {
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Integer> valueStack = new Stack<>();

    for (int i=expr.length()-1; i>=0; i--) {
      char ch = expr.charAt(i);

      if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
        int v1 = valueStack.pop();
        int v2 = valueStack.pop();
        int val = operation(v1, v2, ch);
        valueStack.push(val);

        // Create infix expression
        String infixV2 = infix.pop();
        String infixV1 = infix.pop();
        String infixV = "(" + infixV1 + ch + infixV2 + ")";
        infix.push(infixV);

        // Create postfix expression
        String postfixV2 = postfix.pop();
        String postfixV1 = postfix.pop();
        String postfixV = postfixV1 + postfixV2 + ch;
        postfix.push(postfixV);
      } else {
        valueStack.push(ch - '0');
        infix.push(ch + "");
        postfix.push(ch + "");
      }
    }

    System.out.println("Value of prefix: " + valueStack.pop());
    System.out.println("Infix expression: " + infix.pop());
    System.out.println("Postfix expression: " + postfix.pop());
  }

  public static int operation(int v1, int v2, char op) {
    if (op == '+') {
      return v1 + v2;
    } else if (op == '-') {
      return v1 - v2;
    } else if (op == '*') {
      return v1 * v2;
    } else {
      return v1 / v2;
    }
  }

  public static void main(String[] args) {
    String str = "-32";
    prefixEvaluation(str);
  }
}
