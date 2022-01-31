package DSA.graphs;

import java.util.ArrayList;

public class Dfs {
  
  /**
   * Applications: 
   * - Cycle detection
   * - Topological Sort (Dused in dependency graphs - when there is a dependency among jobs and schedule jobs -- eg: MakeFile)
   * - Strongly connected components
   * - Solving maze and similar problems 
   * - Path finding: 
   *   --> Can be done using BFS as well but DFS is natural in printing the path, for eg: printing path from S -> D
   *   --> In BFS the queue may contain levels but we can't get a proper path
   */

  // Similar to preorder traversal. DFS is recursive in nature. 
  // Pick a source, pick an adjacent and then call recursively DFS for that adjacent 
  //  and print all the vertices that are reachable from that adjacent
  // We can pick any adjacent value 

  /*
   * Time Complexity: O(V + E) 
   * Space Complexity: O(V)
   */
  public static void dfsTraversal(ArrayList<ArrayList<Integer>> adjList, int V, int source) {
    boolean visited[] = new boolean[V];
    dfsTraversalHelper(adjList, source, visited);
  }

  public static void dfsTraversalHelper(ArrayList<ArrayList<Integer>> adjList, int source, boolean visited[]) {
    visited[source] = true;
    System.out.print(source + " ");

    // Get the adjacent elements of the current source
    for (int u : adjList.get(source)) {
      // Check whether each of the source adjacent element was visited 
      if (visited[u] == false) {
        // If the adjacent element was not visited then make a recursive call
        // Pass that adjacent element and set that element as visited 
        dfsTraversalHelper(adjList, u, visited);
      }
    }
  }

  public static void main(String[] args) {
    int V = 7; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Integer>()); 
    }

		Graph.addEdge(adj,0,1); 
    Graph.addEdge(adj,0,2); 
    Graph.addEdge(adj,2,3); 
    Graph.addEdge(adj,1,3); 
    Graph.addEdge(adj,1,4);
    Graph.addEdge(adj,3,4);

    dfsTraversal(adj, V, 0);
  }
}
