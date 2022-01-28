package DSA.hashing;

public class LongestSubArray01 {

  /**
   * @desc Find the length of the subarray which has equal no. of 1s and 0s
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY:
   *         Time: O(n^2)
   *         Space: O(1)
   */
  public static int longestSubArray01(int arr[], int n) {
    int res = 0;

    for (int i = 0; i < n; i++) {
      int c0 = 0, c1 = 0;
      for (int j = i; j < n; j++) {
        if (arr[j] == 1) {
          c1++;
        }

        if (arr[j] == 0) {
          c0++;
        }

        if (c1 == c0) {
          res = Math.max(res, c0 + c1);
        }
      }
    }

    return res;
  }

  /**
   * @desc Find the length of the subarray which has equal no. of 1s and 0s
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY:
   *         Time: O(n)
   *         Space: O(n)
   * 
   *         Approach:
   *         - Replace every 0 with -1
   *         - Call the function to find the longest subarray with "given" sum, in
   *         this case "0"
   */
  public static int longestSubArray01Better(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        arr[i] = -1;
      }
    }

    int len = LongestSubArraySum.longestSumSubArrayBetter(arr, n, 0);
    return len;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 1, 1, 0, 1, 0 };
    System.out.println("Longest sub array with equal 0s and 1s: " + longestSubArray01(arr, arr.length));
    System.out.println("Longest sub array with equal 0s and 1s: " + longestSubArray01Better(arr, arr.length));
  }
}
