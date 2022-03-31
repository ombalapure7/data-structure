package DSA.arrays;

public class MaxDifference {

  /**
   * @desc Find the max difference arr[j] - arr[i] such that j > i
   * @param arr
   * @param n
   * @return
   * 
   *         Time Complexity: O(n^2)
   *         Space Complexity: O(1)
   */
  public static int maxDifference(int arr[], int n) {
    int res = arr[1] - arr[0];
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        res = Math.max(res, arr[j] - arr[i]);
      }
    }

    return res;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   * 
   * Approach:
   * - Consider every element as arr[j]
   * - And we keep track of the "min" value
   * - Keep track of (arr[j] - min)
   */
  public static int maxDifferenceBetter(int arr[], int n) {
    int res = arr[1] - arr[0], minValue = arr[0];
    for (int j = 1; j < n; j++) {
      res = Math.max(res, arr[j] - minValue);
      minValue = Math.min(minValue, arr[j]);
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = {2,3,10,6,4,8,1};
    System.out.println("Max difference in array - Naive: " + maxDifference(arr, arr.length));
    System.out.println("Max difference in array - Efficient: " + maxDifferenceBetter(arr, arr.length));
  }
}
