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
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   * It requires O(n) space and requires more than 1 traversal
   */
  public static void seperatePosNeg(int[] arr, int n) {
    int[] temp = new int[n];
    int count = 0;

    for (int i=0; i<n; i++) {
      if (arr[i] < 0) {
        temp[count++] = arr[i];
      }
    }

    for (int i=0; i<n; i++) {
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
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void seperatePosNegBetter(int[] arr, int n) {
    
  }

   public static void main(String[] args) {
     int[] arr = {13, -12, 18, -10};
     seperatePosNeg(arr, arr.length);
     seperatePosNeg(arr, arr.length);
   }

}
