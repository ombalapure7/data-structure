package DSA.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ElementSumNonZero {
  private static Node head;

  private void removeNonZeroElements(Node root) {
    Node start = root;
    Stack<Node> stack = new Stack<>();
    boolean flag = false;
    List<Node> list = new ArrayList<>();

    while (start != null) {
      if (start.data > 0)
        stack.push(start);
      else {
        int sum = start.data;
        flag = false;

        while (!stack.isEmpty()) {
          Node temp = stack.pop();
          sum += temp.data;
          if (sum == 0) {
            flag = true;
            list.clear();
            break;
          }

          list.add(temp);
        }

        if (!flag) {
          list.forEach(i -> stack.add(i));
          stack.add(start);
        }
      }

      start = start.next;
    }

    stack.forEach(i -> System.out.print(i.data + " -> "));
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    ElementSumNonZero list = new ElementSumNonZero();
    ElementSumNonZero.head = new Node(6);
    ElementSumNonZero.head.next = new Node(-6);
    ElementSumNonZero.head.next.next = new Node(8);
    ElementSumNonZero.head.next.next.next = new Node(4);
    ElementSumNonZero.head.next.next.next.next = new Node(-12);
    ElementSumNonZero.head.next.next.next.next.next = new Node(9);
    ElementSumNonZero.head.next.next.next.next.next.next = new Node(8);
    ElementSumNonZero.head.next.next.next.next.next.next.next = new Node(-8);
    list.removeNonZeroElements(head);
  }
}