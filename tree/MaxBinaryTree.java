package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxBinaryTree {
  
  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node 
   */
  public static int maxInBinaryTree(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    } 

    return Math.max(root.key, Math.max(maxInBinaryTree(root.left), maxInBinaryTree(root.right)));
  }

  /*
   * In case of level order traversal appraoch using a queue 
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(w) - W is the width of the binary tree
   * 
   * This approach is better if the tree is skewed as it will need less space. 
   * But if the tree is balanced then level order will need more space than recursive solution. 
   */
  public static int maxInBinaryTreeItr(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int max = Integer.MIN_VALUE;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.key > max) {
        max = node.key;
      } 

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(80);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(50);

    System.out.println("Max no. in a binary tree: " + maxInBinaryTree(root));
    System.out.println("Max no. in a binary tree: " + maxInBinaryTreeItr(root));
  }
}
