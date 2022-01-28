package DSA.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Test {

  /* Next greater element - from end */
  public static void nextGreaterFromEnd(int arr[], int n) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> ngList = new ArrayList<>();

    ngList.add(-1);
    st.add(arr[n - 1]);

    for (int i = n - 2; i >= 0; i--) {
      // Pop until top of stack is greater than the current element
      while (!st.isEmpty() && arr[i] >= st.peek()) {
        st.pop();
      }

      if (st.size() == 0) {
        // Current element is the largest
        ngList.add(-1);
      } else {
        // The top element is the next greater
        ngList.add(st.peek());
      }

      st.add(arr[i]);
    }

    Collections.reverse(ngList);
    System.out.println(ngList);
  }

  /* Next greater element - from start */
  public static void nextGreaterFromStart(int arr[], int n) {
    Stack<Integer> st = new Stack<>();
    int[] ngList = new int[n];
    st.push(0);

    for (int i = 1; i < n; i++) {
      while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
        int pos = st.peek();
        ngList[pos] = arr[i];
        st.pop();
      }

      st.push(i);
    }

    while (!st.isEmpty()) {
      int pos = st.peek();
      ngList[pos] = -1;
      st.pop();
    }

    System.out.println(Arrays.toString(ngList));
  }

  public static void infixPostfix(String expr) {
    Stack<String> post = new Stack<>();
    Stack<Character> opr = new Stack<>();

    for (int i = 0; i < expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '(') {
        opr.push(ch);
      } else if (Character.isLetterOrDigit(ch)) {
        post.push(ch + "");
      } else if (ch == ')') {
        while (opr.peek() != '(') {
          char op = opr.pop();
          String v2 = post.pop();
          String v1 = post.pop();

          String res = v1 + v2 + op;
          post.push(res);
        }

        opr.pop();
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
        while (opr.size() > 0 && opr.peek() != '(' && prec(ch) <= prec(opr.peek())) {
          char op = opr.pop();
          String v2 = post.pop();
          String v1 = post.pop();
          post.push(v1 + v2 + op);
        }

        opr.push(ch);
      }
    }

    while (opr.size() > 0) {
      char op = opr.pop();

      String postv2 = post.pop();
      String postv1 = post.pop();
      String postv = postv1 + postv2 + op;
      post.push(postv);
    }

    System.out.println("Postfix Expression: " + post.pop());
  }

  public static void infixEvaluation(String expr) {
    Stack<Character> operator = new Stack<>();
    Stack<Integer> operand = new Stack<>();

    for (int i = 0; i < expr.length(); i++) {
      char ch = expr.charAt(i);

      if (ch == '(') {
        operator.push(ch);
      } else if (Character.isDigit(ch)) {
        operand.push(ch - '0');
      } else if (ch == ')') {
        while (operator.peek() != '(') {
          char optr = operator.pop();
          int v1 = operand.pop();
          int v2 = operand.pop();

          int res = operation(v1, v2, optr);
          operand.push(res);
        }

        operator.pop();
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (operator.size() > 0 && operator.peek() != '(' &&
            prec(ch) <= prec(operator.peek())) {
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

  public static int prec(char op) {
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

  public static void stockSpan(int arr[], int n) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int span = 1;
      for (int j = i - 1; j >= 0 && arr[i] >= arr[j]; j--) {
        span++;
      }

      list.add(span);
    }

    System.out.println(list);
  }

  public static void stockSpanBetter(int arr[], int n) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> st = new Stack<>();
    st.add(0);
    list.add(1);

    for (int i = 1; i < n; i++) {
      while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
        st.pop();
      }

      int span = st.isEmpty() ? i + 1 : i - st.peek();
      list.add(span);
      st.push(i);
    }

    System.out.println(list);
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 20, 30, 10, 5, 15 };
    nextGreaterFromEnd(arr, arr.length);
    nextGreaterFromStart(arr, arr.length);
    infixPostfix("(a+b)");
    infixEvaluation("2-6*2");

    int[] newArr = new int[] { 18, 12, 13, 14, 11, 16 };
    // 1 1 2 3 1 5
    stockSpan(newArr, newArr.length);
    stockSpanBetter(newArr, newArr.length);
  }
}

// BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
// String str[] = obj.readLine().split(" ");

// int[] arr =
// Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();
// System.out.println(Arrays.toString(arr));
// int n = arr.length;