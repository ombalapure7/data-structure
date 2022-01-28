package DSA.tree;

import java.util.ArrayList;

public class Lca {
  // Ancestor of a node is node itself its parent and parent of parent and so on
  // Using LCA we can also find distance b/w two nodes

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * Approach: 
   * - Find a path from x to the root and create an array for path-1 
   * - Find a path from y to the root and create an array for path-2 
   * - Now while traversing the arrays find a common element b/w them, the common element will be the LCA
   * 
   * It requires 3 traversal of the tree and overhead for storing paths
   */
  public static Node leastCommonAncestor(Node root, int n1, int n2) {
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    if (findPath(root, path1, n1) == false || findPath(root, path2, n2) == false) {
      return null;
    }

    for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
      if (path1.get(i+1) != path2.get(i+1)) {
        return path1.get(i);
      }
    }

    return null;
  }

  // Helper function to find the path from root to "n"
  public static boolean findPath(Node root, ArrayList<Node> p, int n) {
    if (root == null) {
      return false;
    }

    p.add(root);

    if (root.key == n) {
      return true;
    }

    if (findPath(root.left, p, n) || findPath(root.right, p, n)) {
      return true;
    }

    p.remove(p.size() - 1);
    return false;
  }

  /**
   * Time Complexity: O(n)
   * Space Complexity: O(h)
   * 
   * Approach: 
   * - Assumes that both n1 and n2 exist in the binary tree
   * - Requires one traversal but returns wrong result 
   *    if one of the key is not present and result is not returned as NULL                                                                                  
   */
  public static Node leastCommonAncestorBetter(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }

    if (root.key == n1 || root.key == n2) {
      return root;
    }

    // 1 key is present in left subtree and another in right subtree
    Node lca1 = leastCommonAncestorBetter(root, n1, n2);
    Node lca2 = leastCommonAncestorBetter(root, n1, n2);

    if (lca1 != null && lca2 != null) {
      return root;
    }

    //  If both the keys are present in the left side
    //  Else both the keys are present in the right side
    if (lca1 != null) {
      return lca1;
    } else {
      return lca2;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(50);

    int n1 = 20, n2 = 50;

    Node res = leastCommonAncestor(root, n1, n2);
    if (res == null) {
      System.out.println("Got a NULL value!");
    } else {
      System.out.println("LCA: " + res.key);
    }

    System.out.println("");
  }
}
