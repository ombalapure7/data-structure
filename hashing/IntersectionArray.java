package DSA.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArray {

  /**
   * @desc Distinct common elements in 2 arrays
   * @param a
   * @param b
   * @param m
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(m * (n+m))
   *         Space: O(1)
   */
  public static int intersection(int a[], int b[], int m, int n) {
    int res = 0;
    for (int i = 0; i < m; i++) {
      boolean flag = false;
      // Check if the current element was seen before
      // We need this check as we have duplicates in both arrays
      for (int j = 0; j < i; j++) {
        if (a[i] == a[j]) {
          flag = true;
          break;
        }
      }

      // Skip the iteration if the current element was was before
      if (flag == true) {
        continue;
      }

      // Check if a[i] is present in b[] 
      // The entire array b[] is scanned
      for (int j = 0; j < n; j++) {
        if (a[i] == b[j]) {
          System.out.print(a[i] + " ");
          res++;
          break;
        }
      }
    }

    System.out.println();

    return res;
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static int intersectionHash(int a[], int b[]) {
    int res = 0;
    Set<Integer> set = new HashSet<>();

    // Store all elements of "a" in the hashset
    for (int x : a) {
      set.add(x);
    }

    // set: [20, 10, 30]
    for (int x : b) {
      if (set.contains(x)) {
        res++;
        // Set has unique elements, "b" array will have duplicate elements
        // So we must remove elements so that we don't print them and increase the "res"
        // counter
        set.remove(x);
        System.out.print(x + " ");
      }
    }

    System.out.println();
    // set: [30]
    return res;
  }

  /**
   * @desc Distinct common elements in 2 arrays
   * @param a
   * @param b
   * @param m
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*logn)
   *         Space: O(m ∩ n)
   * 
   *         We consider "n" as the size of the bigger array
   *         NOTE: This solution works if there is no/little randomness in the arrays
   *         If the elements are random then the arrays need to be sorted
   */
  public static void intersectionOk(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    HashSet<Integer> set = new HashSet<>();

    int n = a.length, m = b.length;
    int i = 0, j = 0;

    while (i < n && j < m) {
      if (a[i] < b[j]) {
        i++;
      } else if (a[i] > b[j]) {
        j++;
      } else {
        set.add(a[i]);
        i++;
        j++;
      }
    }

    System.out.println(set);
    System.out.println("No. of distinct and common elements - Good: " + set.size());
  }

  public static void main(String[] args) {
    // int a[] = { 10, 20, 10, 30, 20 };
    // int b[] = { 20, 10, 10, 40 };

    int a[] = { 1, 3, 4, 5, 7 };
    int b[] = { 2, 3, 5, 6 };

    System.out.println("No. of distinct and common elements - Naive: " +
        intersection(a, b, a.length, b.length));
    System.out.println("#############################");
    System.out.println("No. of distinct and common elements - Efficient: " +
        intersectionHash(a, b));
    System.out.println("#############################");
    intersectionOk(a, b);
  }
}
