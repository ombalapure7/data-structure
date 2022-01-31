package DSA.tree;

public class SizeBinaryTree {

  /*
   * Time Complexity: O(n) - Constant work for n nodes
   * Space Complexity: O(h) - At a time there will be either left or right node
   */
  public static int sizeOfBinaryTree(Node root) {
    if (root == null) {
      return 0;
    }

    return 1 + sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
  }

  /*
   * Time Complexity: O(n) - Constant work for n nodes
   * Space Complexity: O(h) - At a time there will be either left or right nodes
   * in the call stack
   * 
   * Finding heigh of a complete binary tree
   * In a complete binary tree only the last level can have partial nodes
   * whereas other levels must be filled completely
   */
  public static int countNodesInCbt(Node root) {
    int lh = 0, rh = 0;

    Node currNode = root;
    while (currNode != null) {
      lh++;
      currNode = currNode.left;
    }

    currNode = root;
    while (currNode != null) {
      rh++;
      currNode = currNode.right;
    }

    if (lh == rh) {
      return (int) Math.pow(2, lh) - 1;
    } else {
      return 1 + countNodesInCbt(root.left) + countNodesInCbt(root.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(50);

    System.out.println("Size of the binary tree: " + sizeOfBinaryTree(root));
    System.out.println("Size of the complete binary tree: " + countNodesInCbt(root));
  }
}
