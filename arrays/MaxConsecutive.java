package DSA.arrays;

public class MaxConsecutive {

  /*
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public static int maxConsecutiveOnes(int arr[], int n) {
    int res = 0;
    for (int i = 0; i < n; i++) {
      int current = 0;
      for (int j = i; j < n; j++) {
        if (arr[j] == 1) {
          current++;
        } else {
          break;
        }
      }

      res = Math.max(res, current);
    }

    return res;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static int maxConsecutiveOnesBetter(int arr[], int n) {
    int res = 0, current = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0 || arr[i] != 1) {
        current = 0;
      } else {
        current++;
        res = Math.max(res, current);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 0, 1, 1, 1, 1, 0 };
    System.out.println("Max Consecutive - Naive: " + maxConsecutiveOnes(arr, arr.length));
    System.out.println("Max Consecutive - Efficient: " + maxConsecutiveOnesBetter(arr, arr.length));
  }
}
