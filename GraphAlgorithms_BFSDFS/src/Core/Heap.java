
package Core;

import Graph.Vertex;
import Graph.Edge;


public class Heap {

    private Edge[] a;
    private int heapSize;
    private Vertex[] v;
    public Heap(){}
    public Heap(int i,Edge b[])
    {
        
        heapSize=i;
        a=new Edge[i+1];
        System.arraycopy(b,0,a,1,heapSize);
        
    }
    public Heap(int i,Vertex[] b)
    {
         heapSize=i;
        v=new Vertex[i+1];
        System.arraycopy(b,0,v,1,heapSize);
    }
   public Edge[] getEdges()
   {
       return a;
   }
    public int parent(int i)
    {
        return  (int)i/2;
    }
    public int left(int i)
    {
        return 2*i;
    }
    public int right(int i)
    {
        return (2*i)+1;
    }

    

     public void minHeapify(int i)
    {

        int l,r;
        int smallest;
        l=left(i);
        r=right(i);

        if(l<=heapSize)
        {
            if(a[l].getWeight()<a[i].getWeight()){
                        smallest=l;
            }else smallest=i;
        }
        else
        {
            smallest=i;
        }

        if(r<=heapSize)
        {
            if(a[r].getWeight()<a[smallest].getWeight()){
                smallest=r;
            }
        }
        if(smallest!=i)
        {
            Edge temp;
            temp=a[i];
            a[i]=a[smallest];
            a[smallest]=temp;
            minHeapify(smallest);
        }



    }
 public void minVHeapify(int i)
    {

        int l,r;
        int smallest;
        l=left(i);
        r=right(i);

        if(l<=heapSize)
        {
            if(v[l].getWeight()<v[i].getWeight()){
                        smallest=l;
            }else smallest=i;
        }
        else
        {
            smallest=i;
        }

        if(r<=heapSize)
        {
            if(v[r].getWeight()<v[smallest].getWeight()){
                smallest=r;
            }
        }
        if(smallest!=i)
        {
            Vertex temp;
            temp=v[i];
            v[i]=v[smallest];
            v[smallest]=temp;
            minVHeapify(smallest);
        }



    }
     public void maxHeapify(int i)
    {

        int l,r;
        int smallest;
        l=left(i);
        r=right(i);

        if(l<=heapSize)
        {
            if(a[l].getWeight()>a[i].getWeight()){
                        smallest=l;
            }else smallest=i;
        }
        else
        {
            smallest=i;
        }

        if(r<=heapSize)
        {
            if(a[r].getWeight()>a[smallest].getWeight()){
                smallest=r;
            }
        }
        if(smallest!=i)
        {
            Edge temp;
            temp=a[i];
            a[i]=a[smallest];
            a[smallest]=temp;
            maxHeapify(smallest);
        }



    }
    public void buildMinHeap()
    {
        
        for(int j=(a.length)/2;j>=1;j--)
        {
            minHeapify(j);
        }

    }

    public void buildVMinHeap()
    {

        for(int j=(v.length)/2;j>=1;j--)
        {
            minVHeapify(j);
        }

    }

    public void heapSort()
    {
        for(int j=a.length-1;j>=2;j--)
        { 
            Edge temp;
            temp=a[1];
            a[1]=a[j];
            a[j]=temp;
            heapSize=heapSize-1;
            minHeapify(1);
        }
    }

    public int heapMinimum(int a[])
    {
        return a[1];
    }

    public boolean  isEmpty()
    {
        if(heapSize<1)
            return false;
        else
            return true;
    }

    public boolean isInQueue(String vLabel)
    {
        for(int i=1;i<=heapSize;i++)
        {
            if(v[i].label.equals(vLabel))
                return true;
        }
        return false;
    }
    public Vertex heapVExtractMin()
    {
        if(heapSize<1)
            System.out.println("Heap Underflow");
        Vertex min=v[1];
        v[1]=v[heapSize];
        heapSize=heapSize-1;
        minVHeapify(1);
        return min;
    }

    public void heapIncreaseKey(int a[],int i, int key)
    {
        if(key<a[i])
            System.out.println("New key is smaller than current key.");
        a[i]=key;
        while((i>1)&&(a[parent(i)]<a[i]))
        {
            int temp;
            temp=a[i];
            a[i]=a[parent(i)];
            a[parent(i)]=temp;
            i=parent(i);
        }
    }

    public void minHeapInsert(int a[],int key)
    {
        heapSize=heapSize+1;
        a[heapSize]=-9999;
        heapIncreaseKey(a, heapSize, key);
    }
    public void displayHeap(int heapLength)
    {
        for(int k=1;k<=heapLength;k++)
        {
            System.out.println(a[k].stNode+"-"+a[k].endNode+"-"+a[k].edWeight);
        }

    }

    
}


