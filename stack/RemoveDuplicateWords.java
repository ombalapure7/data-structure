package DSA.stack;

import java.util.Stack;

public class RemoveDuplicateWords {
  public static void removeDuplicateAdjacent(String sentence) {
    String strArr[] = sentence.split(" ");
    Stack<String> st = new Stack<>();

    for (int i = 0; i < strArr.length; i++) {
      if (!st.isEmpty() && st.peek().equals(strArr[i])) {
        st.pop();
        continue;
      }

      st.push(strArr[i]);
    }

    String arr[] = new String[st.size()];
    String res = "";
    int count = 0;
    while (!st.isEmpty()) {
      arr[count++] = st.pop();
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      res += arr[i] + " ";
    }

    System.out.println(res.substring(0, res.length() - 1));
  }

  public static void main(String[] args) {
    String sentence = "I am john cena cena john";
    removeDuplicateAdjacent(sentence);
  }
}
