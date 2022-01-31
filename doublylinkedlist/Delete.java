package DSA.doublylinkedlist;

public class Delete {
  
  public static Node deleteHead(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    head = head.next;
    head.prev = null;

    return head;
  }

  public static Node deleteLastNode(Node head) {
    if (head == null || head.next == null) {
      return null;
    }

    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }

    // Go to second last node
    // And point next to NULL
    curr.prev.next = null;
    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    Node temp1 = new Node(20);
    Node temp2 = new Node(30);
    head.next = temp1;
    temp1.prev = head;
    temp1.next = temp2;
    temp2.prev = temp1;

    head = deleteHead(head);
    // Node.printlist(head);

    head = deleteHead(head);
    Node.printlist(head);
  }
}
