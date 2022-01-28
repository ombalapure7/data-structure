package DSA.bst;

import java.util.ArrayList;
import java.util.Stack;

public class CheckBst {

  // If we compare every node with left and right node, 
  //   this approach will return true even for an invalid BST

  // Stores the inorder traversal 
  static int prev = Integer.MIN_VALUE;

  /**
   * Time Complexity: O(n^2)
   * Space Complexity: O(h)
   * 
   * The complexity is quadratic in case the tree is skewed
   * 
   * Approach:
   * - Find max in left tree
   * - Find min in right tree
   * - Now compare every node with this value
   */
  public static boolean isTreeBst(Node root) {
    if (root == null) {
      return true;
    }

    // Find the biggest value on left
    if (root.left != null && MinMax.maxValue(root.left) > root.key) {
      return false;
    }

    // Find the smallest value on right
    if (root.right != null && MinMax.minValue(root.right) < root.key) {
      return false;
    }

    // We have to check the min/max condition for every node 
    // So we make recursive calls for all the nodes
    if (isTreeBst(root.left) == false || isTreeBst(root.right) == false) {
      return false;
    }
 
    return true;
  }

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public static boolean isTreeBstBetter(Node root) {
    // Inorder traversal of a BST has sorted values
    ArrayList<Integer> arr = inorderItr(root);

    // Check if the array is sorted
    for (int i=1; i<arr.size(); i++) {
      if (arr.get(i) < arr.get(i-1)) {
        return false;
      }
    }
    
    return true;
  }

  /* Helper function to generate arraylist containing inorder traversal of a BST */
  public static ArrayList<Integer> inorderItr(Node root) {
    ArrayList<Integer> arr = new ArrayList<>();

    if (root == null) {
      return null;
    }
 
    // We use a stack coz it will store the last processed node
    //  to get back to the root and then to the right child of that root
    // Hence we are pushing nodes not just the node's value, to keep the left and right pointer intact
    Stack<Node> stack = new Stack<Node>();
    Node curr = root;

    // Traverse the BST
    while (curr != null || stack.size() > 0)
    {
      // Reach the left most Node of the
      while (curr !=  null) {
        // Place pointer to a tree node on the stack before traversing
        //  the node's left subtree 
        stack.push(curr);
        curr = curr.left;
      }

      // Current must be NULL at this point
      curr = stack.pop();
      arr.add(curr.key);
      
      // Visit the  
      curr = curr.right;
    }

    return arr;
  }

  public static void main(String[] args) {
    Node root = new Node(4);  
    root.left = new Node(2);  
    root.right = new Node(5);  
    root.left.left = new Node(1);  
    root.left.right = new Node(3);  
    // root.right.right = new Node(-1);  

    System.out.println("Is this tree a BST: " + isTreeBst(root));
    System.out.println("Is this tree a BST: " + isTreeBstBetter(root));
  }
}
