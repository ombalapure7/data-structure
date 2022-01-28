package DSA.hashing;

import java.util.HashSet;

public class SubArrayGivenSum {

  /**
   * @desc Check if there is a subarray with given sum
   * @param arr
   * @param n
   * @param sum
   * @return
   * 
   * COMPLEXITY
   * Time: O(n*n)
   * Space: O(1)
   */
  public static boolean subArrayGivenSum(int arr[], int n, int sum) {
    for (int i = 0; i < n; i++) {
      int currSum = 0;
      for (int j = i; j < n; j++) {
        currSum += arr[j];
        if (currSum == sum) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * @desc Check if there is a subarray with given sum
   * @param arr
   * @param n
   * @param sum
   * @return
   * 
   *  Appraoch:
   *  - Calculate the prefix sum and store in hashset
   *  - We need to check if "prefixsum - sum" already exists in the set
   *  - If yes -> Return true
   *  - Else -> Keep calculating the prefixsum and check if it is present in the set
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   */
  public static boolean subArrayGivenSumBetter(int[] arr, int n, int sum) {
    HashSet<Integer> set = new HashSet<>();
    int prefixSum = 0;

    for (int i = 0; i < n; i++) {
      prefixSum += arr[i];

      if (prefixSum == sum) {
        return true;
      }

      if (set.contains(prefixSum - sum)) {
        return true;
      }

      set.add(prefixSum);
    }

    return false;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 8, 3, 3, 13 }; // 14
    System.out.println("Array has subarray with given sum - Naive: " + subArrayGivenSum(arr, arr.length, 14));

    int[] newArr = { 5, 8, 6, 13, 3, -1 }; // 22
    System.out
        .println("Array has subarray with given sum - Better: " + subArrayGivenSumBetter(newArr, newArr.length, 22));
  }
}
