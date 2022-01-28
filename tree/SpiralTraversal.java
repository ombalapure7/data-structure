package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(n)
   * 
   * Every single value is pushed/popped to/from a stack Every single value is
   * queued/enqueued So total 4 operations for a value O(4n) =~ O(n)
   */
  public static void printSpiralTraversal(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    Stack<Integer> stack = new Stack<>();
    // A flag that will help us print the levels in reverse/forward (alternating)
    // direction
    boolean reverse = false;

    while (!queue.isEmpty()) {
      int count = queue.size();

      for (int i = 0; i < count; i++) {
        Node currNode = queue.poll();

        // To print levels in reverse order, push elements to stack and then pop it
        // This will print the elements in reverse order
        if (reverse) {
          stack.push(currNode.key);
        } else {
          // Print the level in forward direction
          System.out.print(currNode.key + " ");
        }

        if (currNode.left != null) {
          queue.add(currNode.left);
        }

        if (currNode.right != null) {
          queue.add(currNode.right);
        }
      }

      // Prints level in reverse order
      // Pops element from the stack one by one
      if (reverse) {
        while (!stack.isEmpty()) {
          System.out.print(stack.pop() + " ");
        }
      }

      reverse = !reverse;
      System.out.println();
    }
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(n)
   */
  public static void printSpiralTraversalSpaceEff(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();

    s1.add(root);

    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.empty()) {
        Node currNode = s1.peek();
        s1.pop();

        System.out.print(currNode.key + " ");

        if (currNode.right != null) {
          s2.add(currNode.right);
        }

        if (currNode.left != null) {
          s2.add(currNode.left);
        }
      }

      while (!s2.empty()) {
        Node currNode = s2.peek();
        s2.pop();

        System.out.print(currNode.key + " "); 

        if (currNode.left != null) {
          s1.add(currNode.left);
        }

        if (currNode.right != null) {
          s1.add(currNode.right);
        }
      }
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    printSpiralTraversal(root);
    printSpiralTraversalSpaceEff(root);
  }
}
