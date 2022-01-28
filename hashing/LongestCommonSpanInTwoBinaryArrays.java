package DSA.hashing;

public class LongestCommonSpanInTwoBinaryArrays {

  /**
   * @desc Find the length of the common span in 2 binary arrays and the elements
   *       need not be in the same order. Length of both the arrays are same.
   * @param a
   * @param b
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*n)
   *         Space: O(1)
   */
  public static int longestCommonSpan(int[] a, int[] b, int n) {
    int res = 0;

    for (int i = 0; i < n; i++) {
      int sum1 = 0, sum2 = 0;
      for (int j = i; j < n; j++) {
        sum1 += a[j];
        sum2 += b[j];

        if (sum1 == sum2) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  /**
   * @desc Find the length of the common span in 2 binary arrays and the elements
   *       need not be in the same order. Length of both the arrays are same.
   * @param a
   * @param b
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(n)
   * 
   *         Approach:
   *         - Create an aux array and store the differences of a[i]-b[j] or vice
   *         versa inside it
   *         - Now run the function for "longest subarray with zero sum" on this
   *         aux array
   *         - We could directly count the no. of "0s" but we need to find the no.
   *         of elements that add up to "0", so that we get the maximum length possible.
   */
  public static int longestCommonSpanBetter(int[] a, int[] b, int n) {
    int[] temp = new int[n];

    for (int i = 0; i < n; i++) {
      temp[i] = a[i] - b[i];
    }

    int res = LongestSubArraySum.longestSumSubArrayBetter(temp, n, 0);
    return res;
  }

  public static void main(String[] args) {
    // OP: 4
    // int[] a = {0, 1, 0, 0, 0, 0};
    // int[] b = {1, 0, 1, 0, 0, 1};

    // OP: 6
    int[] a = { 0, 1, 0, 1, 1, 1, 1 };
    int[] b = { 1, 1, 1, 1, 1, 0, 1 };

    System.out.println("Longest common span in both arrays - Naive: " + longestCommonSpan(a, b, a.length));
    System.out.println("Longest common span in both arrays - Better: " + longestCommonSpanBetter(a, b, a.length));
  }
}