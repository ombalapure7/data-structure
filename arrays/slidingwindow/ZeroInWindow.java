package DSA.arrays.slidingwindow;

public class ZeroInWindow {

  /**
   * @desc Largest element in each window
   * @param arr
   * @param n
   * @param k
   * 
   *            COMPLEXITY
   *            Time: O((n-k) * k)
   *            Space: O(1)
   */
  public static void zeroInWindow(int[] arr, int n, int k) {
    String indecies = "";

    for (int i = 0; i < n - k + 1; i++) {
      boolean hasZero = false;
      int index = 0;
      for (int j = 0; j < k; j++) {
        if (arr[i + j] == 0) {
          hasZero = true;
          index = (i + j) + 1;
        }
      }

      if (hasZero) {
        indecies += String.valueOf(index) + " ";
      } else {
        indecies += "-1 ";
      }
    }

    System.out.println(indecies.substring(0, indecies.length() - 1));
  }

  public static void main(String[] args) {
    int[] arr = { 1, 0, 6, 7, 4, 0, 9 };
    zeroInWindow(arr, arr.length, 2);
  }
}
