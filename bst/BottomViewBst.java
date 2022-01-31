package DSA.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBst {

  /**
   * Time Complexity: O(w) 
   * Space Complexity: O(hd) + Q(w)
   * 
   * Approach:
   * - Label the nodes in the same vertical levels with same value
   * - Place the nodes with their levels in the map, with level as the key and node value as value
   * - Check if the level is present in the map 
   *    - If yes then enter the [key,value] pair
   *    - Else update the value (This makes sure we print the bottom view nodes)
   */
  public static void verticalTraversal(Node root) {
    // Integer - vertical level 
    // ArrayList - nodes in same level
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Queue<BottomViewPair> q = new LinkedList<>();
    q.add(new BottomViewPair(root, 0));

    while (!q.isEmpty()) {
      // Remove first element from the queue
      BottomViewPair p = q.poll();

      // Get node and hd of the current node
      Node curr = p.node;
      int hd = p.hd;
      
      map.put(hd, curr.key); 

      if (curr.left != null) {
        q.add(new BottomViewPair(curr.left, hd-1));
      }

      if (curr.right != null) {
        q.add(new BottomViewPair(curr.right, hd+1));
      }
    }
 
    System.out.println(map);
  }

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(25);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    verticalTraversal(root);
  }
}

// Wrap the node and its vertical level together
class BottomViewPair {
  Node node;
  int hd;

  BottomViewPair(Node n, int h) {
    node = n;
    hd = h;
  }
}