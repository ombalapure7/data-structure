package DSA.linkedlist;

public class Delete {

  /**
   * @desc  Delete first node in a linked list 
   * @param head
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(1)
   */
  public static Node deleteFirstNode(Node head) {
    if (head == null) {
      return null;
    }

    return head.next;
  }

  /**
   * @desc  Delete last node in a linked list 
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static Node deleteLastNode(Node head) {
    // The list is empty nothing to delete
    if (head == null) {
      return null;
    }

    // There is only one node in the list
    if (head.next == null) {
      return null;
    }

    Node curr = head;
    // Check if there are atleast two nodes in the list
    while (curr.next.next != null) {
      curr = curr.next;
    }

    curr.next = null;
    return head;
  }

  /**
   * @desc  Delete specific node
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static Node deleteKey(Node head, int key) {
    if (head == null) {
      return null;
    }

    if (head.data == key) {
      head = head.next;
    }

    Node curr = head;
    Node prev = null;
    while (curr != null) {
      if (curr.data == key) {
        prev.next = curr.next;
        break;
      } 

      prev = curr;
      curr = curr.next;
    }

    return head;
  }
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);    
    head.next.next = new Node(3);    
    head.next.next.next = new Node(4);    

    // head = deleteFirstNode(head);
    // Node.traverse(head);

    // head = deleteLastNode(head);
    // Node.traverse(head);
   
    head = deleteKey(head, 4);
    Node.traverse(head);
  }
}
