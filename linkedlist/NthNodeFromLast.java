package DSA.linkedlist;

public class NthNodeFromLast {

  /**
   * @desc  Print nth node from last
   * @param head
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void printNodeFromEnd(Node head, int n) {
    if (head == null) {
      return;
    }

    int count = 0;
    // Find the linked list length
    for (Node curr = head; curr != null; curr = curr.next) {
      count++;
    }

    // Reach the (count-n)+1 position
    Node curr = head;
    // i = 1; i < (count-n)+1; i++
    for (int i=0; i<(count-n); i++) {
      curr = curr.next;
    }

    System.out.println("Nth node from end - Naive: " + curr.data);
  }

  /**
   * @desc  Print nth node from last
   * @param head
   * @param n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Keep 2 pointers first and second
   * - If n=3 then first should point to 3rd node
   * - Now first is 3 steps ahead 
   * - Start moving second and first one by one
   */
  public static void printNodeFromEndBetter(Node head, int n) {
    if (head == null) {
      return;
    }

    Node first = head;
    // Move first by n steps
    for (int i=0; i<n; i++) {
      // If list's length < n
      if (first == null) {
        return;
      }

      first = first.next;
    }

    Node second = head;
    // Now first and second move by 1 step
    while (first != null) {
      second = second.next;
      first = first.next;
    }

    System.out.println("Nth node from end - Better: " + second.data);
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);

    printNodeFromEnd(head, 4);
    printNodeFromEndBetter(head, 4);
  }
}
