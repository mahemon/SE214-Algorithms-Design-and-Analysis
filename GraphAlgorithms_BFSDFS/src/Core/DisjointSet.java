
package Core;


public class DisjointSet {
    private int[]  parent;
    private int[]  rank;
    private int nVerts;
    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
    }

    public int[] getRank() {
        return rank;
    }

    public void setRank(int[] rank) {
        this.rank = rank;
    }

    public DisjointSet() {
    }
    public DisjointSet(int nVerts) {
        parent=new int[nVerts];
        rank=new int[nVerts];
        this.nVerts=nVerts;
    }
    public void makeSet(){
        for(int i=0;i<nVerts;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int findSet(int vert){
        if(vert!=parent[vert]){
            vert=findSet(parent[vert]);
        }
        return vert;
    }
    public void setLink(int vertx, int verty){
        if(rank[vertx]>rank[verty]){
            parent[verty]=vertx;
        }
        else {
            parent[vertx]=verty;
            if(rank[vertx]==rank[verty]){
                rank[verty]=rank[verty]+1;
            }
        }
    }
    public void setUnion(int vertx,int verty){
        setLink(findSet(vertx),findSet(verty));
    }

    public void displaySet()
    {
        for(int i=0;i<nVerts;i++)
        {
            System.out.println("Parent "+i+" = "+parent[i]+" Rank "+i+" = "+rank[i]);
        }
    }
}
