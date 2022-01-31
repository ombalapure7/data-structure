package DSA.linkedlist;

public class DeleteNodeWoHead {

  /**
   * @desc  Delete a node w/o knowing the head pointer of a linked list
   * @param args
   * 
   * COMPLEXITY
   * Time: O(1)
   * Space: O(1)
   * 
   * Approach: 
   * - If node at position 4 is to be deleted then copy it's value to node 3
   * - Now point the node 3's next to node 5
   * 
   * NOTE: This approach assumes that the node to be delete is not a tail node 
   */
  public static void deleteNodeWoHeadPointer(Node ptr) {
    // Copy current node's reference
    Node temp = ptr.next;
    // Now copy the data of the next node
    ptr.data = temp.data;
    // Now link the current node's next to 1 node ahead
    ptr.next = temp.next;
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    Node ptr = new Node(30);
    head.next.next = ptr;
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(25);

    deleteNodeWoHeadPointer(ptr);
    Node.traverse(head);
  }
}
