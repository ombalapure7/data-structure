package DSA.tree;

public class HeightBinaryTree {

  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node 
   *  will be in the function/recursive call stack
   *  Hence we have O(logn) =~ O(h), where h is height of the Binary Tree
   *  In worst case there will be h+1 recursive calls
   */
  public static int heightBinaryTree(Node root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(heightBinaryTree(root.left), heightBinaryTree(root.right)) + 1;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(30);
    root.right.left = new Node(40);
    root.right.right = new Node(50);
    // root.right.right.left = new Node(70);

    System.out.println("Height of the binary tree: " + heightBinaryTree(root));
  }
}