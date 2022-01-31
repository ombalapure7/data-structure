package DSA.strings;

public class StringRotation {

  /**
   * @desc Given 2 strings, check wheter both of them are rotations of each other
   * @param s1
   * @param s2
   * @return
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Concat s1 with s1
   * - Now search for s2 inside of s1
   */
  public static boolean areRotations(String s1, String s2) {
    // Unequal length strings cannot be rotations of each other
    if (s1.length() != s2.length()) {
      return false;
    }

    s1 = s1 + s1;
    int n = s1.length();
    int m = s2.length();

    for (int i = 0; i < n - m + 1; i++) {
      // Check if s2 is a substring of s1
      if (s1.substring(i, m + i).equals(s2)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String s1 = "ABCD";
    String s2 = "CDAB";
    System.out.println("Are string rotations of each other: " + areRotations(s1, s2));
  }
}
