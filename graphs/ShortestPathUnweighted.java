package DSA.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {
  
  /*
   * Time Complexity: O(V + E)
   * Space Complexity: O(2E)
   * 
   * Here we pick a source and then print the distance from that source
   *  to every vertex
   * 
   * Approach:
   * - Use BFS as it covers distance with shortest path
   * - Edges which are closer are traversed first
   */
  public static void shortestDistanceUnweightedGraph(ArrayList<ArrayList<Integer>> adj,
      int V, int s, int[] dist) {
    boolean visited[] = new boolean[V];
    
    Queue<Integer> q = new LinkedList<>();
    // Mark source vertex as visited
    visited[s] = true; 
    q.add(s); 

    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj.get(u)) {
        if (visited[v] == false) {
          dist[v] = dist[u] + 1;
          visited[v] = true;
          q.add(v);
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 4; 
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);   
    
    // Create adjaceny list for every vertex
    for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>()); 
    }

    Graph.addEdge(adj,0,1); 
    Graph.addEdge(adj,1,2); 
    Graph.addEdge(adj,2,3); 
    Graph.addEdge(adj,0,2); 
    Graph.addEdge(adj,1,3);

    // Store the distances from source vertex
    int dist[] = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    // Distance from source to source is 0
    dist[0] = 0;

    // Op: [0, 1, 1, 2]
    shortestDistanceUnweightedGraph(adj, V, 0, dist);
    System.out.println(Arrays.toString(dist));
  }
}
