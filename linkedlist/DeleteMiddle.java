package DSA.linkedlist;

// Java program to delete the
// middle of a linked list
public class DeleteMiddle {

  /* Link list Node */
  static class Node {
    int data;
    Node next;
  }

  // Deletes middle node and returns
  // head of the modified list
  static Node deleteMid(Node head) {
    // Base cases
    if (head == null)
      return null;
    if (head.next == null) {
      return null;
    }

    // Initialize slow and fast pointers
    // to reach middle of linked list
    Node slow = head;
    Node fast = head;

    // Find the middle and previous of middle.
    Node prev = null;

    // To store previous of slow
    while (fast != null
        && fast.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }

    System.out.println("MID: " + slow.data);
    System.out.println("PREV: " + prev.data);

    // Delete the middle node
    prev.next = slow.next;

    return head;
  }

  // A utility function to print
  // a given linked list
  static void printList(Node ptr) {
    while (ptr != null) {
      System.out.print(ptr.data + "->");
      ptr = ptr.next;
    }
    System.out.println("NULL");
  }

  // Utility function to create a new node.
  static Node newNode(int data) {
    Node temp = new Node();
    temp.data = data;
    temp.next = null;
    return temp;
  }

  public static void main(String[] args) {
    /* Start with the empty list */
    Node head = newNode(45);
    head.next = newNode(56);
    head.next.next = newNode(67);
    head.next.next.next = newNode(78);

    System.out.println("Given Linked List");
    printList(head);

    head = deleteMid(head);

    System.out.println("Linked List after deletion of middle");
    printList(head);
  }
}
