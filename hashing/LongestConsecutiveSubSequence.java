package DSA.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubSequence {

  /**
   * @desc Length of subsequence in the form of x, x+1, x+2
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*logn)
   *         Space: O(1)
   * 
   *         Approach:
   *         - Sort the array
   *         - Now traverse the array linearly
   *         - If the sequcence breaks then set the length as 1
   *         - Else keep increasing the length counter
   */
  public static int longestConsecutiveSubSequence(int[] arr, int n) {
    Arrays.sort(arr);

    int res = 1, curr = 1;
    for (int i = 1; i < n; i++) {
      // Check if the previous element is smaller by '1'
      if (arr[i] == arr[i - 1] + 1) {
        curr++;
      } else {
        res = Math.max(res, curr);
        curr = 1;
      }
    }

    res = Math.max(res, curr);
    return res;
  }

  /**
   * @desc Length of subsequence in the form of x, x+1, x+2
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(n)
   * 
   *         Approach:
   *         - Insert every element in hashset.
   *         - With "2n" lookups, find the result.
   */
  public static int longestConsecutiveSubSequenceBetter(int[] arr, int n) {
    HashSet<Integer> set = new HashSet<>();

    // Add all the elements to the set
    for (Integer x : arr) {
      set.add(x);
    }

    int res = 1;
    for (Integer x : set) {
      // Start looking forward as the previous smaller element is not present
      if (!set.contains((x - 1))) {
        int curr = 1;
        // Increase the "curr" till element at i+1th > element at ith index by "1"
        while (set.contains(x + curr)) {
          curr++;
        }
        // Get the length which is greater
        res = Math.max(res, curr);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 1, 9, 3, 4, 2, 10, 13 };
    System.out
        .println("Length of the longest consecutive subsequence: " + longestConsecutiveSubSequence(arr, arr.length));

    System.out
        .println(
            "Length of the longest consecutive subsequence: " + longestConsecutiveSubSequenceBetter(arr, arr.length));
  }
}
