package DSA.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {

  /**
   * Time Complexity: O(w) 
   * Space Complexity: O(hd) + Q(w)
   */
  public static void verticalTraversal(Node root) {
    // Integer - vertical level 
    // ArrayList - nodes in same level
    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root, 0));

    while (!q.isEmpty()) {
      // Remove first element from the queue
      Pair p = q.poll();

      // Get node and hd of the current node
      Node curr = p.node;
      int hd = p.hd;

      if (map.containsKey(hd)) {
        map.get(hd).add(curr.key); 
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(curr.key);
        map.put(hd, list);
      }

      if (curr.left != null) {
        q.add(new Pair(curr.left, hd-1));
      }

      if (curr.right != null) {
        q.add(new Pair(curr.right, hd+1));
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
class Pair {
  Node node;
  int hd;

  Pair(Node n, int h) {
    node = n;
    hd = h;
  }
}