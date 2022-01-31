package DSA.doublylinkedlist;

public class Reverse {

  public static Node reverse(Node head) {
    if (head == null) {
      return null;
    }

    Node prev = null, curr = head;

    while (curr != null) {
      prev = curr.prev;
      curr.prev = curr.next;
      curr.next = prev;
      
      curr = curr.prev;
    }

    return prev.prev;
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    Node temp1 = new Node(20);
    Node temp2 = new Node(30);
    head.next = temp1;
    temp1.prev = head;
    temp1.next = temp2;
    temp2.prev = temp1;

    head = reverse(head);
    Node.printlist(head);
  }
}
