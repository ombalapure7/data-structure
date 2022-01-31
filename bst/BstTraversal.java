package DSA.bst;

public class BstTraversal {
  
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
}
