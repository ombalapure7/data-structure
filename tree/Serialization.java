package DSA.tree;

import java.util.ArrayList;

public class Serialization {

  // A naive approach will be to find the inroder and pre/post order of the tree
  // Store both the result i.e. preorder traversal in an array

  // For n nodes there will be n+1 EMPTY values
  static final int EMPTY = -1;
  static int index = 0;

  /**
   * Time Complexity: O(n) - traverse every node
   * Spcae Complexity: O(n) - 2n+1 entries in the array
   */
  public static void serialize(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      arr.add(EMPTY);
      return;
    }

    // We are following preorder traversal of the binary tree
    // Get root of the tree is easy in case of preorder traversal
    arr.add(root.key);
    serialize(root.left, arr);
    serialize(root.right, arr);
  }

  /**
   * Time Complexity: O(n) - traverse every array element
   * Spcae Complexity: O(n) - 2n+1 entries in the array
   */
  public static Node deserialize(ArrayList<Integer> arr) {
    if (index == arr.size()) {
      return null;
    }

    int val = arr.get(index);
    index++;

    if (val == EMPTY) {
      return null;
    }

    Node root = new Node(val);
    root.left = deserialize(arr);
    root.right = deserialize(arr);

    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);

    ArrayList<Integer> arr = new ArrayList<>();
    serialize(root, arr);

    for (int x : arr) {
      System.out.print(x + " ");
    }

    System.out.println();
    Node newRoot = deserialize(arr);
    BinaryTreeTraversal.inorderTraversal(newRoot);
  }
}
