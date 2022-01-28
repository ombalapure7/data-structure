package DSA.linkedlist;

import java.util.ArrayList;

public class ReverseLinkedList {
  
  /**
   * @desc  Reverse a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   * Approach:
   * - Copy contents of the linked list to an auxillary arraylist
   * - Now iterate the arraylist and copy the list items in reverse order
   * 
   * Traversal is being done twice
   * Solution needs extra space
   */
  public static void reverseLinkedList(Node head) {
    ArrayList<Integer> arr = new ArrayList<>();

    Node curr = null;
    for (curr = head; curr != null; curr = curr.next) {
      arr.add(curr.data);
    }

    for (curr = head; curr != null; curr = curr.next) {
      curr.data = arr.remove(arr.size() - 1);
    }

    curr = head;
    Node.traverse(head);
  }

  /**
   * @desc  Reverse a linked list - w/o extra space
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void reverseLinkedListBetter(Node head) {
    Node curr = head;
    Node prev = null;
    
    while(curr != null) {
      // Copy the node reference of alternate node
      Node next = curr.next;
      // Make the current node point to the previous
      curr.next = prev;
      // prev stores the previous node reference
      prev = curr;
      // curr stores the current node reference
      curr = next;
    }

    Node.traverse(prev);
  }

  /**
   * @desc  Reverse a linked list recursively
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   */
  public static Node reverseBetterRec(Node curr, Node prev) {
    if (curr == null) {
      return prev;
    }

    Node next = curr.next;
    curr.next = prev;

    return reverseBetterRec(next, curr);
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);

    // reverseLinkedList(head);
    // reverseLinkedListBetter(head);
    head = reverseBetterRec(head, null);
    Node.traverse(head);
  }
}
