package DSA.strings;

public class LongestDistinctSubstring {

  /**
   * @desc Find length of the longest distinct substring
   * @param str
   * 
   *            COMPLEXITY
   *            Time: O(n^3)
   *            Space: O(1)
   */
  public static int longestDistinctSubstring(String str) {
    int n = str.length();
    int res = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (areDistinct(str, i, j)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  public static boolean areDistinct(String str, int i, int j) {
    boolean[] visited = new boolean[256];
    for (int k = i; k <= j; k++) {
      if (visited[str.charAt(k)] == true) {
        return false;
      } else {
        visited[str.charAt(k)] = true;
      }
    }

    return true;
  }

  /**
   * @desc Find length of the longest distinct substring
   * @param str
   * 
   *            COMPLEXITY
   *            Time: O(n^2)
   *            Space: O(1)
   */
  public static int longestDistinctSubstringBetter(String str) {
    int n = str.length();
    int res = 0;

    for (int i = 0; i < n; i++) {
      // abac
      boolean[] visited = new boolean[256];
      for (int j = i; j < n; j++) {
        if (visited[str.charAt(j)] == true) {
          break;
        } else {
          res = Math.max(res, j - i + 1);
          visited[str.charAt(j)] = true;
        }
      }
    }

    return res;
  }

  /**
   * @desc Find length of the longest distinct substring
   * @param str
   * 
   *            COMPLEXITY
   *            Time: O(n)
   *            Space: O(1)
   */
  public static int longestDistinctSubstringBest(String str) {
    String test = "";
    int maxLength = -1;

    if (str.isEmpty()) {
      return 0;
    } else if (str.length() == 1) {
      return 1;
    }

    for (char c : str.toCharArray()) {
      String current = String.valueOf(c);
      // If string already contains the character
      // then get the substring after that repeating character
      if (test.contains(current)) {
        System.out.println("Index of curr: " + test.indexOf(current));
        test = test.substring(test.indexOf(current) + 1);
      }

      test = test + String.valueOf(c);
      maxLength = Math.max(test.length(), maxLength);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of distinct substring - Naive: " + longestDistinctSubstring("abac"));
    System.out.println("Length of distinct substring - Better: " + longestDistinctSubstringBetter("abac"));
    System.out.println("Length of distinct substring - Better: " + longestDistinctSubstringBest("abac"));
  }
}
