package DSA.arrays;

import java.util.HashSet;

public class RemoveDuplicatesUnsorted {

  /**
   * @desc Remove duplicates from an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n^2)
   * Space: O(n)
   * 
   * Approach:
   * - Take one element from arr and check if present in the new temp array
   * - Insert element in the temp array
   * - Else skip the iteration
   * - Do this until all the elements in the original are processed
   */
  public static void removeDuplicates(int[] arr, int n) {
    int[] tempArr = new int[arr.length];
    int counter = 0;
    
    for (int i = 0; i < n; i++) {
      boolean isPresent = false;
      for (int j = 0; j < n; j++) {
        if (arr[i] == tempArr[j]) {
          isPresent = true;
          break;
        }
      }

      // Element not present in temp array, insert it
      if (!isPresent) {
        tempArr[counter++] = arr[i];
      }
    }

    // Print the result
    for (int i = 0; i < counter; i++) {
      System.out.print(tempArr[i] + " ");
    }

    System.out.println();
  }

  /**
   * @desc Remove duplicates in an array
   * @param arr
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   * We traverse the array once and the lookup in hashset is O(1)
   */
  public static void removeDuplicatesBetter(int[] arr, int n) {
    HashSet<Integer> set = new HashSet<>();
    
    for (int x : arr) {
      if (!(set.contains(x))) {
        System.out.print(x + " ");
        set.add(x);
      } else {
        continue;
      }
    }

    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 20, 30, 30, 30, 40, 50, 60, 60 };
    removeDuplicates(arr, arr.length);
    removeDuplicatesBetter(arr, arr.length);
  }
}
