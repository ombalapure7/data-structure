package DSA.linkedlist;

import java.util.Stack;

public class ReverseLinkedListInGroups {

  /**
   * @desc Reverse list in sizes of k
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n/k)
   */
  public static Node reverseListInSizeK(Node head, int k) {
    Node curr = head, next = null, prev = null;
    int count = 0;

    // Reverse first k nodes
    while (curr != null && count < k) {
      // Reverse k node
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;

      // Increase counter
      count++;
    }

    // Make a recursive call for the remaining n - k nodes
    if (next != null) {
      // prev is returned as the new head everytime
      Node restHead = reverseListInSizeK(next, k);
      // The kth node will be the new head
      // 1 2 3 4 5
      // If k = 3 then 3 becomes the new head
      // 3 2 1 4 5
      // NOTE: head will be the last node now
      // so now connect it to new head i.e. prev
      head.next = restHead;
    }

    return prev;
  }

  /**
   * @desc Reverse list in sizes of k
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   */
  public static void reverseListInSizeKItr(Node head, int k) {
    Node curr = head, prevFirst = null;
    boolean isFirstPass = true;
    
    while (curr != null) {
      Node first = curr, prev = null;
      int count = 0;
      
      // Reverse k node
      while (curr != null && count < k) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        count++;
      }

      if (isFirstPass) {
        head = prev;
        isFirstPass = false;
      } else {
        prevFirst.next = prev;
      }

      prevFirst = first;
    }

    Node.traverse(head);
  }

  /**
   * @desc Reverse list in sizes of k - using a stack
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(k)
   * 
   * At a time k nodes will be present in the stack
   */
  public static void reverseKStack(Node head, int k) {
    Stack<Node> st = new Stack<>();
    Node curr = head;
    Node prev = null;

    while (curr != null) {
      int count = 0;
      while (curr != null && count < k) {
        // Push k nodes to the stack
        st.push(curr);
        curr = curr.next;
        count++;
      }

      while (st.size() > 0) {
        if (prev == null) {
          // Is 1st pass
          prev = st.peek();
          head = prev;
          st.pop();
        } else {
          // After 1st pass
          prev.next = st.peek();
          prev = prev.next;
          st.pop();
        }
      }
    }

    prev.next = null;

    Node.traverse(head);
  } 

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);

    // head = reverseListInSizeK(head, 3);
    // Node.traverse(head);
    
    // reverseListInSizeKItr(head, 3);

    reverseKStack(head, 3);
  }
}
