package DSA.searching;

public class MinPages {

  /**
   * @desc Min no. of pages that can be read by "k" students
   *       Maximum no. of pages allocated is minimum
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(2^n)
   * Space: O(n)
   */
  public static int minNoOfPages(int[] arr, int n, int k) {
    if (k == 1) {
      return sum(arr, 0, n-1);
    }

    if (n == 1) {
      return arr[0];
    }

    int res = Integer.MAX_VALUE;
    for (int i=0; i<n; i++) {
      res = Math.min(res, Math.max(minNoOfPages(arr, i, k-1), sum(arr, i, n-1)));
    }

    return res;
  }

  /* Helper function to find the sum of subarray elements */
  public static int sum(int arr[], int b, int e) {
    int s = 0;
    for (int i = b; i <= e; i++) {
      s += arr[i];
    }

    return s;
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 10, 30 };
    System.out.println("Minimum no. of pages - Naive: " + minNoOfPages(arr, arr.length, 2));
  }
}
