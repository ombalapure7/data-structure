package DSA.sorting;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
  int st;
  int end;

  Interval(int st, int end) {
    this.st = st;
    this.end = end;
  }
}

public class MergeOveralapping {

  /**
   * @desc Merge overalapping intervals and print non-overalpping intervals
   * @param arr
   * @param n
   * 
   *            COMPLEXITY
   *            Time: O(n*logn)
   *            Space: O(1)
   */
  public static void mergeOverlappingIntervals(Interval[] arr, int n) {
    // Sort the intervals based on starting value
    Arrays.sort(arr, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        return i1.st - i2.end;
      }
    });

    int res = 0;
    for (int i = 1; i < n; i++) {
      if (arr[res].end >= arr[i].st) {
        arr[res].end = Math.max(arr[res].end, arr[i].end);
        arr[res].st = Math.min(arr[res].st, arr[i].st);
      } else {
        res++;
        arr[res] = arr[i];
      }
    }

    for (int i = 0; i <= res; i++) {
      System.out.print("[" + arr[i].st + ", " + arr[i].end + "] ");
    }
  }

  public static void main(String[] args) {
    // Interval[] arr = { new Interval(5, 10), new Interval(3, 15), new Interval(18,
    // 30),
    // new Interval(2, 7) };
    Interval[] arr = { new Interval(7, 9), new Interval(6, 10), new Interval(4, 5),
        new Interval(1, 3), new Interval(2, 4) };

    mergeOverlappingIntervals(arr, arr.length);
  }
}
