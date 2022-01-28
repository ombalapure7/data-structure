package DSA.hashing;

import java.util.HashMap;

public class LongestSubArraySum {
  /*
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public static int longestSumSubArray(int arr[], int n, int sum) {
    int res = 0;
    for (int i = 0; i < n; i++) {
      int currSum = 0;
      for (int j = i; j < n; j++) {
        currSum += arr[j];
        if (currSum == sum) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  /**
   * @desc Max length of subarray with a given sum
   * @param arr
   * @param n
   * @param sum
   * @return
   * 
   *         COMPLEXITY:
   *         Time: O(n)
   *         Space: O(n)
   */
  public static int longestSumSubArrayBetter(int arr[], int n, int sum) {
    // Using a hashmap as we have - key => preSum and value => index
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    int preSum = 0;

    for (int i = 0; i < n; i++) {
      preSum += arr[i];

      // Found subarray at the beggining itself equal to "sum"
      if (preSum == sum) {
        res = i + 1;
      }

      // If the current "prefix" does not exist in the "map", then add it
      if (!map.containsKey(preSum)) {
        map.put(preSum, i);
      }

      // Given "sum" exist in the "map"
      if (map.containsKey(preSum - sum)) {
        res = Math.max(res, i - map.get(preSum));
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 2, 3, 4 };
    System.out.println("Max length sum sub array - Naive: " + longestSumSubArray(arr, arr.length, 5));

    int[] newArr = { 5, 8, -4, -4, 9, -2, 2 };
    System.out.println("Max length sum sub array - Better: " + longestSumSubArrayBetter(newArr, newArr.length, 4));
  }
}
