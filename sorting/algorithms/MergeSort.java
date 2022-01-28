package DSA.sorting.algorithms;

import java.util.Arrays;

public class MergeSort {
  /**
   * @desc Sort an array using the merge sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*logn)
   *            Space: O(n)
   * 
   *            PRINCIPLE
   * 
   *            NOTE:
   *            - Divide and conquer algorithm
   *            - Stable and takes O(n*logn) time and O(n) space
   *            - Good for linkedlists are space taken is O(1)
   *            - Quick sort outperforms it incase of arrays
   */
  public static void mergeSort(int[] arr, int left, int right) {
    // Atleast 2 elemets must be there
    if (right > left) {
      int mid = left + (right - left) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  /* Function to merge two arrays */
  public static void merge(int[] arr, int low, int mid, int high) {
    // STEP 1: Setup aux arrays
    int n1 = mid - low + 1, n2 = high - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++) {
      left[i] = arr[i + low];
    }

    for (int j = 0; j < n2; j++) {
      right[j] = arr[mid + 1 + j];
    }

    // STEP 2: Merge the two arrays
    int i = 0, j = 0, k = low;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    // Copy remaining elements
    while (i < n1) {
      arr[k++] = left[i++];
    }

    while (j < n2) {
      arr[k++] = right[j++];
    }
  }

  public static void main(String[] args) {
    int[] arr = { 10, 15, 20, 40, 8, 11, 15, 22, 25 };
    mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    // merge(arr, 0, arr.length/2 - 1, arr.length-1);
  }
}
