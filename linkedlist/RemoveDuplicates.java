package DSA.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

  /**
   * @desc Remove duplicates from a sorted linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void removeDuplicatesSorted(Node head) {
    if (head == null) {
      return;
    }

    if (head.next == null) {
      System.out.println("Only one node in the list");
      return;
    }

    Node curr = head;

    while (curr != null && curr.next != null) {
      if (curr.data == curr.next.data) {
        // If adjacent values are same then drop one node
        curr.next = curr.next.next;
      } else {
        // Else do thing and move to next node
        curr = curr.next;
      }
    }

    curr = head;
    Node.traverse(curr);
  }

  /**
   * @desc Remove duplicates from an unsorted linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void removeDuplicatesUnsorted(Node head) {
    Node ptr1 = null, ptr2 = null;
    ptr1 = head;

    while (ptr1 != null && ptr1.next != null) {
      ptr2 = ptr1;

      while (ptr2.next != null) {
        if (ptr1.data == ptr2.next.data) {
          ptr2.next = ptr2.next.next;
        } else {
          ptr2 = ptr2.next;
        }
      }

      ptr1 = ptr1.next;
    }

    Node.traverse(head);
  }

  /**
   * @desc Remove duplicates from an unsorted linked list using a hash set
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   */
  public static void removeDuplicateUnsortedHash(Node head) {
    Set<Integer> set = new HashSet<>();

    // Push all the node's data to the hashset
    for (Node curr = head; curr != null; curr = curr.next) {
      set.add(curr.data);
    }
    
    // Head and tail for of the new linked list
    Node newHead = null, tail = null;

    // Fetch data from the hashset and create nodes and link them
    for (Integer x : set) {
      Node curr = new Node(x);

    if (newHead == null) {
      newHead = tail = curr;
      curr.next = null;
    } else {
      tail.next = curr;
      tail = curr;
    }

      curr = curr.next;
    }

    // Traverse the list
    Node.traverse(newHead);
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(4);
    head.next.next = new Node(5);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    // removeDuplicatesSorted(head);
    // removeDuplicatesUnsorted(head);
    removeDuplicateUnsortedHash(head);
  }
}
