package DSA.hashing;

import java.util.HashMap;
import java.util.Map;
import DSA.arrays.Largest;

public class Frequencies {

  /*
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public static void printFrequencies(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      boolean flag = false;

      // Check if element was seen before
      for (int j = 0; j < i; j++) {
        if (arr[i] == arr[j]) {
          flag = true;
          break;
        }
      }

      // Skip iteration if element was seen before
      if (flag == true) {
        continue;
      }

      // Current element was not seen earlier (left side)
      // Now check if it is present on the right side
      int freq = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          freq++;
        }
      }

      System.out.println(arr[i] + " encountered " + freq + " time(s)");
    }
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static void printFrequenciesHash(int arr[], int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    // for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    // System.out.println(e.getKey() + " encountered " + e.getValue() + " time(s)");
    // }

    map.forEach((K, V) -> {
      System.out.println(K + " appear " + V + " time(s)");
    });
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   * 
   * NOTE: Solution does not work for negative array values
   *  Also, this solution works only if we know the largest element in the array
   *  and the largest element is smaller than the array's length.
   */
  public static void frequencies(int[] arr, int n) {
    int largest = arr[Largest.largestElementIndex(arr, n)];
    int[] count = new int[largest + 1];
 
    for (int i = 0; i < n; i++) {
      count[arr[i]]++;
    }

    for (int i = 0; i <= largest || i < count.length; i++) {
      if (count[i] >= 1) {
        System.out.println(i + " Occur " + count[i] + " time(s)");
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 10, 20, 30 };
    printFrequencies(arr, arr.length);
    System.out.println("##################################");
    printFrequenciesHash(arr, arr.length);
    System.out.println("##################################");
    frequencies(arr, arr.length);
  }
}
