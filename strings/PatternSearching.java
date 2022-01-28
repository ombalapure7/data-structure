package DSA.strings;

public class PatternSearching {

  /**
   * @desc Check if a pattern exists in a string, if it does then
   *       print the index from where the pattern matched completely
   * @param str
   * @param pattern
   * 
   * COMPLEXITY
   * Time: O((n-m)*m)
   * Space: O(1)
   */
  public static void patternSearch(String str, String pattern) {
    int n = str.length();
    int m = pattern.length();

    for (int i = 0; i < n - m + 1; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (pattern.charAt(j) != str.charAt(i + j)) {
          break;
        }
      }

      if (j == m) {
        // Print the starting index "i" from where
        // the pattern matched completely
        System.out.print(i + " ");
      }
    }
  }

  /**
   * @param str
   * @param pattern
   * 
   * We assume that the pattern has unique characters
   * And move the window by (i+j) if pattern matching fails at certain point
   * instead of increasing "i" by 1
   */
  public static void patternSearchBetter(String str, String pattern) {
    int n = str.length();
    int m = pattern.length();

    for (int i = 0; i < n - m + 1;) {
      int j;
      for (j = 0; j < m; j++) {
        if (pattern.charAt(j) != str.charAt(i + j)) {
          break;
        }
      }

      if (j == m) {
        System.out.print(i + " ");
      }

      if (j == 0) {
        // Pattern matching failed for the 1st character
        i++;
      } else {
        // Pattern matching failed after few characters
        i = (i + j);
      }
    }
  }

  public static void main(String[] args) {
    String str = "ABCABCD";
    String pattern = "ABCD";

    patternSearch(str, pattern);
    System.out.println();
    patternSearchBetter(str, pattern);
  }
}
