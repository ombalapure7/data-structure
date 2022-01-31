package DSA.strings;

import java.util.Arrays;

public class LeftMostNonRepeating {
  private static final int CHAR = 256;

  /**
   * @desc Find the index of the left most repeating character
   * @param str
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n*n)
   *         Space: O(1)
   */
  public static int leftMostNonRepeating(String str) {
    for (int i = 0; i < str.length(); i++) {
      boolean flag = false;
      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        return i;
      }
    }

    return -1;
  }

  /**
   * @desc Find the index of the left most repeating character
   * @param str
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(1)
   */
  public static int leftMostNonRepeatingBetter(String str) {
    int[] fI = new int[CHAR];

    // Populate array with value of -1
    Arrays.fill(fI, -1);

    for (int i = 0; i < str.length(); i++) {
      if (fI[str.charAt(i)] == -1) {
        // Mark current character as visited
        fI[str.charAt(i)] = i;
      } else {
        // Since default value is -1 we put -2
        fI[str.charAt(i)] = -2;
      }
    }

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < CHAR; i++) {
      if (fI[i] >= 0) {
        // We need to find the minimum index
        // For eg: "c" is at 3 and "d" is at 5 and both of them appear once
        // So we have to pick "c"
        res = Math.min(res, fI[i]);

        // OR
        // res = fI[i];
        // break;
      }
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    // String str = "abbcda";
    System.out.println("Left most non repeating char index - Naive: " + leftMostNonRepeating(str));
    System.out.println("Left most non repeating char index - Better: " + leftMostNonRepeatingBetter(str));
  }
}
