package DSA.linkedlist;

public class PairWiseSwap {
  
  /**
   * 
   * @param head
   * @return Pair wise swap - swapping node data
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Iterate over the list 
   * - Keep on swapping the data of two adjacent nodes
   * 
   * Incase the list is of odd length then leave the last node
   * 
   * NOTE: This approach takes linear time but if the data is big or complex (or an object itself)
   *    then swapping is a costly operation
   */
  public static void pairWiseSwap(Node head) {
    Node curr = head;
    while (curr != null && curr.next != null) {
      // Swap the node data
      int temp = curr.data;
      curr.data = curr.next.data;
      curr.next.data = temp;

      // We need to move over 2 nodes at a time
      curr = curr.next.next;
    }

    curr = head;
    Node.traverse(head);
  }

  /**
   * 
   * @param head
   * @return Pair wise swap - changing links
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Iterate over the list and change the links 
   * - And while doing so store the curr.next.next reference or we will lose the entrie list
   */
  public static void pairWiseSwapChangeLink(Node head) {
    if (head == null || head.next == null) {
      System.out.println("List is either empty or has only 1 node!");
      return;
    }

    // Store the reference of the 3rd node
    Node curr = head.next.next;
    Node prev = head;
    // 2nd node becomes the head
    head = head.next;
    // Head node becomes the 2nd node
    head.next = prev;

    while (curr != null && curr.next != null) {
      prev.next = curr.next;
      prev = curr;
      Node next = curr.next.next;
      curr.next.next = curr;
      curr = next;
    }

    prev.next = curr;
    Node.traverse(head);
  }

  public static void swap(Node head) {
    Node curr = head.next.next;

    System.out.println(curr.data);
  }

  public static void main(String[] args) {
    Node head = new Node(2);
    head.next = new Node(1);
    head.next.next = new Node(4);
    // head.next.next.next = new Node(3);
    // head.next.next.next.next = new Node(6);
    // head.next.next.next.next.next = new Node(5);

    // pairWiseSwap(head);
    // pairWiseSwapChangeLink(head);
    swap(head);
  }
}
