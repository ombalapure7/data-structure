package DSA.linkedlist;

public class MergeSortedList {

  /**
   * 
   * @desc  Merge two sorted linked lists
   * @param a
   * @param b
   * @return head
   * 
   * COMPLEXITY
   * Time: O(m + n)
   * Space: O(1)
   * 
   */
  public static Node sortedMerge(Node a, Node b) {
    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    Node head = null, tail = null;
    if (a.data <= b.data) {
      head = tail = a;
      a = a.next;
    } else {
      head = tail = b;
      b = b.next;
    }

    while (a != null && b != null) {
      if (a.data <= b.data) {
        // Attach new node to next of tail
        tail.next = a;
        // The new attached ndoe becomes the tail
        tail = a;
        a = a.next;
      } else {
        // Attach new node to next of tail
        tail.next = b;
        // The new attached ndoe becomes the tail
        tail = b;
        b = b.next;
      }
    }

    if (a == null) {
      // All nodes in "a" are processed
      tail.next = b;
    } else {
      // All nodes in "b" are processed
      tail.next = a;
    }

    return head;
  }

  public static void main(String[] args) {
    Node a = new Node(10);
    a.next = new Node(20);
    a.next.next = new Node(30);
    Node b = new Node(5);
    b.next = new Node(35);
    b.next.next = new Node(40);

    Node.traverse(sortedMerge(a, b));
  }
}
