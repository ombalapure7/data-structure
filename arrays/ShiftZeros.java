package DSA.arrays;

import java.util.Arrays;

public class ShiftZeros {
  /*
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public static void shiftZeros(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      // Check if element is 0
      if (arr[i] == 0) {
        // If yes then search for a !0 element futhure in the array
        for (int j = i + 1; j < n; j++) {
          if (arr[j] != 0) {
            // When !0 element is found, swap it with a non zero element
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
          }
        }
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void shiftZerosBetter(int[] arr, int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      // Ignore the 0s
      if (arr[i] != 0) {
        // Swap the elements
        int temp = arr[i];
        arr[i] = arr[count];
        arr[count] = temp;

        // Increase the "count" when a non-zero elements is found
        // "count" keeps track of when was the last time
        // a non-zero element was encountered
        count++;
      }
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int[] arr = { 8, 5, 0, 0, 8, 0, 9, 0 };
    shiftZeros(arr, arr.length);

    int[] newArr = { 8, 5, 0, 0, 8, 0, 9, 0 };
    shiftZeros(newArr, newArr.length);
  }
}
