package DSA.sorting;

import java.util.Arrays;

public class MeetMaxGuests {

  /**
   * @desc Find the no. of max guests that can be met
   *       based on the arrival and departue times
   * @param arr
   * @param dep
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(1)
   */
  public static int meetMaxGuests(int[] arr, int[] dep, int n) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int res = 0;
      for (int j = i; j < n; j++) {
        if (arr[i] < dep[j]) {
          res++;
        }
      }

      max = Math.max(max, res);
    }

    return max;
  }

  /**
   * @desc Find the no. of max guests that can be met
   *       based on the arrival and departue times
   * @param arr
   * @param dep
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*logn)
   *         Space: O(1)
   */
  public static int meetMaxGuestsBetter(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    // [500, 600, 700, 800]
    // [530, 820, 830, 840]

    int i = 1, j = 0, res = 1, curr = 1;
    int n = arr.length;

    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        curr++;
        i++;
      } else {
        curr--;
        j++;
      }

      res = Math.max(res, curr);
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 900, 600, 700};
    int dep[] = { 1000, 800, 730};

    // int arr[] = { 800, 700, 600, 500 };
    // int dep[] = { 840, 820, 830, 530 };

    System.out.println("Max guests that can be met - Naive: " + meetMaxGuests(arr, dep, arr.length));
    System.out.println("Max guests that can be met - Better: " + meetMaxGuestsBetter(arr, dep));
  }
}
