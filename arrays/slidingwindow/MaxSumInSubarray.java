package DSA.arrays.slidingwindow;

public class MaxSumInSubarray {

  /**
   * @desc  Maximum sum in a subarray
   * @param arr
   * @param n
   * @param k
   * 
   * COMPLEXITY
   * Time: O((n-k) * k)
   * Space: O(1)
   */
  public static int maxConsecutiveSumKNaive(int[] arr, int n, int k) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n - k + 1; i++) {
      int currSum = 0;
      for (int j = 0; j < k; j++) {
        currSum += arr[i + j];
      }

      maxSum = Math.max(currSum, maxSum);
    }

    return maxSum;
  }

  
  /**
   * @desc  Maximum sum in a subarray
   * @param arr
   * @param n
   * @param k
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach
   * - Get sum of 1st k elements
   * - To get the sum of next k elements
   *    - Add the next element arr[i] to the current sum
   *    - Subtract the first element of the previous window arr[i-k]
   */
  public static int maxConsecutiveSumKBetter(int[] arr, int n, int k) {
    int currSum = 0;
    // Get sum of 1st k elements
    for (int i=0; i<k; i++) {
      currSum += arr[i];
    }

    int maxSum = currSum;
    for (int i=k; i<n; i++) {
      // Add the next element to the currSum 
      // And subtract the first element of previous window
      currSum += (arr[i] - arr[i-k]);
      maxSum = Math.max(currSum, maxSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 8, 30, -5, 20, 7 };
    // OP: 45
    System.out.println("Maximum sum in a subarray - Naive: " + maxConsecutiveSumKNaive(arr, arr.length, 3));
    System.out.println("Maximum sum in a subarray - Better: " + maxConsecutiveSumKBetter(arr, arr.length, 3));;
  }
}
