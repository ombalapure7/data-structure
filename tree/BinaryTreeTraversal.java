package DSA.tree;

public class BinaryTreeTraversal {

  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node in the function/recursive call
   *  stack O(logn) =~ O(h) Where h is height of the Binary Tree
   */
  public static void inorderTraversal(Node root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.key + " ");
      inorderTraversal(root.right);
    }
  }

  public static void preOrderTraversal(Node root) {
    if (root != null) {
      System.out.print(root.key + " ");
      inorderTraversal(root.left);
      inorderTraversal(root.right);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    inorderTraversal(root);
  }
}
