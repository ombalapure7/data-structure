package DSA.arrays;

import java.util.Arrays;

public class LeftRotate {

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void leftRotateOne(int arr[], int n) {
    // 1st element goes to last index
    int temp = arr[0];

    for (int i = 1; i < n; i++) {
      arr[i - 1] = arr[i];
    }

    arr[n - 1] = temp;

    // System.out.println(Arrays.toString(arr));
  }

  /*
   * Time Complexity: O(n*d)
   * Space Complexity: O(1)
   */
  public static void leftRotateByD(int arr[], int n, int d) {
    for (int i = 0; i < d; i++) {
      leftRotateOne(arr, n);
    }

    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time Complexity: O(n+d) =~ O(n) since d < n
   * Space Complexity: O(d)
   */
  public static void leftRotateByDBetter(int arr[], int n, int d) {
    int temp[] = new int[d];

    // Copy 1st "d" elements to a temp array
    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }

    // Now rotate the elements except the first "d" elements
    for (int i = d; i < n; i++) {
      arr[i - d] = arr[i];
    }

    // Now copy the "d" elements in the original array
    for (int i = 0; i < d; i++) {
      arr[n - d + 1] = temp[i];
    }

    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void leftRotateSpaceOpt(int arr[], int n, int d) {
    reverse(arr, 0, d - 1);
    reverse(arr, d, n - 1);
    reverse(arr, 0, n - 1);

    System.out.println(Arrays.toString(arr));
  }

  // Function to reverse an array
  public static void reverse(int arr[], int low, int high) {
    while (low < high) {
      int temp = arr[low];
      arr[low] = arr[high];
      arr[high] = temp;

      low++;
      high--;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    // op: [2, 3, 4, 5, 1]
    leftRotateOne(arr, arr.length);

    int newArr[] = { 1, 2, 3, 4, 5 };
    // op: [3, 4, 5, 1, 2]
    leftRotateByD(newArr, newArr.length, 2);

    int newNewArr[] = { 1, 2, 3, 4, 5 };
    // op: [3, 4, 5, 1, 2]
    leftRotateSpaceOpt(newNewArr, newNewArr.length, 2);
  }
}
