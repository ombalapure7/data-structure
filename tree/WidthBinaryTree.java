package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthBinaryTree {

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(w), w - width of the tree
   */
  public static int widthOfBinaryTree(Node root) {
    if (root == null) {
      return 0;
    }

    int res = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int count = queue.size();
      res = Math.max(res, count);

      for (int i = 0; i < count; i++) {
        Node currNode = queue.poll();

        if (currNode.left != null) {
          queue.add(currNode.left);
        }

        if (currNode.right != null) {
          queue.add(currNode.right);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.right.left = new Node(60);
    // root.right.right = new Node(70);

    System.out.println("Width of the binary tree: " + widthOfBinaryTree(root));
  }
}
