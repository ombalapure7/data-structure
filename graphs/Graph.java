package DSA.graphs;

import java.util.ArrayList;

public class Graph {
  
  /**
   * Applications: 
   *  Facebook friend connections, web pages linked together (used by crawlers), connected city roads, router connections
   * 
   * Representation: 
   * Adjacency Matrix 
   *   => Space: O(V*V)
   *   => Check if u and v are adjacent: O(1)
   *   => Final all vertices adjacent to u: O(V)
   *   => Find degree of u: O(V)
   *   => Add/Remove edge: O(1) - Only have to change the matrix values
   *   => Add/Remove vertex: O(V) - Create a new bigger/smaller matrix and copy all the entries 
   *   => Issues: Store redundant info, as it also shows which vertices are NOT CONNECTED
   * 
   * Adjacency List
   *   => Can use dynamic size arrays or Linked lists
   *   => Space: O(V+E)
   *    --> Undirected: O(V+2*E)
   *    --> Directed: O(V+E)
   *   => Check an edge from u to v: O(V)
   *   => Find all adjacents to u: O(degree(u))
   *   => Find degree of u: O(1)
   *   => Add edge: O(1)
   *   => Remove edge: O(V)
   */

  /* Create adjacency list */
  public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
    // As the graph is undirected
    // u is connected to v and vice versa
    adjList.get(u).add(v);
    adjList.get(v).add(u);
  }

  /* Prints adjacency list */
  public static void printAdjList(ArrayList<ArrayList<Integer>> adjList) {
    for (int i=0; i<adjList.size(); i++) {
      for (int j=0; j<adjList.get(i).size(); j++) {
        System.out.print(adjList.get(i).get(j) + " ");
      }
      System.out.println();
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

    addEdge(adjList, 0, 1);
    addEdge(adjList, 0, 2);
    addEdge(adjList, 1, 2);
    addEdge(adjList, 1, 3);

    printAdjList(adjList);
  }
}

/**
 * NOTE: Degrees in a graph
 * 
 * Undirected graph: means number of vertices connected to a vertex
 * Directed graph: has edges coming/going out of a vertex i.e indegree/outdegree
 */

/**
 * Comparison: 
 * Most of the graph applications the graphs are sparse (where connectively is less) not dense
 * So we use adjacency list 
 * 
 * For sparse graphs: 
 * Undirected: 0 <= E <= V*(V-1)/2
 * Directed: 0 <= E <= V*(V-1)
 */  