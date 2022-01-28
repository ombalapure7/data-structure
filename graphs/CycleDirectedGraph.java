package DSA.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDirectedGraph {
  // If there is an edge from a descendant to one of the ancestors, there is a cycle
  // Such an edge is called Back Edge
  // To find such an edge we maintain an array to keep track of the recursion call stack
  // If there is an edge from 0 -> 1. 1 has no adjacents in that case we can mark index 1 as FALSE 
  //  as the recursion call stack for it has finished

  /**
   * Time Complexity: O(h) 
   * Space Complexity: O(1)
   * 
   * Kahn's algorithm for Topological sort can be used to detect cycle in a Directed graph
   *  count == V i.e. we have processed all the vertices then there is no cycle
   */
  public static boolean topologicalSortBfs(ArrayList<ArrayList<Integer>> adj, int V) {
    int inDegree[] = new int[V];
    for (int u=0; u<V; u++) {
      for (int v : adj.get(u)) {
        inDegree[v]++;
      }      
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i=0; i<V; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    // We increment count when a vertex is removed/processed from the queue
    // If all the vertices are processed that means there is no cycle
    int count = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      // System.out.print(u + " ");

      for (int v : adj.get(u)) {
        if (--inDegree[v] == 0) {
          q.add(v);
        }
      }

      count++;
    }

    // NOTE: There will be a point when the queue will be empty
    // i.e. there won't be any vertex with Incoming edge value as 0 at certain point
    // this is when we come to know that there is a cycle in the graph

    // If count < V or count != V  
    return count != V;
  }

  /* Create adjacency lists for every vertex in a graph */
  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
  }

  public static void main(String[] args) {
    int V = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    addEdge(adj,0, 1); 
    addEdge(adj,4, 1); 
    addEdge(adj,1, 2); 
    addEdge(adj,2, 3); 
    addEdge(adj,3, 1);  

    // Kahn's algorithm to detect cycle
    System.out.println("Is there a cycle in this graph: " + topologicalSortBfs(adj, V));
  }
}
