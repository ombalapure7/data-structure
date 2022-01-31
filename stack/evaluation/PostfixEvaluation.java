package DSA.stack.evaluation;

import java.util.Stack;

public class PostfixEvaluation {
  
  /**
   * @desc  Convert postfix expression to a prefix & infix expression
   * @param expr
   * 
   * Approach: 
   * - Maintain a value stack and push operators to it
   * - Incase if any operator is encountered
   *   - Pop 2 operands from the value stack and perform the operation with the current operator
   */
  public static void postfixEvaluation(String expr) {
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<Integer> valueStack = new Stack<>();

    for (int i=0; i<expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '+' || ch == '*' || ch == '/' || ch == '-') {
        int v2 = valueStack.pop();
        int v1 = valueStack.pop();
        int val = operation(v1, v2, ch);
        valueStack.push(val);

        // Create infix expression
        String infixV2 = infix.pop();
        String infixV1 = infix.pop();
        String infixV = "(" + infixV1 + ch + infixV2 + ")";
        infix.push(infixV);

        // Create prefix expression
        String prefixV2= prefix.pop();
        String prefixV1= prefix.pop();
        String prefixV = ch + prefixV1 + prefixV2;
        prefix.push(prefixV);
      } else {
        valueStack.push(ch - '0');
        infix.push(ch + "");
        prefix.push(ch + "");
      }
    }

    System.out.println("Value of postfix: " + valueStack.pop());
    System.out.println("Prefix expression: " + prefix.pop());
    System.out.println("Infix expression: " + infix.pop());
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
    // String str = "231*+9-";
    // -4

    // String str = "123+*8-";
    String str = "5 3 1 * + 9 -";
    str = str.replace(" ", "");
    postfixEvaluation(str);
  }
}
