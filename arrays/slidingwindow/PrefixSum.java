package DSA.arrays.slidingwindow;

public class PrefixSum {

  /**
   * @desc Pass 2 indexes and return the sum of all the elements present b/w those
   *       indices
   * @param arr
   * @param n
   * @return
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static int prefixSum(int[] arr, int n, int left, int right) {
    int sum = 0;

    for (int i = left; i <= right; i++) {
      sum += arr[i];
    }

    return sum;
  }

  /**
   * @desc Pass 2 indexes and return the sum of all the elements present b/w those
   *       indices
   * @param arr
   * @param n
   * @return
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(1)
   * 
   * Approach:
   * - Create a prefix array
   * - Once the prefix array is ready and we have left and right indexes, do:
   *    => arr[right] - arr[left - 1]
   */
  public static int prefixSumBetter(int[] arr, int left, int right) {
    // left = 0 means sum from the beginning of the array
    if (left != 0) {
      return arr[right] - arr[left - 1];
    } else {
      // Return the last element as it contains the sum of all the elements
      // present in the array
      return arr[right];
    }
  }

  // Takes O(n) time to construct the prefix sum array
  // Aux space taken will be O(n)
  public static int[] createPrefixArray(int[] arr, int n) {
    int[] prefix = new int[n];
    prefix[0] = arr[0];

    for (int i=1; i<n; i++) {
      prefix[i] = arr[i] + prefix[i-1];
    }

    return prefix;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 8, 3, 9, 6, 5, 4 };
    System.out.println("Prefix Sum - Naive: " + prefixSum(arr, arr.length, 2, 4));

    int[] prefix = createPrefixArray(arr, arr.length);
    System.out.println("Prefix Sum - Better: " + prefixSumBetter(prefix, 2, 4));
  }
}

