package DSA.sorting;

import java.util.Arrays;

public class SortTwoTypeElements {

  /**
   * Seperating two types of elements can be:
   * - Seperate odd even nos.
   * - Seperate 0s and 1s
   * - Seperate +ve and -ve nos.
   */

  /**
   * @desc Seperate +ve and -ve numbers
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(n)
   * 
   *            This solution takes O(n) time but it requires
   *            O(n) space and does more than 1 traversal
   */
  public static void seperatePosNeg(int[] arr, int n) {
    int[] temp = new int[n];
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] < 0) {
        temp[count++] = arr[i];
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] >= 0) {
        temp[count++] = arr[i];
      }
    }

    System.out.println(Arrays.toString(temp));
  }

  /**
   * @desc Seperate +ve and -ve numbers
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(1)
   * 
   *            We can apply Hoare's partition method for such seggregation
   *            This requires 1 traversal and does not need extra space
   * 
   *            Approach:
   *            - There are 2 pointers on each side of the array
   *            - Increase the 'left pointer' until -ve elements are encountered
   *            - Decrease the 'right pointer' until +ve elements are encountered
   *            - If +ve no. is found on the left side stop the 'left pointer'
   *            - If -ve no. is found on the right side stop the 'right pointer'
   *            - Do a swap for arr[i] and arr[j]
   *            - Return if "i" and "j" meet or cross each other
   */
  public static void seperatePosNegBetter(int[] arr, int n) {
    int i = -1, j = n;

    while (true) {
      do {
        i++;
      } while (arr[i] < 0);

      do {
        j--;
      } while (arr[j] >= 0);

      if (i >= j) {
        return;
      }

      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 13, -12, 18, -10 };
    seperatePosNeg(arr, arr.length);
    seperatePosNegBetter(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
