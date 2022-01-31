package DSA.bst;

public class KthSmallest {

  static int count;

  /**
   * Time Complexity: O(h+k) 
   * Space Complexity: O(h)
   * 
   * Approach: 
   * - Smallest element is present on left side, so travel to the left most node
   * - Now the control will go to the right side, now increase the counter 
   * - Stop when the counter and k are equal 
   */
  public static void kthSmallest(Node root, int k) {
    if (root != null) {
      kthSmallest(root.left, k);
      count++;
      
      if (count == k) {
        System.out.print(root.key);
        // If we don't return from here the complexity will be O(n)
        return;
      }

      kthSmallest(root.right, k);
    }
  }

  public static void main(String[] args) {
    Node root = new Node(15);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.right = new Node(20);
    root.right.left = new Node(18);
    root.right.left.left = new Node(16);
    root.right.right = new Node(80);
    int k = 3;

    kthSmallest(root, k);
  }
}