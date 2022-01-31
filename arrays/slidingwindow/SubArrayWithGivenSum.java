package DSA.arrays.slidingwindow;

public class SubArrayWithGivenSum {

  /**
   * @desc Check if a subarray has given sum
   * @param arr
   * @param n
   * @return
   * 
   * COMPLEXITY
   * Time: O(n*n)
   * Space: O(1)
   */
  public static boolean hasSumInSubArray(int[] arr, int n, int subArraySum) {
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += arr[j];
        if (sum == subArraySum) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * @desc  Check if a subarray has given sum
   * @param arr
   * @param n
   * @return
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach
   * - Assume arr[0] as the current sum
   * - Maintain two variables to keep track of the start and end of a window
   * - Keep adding elements from the array to the current sum
   * - If current sum become greater that the "given sum"
   *    - Subtract the current sum by the element present at the start of the window
   *    - Increase the start window counter
   * - Else keep on adding the elements
   */
  public static boolean hasSumInSubArrayBetter(int[] arr, int n, int subArraySum) {
    int currSum = arr[0], st = 0;

    for (int end = 1; end < n; end++) {
      // Current sum is greater than the "given sum"
      while (currSum > subArraySum && st < end - 1) {
        currSum -= arr[st];
        // Move the virtual window
        // Increase start of window counter
        st++;
      }

      // Current sum is present
      if (currSum == subArraySum) {
        return true;
      }

      // Keep on adding elements (till we reach the end)
      if (end < n) {
        currSum += arr[end];
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 4, 20, 3, 10, 5 };
    System.out.println("Sub array has given sum - Naive: " + hasSumInSubArray(arr, arr.length, 33));

    // int[] arr = {2, 5};
    // System.out.println("Sub array has given sum - Naive: " +
    // hasSumInSubArray(arr, arr.length, 3));
    System.out.println("Sub array has given sum - Better: " + hasSumInSubArrayBetter(arr, arr.length, 33));
  }
}
