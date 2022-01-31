package DSA.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

  /**
   * Applications: 
   * - Shortest path in unweighted graphs
   * - Crawlers in search engines
   * - Peer to peer network
   * - Social network search
   * - Garbage collection
   * - Cycle detection
   * - Broadcasting
   * - Ford Fulkerson algorithm
   */

  /*
   * Time Complexity: O(E) 
   * Sum of all the adj lists 
   * - Undirected graph: 2E 
   * - Undirected graph: E
   * 
   * Space Complexity: O(V) 
   * 
   * Eg: Consider facebook connections. You print yourself and your (immediate) connections, 
   *  then your mutual friends and so on
   * We have to print the node just once, so we maintain visited[] array to keep track of visisted vertex
   */
  public static void bfsTraversal(ArrayList<ArrayList<Integer>> adjList, int V, int source) {
    // No node is visited more than once
    boolean visited[] = new boolean[V+1];
    // Starting node is visited 
    visited[source] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);

    while(!queue.isEmpty()) {
      int u = queue.poll();
      System.out.print(u + " ");

      // adjList.get(u) - gets us an ArrayList at index v
      for (int v : adjList.get(u)) {
        // Vertex not visited add this to the queue
        if (visited[v] == false) {
          visited[v] = true;
          queue.add(v);
        }
      }
    }
  } 

  public static void main(String[] args) {
    // Creating array of arraylist causes errors/warnings
    int V = 5;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);
    for (int i=0; i<V; i++) {
      // Each index will contain an ArrayList 
      adjList.add(new ArrayList<>());
    }

    Graph.addEdge(adjList, 0, 1);
    Graph.addEdge(adjList, 0, 2);
    Graph.addEdge(adjList, 1, 2);
    Graph.addEdge(adjList, 2, 3);
    Graph.addEdge(adjList, 1, 3);
    Graph.addEdge(adjList, 3, 4);
    Graph.addEdge(adjList, 2, 4);
  
    bfsTraversal(adjList, V, 0);
  }
}
