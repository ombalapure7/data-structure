package DSA.sorting.algorithms;

import java.util.Arrays;

public class QuickSort {

  /**
   * @desc Sort an ay using the quick sort algorithm
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*logn)
   *            Space: O(n)
   * 
   *            PRINCIPLE
   *            Find a pivot point and place the elements smaller than the pivot
   *            element on the right and greater ones on the left.
   * 
   *            NOTE:
   *            - Divide and conquer algorithm
   *            - Worst time taken is O(n^2)
   *            - Considered good as it is - inplace, cache friendly, average time
   *            is n*logn
   *            - Parition is the key functiion
   *            - Tail recursive (doing recursive call as last thing)
   *            - Java uses QUICK sort for primitive types and TIM sort for
   *            non-primitives. TIM Sort is a variation of merge sort.
   */
  public static void quickSort(int[] arr, int l, int h) {
    if (l < h) {
      // int p = partition(arr, l, h, h);
      // int p = lombutoPartition(arr, l, h);
      int p = hoaresPartition(arr, l, h);
      quickSort(arr, l, p - 1);
      quickSort(arr, p + 1, h);
    }
  }

  /* Naive paritition method */
  public static int partition(int[] arr, int l, int h, int p) {
    int[] temp = new int[h - l + 1];
    int index = 0;

    // Copy all the smaller elements to temp[]
    for (int i = l; i <= h; i++) {
      if (arr[i] < arr[p]) {
        temp[index++] = arr[i];
      }
    }

    // Copy all the equal elements to temp[]
    // This is done to get the last occurence of the pivot incase there are
    // duplicates
    for (int i = l; i <= h; i++) {
      if (arr[i] == arr[p]) {
        temp[index++] = arr[i];
      }
    }

    // Copy all the greater elements to temp[]
    int res = l + index - 1;
    for (int i = l; i <= h; i++) {
      if (arr[i] > arr[p]) {
        temp[index++] = arr[i];
      }
    }

    // Copy the elements from temp[] to arr[]
    for (int i = l; i <= h; i++) {
      arr[i] = temp[i - l];
    }

    return res;
  }

  /* Lomuto partition */
  public static int lombutoPartition(int[] arr, int l, int h) {
    // Consider the last element as pivot
    int pivot = arr[h];
    // "i" is -1 initially
    int i = l - 1;

    // Elements from 0 to i are smaller than pivot
    // Element from (i+1) to j are greater than pivot
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[h];
    arr[h] = temp;
    return i + 1;
  }

  /* Hoare parition */
  public static int hoaresPartition(int[] arr, int l, int h) {
    // Consider the first element as pivot
    // i = low - 1 and j = high + 1
    // i and j are moved closer to each other
    int pivot = arr[l];
    int i = l - 1, j = h + 1;

    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);

      do {
        j--;
      } while (arr[j] > pivot);

      if (i >= j) {
        return j;
      }

      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 5, 13, 6, 9, 12, 11, 8 };
    int n = arr.length;
    quickSort(arr, 0, n - 1);
    System.out.println(Arrays.toString(arr));
  }
}