package DSA.bst;

public class FloorCeiling {
  // Closest smaller or equal value

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(1)
   */
  public static Node floorInBst(Node root, int x) {
    Node res = null;

    while (root != null) {
      if (root.key == x) {
        return root;
      } else if (root.key > x) {
        root = root.left;
      } else {
        res = root;
        root = root.right;
      }
    }

    return res;
  }

  // Closest greater or equal value

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(1)
   */
  public static Node ceilingInBst(Node root, int x) {
    Node res = null;
 
    while (root != null) {
      if (root.key == x) {
        return root;
      } else if (root.key < x) {
        root = root.right;
      } else {
        res = root;
        root = root.left;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Node root = new Node(15);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.right = new Node(20);
    root.right.left = new Node(18);
    root.right.left.left = new Node(16);
    root.right.right = new Node(80);

    System.out.println("Floor value in this BST: " + (floorInBst(root, 17).key));
    System.out.println("Ceiling value in this BST: " + (ceilingInBst(root, 17).key));
  }
}
