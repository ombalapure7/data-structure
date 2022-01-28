package DSA.tree;

public class TreeToDLL {

  static Node prev = null;

  // We should follow inorder traversal to convert a tree to a doubly linked list
  // We can use left and right pointer as prev and next pointers instead of creating new ones
  
  /*
   * Time Complexity: O(n) - constant work for every node 
   * Space Complexity: O(h) - inorder traversal is done
   */
  public static Node binaryTreeToDll(Node root) {
    // Return the left most node
    if (root == null) {
      return root;
    }

    Node head = binaryTreeToDll(root.left);
    // The very first node of a tree will be considered as HEAD
    // This IF condition executes only once
    if (prev == null) {
      head = root;
    } else {
      // left -> backward link
      // right -> forward link
      
      // In 1st iteration setting backward link
      root.left = prev;
      // In 1st iteration setting forward link
      prev.right = root;
    }

    // prev will keep track of the previously visited node to create links
    prev = root;
    binaryTreeToDll(root.right);
    return head;
  }
 
  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(5);
    root.right = new Node(20);
    root.right.left = new Node(30);
    root.right.right = new Node(35);

    Node dllHead = binaryTreeToDll(root);
    Node temp = dllHead;

    if (dllHead == null) {
      System.out.println("Nothing to print!");
    } else {
      while (temp != null) {
        System.out.print(temp.key + " ");
        temp = temp.right;
      }
    }
  }
}
