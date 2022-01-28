package DSA.bst;

import java.util.TreeMap;

public class VerticalSum {
  /**
   * Time Complexity: O(n * log(hd) + hd)
   * Space Complexity: O(h)
   * 
   * Total hd are -3 to 2 there are 6 possible horizontal distances
   * For n nodes we are doing log(hd) work and another hd work to print the map
   */
  public static void verticalSum(Node root) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    verticalSumRec(root, 0, map);

    System.out.println("Map: " + map);
  }

  /* Helper function to find the vertical sum */
  public static void verticalSumRec(Node root, int hd, TreeMap<Integer, Integer> map) {
    // Nodes in the same vertical level will have the same value
    /* 
              10(0)
             /     \ 
          20(-1)   50(+1)
        /      \
      30(-2)  40(0) 
    */

    if (root == null) {
      return;
    }

    // Left node values will be in -ve
    verticalSumRec(root.left, hd-1, map);
    
    // Doing inorder traversal in this
    // Any traversal will work as long as the hd is passed correctly
    int sum = (map.get(hd) == null ? 0 : map.get(hd));
    map.put(hd, sum + root.key);
    
    // Left node values will be in +ve
    verticalSumRec(root.right, hd+1, map);
  }

  public static void main(String[] args) {
    Node root = new Node(10);  
    root.left = new Node(20);  
    root.right = new Node(50);  
    root.left.left = new Node(30);
    root.left.right = new Node(40);    

    verticalSum(root);
  }
}
