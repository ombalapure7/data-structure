package DSA.stack;

import java.util.Stack;

public class LargesRectangleArea {

  /**
   * @desc Maximum area of rectangle in a histogram
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time:
   * Space:
   * 
   * Approach
   * - For current element go to the left and right side
   * - Say if current element is 2, then all the bars (numbers) where x >= 2 should be considered
   * - Add up the bar values where x >= 2
   */
  public static int maxRectangleArea(int arr[], int n) {
    int res = 0;

    for (int i = 0; i < n; i++) {
      int curr = arr[i];

      // Go from arr[i] till 0
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] >= arr[i]) {
          curr += arr[i];
        } else {
          break;
        }
      }

      // Go from arr[i] to arr.length-1
      for (int j = i + 1; j < n; j++) {
        if (arr[j] >= arr[i]) {
          curr += arr[i];
        } else {
          break;
        }
      }

      res = Math.max(res, curr);
    }

    return res;
  }

  /**
   * @desc Maximum area of rectangle in a histogram
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   *  Approach
   *  - Declare "res" to store final result
   *  - Find the previous smaller element for every element
   *  - Find the next smaller element for every element
   *  - For every element of arr[i], do:
   *  curr = arr[i]
   *  curr += (i-ps[i]-1)*arr[i]
   *  curr += (ns[i]-i-1)*arr[i]
   *  res = Math.max(res, curr)
   */
  public static int maxRectangleAreaBetter(int arr[], int n) {
    int res = 0;
    int[] ps = new int[n];
    int[] ns = new int[n];

    Stack<Integer> s = new Stack<>();

    s.add(0);
    // Find smaller/equal to elements on left side
    for (int i = 0; i < n; i++) {
      while (s.isEmpty() == false && arr[s.peek()] >= arr[i]) {
        s.pop();
      }

      // Put -1 if previous smaller/equal on left does not exist
      int pse = s.isEmpty() ? -1 : s.peek();
      ps[i] = pse;
      s.push(i);
    }

    // Empty the stack
    while (s.isEmpty() == false) {
      s.pop();
    }

    // Find smaller/equal to elements on right side
    s.push(n - 1);
    for (int i = n - 1; i > 0; i--) {
      while (s.isEmpty() == false && arr[s.peek()] >= arr[i]) {
        s.pop();
      }

      // Put arr.length if previous smaller/equal on right does not exist
      int nse = s.isEmpty() ? n : s.peek();
      ns[i] = nse;
      s.add(i);
    }

    // Calculate area
    for (int i = 0; i < n; i++) {
      int curr = arr[i];
      curr += (i - ps[i] - 1) * arr[i];
      curr += (ns[i] - i - 1) * arr[i];

      res = Math.max(res, curr);
    }

    return res;
  }

  public static int maxAreaHistogram(int arr[], int n) {
    int maxArea = 0;

    Stack<Integer> st = new Stack<>();
    
    // Processing right elements
    int rb[] = new int[arr.length]; // nse index on right
    st.push(n - 1);
    rb[n - 1] = n;

    for (int i=n-2; i>=0; i--) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        // No greater elements on the right - put value as n
        rb[i] = n;
      } else {
        rb[i] = st.peek();
      }

      st.push(i);
    }

    // Processing left elements
    int lb[] = new int[arr.length]; // nse index on left
    st.push(0);
    lb[0] = -1;

    for (int i=1; i<n; i++) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        // No greater elements on the left - put value as -1
        lb[i] = -1;
      } else {
        lb[i] = st.peek();
      }

      st.push(i);
    }

    for (int i=0; i<arr.length; i++) {
      // By subtracting left and right indexes we get width
      int width = rb[i] - lb[i] - 1;
      int area = arr[i] * width;
      maxArea = Math.max(area, maxArea);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 6, 2, 5, 4, 1, 5, 6 };
    System.out.println("Max area of histogram - Naive: " + maxRectangleArea(arr, arr.length));

    int[] newArr = new int[] { 6, 2, 5, 4, 1, 5, 6 };
    System.out.println("Max area of histogram - Better: " + maxRectangleAreaBetter(newArr, newArr.length));
    System.out.println("Max area of histogram - Better: " + maxAreaHistogram(newArr, newArr.length));
  }
}
