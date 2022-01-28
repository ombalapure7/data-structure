package DSA.strings;

public class LeftMostRepeating {
  private static final int CHAR = 256;

  /**
   * @desc  Find the index of the left most repeating character
   * @param str
   * @return
   * 
   * COMPLEXITY
   * Time: O(n*n)
   * Space: O(1)
   */
  public static int leftMostRepeating(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j)) {
          return i;
        }
      }

      // OR
      // for (int j = 0; j < str.length(); j++) {
      //   if (i != j && str.charAt(i) == str.charAt(j)) {
      //     return i;
      //   }
      // }
    }

    return -1;
  }

  /**
   * @desc  Find the index of the left most repeating character
   * @param str
   * @return
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * This approach needs two traversal
   * One for storing the indices and second one to find the occurrence(s)
   */
  public static int leftMostRepeatingBetter(String str) {
    int[] count = new int[256];

    for (int i=0; i<str.length(); i++) {
      count[str.charAt(i)]++;
    }

    for (int i=0; i<str.length(); i++) {
      // If you want to find the left most non repeating character
      // Write this instead => count[str.charAt(i)] == 1 
      if (count[str.charAt(i)] > 1) {
        return i;
      }
    }

    return -1;
  }

  /**
   * @desc  Find the index of the left most repeating character
   * @param str
   * @return
   * 
   * Approach:
   * - Create a visited[] array of type boolean
   * - Traverse from the right side
   * - Mark the visited character as visited and store its index
   * - If a character encountered is not visited
   *    - Mark it as visited
   * - Else 
   *    - Store this characters index
   * - Return the index which was stored
   */
  public static int leftMostRepeatingEfficient(String str) {
    boolean[] visited = new boolean[CHAR];
    int res = -1;

    for (int i=str.length()-1; i>=0; i--) {
      if (visited[str.charAt(i)]) {
        res = i;
      } else {
        visited[str.charAt(i)] = true;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    String str = "cabbad";
    System.out.println("Left most repeating char index - Naive: " + leftMostRepeating(str));
    System.out.println("Left most repeating char index - Better: " + leftMostRepeatingBetter(str));
    System.out.println("Left most repeating char index - Efficient: " + leftMostRepeatingEfficient(str));
  }
}
