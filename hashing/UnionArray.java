package DSA.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionArray {

  /**
   * @desc Find the union of 2 arrays but there no distinct elements in each array
   * Naive approach
   * - Create an extra array say dist[]
   * - For every element of a[] check if it is present in dist[], if NO:
   *    a) Increment res
   *    b) Append the element to dist[]
   * - Repeat the same for b[]
   * 
   * Time Complexity: O(m * (m/2) + n*(m + n)) =~ O(m^2 + n*(m + n))
   * Space Complexity: O(n)
   */
  public static void union(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    int n = a.length, m = b.length;
    int i = 0, j = 0;
    int[] res = new int[n + m];
    int count = 0;

    while (i < n && j < m) {
      if (a[i] < b[j]) {
        boolean skip = false;
        // Check if the current element is already present in res[]
        for (int k = 0; k < res.length; k++) {
          if (a[i] == res[k]) {
            skip = true;
            break;
          }
        }

        // Current element not present inside res[] already, so add it
        if (skip) {
          i++;
          continue;
        }

        res[count++] = a[i++];
      } else {
        boolean skip = false;
        for (int k = 0; k < res.length; k++) {
          if (b[j] == res[k]) {
            skip = true;
            break;
          }
        }

        if (skip) {
          j++;
          continue;
        }

        res[count++] = b[j++];
      }
    }

    // There may be a case where elements in one
    // array gets proceesed completely
    while (i < n) {
      res[count++] = a[i++];
    }

    while (j < m) {
      res[count++] = b[j++];
    }

    // Print the resultant array
    for (int k = 0; k < count; k++) {
      System.out.print(res[k] + " ");
    }
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static int unionHash(int a[], int b[]) {
    Set<Integer> set = new HashSet<>();
    for (int x : a) {
      set.add(x);
    }

    for (int x : b) {
      set.add(x);
    }

    return set.size();
  }

  public static void main(String[] args) {
    int a[] = { 10, 20, 10, 30, 20 };
    int b[] = { 20, 10, 10, 40 };

    // int a[] = { 1, 3, 4, 5, 7 };
    // int b[] = { 2, 3, 5, 6 };

    System.out.println("##################################");
    System.out.println("No. of distinct elements - Efficient: " + unionHash(a, b));
    System.out.println("##################################");
    union(a, b);
  }
}
