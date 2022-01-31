package DSA.hashing;

import java.util.HashMap;

public class DistinctElementsInEveryWindow {

  /**
   * @desc Count no. of distinct elements in every window
   * @param arr
   * @param n
   * @return
   * 
   *         No. of windows in an array of size "n" with window size as "k"
   *         will be equal to => n - k + 1
   * 
   *         COMPLEXITY
   *         Time: O((n-k)*k*k)
   *         Space: O(1)
   * 
   *         The complexity will be cubic if the window is big
   */
  public static void distinctElementsInEveryWindow(int[] arr, int n, int k) {
    for (int i = 0; i < n - k + 1; i++) {
      int count = 0;
      for (int j = 0; j < k; j++) {
        boolean flag = false;
        for (int p = 0; p < j; p++) {
          if (arr[i + j] == arr[i + p]) {
            flag = true;
            break;
          }
        }

        if (!flag) {
          count++;
        }
      }
      
      System.out.print(count + " ");
    }

    System.out.println();
  }

  /**
   * @desc Count no. of distinct elements in every window
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(n)
   * 
   *         Approach
   *         - Create frequency map of first "k" elements
   *         - Print size of the map
   *         - Decrease frequency of arr[i-k]
   *         - If frequency of arr[i-k] becomes "0" then remove it from the map
   *         - If arr[i] does not exist in the map, insert it
   *         - Else increase it's frequency in the map
   *         - Print the size of the map
   */
  public static void distinctElementsInEveryWindowBetter(int[] arr, int n, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    // Count frequency of first "k" elements
    for (int i = 0; i < k; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    System.out.print(map.size() + " ");

    for (int i = k; i < n; i++) {
      // Remove the item from the start of the window
      map.put(arr[i - k], map.get(arr[i - k]) - 1);

      // Remove items whose frequency becomes "0"
      if (map.get(arr[i - k]) == 0) {
        map.remove(arr[i - k]);
      }

      // Add item from the last of the window
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }

      /* Syntactic sugar for the above piece of code */
      // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

      System.out.print(map.size() + " ");
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 20, 20, 10, 30, 40, 10 };
    distinctElementsInEveryWindow(arr, arr.length, 4);
    distinctElementsInEveryWindowBetter(arr, arr.length, 4);
  }
}
