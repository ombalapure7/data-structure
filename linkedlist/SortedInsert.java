package DSA.linkedlist;

public class SortedInsert {

  /**
   * @desc  Sorted insert in a linked list
   * @param args
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static Node sortedInsert(Node head, int x) {
    Node temp = new Node(x);

    // List is empty return the newly created node
    if (head == null) {
      return temp;
    }

    // If list only has one node
    if (x < head.data) {
      temp.next = head;
      return temp;
    }

    Node curr = head;
    while (curr.next != null && x > curr.next.data) {
      curr = curr.next;
    }

    // Current new node to current's next node
    temp.next = curr.next;
    // Now connect current to the new node
    curr.next = temp;

    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);

    // head = sortedInsert(head, 5);
    // head = sortedInsert(head, 60);

    // Node.traverse(head);
  }
}