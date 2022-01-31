package DSA.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

class NodeP {
  Character data;
  NodeP next;

  NodeP(Character data) {
    this.data = data;
    next = null;
  }
}

public class Palindrome {

  /**
   * 
   * @param head
   * @return boolean
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   */
  public static boolean palindromeHash(NodeP head) {
    Deque<Character> stack = new ArrayDeque<>();

    for (NodeP curr = head; curr != null; curr = curr.next) {
      stack.push(curr.data);
    }

    for (NodeP curr = head; curr != null; curr = curr.next) {
      if (stack.pop() != curr.data) {
        return false;
      }
    }

    return true;
  }

  /**
   * 
   * @param   head
   * @return  boolean
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Find the middle node
   * - Reverse the second half
   * - Now compare first and second half
   * 
   * 1 2 3 4 5
   * k a y a k
   * If y is the mid point
   * Compare 1 and 4 | 2 and 5 | so on...
   * 
   */
  public static boolean palindromeBetter(NodeP head) {
    if (head == null) {
      return true;
    }

    // Step 1: Find the middle node
    NodeP slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Step 2: Reverse the second half
    NodeP rev = reverseList(slow.next);
    
    // Step 3: Compare the first and second half values
    NodeP curr = head;
    while (rev != null) {
      if (rev.data != curr.data) {
        return false;
      }

      // Move the pointers iterating over 1st and 2nd half one-by-one
      rev = rev.next;
      curr = curr.next;
    }

    return true;
  }

  public static NodeP reverseList(NodeP head) {
    if (head == null || head.next == null) {
      return head;
    }

    NodeP rest_head = reverseList(head.next);
    NodeP rest_tail = head.next;
    rest_tail.next = head;
    head.next = null;
    return rest_head;
  }

  public static void main(String[] args) {
    NodeP head = new NodeP('k');
    head.next = new NodeP('a');
    head.next.next = new NodeP('y');
    head.next.next.next = new NodeP('a');
    head.next.next.next.next = new NodeP('k');

    System.out.println("Is the list palindrome - Hashing: " + palindromeHash(head));
    System.out.println("Is the list palindrome - Better : " + palindromeBetter(head));
  }
}
