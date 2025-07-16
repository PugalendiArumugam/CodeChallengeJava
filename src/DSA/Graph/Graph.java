package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    ArrayList<Node> nodes;
    int[][] matrix;
    Graph(int size){
        matrix = new int[size][size];
        nodes = new ArrayList<>();
    }

     public void addNode(Node node){
        nodes.add(node);
     }

     public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
     }

     public boolean checkEdge(int src, int dest){
        if(matrix[src][dest] == 1){
            return true;
        } else {
            return false;
        }
     }

     public void print(){

        //print Node data
         System.out.print("  ");
        for (Node node: nodes){
            System.out.print(node.data+" ");
        }
         System.out.println();

         // print edges
        for(int i =0; i<matrix.length;i++){
            System.out.print(nodes.get(i).data+" ");
            for(int j =0; j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
     }

     public void breathFirstSearch(int src){
         Queue<Integer> queue = new LinkedList<>();
         boolean[] visited = new boolean[matrix.length];

         queue.offer(src);
         visited[src] = true;
         while (queue.size() != 0){
             src = queue.poll();
             System.out.println(nodes.get(src).data+" = visited");

             for (int i = 0; i<matrix[src].length;i++){
                 if(matrix[src][i] == 1 && !visited[i])
                 {
                    queue.offer(i);
                    visited[i] = true;
                 }
             }
         }
     }
}
