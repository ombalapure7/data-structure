package DSA.strings;

public class ReverseWords {
  
  /**
   * Naive approach:
   * - Push every word to a stack
   * - Pop the words and append it to a string
   */

  /**
   * @desc  Reverse words in a string
   * @param str
   * 
   * Approach:
   * - First reverse every word in a string, if space is encountered that means a word ends
   * - Reverse the entire string itself, this results in reversed words in a string
   * 
   * COMPLEXITY
   * Time: 
   * Space: O(1)
   */
  public static void reverseWords(char[] str, int n) {
    int start = 0;
    // Reverse words in the string - in place
    for (int end=0; end<n; end++) {
      if (str[end] == ' ') {
        reverse(str, start, end-1);
        start = end + 1;
      }
    }

    // Reverse the last word
    reverse(str, start, n-1);

    // Reverse the entire string sentence
    reverse(str, 0, n-1);

    String res = "";
    for (Character ch : str) {
      res += ch;
    }

    System.out.println(res);
  }

  public static void reverse(char str[], int low, int high) {
    while (low <= high) {
      char temp = str[low];
      str[low] = str[high];
      str[high] = temp;
      low++;
      high--;
    }
  }

  public static void main(String[] args) {
    String str = "Welcome to Gfg";
    char[] ch = str.toCharArray();
    reverseWords(ch, str.length());
  }
}
