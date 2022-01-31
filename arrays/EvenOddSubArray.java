package DSA.arrays;

public class EvenOddSubArray {

  /**
   * @desc Find length of a subarray which contains odd & even nos. alternatingly
   * @param arr
   * @param n
   * @return
   * 
   *         Time Complexity: O(n^2)
   *         Space Complexity: O(1)
   */
  public static int maxLenOddEvenSubArray(int arr[], int n) {
    int res = 1;

    for (int i = 0; i < n; i++) {
      int current = 1;
      for (int j = i + 1; j < n; j++) {
        if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) || (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0)) {
          current++;
        } else {
          break;
        }
      }
      res = Math.max(res, current);
    }

    // op: Longest odd even sub array - Naive: 3
    return res;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static int maxLenOddEvenSubArrayBetter(int arr[], int n) {
    int res = 1, current = 1;
    for (int i = 1; i < n; i++) {
      if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
        current++;
        res = Math.max(res, current);
      } else {
        current = 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 10, 20, 6, 3, 8, 1, 2 };
    System.out.println("Longest odd even sub array - Naive: " + maxLenOddEvenSubArray(arr, arr.length));
    System.out.println("Longest odd even sub array - Efficient: " + maxLenOddEvenSubArrayBetter(arr, arr.length));
  }
}
