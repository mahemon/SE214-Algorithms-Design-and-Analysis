package GraphAlgorithms_BFSDFS;
public class Main {
 
  public static void main(String args[]) {
    BFS g = new BFS();
    g.setValue(4); // number of vertex
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("\n Following is Breadth First Traversal " + "(starting from vertex 2)");
    g.doBFS(2);
   
    DFS dfs = new DFS();
    dfs.setValue(4);
    dfs.addEdge(0, 1);
    dfs.addEdge(0, 2);
    dfs.addEdge(1, 2);
    dfs.addEdge(2, 0);
    dfs.addEdge(2, 3);
    dfs.addEdge(3, 3);
    System.out.println("Following is Depth First Traversal (starting from vertex 2)");
    dfs.DFS(2);
  }
}

// bfs 2 0 3 1 
// dfs 2 0 1 3