
package GraphAlgorithms_BFSDFS;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
  private int V;
  private LinkedList<Integer> adj[];
 // int arr[]= new int[5];

  // Create a graph
  void setValue(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList(); 
  }
  // adj[0] -> 
  // adj[1] -> 
  // adj[2] -> 
  // adj[3] -> 

  // Add edges to the graph
  void addEdge(int v, int u) {
    adj[v].add(u); // adj[0]-> [ 1, 2 ]
  }

  // BFS algorithm
  void doBFS(int s) { 
     String visited[] = new String[4];
      for (int i = 0; i < visited.length; i++) {
           visited[i]="WHITE";
      }
         //   visited[1]=false
                    //visited[2]=true
                            //visited[3]=false
    LinkedList<Integer> queue = new LinkedList();
   
    visited[2] = "BLACK";
    queue.add(s);  //  , 3 , 1

    while (queue.size() != 0) {
      s = queue.poll(); // 0
      System.out.print(s + " ");  // 2 0
      // adj[0] -> [ 1 , 2 ]
      Iterator<Integer> i = adj[s].listIterator();
      // i = [1],[2]
      while (i.hasNext()) {
        int n = i.next(); // 1
        if (visited[n].equals("WHITE")) {
            visited[n] = "BLACK";
            queue.add(n);
        }
      }
    }
  }

}
