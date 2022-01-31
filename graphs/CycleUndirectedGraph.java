package DSA.graphs;

import java.util.ArrayList;

public class CycleUndirectedGraph {
  // O(V+E)
  // We need to maintain additional variable to keep track of the parent
  // If we dont do that then there will be cycle in (undirected) graph even with 2 nodes
  // A vertex is not visited and is not parent then there is a cycle
  public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
    boolean visisted[] = new boolean[V];
    
    for (int i=0; i<V; i++) {
      if (visisted[i] == false) {
        if (dfsTraversalHelper(adj, i, visisted, -1) == true) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean dfsTraversalHelper(ArrayList<ArrayList<Integer>> adj, 
      int s, boolean[] visisted, int parent) {
    visisted[s] = true;

    // Get adjacency list for every vertex
    for (int u : adj.get(s)) {
      if (visisted[u] == false) {
        if (dfsTraversalHelper(adj, u, visisted, parent) == true) {
          return true;
        } 
      } else if (u != parent) {
        return true;
      }
    }

    return false;
  }
 
  public static void main(String[] args) {
    int V = 6; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>()); 
    }

    Graph.addEdge(adj,0,1); 
    Graph.addEdge(adj,1,2); 
    Graph.addEdge(adj,2,4); 
    Graph.addEdge(adj,4,5); 
    Graph.addEdge(adj,1,3);
    Graph.addEdge(adj,2,3);

    System.out.println("Does graph contain a cycle: " + hasCycle(adj, V));
  }
}
