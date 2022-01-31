package DSA.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

  /**
   * Time Complexity: O(V+E)
   * Spcae Complexity: O(V)
   * 
   * Topological sort looks for Incoming edges for a vertex
   *  vertex that do not have (0 edges) an Incoming edge will be printed first
   * It is similar to a project with interelated dependencies, if the dependencies are met
   *  only then an entire project will be built i.e. the dependent jobs should be executed later 
   * 
   * NOTE: Topological sort does work if there is a cycle in a graph
   */
  public static void topologicalSortBfs(ArrayList<ArrayList<Integer>> adj, int V) {
    // Keeps track of the incoming edges, we have edges from 0 -> 2 and 0 -> 3 and 1 -> 3
    //       0   1
    //      / \ /  
    //     2   3   
    // We will increment value at index 2 and 3 by 1 once we go through the adjacents of vertex "0"
    // Again we increase value at index 3 when we go through adjacents of vertex "1"
    int inDegree[] = new int[V];
    for (int u=0; u<V; u++) {
      for (int v : adj.get(u)) {
        inDegree[v]++;
      }      
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i=0; i<V; i++) {
      // Add the vertex with 0 Incoming edges first
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.print(u + " ");
      // We take out 0 and reduce indegree values of 2 and 3 
      // Resultant indegree for 2 will be 0 and for 3 will be 1
      // Now we add the vertex with 0 indegree edges to queue i.e. "2"
      for (int v : adj.get(u)) {
        if (--inDegree[v] == 0) {
          // Once the incoming edges decrease to 0
          // Add that vertex to the queue 
          q.add(v);
        }
      }
    }
  }

  /* Create adjacency lists for every vertex in a graph */
  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
  }

  /**
   * Time Complexity: O(V+E)
   * Spcae Complexity: O(V)
   */
  public static void topologicalSortDfs(ArrayList<ArrayList<Integer>> adj, int V) {
    boolean visited[] = new boolean[V];
    
    Stack<Integer> st = new Stack<Integer>(); 
    for (int i=0; i<V; i++) {
      if (visited[i] == false) {
        dfsTraversalHelper(adj, i, st, visited);
      }
    }

    while (st.empty() == false) {
      System.out.print(st.pop() + " ");
    }
  }

  /* Does DFS Traversal of a graph */
  public static void dfsTraversalHelper(ArrayList<ArrayList<Integer>> adj, 
        int u,Stack<Integer> st, boolean visited[]) {
    visited[u] = true;
    
    for (int v : adj.get(u)) {
      if (visited[v] == false) {
        // Make recursive calls till "u" has adjacents
        // There will be a point when "u" wont have any adjacents
        dfsTraversalHelper(adj, v, st, visited);
      }
    }

    // As the control goes back to the caller
    // Start pushing vertices to the stack
    st.push(u);
  }

  public static void main(String[] args) {
    int V = 5;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<Integer>());
    }

    // addEdge(adj, 0, 2);
    // addEdge(adj, 0, 3);
    // addEdge(adj, 1, 3);
    // addEdge(adj, 1, 4);
    // addEdge(adj, 2, 3);
  
    // Bfs approach
    // Op: 0 1 2 4 3
    topologicalSortBfs(adj, V);

    System.out.println();

    addEdge(adj,0, 1); 
    addEdge(adj,1, 3); 
    addEdge(adj,2, 3); 
    addEdge(adj,3, 4); 
    addEdge(adj,2, 4); 

    // Dfs approach
    // Op: 2 0 1 3 4 
    topologicalSortDfs(adj, V);
  }
}
