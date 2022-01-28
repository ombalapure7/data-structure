package DSA.sorting;

import java.util.Arrays;

public class KthSmallest {
  
  /**
   * @desc Find the kth smallest element in the array
   * @param arr
   * @param n
   * @param k
   * @return
   * 
   * Assuming that the array contains distinct elements
   * Sort the array and return the element at the (k-1)th index
   * 
   * COMPLEXITY
   * Time: O(n*logn)
   * Space: O(n)
   */
  public static int kthSmallestElement(int[] arr, int n, int k) {
    Arrays.sort(arr);
    return k-1;
  }

  /**
   * @desc Find the kth smallest element in the array
   * @param arr
   * @param n
   * @param k
   * @return
   * 
   * Assuming that the array contains distinct elements
   * Sort the array and return the element at the (k-1)th index
   * 
   * COMPLEXITY
   * Time: O(n*logn)
   * Space: O(n)
   */
  public static int kthSmallestElementBetter(int[] arr, int n, int k) {
    return 0;
  }

  public static void main(String[] args) {
    int[] arr = {10, 5, 30, 12};
    System.out.println("Kth smallest element - Naive: " + kthSmallestElement(arr, arr.length, 2));
  }

}
