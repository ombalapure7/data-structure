package DSA.tree;

public class DiameterBinaryTree {
  // Find longest path b/w two nodes i.e. no. of nodes
  static int res = 0;

  /**
   * Time Complexity: O(n^2) 
   * Space Complexity: O(h)
   * 
   * Approach: Find the left and right height for every node and add to it
   */
  public static int diameterOfBinaryTree(Node root) {
    if (root == null) {
      return 0;
    }

    // Using heightBinaryTree() to find the height for every node
    int d1 = 1 + HeightBinaryTree.heightBinaryTree(root.left) 
            + HeightBinaryTree.heightBinaryTree(root.right);

    int d2 = diameterOfBinaryTree(root.left);
    int d3 = diameterOfBinaryTree(root.right);
    
    return Math.max(d1, Math.max(d2, d3));
  }

   /**
   * Time Complexity: O(n) 
   * Space Complexity: O(h)
   * 
   * Approach: 
   *  - Precompute height of every node and store it in hashmap
   *  - But this will cause an overhead for space and hashmap operations
   * 
   * Another approach: 
   *  - We can calculate the diameter after we find the left and right height of a node
   *  - Eg:     1 
   *          /   \
   *         2     3
   *  - rh = 1, lh = 1, so diamter = 1 + lh + rh = 3
   */
  public static int diameterOfBinaryTreeBetter(Node root) {
    if (root == null) {
      return 0;
    }

    int lHeight = diameterOfBinaryTreeBetter(root.left);
    int rHeight = diameterOfBinaryTreeBetter(root.right);

    res = Math.max(res, 1 + lHeight + rHeight);
    return 1 + Math.max(lHeight, rHeight);
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(60);
    root.right.left.left = new Node(50);
    root.right.right.right = new Node(70);

    System.out.println("Diameter of the binary tree - Naive: " + diameterOfBinaryTree(root));

    diameterOfBinaryTreeBetter(root);
    System.out.println("Diameter of the binary tree - Efficient: " + res);
  }
}
