package DSA.hashing;

import java.util.HashSet;
import java.util.Set;

public class PariSum {

  /*
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   * 
   * There will be n*(n-1)/2 pairs, 1 element can be paired with n-1 elements
   * There will be repeated pairs eg: 8,3 and 3,8 -- so we divide by 2
   */
  public static void pairSum(int arr[], int n, int sum) {
    for (int i = 0; i < n; i++) {
      // We don't start from 0th index again
      // As we want to avoid duplicate pairs
      for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == sum) {
          System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
        }
      }
    }
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static void pairSumHash(int arr[], int sum) {
    Set<Integer> set = new HashSet<>();

    for (int x : arr) {
      if (set.contains(sum - x)) {
        System.out.println(sum - x + " + " + x + " = " + sum);
      } else {
        set.add(x);
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 8, 3, 4, 9 };
    pairSum(arr, arr.length, 13);

    int newArr[] = { 8, 3, 4, 2, 5 };
    pairSumHash(newArr, 6);
  }
}
