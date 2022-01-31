package DSA.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBst {

  /**
   * Time Complexity: O(w) 
   * Space Complexity: O(hd) + Q(w)
   * 
   * Approach:
   * - Label the nodes in the same vertical levels with same value
   * - Place the nodes with their levels in the map, with level as the key and node value as value
   * - Check if the level is present in the map 
   *    - If yes then enter the [key,value] pair
   *    - Else do nothing (This makes sure we have only the top view nodes)
   */
  public static void verticalTraversal(Node root) {
    // Integer - vertical level 
    // ArrayList - nodes in same level
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Queue<TopViewPair> q = new LinkedList<>();
    q.add(new TopViewPair(root, 0));

    while (!q.isEmpty()) {
      // Remove first element from the queue
      TopViewPair p = q.poll();

      // Get node and hd of the current node
      Node curr = p.node;
      int hd = p.hd;

      if (!map.containsKey(hd)) {
        map.put(hd, curr.key); 
      } 

      if (curr.left != null) {
        q.add(new TopViewPair(curr.left, hd-1));
      }

      if (curr.right != null) {
        q.add(new TopViewPair(curr.right, hd+1));
      }
    }
 
    System.out.println(map);
  }

  public static void main(String[] args) {
    Node root = new Node(10);  
    root.left = new Node(20);  
    root.right = new Node(30);  
    root.left.left = new Node(40);
    root.left.right = new Node(50);

    verticalTraversal(root);
  }
}

// Wrap the node and its vertical level together
class TopViewPair {
  Node node;
  int hd;

  TopViewPair(Node n, int h) {
    node = n;
    hd = h;
  }
}