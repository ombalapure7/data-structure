package DSA.stack;

import java.util.Stack;

public class GetMinBetter {
  static Stack<Integer> s = new Stack<>();
  int min;

  public void push(int x) {
    if (s.isEmpty()) {
      // Very 1st element will be considered as minimum
      min = x;
      s.add(x);
    } else if (x <= min) {
      // Current element is less than "min"
      s.add(2 * x - min);
      // Update the "min"
      min = x;
    } else {
      // Just push the element if not less than "min"
      s.add(x);
    }
  }

  public int pop() {
    int t = s.peek(); 
    s.pop();

    // The top of stack stores special value not an actual value
    if (t <= min) {
      int res = min;
      // Since, t = 2x - min
      // We can say that, min = 2x - t
      min = 2 * min - t;
      return res;
    } else {
      return t;
    }
  }

  int peek() {
    int t = s.peek();
    return ((t <= min) ? min : t);
  }

  /**
   * 
   * @return min
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(1)
   * 
   */
  int getMin() {
    return min;
  }

  public static void main(String[] args) {
    GetMinBetter s = new GetMinBetter();
    s.push(4);
    s.push(5);
    s.push(8);
    s.push(1);
    s.pop();

    System.out.print(" Minimum Element from Stack: " + s.getMin());
  }
}
