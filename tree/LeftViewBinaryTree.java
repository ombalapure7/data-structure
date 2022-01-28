package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

  static int maxLevel = 0;
  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node 
   * 
   * Apporach: 
   * Doing a preorder traversal will get us LEFT MOST node everytime
   */
  public static void leftViewOfBinaryTree(Node root, int level) {
    if (root == null) {
      return;
    }

    if (maxLevel < level) {
      System.out.print(root.key + " ");
      maxLevel = level;
    }

    leftViewOfBinaryTree(root.left, level+1);
    leftViewOfBinaryTree(root.right, level+1);
  }

  /*
   * Time Complexity: O(n) - Visit every node once 
   * Space Complexity: O(w) - At a time each level is present in the queue
   * NOTE: Aux space is O(n/2) =~ o(n) in case there are n/2 nodes at last level i.e. the tree is complete 
   */
  public static void leftViewOfBinaryTreeItr(Node root) {
    if (root == null) {
      return;
    }
 
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int count = queue.size();

      for (int i=0; i<count; i++) {
        Node currNode = queue.poll();

        if (i == 0) {
          System.out.print(currNode.key + " ");
        }

        if (currNode.left != null) {
          queue.add(currNode.left);
        } 

        if (currNode.right != null) {
          queue.add(currNode.right);
        }
      }
    }
  }


  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(50);

    leftViewOfBinaryTree(root, 1);
    System.out.println();
    leftViewOfBinaryTreeItr(root);
  }
}
