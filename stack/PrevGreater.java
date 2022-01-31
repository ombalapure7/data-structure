package DSA.stack;

import java.util.Stack;

public class PrevGreater {

  /**
   * 
   * @desc  Find the previous greater element in an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n ^ 2)
   * Space: O(1)
   * 
   */
  public static void previousGreater(int arr[], int n) {
    for (int i=0; i<n; i++) {
      int j;
      // Start from the right side and check if the exisiting element 
      //    is smaller than any previous element
      // We have an array 20,30,10,5,15
      // If i=2 start from 10, then go from index 2 to 0
      // If i=3 start from 10, then go from index 3 to 0
      // And so on...
      for (j=i; j>=0; j--) {
        if (arr[j] > arr[i]) {
          System.out.print(arr[j] + " ");
          break;
        }
      }

      if (j == -1) {
        System.out.print(-1 + " ");
      }
    }
  }

  /**
   * 
   * @desc  Find the previous greater element in an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   */
  public static void previousGreaterBetter(int arr[], int n) {
    Stack<Integer> stack = new Stack<>();

    // Process first element
    stack.push(arr[0]);
    System.out.print(-1 + " ");

    for (int i=1; i<n; i++) {
      // Check if the stack top is smaller than current item
      // If yes then pop it till the condition is not satisfied
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      // int pg = stack.isEmpty() ? -1 : stack.peek();
      int pg; 
      if (stack.size() == 0) {
        pg = -1;
      } else {
        pg = stack.peek();
      }

      System.out.print(pg + " ");

      // Add the new item to the stack
      stack.push(arr[i]);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{20,30,10,5,15};
    // -1 -1 30 10 30
    previousGreater(arr, arr.length);
    System.out.println();
    previousGreaterBetter(arr, arr.length);
  }
}
