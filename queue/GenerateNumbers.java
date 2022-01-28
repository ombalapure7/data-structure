package DSA.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbers {
  
  public static void generateNumbers(int n) {
    Queue<String> queue = new LinkedList<>();
    queue.add("5");
    queue.add("6");

    for (int i=0; i<n; i++) {
      String curr = queue.poll();
      System.err.print(curr + " ");
      queue.add(curr + "5");
      queue.add(curr + "6");
    }
  }

  public static void main(String[] args) {
    generateNumbers(5);
  }
}
