package DSA.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
  
  /**
   * Time Complexity: O(n) 
   * Space Complexity: O(h)
   * 
   * Naive approach: 
   * - Find height of the tree
   * - Print nodes at distance "k" from root and we start from k=0 to h
   * 
   * O(n) to find the height, run a looph times and we call a function printNodesAtK inside the loop
   * Hence overall we have O(h*n)
   * 
   * NOTE: In case of recursion we cannot switch to left/right side at print node at same level
   */


  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(n) - At a time there will be either left or right node
   * 
   * We insert nodes of a level at a time in queue then remove and repeat it again
   * Every node goes (come out) in the queue ONCE 
   * Enqueue and deque is O(1), so we are doing this for "n" nodes hence O(n)
   * 
   * We are inserting one level of a tree at a time so space complexity will be O(width of binary tree)
   * In case of a perfect binary tree there will - n+1/2 nodes at the last level
   * 
   * Average case θ(w)
   * Worst case O(n)
   */
  public static void levelOrderTraversal(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int count = queue.size();

      for (int i=0; i<count; i++) {
        Node currNode = queue.poll();
        System.out.print(currNode.key + " ");

        if (currNode.left != null) {
          queue.add(currNode.left);
        } 
        if (currNode.right != null) {
          queue.add(currNode.right);
        }
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.right.right = new Node(70);
    root.right.right.right = new Node(80);

    levelOrderTraversal(root);
  }
}
