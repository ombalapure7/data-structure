package DSA.tree;

public class ChildrenSumProperty {
  
  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node 
   */
  public static boolean hasChildrenSumProperty(Node root) {
    if (root == null) {
      return true;
    }

    // This is condition is necessary to check 
    // In case a leaf node is encountered a false value will be returned
    if (root.left == null && root.left == null) {
      return true;
    }

    int sum = 0;
    if (root.left != null) {
      sum += root.left.key;
    }

    if (root.right != null) {
      sum += root.right.key;
    }

    return (root.key == sum) && (hasChildrenSumProperty(root.left) 
        && hasChildrenSumProperty(root.right));
  }

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(12);
    root.left.left = new Node(3);
    root.left.right = new Node(5);

    System.out.println("Has children sum property: " + hasChildrenSumProperty(root));
  }
}