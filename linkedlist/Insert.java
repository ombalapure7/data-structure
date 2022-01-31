package DSA.linkedlist;

public class Insert {

  /**
   * @desc  Insert a node at the beginning of a linked list
   * @param head
   * @param x
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(1)
   */
  public static Node insertAtBeginnig(Node head, int x) {
    Node temp = new Node(x);
    temp.next = head;
    return temp;
  }

  /**
   * @desc  Insert a node at the end of a linked list
   * @param head
   * @param x
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static Node insertAtEnd(Node head, int x) {
    Node temp = new Node(x);

    // If this condition is not added it will cause
    // Segmentation fault in C++
    // NPE in Java
    // As we will try to access null.next (curr.next)
    if (head == null) {
      return temp;
    }

    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = temp;

    return head;
  }

  /**
   * @desc  Insert a node at the end of a linked list
   * @param head
   * @param x
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static Node insertAtIndex(Node head, int x, int pos) {
    // We have to return a "head" in case the insertion is done at the beginning
    Node newNode = new Node(x);
    
    // The list is empty, return reference of the newly created node
    if (head == null) {
      return newNode;
    }

    if (pos == 1) {
      newNode.next = head;
      return newNode;
    }

    //     STOP at 2 if pos=4
    // 1 -> 2 -> 3 -> 5 -> 6
    //           \   /
    //             4   
    Node curr = head;
    for (int i=1; i<=pos - 2 && curr!=null; i++) {
      curr = curr.next;
    }

    // Index does not exist where node was supposed to be inserted
    if (curr == null) {
      return head;
    }

    newNode.next = curr.next;
    curr.next = newNode;

    return head;
  }

  public static void main(String[] args) {
    Node head = null;
    head = insertAtBeginnig(head, 30);
    head = insertAtBeginnig(head, 20);
    head = insertAtBeginnig(head, 10);

    Node.traverse(head);
    
    head = insertAtEnd(head, 40);
    Node.traverse(head);

    head = insertAtIndex(head, 19, 2);
    Node.traverse(head);
  }
}
