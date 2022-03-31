package DSA.arrays;

import java.util.Arrays;

public class TrappingRainWater {

  /**
   * @desc Find the trapped units of water
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   * 
   *         NOTE: If the array is in sorted, 0 units of water will be collected
   */
  public static int trappingRainWater(int arr[], int n) {
    int quantity = 0;

    for (int i = 1; i < n - 1; i++) {
      int leftMax = arr[i];
      // Keep track of left bar height
      for (int j = 0; j < i; j++) {
        leftMax = Math.max(leftMax, arr[j]);
      }

      int rightMax = arr[i];
      // Keep track of right bar height
      for (int j = i + 1; j < n; j++) {
        rightMax = Math.max(rightMax, arr[j]);
      }

      // We have the left and right bar height now
      // quantity can be calculated
      quantity += (Math.min(leftMax, rightMax) - arr[i]);
    }

    return quantity;
  }

  /**
   * @desc
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(1)
   * 
   *         Approach:
   *         - Compute the left and right max height of the bars separately
   *         - Once done find value of "Math.min(leftMax[i], rightMax[i]) -
   *         arr[i]"
   *         - Start adding up the value calculated from the above step in each
   *         iteration
   */
  public static int trappingRainWaterBetter(int arr[], int n) {
    // leftMax and rightMax is precomputed
    int res = 0, leftMax[] = new int[n], rightMax[] = new int[n];

    // arr: 5, 0, 6, 2, 3
    leftMax[0] = arr[0];
    for (int i = 1; i < n; i++) {
      // 5 5 6 6 6
      leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
    }

    rightMax[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 1; i--) {
      // 6 6 6 3 3
      rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
    }

    for (int i = 1; i < n - 1; i++) {
      res += Math.min(leftMax[i], rightMax[i]) - arr[i];
    }

    return res;
  }

  public static void main(String[] args) {
    // int arr[] = { 3, 0, 1, 2, 5 };
    // int arr[] = { 3, 5, 2, 3 };
    int arr[] = { 5, 0, 6, 2, 3 };
    System.out.println("Water units trapped - Naive: " + trappingRainWater(arr, arr.length));
    System.out.println("Water units trapped - Efficient: " + trappingRainWaterBetter(arr, arr.length));
  }
}
