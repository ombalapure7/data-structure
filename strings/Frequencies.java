package DSA.strings;

public class Frequencies {

  /* 
  equals: compares content of two strings, it returns boolean

  contains: can be used to find substring in a string, it returns boolean

  compareTo: compares 2 strings lexicographically
    eg: str1 = geek, str2 = a; here str1 is greater lexicographically as "g" after "a"
    If strings are equal, method returns 0 

  indexOf: can be used to find substring, returns -1 if substring not present
    Returns index value from where the substring strats in the original string

    Use case: 
    - s1.indexOf(s2)
    - s1.indexOf(s2, 1) -> will check if substring is present after index "1"

    NOTE: When a concat is done a new string object is created
  */

  public static void frequencies(String str) {
    int count[] = new int[26];
    for (int i = 0; i < str.length(); i++) {
      // ASCII values of g -> 71 and a -> 65
      // 71 - 65 = 6
      // So we increment the value at index 6 by 1
      count[str.charAt(i) - 'a']++;
    }

    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        // At index 6, value of 4 is present 
        // 4 + 65 = 71 i.e. "g"
        System.out.println((char) (i + 'a') + " " + count[i]);
      }
    }
  }

  public static void main(String[] args) {
    frequencies("geeksforgeeks");
  }
}
