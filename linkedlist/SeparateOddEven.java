package DSA.linkedlist;

public class SeparateOddEven {
  
  /**
   * @desc  Separate odd/even elements such that first has odd and second half has even elements
   * @param args
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Traverse the linked list and keep connecting even and odd nodes together
   * - Declare variables evenStart, evenEnd, oddStart, oddEnd
   *   - evenStart and evenEnd to keep track of the list with even nodes
   *   - oddStart and oddEnd to keep track of the list with odd nodes
   * - Create 2 lists of odd and even elements and then join them
   * 
   */
  public static void separateEvenOdd(Node head) {
    Node es = null, ee = null, os = null, oe = null;

    for (Node curr = head; curr != null; curr = curr.next) {
      int x = curr.data;

      if (x % 2 != 0) {
        // Even linked list not started yet
        if (es == null) {
          es = curr;
          ee = es;
        } else {
          // Add the node to the end of even list
          ee.next = curr;
          // Move the even end
          ee = ee.next;
        }
      } else {
        // Odd linked list not started yet
        if (os == null) {
          os = curr;
          oe = os;
        } else {
          // Add the node to the end of odd list
          oe.next = curr;
          // Move the odd end
          oe = oe.next;
        }
      }
    }

    if (os == null || es == null) {
      return;
    }

    // Join the last node of even list to the head of the odd list
    ee.next = os;
    // Set the last element of the odd list as NULL
    oe.next = null;

    Node.traverse(es);
  }

  public static void oe(Node head) {
    Node es = null, ee = null, os = null, oe = null;

    for (Node curr = head; curr != null; curr = curr.next) {
      int x = curr.data;

      if (x % 2 != 0) {
        if (os == null) {
          os = curr;
          oe = os;
        } else {
          oe.next = curr;
          oe = oe.next;
        }
      } else {
        if (es == null) {
          es = curr;
          ee = es;
        } else {
          ee.next = curr;
          ee = ee.next;
        }
      }
    }

    ee.next = os;
    oe.next = null;

    Node.traverse(es);
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);

    // separateEvenOdd(head);
    oe(head);
  }
}
