package DSA.tree;

public class ConstructBinaryTree {

  static int preIndex = 0;

  // We can construct a binary tree only if we have an inorder + preoder OR inorder + postorder sequence

  /**
   * Time Complexity: O(n^2) - Doing O(n) work for every node
   * Space Complexity: O(n) - length of the arrays
   */
  public static Node constructBinaryTree(int in[], int pre[], int is, int ie) {
    if (is > ie) {
      return null;
    }

    Node root = new Node(pre[preIndex++]);
    int inIndex = 0;

    // Root will be present at 0th index in case of preorder 
    // Search that root in the inorder array, once found break the loop
    for (int i=is; i<=ie; i++) {
      if (in[i] == root.key) {
        inIndex = i;
        break;
      }
    }

    // Build the left half
    root.left = constructBinaryTree(in, pre, is, inIndex-1);
    // Build the right half
    root.right = constructBinaryTree(in, pre, inIndex+1, ie);

    return root;
  } 
  
  public static void main(String[] args) {
    int in[] = {20,10,40,30,50};
    int pre[] = {10,20,30,40,50}; 

    // Since we are construting a preorder tree we don't need start/end index
    Node root = constructBinaryTree(in, pre, 0, in.length-1);
    // Op: 20 10 40 30 50 
    BinaryTreeTraversal.inorderTraversal(root);
  }
}
