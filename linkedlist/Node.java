package DSA.linkedlist;

public class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    next = null;
  }

  /**
   * @desc  Travese a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void traverse(Node head) {
    if (head == null) {
      return;
    }

    Node temp = head;
    // Stop when temp.next == null
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    
    System.out.println();
  }

  /**
   * @desc  Travese a linked list (recursivley)
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   */
  public void traverseRec(Node head) {
    if (head == null) {
      return;
    }

    System.out.print(head.data + " ");
    traverseRec(head.next);
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);    
    head.next.next = new Node(3);    
    head.next.next.next = new Node(4);    
    traverse(head);
  }
}