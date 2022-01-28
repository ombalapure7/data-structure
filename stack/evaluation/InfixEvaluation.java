package DSA.stack.evaluation;

import java.util.Stack;

public class InfixEvaluation {
  
  /**
   * Approach:
   * - Maintain 2 stacks-1 for operands and stack-2 for operators
   * - Push operators to stack-2 and operands to stack-1 until you get ) or /
   * - If / or * is encountered then pop 2 number from stack-1 and top operator from stack-2
   *   - Perform the operation and store the result on stack-1 (as / has higher priority)
   * - If + or - is found then check the top operator on stack-2 
   *   - If the top op is * or / then they should be processed first
   * - If ) is encountered, pop till you get (
   *   - Pop an operator from stack-2
   *   - Pop 2 operands from stack-1 and do the resp. op and store the result on stack-1
   */
  public static void infixEvaluation(String str) {
    Stack<Integer> operand = new Stack<>();
    Stack<Character> operator = new Stack<>();

    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(') {
        operator.push(ch);
      } else if (Character.isDigit(ch)) {
        operand.push(ch - '0');
      } else if (ch == ')') {
        // ) was found, pop until ( is found
        while (operator.peek() != '(') {
          char optr = operator.pop();
          int v1 = operand.pop();
          int v2 = operand.pop();

          int res = operation(v1, v2, optr);
          operand.push(res);
        }

        // Remove the (
        operator.pop();
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (operator.size() > 0 && operator.peek() != '(' &&
                precedence(ch) <= precedence(operator.peek())) {
          char optr = operator.pop();
          int v1 = operand.pop();
          int v2 = operand.pop();

          int res = operation(v2, v1, optr);
          operand.push(res);
        }

        operator.push(ch);
      }
    }

    while (!operator.isEmpty()) {
      char optr = operator.pop();
      int v1 = operand.pop();
      int v2 = operand.pop();

      int res = operation(v2, v1, optr);
      operand.push(res);
    }

    System.out.println("Infix expression evaluation: " + operand.peek());
  }

  public static int precedence(char op) {
    if (op == '+') {
      return 1;
    } else if (op == '-') {
      return 1;
    } else if (op == '*') {
      return 2;
    } else {
      return 2;
    }
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
    String str = "2-6*2"; 
    infixEvaluation(str);
  }
}
