package DSA.hashing;

import java.util.HashMap;

public class NKOccurrence {

  /**
   * @desc Find which elements appear more than n/k times
   * @param arr
   * @param n
   * @param k
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(n)
   */
  public static void moreThanNKOccurrence(int[] arr, int n, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    for (Integer key : map.keySet()) {
      if (map.get(key) > n / k) {
        System.out.print(key + " ");
      }
    }

    System.out.println();
  }

  /**
   * @desc Find which elements appear more than n/k times
   * @param arr
   * @param n
   * @param k
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(1)
   * 
   *            NOTE: This solution works in O(n) time BUT does not work for
   *            negative nos.
   */
  public static void moreThanNKOccurrenceOk(int[] arr, int n, int k) {
    int[] count = new int[256];
    for (int i = 0; i < n; i++) {
      count[arr[i]]++;
    }

    for (int i = 0; i < 256; i++) {
      if (count[i] > arr.length / k) {
        System.out.print(i + " ");
      }
    }

    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = { 30, 10, 20, 20, 10, 20, 30, 30 };
    moreThanNKOccurrence(arr, arr.length, 4);
    moreThanNKOccurrence(arr, arr.length, 4);
  }
}
