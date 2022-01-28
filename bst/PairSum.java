package DSA.bst;

import java.util.HashSet;

public class PairSum {
  
  /**
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * Approach:
   * - Do inorder traversal and store the result in an array
   * - Use 2 pointer approach to find the pari sum 
   * NOTE: Inorder traversal of a BST is always SORTED
   * 
   * O(n) for inroder traversal and O(n) to find pair sum
   * O(n) for function calls
   */
 
  /**
   * Time Complexity: O(n) 
   * Space Complexity: O(h) + O(n) =~ O(n)
   * 
   * Approach: 
   * - Do inorder traversal and check is sum - root.key is present in the hashset
   * - If sum - root.key is not present then insert the root.key to hash set 
   * - Else return the result as TRUE 
   * 
   * This approach can be used in Binary Trees as well, as it does not require a sorted inorder traversal
   */
  public static boolean hasPairSumHash(Node root, int sum, HashSet<Integer> set) {
    System.out.println(set);
    if (root == null) {
      return false;
    }

    // Finding sum in the left subtree
    if (hasPairSumHash(root.left, sum, set) == true) {
      return true;
    }

    if (set.contains(sum - root.key)) {
      return true;
    } else {
      set.add(root.key);
    }

    // Finding sum in the right subtree
    // We will reach this step if we don't find sum in the left subtree
    return hasPairSumHash(root.right, sum, set);
  }

  public static void main(String[] args) {
    Node root = new Node(10);   
    root.left = new Node(8);    
    root.right = new Node(20);  
    root.left.left = new Node(4);
    root.left.right = new Node(9);
    root.right.left = new Node(11);
    root.right.right = new Node(30);  
    root.right.right.left = new Node(25);

    HashSet<Integer> set = new HashSet<>();
    System.out.print("Has pair sum: " + hasPairSumHash(root, 33, set));
  }
}
