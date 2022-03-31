package DSA.arrays.slidingwindow;

import java.util.Stack;

public class MaxInWindow {

  /**
   * @desc Largest element in each window
   * @param arr
   * @param n
   * @param k
   * 
   *            COMPLEXITY
   *            Time: O((n-k) * k)
   *            Space: O(1)
   */
  public static void maxInWindow(int[] arr, int n, int k) {
    for (int i = 0; i < n - k + 1; i++) {
      // int max = Integer.MIN_VALUE;
      // for (int j = 0; j < k; j++) {
      //   if (max < arr[i + j]) {
      //     max = arr[i + j];
      //   }
      // }
      // System.out.print(max + " ");

      // OR

      int res = 0;
      for (int j = 0; j < k; j++) {
        res = maxElement(arr, 0, i+j);
      }

      System.out.print(res + " ");
    }

    System.out.println();
  }

  /**
   * Helper function to find max element in a window
   */
  public static int maxElement(int[] arr, int low, int high) {
    int max = Integer.MIN_VALUE;

    for (int i=low; i<=high; i++) {
      max = Math.max(arr[i], max);
    }

    return max;
  }

  /**
   * @desc Largest element in each window
   * @param arr
   * @param n
   * @param k
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(n)
   * 
   * Approach:
   * - Find the next greater elements and store the indices in an array
   * - Find the next greater element in every window and keep sliding the window
   */
  public static void maxInWindowBetter(int[] arr, int n, int k) {
    /* PART 1: Find the next greater element indices */
    Stack<Integer> st = new Stack<>();
    int[] nge = new int[n];
    
    // Push last element's index
    st.push(n-1);
    // Last element won't have a next greater element
    nge[n - 1] = n;

    for (int i=n-2; i>=0; i--) {
      // Pop till you see -> arr[i] > top of stack
      while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        // Stack is empty and there is no next greater
        nge[i] = n;
      } else {
        // Next greater is present so add it
        nge[i] = st.peek();
      }

      st.push(i);
    }

    /* PART 2: Find greatest element in every window */
    for (int i=0; i<n-k+1; i++) {
      int j = i;
      // Check if the next greater is present inside the current window
      while (nge[j] < i+k) {
        j = nge[j];
      }

      System.out.print(arr[j] + " ");
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
    maxInWindow(arr, arr.length, 3);
    maxInWindowBetter(arr, arr.length, 3);
  }
}
