package DSA.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
  
  public static void reverseQueueItr(Queue<Integer> queue) {
    Stack<Integer> st = new Stack<>();

    while (!queue.isEmpty()) {
      st.push(queue.poll());
    }

    while (!st.isEmpty()) {
      queue.add(st.peek());
      st.pop();
    }

    System.out.println(queue);
  }
  
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>(); 
		queue.add(12); 
		queue.add(5); 
		queue.add(15); 
		queue.add(20); 
	
		reverseQueueItr(queue);
  }
}
