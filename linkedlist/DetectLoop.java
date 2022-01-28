package DSA.linkedlist;

import java.util.HashSet;

class NodeV {
  int data;
  NodeV next;
  boolean visited;

  NodeV(int data) {
    this.data = data;
    next = null;
    visited = false;
  }
}

public class DetectLoop {
  
  /**
   * @desc  Detect a loop in a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * NOTE: This approach works as long as we are allowed to make 
   *  changes to the Node class
   * 
   * Approach:
   * - The node class will have an extra variable of boolean type
   * - All the nodes will that variable say visisted=false
   * - Now keep iterating over the loop and mark visited=true
   * - If visited=true is found for any node that means there is a cycle present
   */
  public static boolean hasLoop(NodeV head) {
    // First node pointing to itself
    if (head.visited) {
      return true;
    }

    NodeV curr = head;
    while (curr != null) {
      // If a node visited once is encountered again, then there's a loop
      if (curr.visited) {
        return true;
      }

      // Mark every visited node as true
      curr.visited = true;
      // Go to the next node
      curr = curr.next;
    }

    return false;
  }

  /**
   * @desc  Detect a loop in a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * NOTE: This approach alters the references/links instead of
   *    doing changes to the Node class. Inshort destroys the linked list.
   * 
   * Approach:
   * - Create a dummy node
   * - Start traversing the linked list and as you traverse, start pointing
   *    the upcoming nodes to "temp"
   * - If there is a node that already points to the temp node, there is a cycle
   */
  public static boolean hasLoopChangeRef(NodeV head) {
    NodeV temp = new NodeV(0);
    NodeV curr = head;

    while (curr != null) {
      // Reached the end of the list, no loop found
      if (curr.next == null) {
        return false;
      }

      // Current's next already points to temp
      // Hence there is a loop
      if (curr.next == temp) {
        return true;
      }

      // Store the current's next otherwise we lose the link to remaining node
      NodeV currNext = curr.next;
      // Point the current's next to temp
      curr.next = temp;
      // Go to the next node
      curr = currNext;
    }

    return false;
  }

  /**
   * @desc  Detect a loop in a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   * NOTE: This approach does not modify the Node class
   *    or modify the pointers/links of the linekd list
   * But it takes O(n) space
   */
  public static boolean hasLoopHash(NodeV head) {
    HashSet<NodeV> set = new HashSet<>();

    for (NodeV curr = head; curr != null; curr = curr.next) {
      if (set.contains(curr)) {
        return true;
      }

      set.add(curr);
    }

    return false;
  }

  /**
   * @desc  Detect a loop in a linked list
   * @param head
   * 
   * COMPLEXITY
   * Time: O(m + n) =~ O(length of list)
   * Space: O(1)
   * 
   * NOTE: This approach does not modify the Node class
   *    or modify the pointers/links of the linekd list
   * And it takes constant space
   * 
   * Approach:
   * - There are 2 pointers fast and slow
   * - slow moves 1 step and fast moves 2 steps at a time
   * - And if they meet at certain point then we conclude - there is a cycle
   * 
   * This approach works every time as distance b/w fast and slow keep on increasing by 1 on each iteration
   * Say there is a cycle of length "n" and when the distance b/w fast and slow becomes "n"
   */
  public static boolean hasLoopFloyd(NodeV head) {
    NodeV slow = head, fast = head;

    while (fast != null && fast.next != null) {
      // fast moves 2 places at a time so check if fast.next == null
      slow = slow.next;
      fast = fast.next.next;

      // fast and slow point at same place - loop is detected
      // NOTE: Dont place this check at the top as the condition will be true for every list
      if (slow == fast) {
        return true;
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    NodeV head = new NodeV(15);
    head.next = new NodeV(10);
    head.next.next = new NodeV(12);
    head.next.next.next = new NodeV(20);
    head.next.next.next.next = head.next;

    System.out.println("List has a loop - Naive: " + hasLoop(head));
    // System.out.println("List has a loop - Better: " + hasLoopChangeRef(head));
    System.out.println("List has a loop - Best: " + hasLoopHash(head));
  }
}
