package DSA.arrays.slidingwindow;

public class SumOfEveryWindow {
  
  /**
   * @desc Find the sum of elements in every window
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n*k)
   * Space: O(1)
   */
  public static void sumOfEveryWindow(int[] arr, int n, int k) {
    for (int i=0; i<n-k+1; i++) {
      int sum = 0;
      for (int j=0; j<k; j++) {
        sum += arr[i+j];
      }

      System.out.print(sum + " ");
    }

    System.out.println();
  }

  /**
   * @desc Find the sum of elements in every window
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Maintain a variable "sum"
   * - Find sum of 1st k elements and store it in "sum"
   * - Now start from (k+1)th element and keep doing 2 things
   *    - Add the new element (arr[i]) to "sum"
   *    - Subtract 1st element of every window from "sum"
   */
  public static void sumOfEveryWindowBetter(int[] arr, int n, int k) {
    int sum = 0;
    for (int i=0; i<k; i++) {
      sum += arr[i];
    }

    System.out.print(sum + " ");

    for (int i=k; i<n; i++) {
      sum += arr[i];
      sum -= arr[i-k];
      System.out.print(sum + " ");
    }
  }

  public static void main(String[] args) {
    // 12 11 14 16
    int[] arr = {4, 5, 3, 3, 8, 5};
    sumOfEveryWindow(arr, arr.length, 3);
    sumOfEveryWindowBetter(arr, arr.length, 3);
  }
}
