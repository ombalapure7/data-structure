package DSA.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArraySumZero {

  /**
   * @desc Check if a sunarray has sum of 0
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   */
  public static boolean hasSubArrayZeroSum(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      int currentSum = 0;
      for (int j = i; j < n; j++) {
        currentSum += arr[j];
        if (currentSum == 0) {
          return true;
        }
      }
    }

    return false;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * Approach:
   * - a0,a1,ai-1 => prefixSum1 and ai,ai+1,...aj...an-1 => prefixSum2
   * - prefixSum2 = prefixSum1 + 0
   * 
   * - Traverse array from left to right and keep computing the prefix-sum
   * - Computed prefix sums are stored in the set
   * - If the current prefix-sum is present in the set
   *    Return true
   * - Else 
   *    Keep computing the prefix sum and check if it exists in the set
   */
  public static boolean hasSubArrayZeroSumHash(int arr[], int n) {    
    Set<Integer> set = new HashSet<>();
    int preSum = 0;

    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];

      if (set.contains(preSum)) {
        return true;
      }

      // Eg: [-3,2,1,4] the prefix sum itself becomes 0, so we return true
      if (preSum == 0) {
        return true;
      }

      set.add(preSum);
    }

    return false;
  }

  public static void main(String[] args) {
    int arr[] = { -4, 3, 1, 2};
    System.out.println("Has sub array 0 sum - Naive: " + hasSubArrayZeroSum(arr, arr.length));
    System.out.println("Has sub array 0 sum - Efficient: " + hasSubArrayZeroSumHash(arr, arr.length));
  }
}
