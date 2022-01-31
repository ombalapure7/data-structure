package DSA.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

  /**
   * @desc The elements might repeat so find the
   *       the no. of distinct elements in the array
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*n)
   *         Space: O(1)
   */
  public static int countDistinct(int arr[], int n) {
    int count = 0;

    for (int i = 0; i < n; i++) {
      boolean flag = false;

      // Check if current element has appeared before
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          // Break loop if element was seen earlier
          break;
        }
      }

      if (!flag) {
        count++;
      }
    }

    return count;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static int countDistinctHash(int arr[], int n) {
    // Set<Integer> set = new HashSet<>(Arrays.asList(arr));
    // return set.size();

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    return set.size();
  }

  public static void main(String[] args) {
    // int arr[] = { 15, 16, 27, 27, 28, 15 };
    // int[] arr = { 15, 12, 13, 12, 13, 13, 8 };
    int[] arr = {4, 5, 3, 3, 8, 5};
    System.out.println("No. of distinct elements - Naive: " + countDistinct(arr, arr.length));
    System.out.println("No. of distinct elements - Efficient: " + countDistinctHash(arr, arr.length));
  }
}