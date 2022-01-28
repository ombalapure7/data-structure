package DSA.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueOp {
  public static void main(String[] args) {
    // By default the Priority Queue implements MIN HEAP
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(10);
    minHeap.add(20);
    minHeap.add(30);
    System.out.println(minHeap.peek());
    System.out.println(minHeap.poll());
    System.out.println(minHeap.peek());

    // We can create a MAX HEAP by following way
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.add(10);
    maxHeap.add(20);
    maxHeap.add(15);
    System.out.println(maxHeap.peek());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.peek());
  }
}
