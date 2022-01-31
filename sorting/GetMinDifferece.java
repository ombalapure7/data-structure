package DSA.sorting;

import java.util.Arrays;

public class GetMinDifferece {

  /**
   * @desc Find the minimum diffence in an array
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   */
  public static int minDifference(int[] arr, int n) {
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        // min = Math.min(min, Math.abs(arr[j] - arr[i]));
        // OR
        if (Math.abs(arr[j] - arr[i]) < min) {
          min = Math.abs(arr[j] - arr[i]);
        }
      }
    }

    return min;
  }

  /**
   * @desc Find the minimum diffence in an array
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   * 
   *         Approach:
   *         - Sort the array
   *         - Find the difference of 2 adjacent elements
   *         - Keep track of the min difference
   *         - Return the min difference at the end
   */
  public static int minDifferenceBetter(int[] arr, int n) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n - 1; i++) {
      min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));
    }

    return min;
  }

  public static void main(String[] args) {
    // int[] arr = { 30, 5, 20, 9 }; // 4
    int[] arr = { 1, 19, -4, 31, 38, 25, 100 }; // 5
    System.out.println("Min difference - Naive: " + minDifference(arr, arr.length));
    System.out.println("Min difference - Better: " + minDifferenceBetter(arr, arr.length));
  }
}
