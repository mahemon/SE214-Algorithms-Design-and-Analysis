package Controller; 

import BFSDFS.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       System.out.println("Enter 1 to run BFS on a undirected graph");
        System.out.println("Enter 2 to run DFS on a directed graph");
       
        System.out.println();
        System.out.print("Enter your choice (1-2) :");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        switch (choice) {
            case 1:
                BFS objBFS=new BFS();
                objBFS.readGraph();
                objBFS.doBFS();
                break;
            case 2:
                DFS objDFS=new DFS();
                objDFS.readGraph();
                objDFS.doDFS();
                break;
            default:
                break;
        }
       
    }
}
