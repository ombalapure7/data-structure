package DSA.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreater {
 
  /**
   * 
   * @desc  Find the next greater element in an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n ^ 2)
   * Space: O(1)
   * 
   */
  public static void nextGreater(int arr[], int n) {
    for (int i=0; i<n; i++) {
      int j;
      for (j=i+1; j<n; j++) {
        if (arr[j] > arr[i]) {
          System.out.print(arr[j] + " ");
          break;
        }
      }

      if (j == n) {
        System.out.print(-1 + " ");
      }
    }
  }

  /**
   * 
   * @desc  Find the next greater element in an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   */
  public static void nextGreaterBetter(int arr[], int n) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> ngList = new ArrayList<>();
    
    // Push the last element
    stack.push(arr[n-1]);
    ngList.add(-1);

    // Start from second last element
    for (int i=n-2; i>=0; i--) {
      // Check if the stack top is less than current item
      // If yes then pop it
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      int ng = stack.isEmpty() ? -1 : stack.peek();
      ngList.add(ng);

      // Add the new item to the stack
      stack.push(arr[i]);
    }

    Collections.reverse(ngList);
    System.out.println(ngList);
  }

  /* This appraoch does not require to reverse the result array list */
  public static void nextGreaterLittleBetter(int arr[], int n) {
    int nge[] = new int[n];
    Stack<Integer> s = new Stack<>();

    s.push(0);
    for (int i=1; i<n; i++) {
      while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
        int pos = s.peek();
        nge[pos] = arr[i];
        s.pop();
      }

      s.push(i);
    }

    while (s.size() > 0) {
      int pos = s.peek();
      nge[pos] = -1;
      s.pop();
    }

    System.out.println(Arrays.toString(nge));
  }

  public static void main(String[] args) {
    int[] arr = new int[]{5,15,10,8,6,12,9,18};
    // // 15 18 12 12 12 18 18 -1 
    nextGreater(arr, arr.length);
    System.out.println();
    // // 15 18 12 12 12 18 18 -1 
    nextGreaterBetter(arr, arr.length);
    // System.out.println();
    nextGreaterLittleBetter(arr, arr.length);
  }
}
