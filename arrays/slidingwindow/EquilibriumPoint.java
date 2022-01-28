package DSA.arrays.slidingwindow;

public class EquilibriumPoint {

  /**
   * @desc Check if the sum of elements before and after an element is equal to
   *       the "given element"
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*n)
   *         Space: O(1)
   */
  public static boolean hasEquilibriumPoint(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      int leftSum = 0, rightSum = 0;

      // Get the left sum
      for (int j = 0; j < i; j++) {
        leftSum += arr[j];
      }

      // Get the right sum
      for (int j = i + 1; j < n; j++) {
        rightSum += arr[j];
      }

      // Compare the left and the right sum
      // Return true if we have an equilibrium at any point
      if (leftSum == rightSum) {
        return true;
      }
    }

    return false;
  }

  /**
   * @desc Check if the sum of elements before and after an element is equal to
   *       the "given element"
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(1)
   */
  public static boolean hasEquilibriumPointBetter(int[] arr, int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }

    int leftSum = 0;
    for (int i = 0; i < n; i++) {
      if (leftSum == sum - arr[i]) {
        return true;
      }

      leftSum += arr[i];
      sum -= arr[i];
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 4, 8, -9, 20, 6 };
    // int[] arr = {2, -2, 4};
    System.out.println("Has equilibrium point - Naive: " + hasEquilibriumPoint(arr, arr.length));
    System.out.println("Has equilibrium point - Better: " + hasEquilibriumPointBetter(arr, arr.length));
  }
}
