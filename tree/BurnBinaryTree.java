package DSA.tree;

public class BurnBinaryTree {
  
  /**
   * Time Complexity: O(n) 
   * Space Complexity: O(n)
   * 
   * Appraoch: 
   * - Use the logic of farthest node from the given node
   * - And the farthest node MUST be reachable through an ancestor
   * - Mark nodes as -1 if it is not a descendant of the passed leaf node
   */

  static class Distance {
    int val;
    Distance(int d) {
      val = d;
    }
  } 

  static int res = 0;

  public static int burnBinaryTree(Node root, int leaf, Distance dist) {
    if (root == null) {
      return 0;
    }

    if (root.key == leaf) {
      dist.val = 0;
      return 1;
    }

    Distance lDist = new Distance(-1);
    Distance rDist = new Distance(-1);

    int lh = burnBinaryTree(root.left, leaf, lDist);
    int rh = burnBinaryTree(root.right, leaf, rDist);

    if (lDist.val != -1) {
      dist.val = lDist.val + 1;
      res = Math.max(res, rh + dist.val);
    } else if (rDist.val != -1) {
      dist.val = rDist.val + 1;
      res = Math.max(res, lh + dist.val);
    }

    return Math.max(lh, rh) + 1;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.left.left.left = new Node(60);
    root.left.left.left.left = new Node(70);

    Distance dist = new Distance(-1);
    int leaf = 50;
    burnBinaryTree(root, leaf, dist);
    System.out.print("Result: " + res);
  }
}
