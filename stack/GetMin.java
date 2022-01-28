package DSA.stack;

import java.util.Stack;

public class GetMin {
  
  // Maintain 2 stacks 
  // ms: has all the elements 
  // as: only has the smaller elements
  static Stack<Integer> ms = new Stack<>();
  static Stack<Integer> as = new Stack<>();

  public void push(int x) {
    if (ms.isEmpty()) {
      ms.push(x);
      as.push(x);
    }

    // Insert every incoming element to the main stack
    ms.add(x);

    // Check if the element to pe pushed to the main stack
    //    is smaller or equal to the element on top of the aux stack
    if (as.peek() >= ms.peek()) {
      as.add(x);
    }
  }

  public void pop() {
    // Remove top from aux stack if equal to top of the main stack
    if (as.peek() == ms.peek()) {
      as.pop();
    }

    ms.pop();
  }

  public int top() {
    return ms.peek();
  }

  /**
   * 
   * @return min
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(n)
   * 
   */
  public int getMin() {
    return as.peek();
  }

  public static void main(String[] args) {
    GetMin myStack = new GetMin();
    myStack.push(4);
    myStack.push(5);
    myStack.push(8);
    myStack.push(1);
    myStack.pop();
    
    System.out.print(" Minimum Element from Stack: " + myStack.getMin() );
  }
}
