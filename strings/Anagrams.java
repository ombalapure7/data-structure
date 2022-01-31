package DSA.strings;

public class Anagrams {

  static final int CHAR = 256;

  /**
   * Time Complexity: O(nlogn) - sorting the strings 
   * Space Complexity: O(1)
   * 
   * Approach:
   *  Sort both the strings and then check if they are equal
   */

  /**
   * Time Complexity: O(n + CHAR) - CHAR is alphabet size
   * Space Complexity: O(1) - we have constant array size of 256, it reamins fixed all times
   * 
   * Approach:
   *  Find the occurence of characters and maintain count in the count[] array
   *  If new character is found in s1: 
   *    increment count at that index in the count[] array
   * 
   *  If character is already present in s2:
   *    decrement count at that index in the count[] array 
   */
  public static boolean anagram(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int count[] = new int[CHAR];
    for (int i=0; i<s1.length(); i++) {
      count[s1.charAt(i)]++;
      count[s2.charAt(i)]--;
    }

    for (int i=0; i<s1.length(); i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s1 = "aabca";
    String s2 = "acaba";

    System.out.println("Are strings anagram: " + anagram(s1, s2));
  }
}
