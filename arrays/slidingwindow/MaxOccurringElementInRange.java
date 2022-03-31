package DSA.arrays.slidingwindow;

import java.util.HashMap;

public class MaxOccurringElementInRange {

  /**
   * @desc  Find max occuring element in given ranges
   * @param L
   * @param R
   * @param n
   * @return
   * 
   * COMPLEXITY
   * Time: O(n * m)
   * Space: O(n * m)
   * 
   * n: Length of L[i] or R[i]
   * m: Length of range from L[i] to R[i]
   */
  public static int maxOccurringElementInRange(int[] L, int[] R, int n) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int left = L[i];
      int right = R[i];

      for (int j = left; j <= right; j++) {
        if (map.containsKey(j)) {
          map.put(j, map.get(j)+1);
        } else {
          map.put(j, 1);
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (Integer key : map.keySet()) {
      // if (map.get(key) > max) {
      //   max = map.get(key);
      // }
      // OR
      max = Math.max(max, map.get(key));
    }

    return max;
  }

  public static void main(String[] args) {
    int L[] = { 1, 2, 3 }, R[] = { 3, 5, 7 }, n = 3;
    System.out.println("Max occurring element in range - Naive: " + maxOccurringElementInRange(L, R, n));
  }
}
