package DSA.sorting;

import java.util.Arrays;

public class ChocolateDistribution {

  /**
   * @desc Distribite chocolate packets evenly among children
   * @param arr
   * @param n
   * 
   *            Every child should get exactly one packet of chocolates
   *            Find the difference of min and max no. of chocolates
   * 
   *            Approach:
   *            - Sort the array
   * 
   */
  public static int chocolateDistribution(int[] arr, int n, int m) {
    if (m > n) {
      return -1;
    }

    Arrays.sort(arr);
    int res = arr[m - 1] - arr[0];
    int index = 0;
    for (int i = 1; i < n - m + 1; i++) {
      // res = Math.min(res, arr[i+m-1] - arr[i]);
      if (res > arr[i + m - 1] - arr[i]) {
        res = arr[i + m - 1] - arr[i];
        index = i;
      }
    }

    System.out.println("Index: " + index);
    return res;
  }

  public static void main(String[] args) {
    int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
    System.out.println(chocolateDistribution(arr, arr.length, 3));
  }
}
