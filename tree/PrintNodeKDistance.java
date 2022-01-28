package DSA.tree;

public class PrintNodeKDistance {
  // For k=2, print the nodes at level k+1 (we exclude the root while counting)

  /*
   * Time Complexity: O(n) - Constant work for n nodes 
   * Space Complexity: O(h) - At a time there will be either left or right node
   */
  public static void printNodesAtKDistance(Node root, int k) {
    if (root == null) {
      return;
    }

    if (k == 0) {
      System.out.print(root.key + " ");
    } else {
      printNodesAtKDistance(root.left, k - 1);
      printNodesAtKDistance(root.right, k - 1);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.right.right = new Node(70);
    root.right.right.right = new Node(80);

    printNodesAtKDistance(root, 2);
  }
}
