package DSA.tree;

public class IsHeightBalanced {
  // | Height of left sub tree - Height of right sub tree | <= 1 
  // If the difference is > 1 then the tree is unbalanced, this applies to everynode

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(h)
   * 
   * Approach:
   * - Compute height of left and right sub tree
   * - Check the difference is <= 1
   */
  public static boolean isTreeBalanced(Node root) {
    if (root == null) {
      return true;
    }

    int lHeight = HeightBinaryTree.heightBinaryTree(root.left);
    int rHeight = HeightBinaryTree.heightBinaryTree(root.right);

    return Math.abs(lHeight - rHeight) <= 1 && (isTreeBalanced(root.left) && isTreeBalanced(root.right));
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(h)
   */
  public static int isTreeBalancedBetter(Node root) {
    if (root == null) {
      return 0;
    }

    // Check height of left sub tree
    int lHeight = isTreeBalancedBetter(root.left);
    if (lHeight == -1) {
      return -1;
    }

    // Check height of right sub tree
    int rHeight = isTreeBalancedBetter(root.right);
    if (rHeight == -1) {
      return -1;
    }

    if (Math.abs(lHeight - rHeight) > 1) {
      return -1;
    } else {
      return Math.max(lHeight, rHeight) + 1;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(5);
    root.right = new Node(30);
    root.right.left = new Node(15);
    root.right.right = new Node(20);

    System.out.println("Is the Binary Tree balanced - Naive: " + isTreeBalanced(root));

    if (isTreeBalancedBetter(root) == -1) {
      System.out.println("The tree is NOT balanced!"); 
    } else {
      System.out.println("The tree is balanced");
    }
  }
}
