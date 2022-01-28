package DSA.bst;

public class BstInsert {

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(h)
   * 
   * Insert is always done at last
   */
  public static Node insert(Node root, int x) {
    if (root == null) {
      return new Node(x);
    }

    if (root.key > x) {
      root.left = insert(root.left, x);
    } else if (root.key < x) {
      root.right = insert(root.right, x);
    }

    return root;
  }

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(1)
   * 
   * Even in insert searching is done, insert is a constant operation - creating + connecting the node
   */
  public static Node insertItr(Node root, int x) {
    Node temp = new Node(x);
    Node parent = null, curr = root;

    while (curr != null) {
      parent = curr;

      if (curr.key > x) {
        curr = curr.left;
      } else if (curr.key < x) {
        curr = curr.right;
      } else {
        return root;
      }
    }

    // If the tree is empty simply create a node and return it
    if (parent == null) {
      return temp;
    }

    if (parent.key > x) {
      parent.left = temp;
    } else {
      parent.right = temp;
    }

    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(5); 
    root.right = new Node(15);
    root.right.left = new Node(12);
    root.right.right = new Node(18);

    // Op: 5 10 12 15 18 20 
    // insert(root, 20);
    insertItr(root, 20);
    BstTraversal.inorderTraversal(root);
  }
}
