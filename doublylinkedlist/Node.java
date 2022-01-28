package DSA.doublylinkedlist;

public class Node {
  int data;
  Node prev;
  Node next;

  Node (int data) {
    this.data = data;
  }

  public static void printlist(Node node) {
    Node last = null;
    System.out.println("Traversal in forward Direction");
    while (node != null) {
      System.out.print(node.data + " ");
      last = node;
      node = node.next;
    }

    System.out.println();
    System.out.println("Traversal in reverse direction");
    while (last != null) {
      System.out.print(last.data + " ");
      last = last.prev;
    }
  }
}
