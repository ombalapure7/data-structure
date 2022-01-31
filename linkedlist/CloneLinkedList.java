package DSA.linkedlist;

class NodeR {
  int data;
  NodeR next;
  NodeR random;

  NodeR(int data) {
    this.data = data;
  }
}

public class CloneLinkedList {
  
  /**
   * 
   * @desc  Clone linked list which has a next and a radom pointer
   * @param head
   * 
   * COMPLEXITY
   * Time:
   * Space:
   * 
   */
  public static void cloneLinkedList(Node head) {
    
  }

  public static void main(String[] args) {
    NodeR head = new NodeR(10); 
    head.next = new NodeR(5); 
    head.next.next = new NodeR(20); 
    head.next.next.next = new NodeR(15); 
    head.next.next.next.next = new NodeR(20); 
    
    head.random = head.next.next;
    head.next.random=head.next.next.next;
    head.next.next.random=head;
    head.next.next.next.random=head.next.next;
    head.next.next.next.next.random=head.next.next.next;
  }
}
