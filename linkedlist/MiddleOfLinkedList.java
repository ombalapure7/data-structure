package DSA.linkedlist;

public class MiddleOfLinkedList {
  
  /**
   * @desc    Print the middle node in a linked list
   * @param   head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void printMiddleNaive(Node head) {
    if (head == null) {
      return;
    }

    int count = 0;
    // Find the linked list length
    Node curr = head;
    while (curr != null) {
      curr = curr.next;
      count++;
    }

    // Go to the (count/2 - 1)the node
    curr = head;
    for (int i=0; i<count/2; i++) {
      System.out.println(i);
      curr = curr.next;
    }
    
    System.out.println("Middle node in the linked list - Naive: " + curr.data);
  }

  /**
   * @desc    Print the middle node in a linked list
   * @param   head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void printMiddleBetter(Node head) {
    if (head == null) {
      return;
    }

    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    System.out.println("Middle node in the linked list - Better: " + slow.data);
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    // head.next.next.next.next = new Node(50);
    // head.next.next.next.next.next = new Node(60);
    // head.next.next.next.next.next.next = new Node(70);
    // head.next.next.next.next.next.next.next = new Node(80);

    printMiddleNaive(head);
    printMiddleBetter(head);
  }
}
