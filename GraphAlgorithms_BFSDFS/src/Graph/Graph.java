package Graph;

import Core.*;
import java.util.HashMap;

public class Graph {
   private final int MAX_VERTS = 20;
   public final int MAX_EDGE=30;
   private Vertex vertexList[];  
   private Edge edgeList[];
   private int adjMat[][];
   private int nVerts;
   private int nEdge;
   private Queue queue;
   private Stack[] list;
   private boolean isDirected;
   private int time;
   HashMap < String,Integer > mymap=new HashMap < String, Integer >();
  
   public Graph(boolean isDir){ 
      vertexList = new Vertex[MAX_VERTS];
      edgeList=new Edge[MAX_EDGE];
      adjMat = new int[MAX_VERTS][MAX_VERTS];
   //   weightedMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      nEdge=0;//
      list=new Stack[MAX_VERTS];
      for(int j=0; j<MAX_VERTS; j++) {
         for(int k=0; k<MAX_VERTS; k++){
            adjMat[j][k] = 0;
     //       weightedMat[j][k]=0;
         }
         list[j]=new Stack();
      }
      queue=new Queue();
      isDirected=isDir;
   }
   
   public void addVertex(String lab){

        vertexList[nVerts] = new Vertex(lab);
        if(mymap.put(lab, nVerts++)==null) ;    
   }
   
   public void addEdge(String start, String end, int w){
       edgeList[nEdge]=new Edge(start, end, w);
       nEdge++;
       if(isDirected)
       {
           adjMat[mymap.get(start)][mymap.get(end)]=w;
           list[mymap.get(start)].push(mymap.get(end));
       }

       else
       {
           adjMat[mymap.get(start)][mymap.get(end)]=w;
           adjMat[mymap.get(end)][mymap.get(start)]=w;
           list[mymap.get(start)].push(mymap.get(end));
           list[mymap.get(end)].push(mymap.get(start));
       }

   }

   public String isInfinite(int v){
       if(v>=999) return "INF";
       else return String.valueOf(v);
     }

   public void addWeightedEdge(String start, String end, int w){
     
       int startx=mymap.get(start);
       int endx=mymap.get(end);
      //weightedMat[startx][endx] = w;
      adjMat[startx][endx]=w;    
   }

   public void addEdge(String start, String end){   
       int startx=mymap.get(start);
       int endx=mymap.get(end);
      adjMat[startx][endx] = 1;
      if(isDirected==false)
      adjMat[endx][startx] = 1;
      list[startx].push(endx);
        if(isDirected==false)
      list[endx].push(startx);
   }
   
   public void displayVertex(int v){
      System.out.println(vertexList[v].label+" Parent : "+ vertexList[v].parent);
   }
   
   public void displayAdjMat(){
       System.out.println("Adjacent Matrix:");
       for(int j=0;j<nVerts;j++)
       {
           for(int k=0;k<nVerts;k++)
           {
               System.out.print(adjMat[j][k]+" ");
           }
           System.out.println();
       }
   }
   
   public void displayAdjList(){
   for(int j=0;j<nVerts;j++){
        System.out.print(j);
        for(int k=0;k<=list[j].gettop();k++){
               System.out.print(" -> "+list[j].get(k));
           }
           System.out.println();
       }
   }
   
   public void displayVertex(){
       for(int v=0;v<nVerts;v++){
                System.out.println(vertexList[v].label+" --> Parent : "+ vertexList[v].parent+
              " --> Color: " +vertexList[v].color+" --> dist:---->"+ vertexList[v].dist);
       }
       System.out.println();
       System.out.println();
   }
   
   public void bfs(){
      vertexList[0].dist=0;
      vertexList[0].color="GRAY";
      queue.insert(0);
      while(!(queue.isEmpty())){
            int vert=(Integer)queue.remove();
            
            displayVertex();
            
            for(int i=0;i<=list[vert].gettop();i++){
                int v2=list[vert].get(i);
                if((vertexList[v2].color).equals("WHITE")){
                    vertexList[v2].color="GRAY";
                    vertexList[v2].dist=vertexList[vert].dist+1;
                    vertexList[v2].parent=vertexList[vert].label;
                    queue.insert(v2);
                }
            }
            vertexList[vert].color="BLACK";
      } 
      displayVertex();
   }
   
   public void dfs(){
       time=0;
       for(int j=0;j<nVerts;j++)
       {
          //displayDFSTime();
           if((vertexList[j].color).equals("WHITE"))
           {
               displayDFSTime();
               dfsVisit(j);
           }
       }
   }
   public void dfsVisit(int verts){
     // displayDFSTime();
       time=time+1;
       vertexList[verts].inTime=time;
       vertexList[verts].color="GRAY";
       displayDFSTime();
       for(int i=0;i<=list[verts].gettop();i++){
           int v2=list[verts].get(i);

           if((vertexList[v2].color).equals("WHITE")){
               vertexList[v2].parent=vertexList[verts].label;
             //  displayDFSTime();
               dfsVisit(v2);

           }
       }
       vertexList[verts].color="BLACK";
       time=time+1;
       vertexList[verts].fTime=time;
       displayDFSTime();
   }
   public void displayDFSTime()
   {
       for(int j=0;j<nVerts;j++){
            System.out.println(vertexList[j].label+"->"+vertexList[j].color+"->"+vertexList[j].parent+"->"+
                    vertexList[j].inTime+"->"+vertexList[j].fTime);
       }
       System.out.println();
       System.out.println();
   }
 }