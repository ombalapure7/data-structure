package DSA.linkedlist;

public class MergeSort {
  Node head = null;

  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  /**
   * @desc   Sort a linked list using merge sort
   * @param  head
   * @return head of linked list
   * 
   * COMPLEXITY
   * Time: O(n*logn)
   * Space: O(n*logn)
   */
  Node mergeSort(Node head) {
    // Base case: if head is null
    if (head == null || head.next == null) {
      return head;
    }

    // get the middle of the list
    Node middle = getMiddle(head);
    Node midNext = middle.next;

    // set the next of middle Node to null
    middle.next = null;

    // Apply mergeSort on left list
    Node left = mergeSort(head);

    // Apply mergeSort on right list
    Node right = mergeSort(midNext);

    // Merge the left and right lists
    Node sortedlist = sortedMerge(left, right);
    return sortedlist;
  }

  Node sortedMerge(Node a, Node b) {
    Node result = null;

    if (a == null)
      return b;
    if (b == null)
      return a;

    /* Pick either a or b, and recur */
    if (a.val <= b.val) {
      result = a;
      result.next = sortedMerge(a.next, b);
    } else {
      result = b;
      result.next = sortedMerge(a, b.next);
    }

    return result;
  }

  // Utility function to get the middle of the linked list
  public static Node getMiddle(Node head) {
    if (head == null)
      return head;

    Node slow = head, fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Insert node in a linked list
  void push(int x) {
    Node temp = new Node(x);
    temp.next = head;
    head = temp;
  }

  // Utility function to print the linked list
  void printList(Node headref) {
    while (headref != null) {
      System.out.print(headref.val + " ");
      headref = headref.next;
    }
  }

  public static void main(String[] args) {
    MergeSort li = new MergeSort();
    li.push(15);
    li.push(10);
    li.push(5);
    li.push(20);
    li.push(3);
    li.push(2);

    // Apply merge Sort
    li.head = li.mergeSort(li.head);
    System.out.print("\n Sorted Linked List is: \n");
    li.printList(li.head);
  }
}
