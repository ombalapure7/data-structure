package DSA.linkedlist;

public class DetectRemoveLoop {

  public static void detectAndRemoveCycle(Node head) {
    Node fast = head, slow = head;

    /* Step 1: Detect the loop */
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    // There is no loop so return
    if (slow != fast) {
      System.out.println("No loop detected...");
      return;
    }

    /* Step 2: Remove the loop */
    slow = head;
    // NOTE: distance from fast and slow to where the loop terminates is same
    //    If both travel at same speed 
    // Compare slow.next and fast.next as the loop won't be executed at all
    //    if the loop is not in the beginning itself
    // You can put slow != fast in that case the prev pointer need to be maintained for fast
    while (slow.next != fast.next) {
      slow = slow.next;
      fast = fast.next;
    } 

    // Remove the loop
    fast.next = null;
  }

  public static void main(String[] args) {
    Node head = new Node(15);
    head.next = new Node(10);
    head.next.next = new Node(12);
    head.next.next.next = new Node(20);
    head.next.next.next.next = head.next.next;

    detectAndRemoveCycle(head);
    Node.traverse(head);
  }
}
