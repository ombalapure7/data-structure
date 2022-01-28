package DSA.graphs;

import java.util.ArrayList;

public class DfsDisconnected {
  
  static int count = 0;

  // Similar to preorder traversal. DFS is recursive in nature. 
  // Pick a source, pick an adjacent and then call DFS recursively for that adjacent 
  //  and print all the vertices that are reachable from that adjacent
  // We can pick any adjacent value to start from 

  /*
   * Time Complexity: O(V + E) 
   * Space Complexity: O(V)
   * 
   * O(V + 2E) =~ O(V + E)
   * V work needs to be done incase the graph is disconnected
   * 2E work is done because the graph is undirected 
   */
  public static int dfsTraversalDisconnected(ArrayList<ArrayList<Integer>> adjList, int V, int source) {
    int count = 0;
    boolean visited[] = new boolean[V];

    for (int i=0; i<V; i++) {
      if (visited[i] == false) {
        dfsTraversaHelper(adjList, i, visited);
        count++;
      }
    }

    return count;
  }

  public static void dfsTraversaHelper(ArrayList<ArrayList<Integer>> adjList, int source, boolean visited[]) {
    visited[source] = true;
    System.out.print(source + " ");

    // Get the adjacent elements of the current source
    for (int u : adjList.get(source)) {
      // Check whether each of the source adjacent element was visited 
      if (visited[u] == false) {
        // If the adjacent element was not visited then make a recursive call
        // Pass that adjacent element and set that element as visited 
        dfsTraversaHelper(adjList, u, visited);
        count++;
      }
    }
  }

  public static void main(String[] args) {
    int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Integer>()); 
    }

    Graph.addEdge(adj,0,1); 
    Graph.addEdge(adj,0,2); 
    Graph.addEdge(adj,1,2);
    Graph.addEdge(adj,3,4);

    System.out.println("No of components: " + dfsTraversalDisconnected(adj, V, 0));
  }
}
