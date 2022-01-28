package DSA.searching;

import java.util.Arrays;
import java.util.HashSet;

public class TwoPointers {

  /**
   * @desc Check if a pair exists that equals to the given sum
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n/2) =~ O(n) - If array is already sorted
   *         Space: O(1)
   * 
   *         The two pointer approach can be applied if the array is sorted
   *         If the array is not sorted then HAHSING will be a better option
   */
  public static boolean pairSum(int[] arr, int n, int sum) {
    Arrays.sort(arr);
    int low = 0, high = n - 1;

    while (low <= high) {
      if (arr[low] + arr[high] > sum) {
        high--;
      } else if (arr[low] + arr[high] < sum) {
        low++;
      } else if (arr[low] + arr[high] == sum) {
        System.out.println(arr[low] + " + " + arr[high] + " = " + sum);
        return true;
      }
    }

    return false;
  }

  /**
   * @desc Check if a pair exists that equals to the given sum - Naive
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^3)
   *         Space: O(1)
   * 
   *         The two pointer approach can be applied if the array is sorted
   *         If the array is not sorted then HAHSING will be a better option
   */
  public static boolean tripletSum(int[] arr, int n, int sum) {
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            System.out.println(arr[i] + " + " + arr[j] + " + " + arr[k] + " = " + sum);
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * @desc Check if a pair exists that equals to the given sum - Optimized
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   * 
   *         The two pointer approach can be applied if the array is sorted
   *         We apply the "pairSum" logic for every index
   */
  public static boolean tripletSumBetter(int[] arr, int n, int sum) {
    for (int i = 0; i < n; i++) {
      int l = i + 1;
      int r = n - 1;

      // Using the pair sum logic
      while (l < r) {
        if (arr[i] + arr[l] + arr[r] == sum) {
          System.out.println(arr[i] + " + " + arr[l] + " + " + arr[r] + " = " + sum);
          return true;
        } else if (arr[i] + arr[l] + arr[r] < sum) {
          l++;
        } else {
          r--;
        }
      }
    }

    return false;
  }

  /**
   * @desc Check if a pair exists that equals to the given sum - Hashing
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(n)
   */
  public static boolean tripletSumBetterHashing(int arr[], int n, int sum) {
    HashSet<Integer> s = new HashSet<Integer>();

    for (int i = 0; i < n - 2; i++) {
      int currSum = sum - arr[i];
      for (int j = i + 1; j < n; j++) {
        if (s.contains(currSum - arr[j])) {
          System.out.println(arr[i] + " + " + arr[j] + " + " + (currSum - arr[j]) + " = " + sum);
          return true;
        }
        s.add(arr[j]);
        System.out.println("Inside: " + s.size());
      }
      s.clear();
      System.out.println("Outside: " + s.size());
    }

    return false;
  }

  public static void main(String[] args) {
    // int[] arr = { 3, 5, 9, 2, 8, 10, 11 };
    int[] arr = { 2, 4, 8, 9, 11, 12, 20, 30 };
    System.out.println("Does a pair sum exist: " + pairSum(arr, arr.length, 17));
    System.out.println("*******************************");
    System.out.println("Does a triplet sum exist - Naive: " + tripletSum(arr, arr.length, 17));
    System.out.println("*******************************");
    System.out.println("Does a triplet sum exist - Better: " + tripletSumBetter(arr, arr.length, 17));
    System.out.println("*******************************");
    System.out.println("Does a triplet sum exist - Hashing: " + tripletSumBetterHashing(arr, arr.length, 17));
  }
}
