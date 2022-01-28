package DSA.sorting.algorithms;

import java.util.Arrays;

public class InsertionSort {

  /**
   * @desc Sort an array using the insertion sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*n)
   *            Space: O(1)
   * 
   *            PRINCIPLE
   *            Consider the 0th index as a sorted part of the array.
   *            Now begin from 1st index and comapre it with element at 0th index,
   *            do swapping if necessary or else move to the next index.
   *            This way we maintain a sorted portion of the array from the 0th
   *            index.
   *            So greater element are shifter by 1 step in every iteration
   *            towards right.
   * 
   *            NOTE:
   *            - Takes n^2 time in worst case
   *            - Its in place and stable
   *            - Better for small arrays
   *            - Takes O(n) time in best case - when array is sorted
   */
  public static void insertionSort(int[] arr, int n) {
    for (int i = 1; i < n; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j--;
      }

      arr[j + 1] = temp;
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int[] arr = { 10, 5, 8, 20, 2, 18 };
    insertionSort(arr, arr.length);
  }
}
