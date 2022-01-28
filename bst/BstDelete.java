package DSA.bst;

public class BstDelete {

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(h)
   * 
   * Case 1: Deleting leaf node is straight forward
   * Case 2: Deleting node with single child
   * Case 3: To delete a node with 2 children, a successor must be found
   */
  public static Node delete(Node root, int x) {
    if (root == null) {
      return null;
    }

    // Searching for x
    if (root.key > x) {
      root.left = delete(root.left, x);
    } else if (root.key < x) {
      root.right = delete(root.right, x);
    } else {
      // Deletion part after x is found
      // Case 2
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        // Case 3
        // Search the min element on the right side
        Node successor = getSuccessor(root);
        root.key = successor.key;
        root.right = delete(root.right, successor.key);
      }
    }

    return root;
  }

  /* Helper function to find the successor */
  public static Node getSuccessor(Node root) {
    Node curr = root.right;
    while (curr != null && curr.left != null) {
      curr = curr.left;
    }

    return curr;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(5);
    root.right = new Node(15);
    root.right.left = new Node(12);
    root.right.right = new Node(18);

    root = delete(root, 15);
    BstTraversal.inorderTraversal(root);
  }
}
