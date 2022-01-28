package DSA.strings;

public class AnagramSearch {
  private static final int CHAR = 256;

  /**
   * @desc Check if a string contains an anagram
   * @param text
   * @param pattern
   * @return
   * 
   *         COMPLEXITY
   *         Time: O((n-m+1)*m)
   *         Space: O(1)
   */
  public static boolean hasAnagramInString(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    for (int i = 0; i < n - m + 1; i++) {
      if (areAnagrams(text, pattern, i)) {
        return true;
      }
    }

    return false;
  }

  // Helper function to check if a string is anagram
  public static boolean areAnagrams(String text, String pattern, int i) {
    int count[] = new int[CHAR];

    for (int j = 0; j < pattern.length(); j++) {
      count[pattern.charAt(j)]++;
      count[text.charAt(i + j)]--;
    }

    for (int j = 0; j < CHAR; j++) {
      if (count[j] != 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * @desc Check if a string contains an anagram
   * @param text
   * @param pattern
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(m + (n-m) *CHAR) =~ O(n*CHAR)
   *         Space: O(CHAR)
   */
  public static boolean hasAnagramInStringBetter(String text, String pattern) {
    int[] CP = new int[CHAR];
    int[] CT = new int[CHAR];

    for (int i = 0; i < pattern.length(); i++) {
      CT[text.charAt(i)]++;
      CP[pattern.charAt(i)]++;
    }

    for (int i = pattern.length(); i < text.length(); i++) {
      if (areCharArraySame(CP, CT)) {
        return true;
      }

      CT[text.charAt(i)]++;
      CT[text.charAt(i - pattern.length())]--;
    }

    return false;
  }

  public static boolean areCharArraySame(int[] CP, int[] CT) {
    for (int i = 0; i < CP.length; i++) {
      if (CP[i] != CT[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String text = "geeksforgeeks";
    String pattern = "frog";
    System.out.println("Does anagram exist - Naive: " + hasAnagramInString(text, pattern));
    System.out.println("Does anagram exist - Naive: " + hasAnagramInStringBetter(text, pattern));
  }
}
