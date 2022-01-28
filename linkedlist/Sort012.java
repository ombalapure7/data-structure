package DSA.linkedlist;

public class Sort012 {

  public static void sort012CopyData(Node head) {
    int count[] = { 0, 0, 0 };

    Node ptr = head;

    while (ptr != null) {
      count[ptr.data]++;
      ptr = ptr.next;
    }

    ptr = head;

    while (ptr != null) {
      if (count[0] != 0) {
        ptr.data = 0;
        count[0]--;
      } else if (count[1] != 0) {
        ptr.data = 1;
        count[1]--;
      } else if (count[2] != 0) {
        ptr.data = 2;
        count[2]--;
      }

      ptr = ptr.next;
    }

    Node.traverse(head);
  }

  public static Node sort012ChangeLinks(Node head) {
    Node zeroD = new Node(0);
    Node oneD = new Node(0);
    Node twoD = new Node(0);

    Node zero = zeroD, one = oneD, two = twoD;

    Node curr = head;
    while (curr != null) {
      if (curr.data == 0) {
        // Append current node to "zero" list's ends
        zero.next = curr;
        zero = zero.next;
        curr = curr.next;
      } else if (curr.data == 1) {
        // Append current node to "one" list's ends
        one.next = curr;
        one = one.next;
        curr = curr.next;
      } else {
        // Append current node to "three" list's ends
        two.next = curr;
        two = two.next;
        curr = curr.next;
      }
    }

    // Attach three lists
    zero.next = (oneD.next != null) ? oneD.next : twoD.next;
    one.next = twoD.next;
    two.next = null;

    // Update the head
    head = zeroD.next;

    return head;
  }

  public static void main(String[] args) {
    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(0);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);
    head.next.next.next.next.next = new Node(1);
    head.next.next.next.next.next.next = new Node(2);
    head.next.next.next.next.next.next.next = new Node(1);
    head.next.next.next.next.next.next.next.next = new Node(2);
    head.next.next.next.next.next.next.next.next.next = new Node(0);

    sort012CopyData(head);

    // head = sort012ChangeLinks(head);
    // Node.traverse(head);
  }
}
