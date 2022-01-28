package DSA.sorting.algorithms;

import java.util.Arrays;

public class BubbleSort {

  /**
   * @desc Sort an array using the bubble sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*n)
   *            Space: O(1)
   * 
   *            PRINCIPLE
   *            Compare 2 adjacent elements and swap if necessary, do this in
   *            every iteration.
   *            The largest elements are moved to (n-1)th positions.
   */
  public static void bubbleSort(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  /**
   * @desc Sort an array using the bubble sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*n)
   *            Space: O(1)
   * 
   *            The above algorithm will take n^2 time even if the array is sorted
   *            So we add a flag "swapped" which is initialized as "true" if a
   *            swap happened
   *            If "swapped" equals 'false' that means the array is sorted, so we
   *            break the loop
   *            Hence the code takes O(n) time incase the array is sorted already
   */
  public static void bubbleSortOptimized(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          swapped = true;
        }
      }

      // No swappings were done in the first iteration.
      // This means the array is sorted, so break the loop
      if (!swapped) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    // int[] arr = { 2, 10, 8, 7 };
    int arr[] = { 2, 1, 4, 3 };
    bubbleSort(arr, arr.length);
  }
}
