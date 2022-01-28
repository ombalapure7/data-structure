package DSA.bst;

public class BstSearch {
  // Not cache friendly (LL, BT as well)
  // TreeSet and TreeMap implement Self Balancing Binary Search Tree

  /**
   * Time Complexity: O(h)
   * Space Complexity: O(h)
   * 
   * If the tree is skewed/not balanced, Comlpexity will be linear
   */
  public static boolean search(Node root, int x) {
    if (root == null) {
      return false;
    } else if (root.key == x) {
      // return true once element is found
      return true;
    } else if (root.key < x) {
      // search element on the right side
      return search(root.right, x);
    } else if (root.key > x) {
      // search element on the left side
      return search(root.left, x);
    }

    return false;
  }

  /**
   * Time Complexity: O(h)
   * Space Complexity: O(1)
   */
  public static boolean searchItr(Node root, int x) {
    while (root != null) {
      if (root.key == x) {
        // return true once element is found
        return true;
      } else if (root.key < x) {
        // search element on the right side
        root = root.right;
      } else if (root.key > x) {
        // search element on the left side
        root = root.left;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Node root = new Node(15);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.right = new Node(20);
    root.right.left = new Node(18);
    root.right.left.left = new Node(16);
    root.right.right = new Node(80);

    int x = 16;

    if (search(root, x)) {
      System.out.println("Found");
    }
    else {
      System.out.println("Not Found");
    }

    if (searchItr(root, x)) {
      System.out.println("Found");
    } else {
      System.out.println("Not Found");
    }
  }
}
