package DSA.sorting.algorithms;

import java.util.Arrays;

public class SelectionSort {

  /**
   * @desc Sort an array using the selection sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*n)
   *            Space: O(1)
   * 
   *            PRINCIPLE
   *            Find the minimum element and place it at the 0th index.
   *            In 2nd iteration find the 2nd minimum element and place it at the
   *            1st index and so on.
   * 
   *            NOTE:
   *            - The complexity will be n^2 in all case, however it takes less
   *            memory writes than quick, insertion or merge sort
   *            - Cycle sort is better than Selection sort in terms of reduced
   *            memory writes
   *            - Has basic idea of heap sort
   *            - Not stable but is inplace
   */
  public static void selectionSort(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      int min = Integer.MAX_VALUE;
      int minIndex = -1;

      for (int j = i; j < n; j++) {
        if (arr[j] < min) {
          min = arr[j];
          minIndex = j;
        }
      }

      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;

      // OR

      // int minIndex = i;
      // for (int j = i + 1; j < n; j++) {
      // if (arr[j] < arr[minIndex]) {
      // minIndex = j;
      // }
      // }

      // int temp = arr[minIndex];
      // arr[minIndex] = arr[i];
      // arr[i] = temp;
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int[] arr = { 10, 5, 8, 20, 2, 18 };
    selectionSort(arr, arr.length);
  }
}
