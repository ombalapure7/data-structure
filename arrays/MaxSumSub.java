package DSA.arrays;

public class MaxSumSub {

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(1)
   */
  public static int maxSumSubArray(int arr[], int n) {
    int res = arr[0];
    for (int i = 1; i < n; i++) {
      int current = 0;
      for (int j = i; j < n; j++) {
        current = current + arr[j];
        res = Math.max(res, current);
      }
    }

    return res;
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   */
  public static int maxSumSubArrayBetter(int arr[], int n) {
    int res = arr[0];
    int maxEnding = arr[0];

    for (int i=1; i<n; i++) {
      // Compare the addition result with the current element
      // The greater value will be stored
      maxEnding = Math.max(maxEnding + arr[i], arr[i]);
      // Again there may be a case value in "res" might be bigger
      // then the addition value
      res = Math.max(res, maxEnding);
    }
    
    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 1, -2, 3, -1, 2 };
    System.out.println("Max sum sub array - Naive: " + maxSumSubArray(arr, arr.length));
    System.out.println("Max sum sub array - Efficient: " + maxSumSubArrayBetter(arr, arr.length));
  }

}
