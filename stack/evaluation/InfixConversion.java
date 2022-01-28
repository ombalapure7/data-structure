package DSA.stack.evaluation;

import java.util.Stack;

public class InfixConversion {
  
  public static void infixConversion(String expr) {
    Stack<String> post = new Stack<>();
    Stack<String> pre = new Stack<>();
    Stack<Character> ops = new Stack<>();
    
    for (int i=0; i<expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '(') {
        ops.push(ch);
      } else if (Character.isLetterOrDigit(ch)) {
        post.push(ch + "");
        pre.push(ch + "");
      } else if (ch == ')') {
        while (ops.peek() != '(') {
          char op = ops.pop();

          // Create postfix expression
          String postv2 = post.pop();
          String postv1 = post.pop();
          String postv = postv1 + postv2 + op;
          post.push(postv);

          // Create prefix expression
          String prev2 = pre.pop();
          String prev1 = pre.pop();
          String prev = op + prev1 + prev2;
          pre.push(prev);
        }
        
        // Pop the ( bracket
        ops.pop();
      } else if (ch == '+' || ch == '*' || ch == '/' || ch == '-' || ch == '^') {
        while (ops.size() > 0 && ops.peek() != '('
                && precedence(ch) <= precedence(ops.peek())) {
          char op = ops.pop();

          // Create postfix expression
          String postv2 = post.pop();
          String postv1 = post.pop();
          String postv = postv1 + postv2 + op;
          post.push(postv);

          // Create prefix expression
          String prev2 = pre.pop();
          String prev1 = pre.pop();
          String prev = op + prev1 + prev2;
          pre.push(prev);
        }

        // Push current char to stack
        ops.push(ch);
      }
    }

    while (ops.size() > 0) {
      char op = ops.pop();

      String postv2 = post.pop();
      String postv1 = post.pop();
      String postv = postv1 + postv2 + op;
      post.push(postv);

      String prev2 = pre.pop();
      String prev1 = pre.pop();
      String prev = op + prev1 + prev2;
      pre.push(prev);
    }

    System.out.println("Postfix Expression: " + post.pop());
    System.out.println("Prefix Expression: " + pre.pop());
  }

  public static int precedence(char op) {
    if (op == '+' || op == '-') {
      return 1;
    } else if (op == '*' || op == '/') {
      return 2;
    } else if (op == '^') {
      return 3;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    String expr = "(A-B/C)*(A/K-L)";
    // Prefix: *-A/BC-/AKL

    // String expr = "((A+B)*(C-D))";
    // *+AB-CD

    // String expr = "((A-(B/C))*((A/K)-L))";
    // *-A/BC-/AKL
    infixConversion(expr);
  } 
}
