package DSA.linkedlist;

import java.util.HashSet;

public class Intersection {

  /**
   * 
   * @param head1
   * @param head2
   * @return Intersection point of 2 linked list
   * 
   * COMPLEXITY
   * Time: O(m + n)
   * Space: O(m)
   * 
   * m: size of list 1
   * n: size of list 2
   * 
   * We only store a single list in the hashset, we assume it will be of size m
   * So space taken is O(m)
   * 
   * Approach: 
   * - Create an empty hashset and store the 1st list inside it
   * - Now iterate over the hashset and check if any of the nodes inside 
   *    the hashset is present in the second list as well
   * - If yes: 
   *    return the node data
   * - Else:
   *    return -1
   */
  public static int getIntersectioHash(Node head1, Node head2) {
    HashSet<Node> set = new HashSet<>();
    Node curr = head1;

    while (curr != null) {
      set.add(curr);
      curr = curr.next;
    }

    curr = head2;
    while (curr != null) {
      if (set.contains(curr)) {
        return curr.data;
      }

      curr = curr.next;
    }

    return -1;
  }

  public static void main(String[] args) {
    Node newNode;
    Node head1 = new Node(10);
    Node head2 = new Node(3);

    newNode = new Node(6);
    head2.next = newNode;

    newNode = new Node(9);
    head2.next.next = newNode;

    newNode = new Node(15);
    head1.next = newNode;
    head2.next.next.next = newNode;

    newNode = new Node(30);
    head1.next.next = newNode;

    head1.next.next.next = null;

    System.out.println("Intersection point of the lists - HashSet: " + getIntersectioHash(head1, head2));
  }
}
