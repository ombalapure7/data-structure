package DSA.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsDisconnected {

  // NOTE: No source given and graphs may be disconnected

  /*
   * Time Complexity: O(V + E) 
   * Space Complexity: O(V)
   */
  public static void bfsDisconnected(ArrayList<ArrayList<Integer>> adjList, int V) {
    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        bfsTraversal(adjList, i, visited);
      }
    }
  }

  /* Helper function to print the disconnected vertices */
  public static void bfsTraversal(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    visited[source] = true;
    q.add(source);

    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.print(u + " ");

      for (int v : adj.get(u)) {
        if (visited[v] == false) {
          visited[v] = true;
          q.add(v);
        }
      }
    }
  }

  /*
   * Time Complexity: O(V + E) 
   * Space Complexity: O(V)
   */
  public static int noOfIslands(ArrayList<ArrayList<Integer>> adjList, int V) {
    int count = 0;
    boolean visited[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        bfsTraversal(adjList, i, visited);
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    // Creating array of arraylist causes errors/warnings
    int V = 7;

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
    for (int i = 0; i < V; i++) {
      // Each index will contain an ArrayList
      adjList.add(new ArrayList<>());
    }

    Graph.addEdge(adjList,0,1); 
    Graph.addEdge(adjList,0,2); 
    Graph.addEdge(adjList,2,3); 
    Graph.addEdge(adjList,1,3); 
    Graph.addEdge(adjList,4,5);
    Graph.addEdge(adjList,5,6);
    Graph.addEdge(adjList,4,6);

    // Bfs for disconnected graph
    bfsDisconnected(adjList, V);
    System.out.println();

    // No. of connected islands
    System.out.println(" | No. of islands: " + noOfIslands(adjList, V));
  }
}
