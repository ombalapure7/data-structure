package DSA.doublylinkedlist;

public class Insert {

  public static Node insertAtBeginning(Node head, int data) {
    if (head == null) {
      return null;
    }

    Node temp = new Node(data);
    temp.next = head;

    if (head != null) {
      head.prev = temp;
    }

    return temp;
  }

  public static Node insertAtEnd(Node head, int data) {
    Node temp = new Node(data);
    Node curr = head;

    if (head == null) {
      return temp;
    }

    while (curr.next != null) {
      curr = curr.next;
    }

    curr.next = temp;
    temp.prev = curr;

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

    head = insertAtBeginning(head, 5);
    // Node.printlist(head);

    head = insertAtEnd(head, 35);
    Node.printlist(head);
  }
}
