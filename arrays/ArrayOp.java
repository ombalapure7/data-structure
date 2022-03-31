package DSA.arrays;

import java.util.Arrays;

public class ArrayOp {

  /*
   * Overall Complexity
   * 
   * Insert: O(1)
   * Search: O(n) for unsorted O(logn) for sorted
   * Delete: O(n) Get ith element: O(1)
   * Update ith element: O(1)
   */

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   * 
   */
  public static int insert(int arr[], int n, int x, int cap, int pos) {
    if (n == cap)
      return n;

    int idx = pos - 1;

    for (int i = n - 1; i >= idx; i--) {
      arr[i + 1] = arr[i];
    }

    arr[idx] = x;

    return n + 1;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void delete(int arr[], int n, int x) {
    int i = 0;
    for (i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        break;
      }
    }

    for (int j = i; j < arr.length - 1; j++) {
      arr[j] = arr[j + 1];
    }
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static int search(int arr[], int n, int x) {
    if (x == arr[0]) {
      return 0;
    }

    for (int i = 0; i < arr.length; i++) {
      if (x == arr[i]) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String args[]) {
    int arr[] = new int[5], cap = 5, n = 3;

    arr[0] = 5;
    arr[1] = 10;
    arr[2] = 20;

    System.out.println("Before Insertion");
    System.out.println(Arrays.toString(arr));

    int x = 7, pos = 2;
    insert(arr, n, x, cap, pos);

    System.out.println("After Insertion");
    System.out.println(Arrays.toString(arr));

    System.out.println("After Deletion");

    delete(arr, n, 7);
    System.out.println(Arrays.toString(arr));

    System.out.println("Element present at index: " + search(arr, n, 20));

    /* Converting string array to integer array */
    // String[] str = new String[]{"1,", "2", "3", "4"};
    // int[] tempArr = Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();
    // System.out.println(Arrays.toString(tempArr));
  }
}
