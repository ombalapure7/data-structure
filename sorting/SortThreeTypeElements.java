package DSA.sorting;

import java.util.Arrays;

public class SortThreeTypeElements {

  /**
   * @desc Sort an array containing 0s, 1s and 2s
   * @param arr
   * @param n
   * 
   *            This solution works in O(n) time but the array is traversed
   *            3 times. And we require O(n) extra space.
   */
  public static void sort012(int[] arr, int n) {
    int[] temp = new int[n];
    int index = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        temp[index++] = arr[i];
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        temp[index++] = arr[i];
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] == 2) {
        temp[index++] = arr[i];
      }
    }

    System.out.println(Arrays.toString(temp));
  }

  /**
   * @desc Sort an array containing 0s, 1s and 2s
   * @param arr
   * @param n
   * 
   *            This solution uses Dutch National Flag algorithm
   *            This is a modification of the Hoare's partition algorithm
   * 
   *            There is a slight modification such that pivot element (1)
   *            are gathered together and smaller elements (0) go on left side
   *            and greater elements (2) go on right side
   */
  public static void sort012Better(int[] arr, int n) {
    int low = 0, high = n - 1, mid = 0;

    while (mid <= high) {
      if (arr[mid] == 0) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        int temp = arr[high];
        arr[high] = arr[mid];
        arr[mid] = temp;
        high--;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 0, 1, 1, 2, 0, 1, 1, 2 };
    sort012(arr, arr.length);
    sort012Better(arr, arr.length);
    System.out.println(arr);
  }
}
