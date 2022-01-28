package DSA.searching;

import java.util.Arrays;

public class RepeatingElements {

  /**
   * @desc Find a repeating element - Naive
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   */
  public static int repeatingElement(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          return arr[i];
        }
      }
    }

    return -1;
  }

  /**
   * @desc Find a repeating element - Better
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*logn)
   *         Space: O(1)
   * 
   *         Approach:
   *         - Sort the array (repeating occurences are grouped)
   *         - Compare 2 adjacent elements
   *         -> If elements match return it
   *         -> Else move to next index
   * 
   *         NOTE: This solution modifies the existing array
   */
  public static int repeatingElementBetter(int[] arr, int n) {
    Arrays.sort(arr);

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        return arr[i];
      }
    }

    return -1;
  }

  /**
   * @desc Find a repeating element - Efficient
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(n)
   * 
   *         Approach:
   *         - Maintain a boolean array of size arr[]
   *         - Every visisted element is marked as visited in the boolean array
   *         - If the current element is already visisted - return it
   *         - Else mark the current element as visisted - move to the next index
   * 
   *         NOTE: This solution works iff -> max element < length of array
   */
  public static int repeatingElementEfficient(int[] arr, int n) {
    boolean[] visisted = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (visisted[arr[i]]) {
        return arr[i];
      }

      visisted[arr[i]] = true;
    }

    return -1;
  }

  /**
   * @desc Find a repeating element - Best
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(1)
   * 
   *         Approach:
   *         - Use Floyd's cycle detection algorithm
   */
  public static int repeatingElementBest(int[] arr, int n) {
    int slow = arr[0], fast = arr[0];

    do {
      slow = arr[slow];
      fast = arr[arr[fast]];

    } while (slow != fast);

    slow = arr[0];

    while (slow != fast) {
      slow = arr[slow];
      fast = arr[fast];
    }

    return slow;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 4, 6, 5, 7, 3 };
    System.out.println("Repeating element is - Naive: " + repeatingElement(arr, arr.length));
    System.out.println("Repeating element is - Better: " + repeatingElementBetter(arr, arr.length));
    System.out.println("Repeating element is - Efficient: " + repeatingElementEfficient(arr, arr.length));
    System.out.println("Repeating element is - Best: " + repeatingElementBest(arr, arr.length));
  }
}
