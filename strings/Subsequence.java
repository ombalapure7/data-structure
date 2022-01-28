package DSA.strings;

public class Subsequence {

  /*
   * NOTE: Subsequence is different than substring, subtrings are contiguous
   * Eg: s1 = "ABCD" and s2 = "AD" returns true && s1 = "ABCDE" and s2 = "AED"
   * returns false
   * 
   * If characters are not contiguous its fine but the order
   * must be the same, in case of a subsequence
   */

  /**
   * Time Complexity: O(n + m)
   * Space Complexity: O(1)
   */
  public static boolean isSubsequence(String s1, String s2, int n, int m) {
    if (n < m) {
      return false;
    }

    int j = 0;
    // "i" will always increment "j" will not, so declaring it separately

    for (int i = 0; i < n && j < m; i++) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
      }
    }

    return (j == m);
  }

  /**
   * Time Complexity: O(n + m)
   * Space Complexity: O(n + m)
   */
  public static boolean isSubsequenceRecursive(String s1, String s2, int n, int m) {
    // All the characters in the substring were processed means
    // the substring "m" is present in "n"
    if (m == 0) {
      return true;
    }

    // All the characters in the bigger string were processed
    // Means "m" is not a substring of "n"
    if (n == 0) {
      return false;
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      // Characters matched to reduce search area for "m" and "n"
      return isSubsequenceRecursive(s1, s2, n - 1, m - 1);
    } else {
      // Reduce search area in "n"
      return isSubsequenceRecursive(s1, s2, n - 1, m);
    }
  }

  public static void main(String[] args) {
    String s1 = "ABCDEF";
    String s2 = "ABD";
    System.out.println("Is string a subsequence - Iterative: " + isSubsequence(s1, s2, s1.length(), s2.length()));
    System.out
        .println("Is string a subsequence - Recursive: " + isSubsequenceRecursive(s1, s2, s1.length(), s2.length()));
  }
}
