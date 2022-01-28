package DSA.linkedlist;

public class IntersectionWoHash {

  static Node head1, head2;

  /**
   * @param head1
   * @param head2
   * @return Intersection point of 2 linked list
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(1)
   * 
   * Approach:
   * - Count nodes in both lists. Let c1 and c2 be the counts.
   * - Travel the bigger list Math.abs(c1 - c2) time.
   * - Travel both the list simultaneously until we find a common node.
   */
  public static int getNode() {
    int c1 = getCount(head1);
    int c2 = getCount(head2);
    int diff = 0;

    if (c1 > c2) {
      diff = c1 - c2;
      return getIntersection(diff, head1, head2);
    } else {
      diff = c2 - c1;
      return getIntersection(diff, head2, head1);
    }
  }

  /* Get the intersection point */
  public static int getIntersection(int diff, Node head1, Node head2) {
    Node curr1 = head1;
    Node curr2 = head2;

    // Iterate diff no. of nodes in list1
    for (int i=0; i<diff; i++) {
      if (curr1 == null) { 
				return -1; 
			} 

			curr1 = curr1.next; 
    }

    // Now curr1 and curr2 are equal distances away from the intersection
    // Move move step step at a time over list1 and list2
    while (curr1 != null && curr2 != null) { 
			if (curr1.data == curr2.data) { 
				return curr1.data; 
			}

			curr1 = curr1.next; 
			curr2 = curr2.next; 
		} 

		return -1; 
  }

  /* Get the no. of nodes in a list */
  public static int getCount(Node node) { 
		Node current = node; 
		int count = 0; 

		while (current != null) { 
			count++; 
			current = current.next; 
		} 

		return count; 
	} 

  public static void main(String[] args) {
		IntersectionWoHash.head1 = new Node(3); 
		IntersectionWoHash.head1.next = new Node(6); 
		IntersectionWoHash.head1.next.next = new Node(9); 
		IntersectionWoHash.head1.next.next.next = new Node(15); 
		IntersectionWoHash.head1.next.next.next.next = new Node(30); 

		IntersectionWoHash.head2 = new Node(10); 
		IntersectionWoHash.head2.next = new Node(15); 
		IntersectionWoHash.head2.next.next = new Node(30); 

    System.out.println("Intersection point of the lists - w/o Hashing: " + getNode());
  }
}
