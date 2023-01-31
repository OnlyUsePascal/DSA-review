package Graph.ShortestPath.Floyd;

import Graph.GraphGen.AdjacencyMatrix;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Floyd {
    AdjacencyMatrix graph;

    Floyd() throws FileNotFoundException {
        System.out.println("=== floyd - shortest path ===");
        graph = new AdjacencyMatrix("src/Graph/ShortestPath/input",true);
    }


    int getPlus(int a, int b){
        //handling overflow
        return ((long) a + b > (long) Integer.MAX_VALUE) ?
                Integer.MAX_VALUE : a + b;
    }


    //O(N^3)
    void findPath(){
        //for each intermediate node k
            //for each couple node i, j
                //dis[i -> j] = min(dis[i -> j], dis[i -> k] + dis[k -> j])

        //init distance
        int[][] dis = new int[graph.n][graph.n];
        for (int i = 0 ; i < graph.n; i++){
            for (int j = 0 ; j < graph.n; j++){
                if (i != j){
                    dis[i][j] = (graph.graphStore[i][j] == 0) ?
                                Integer.MAX_VALUE : graph.graphStore[i][j];
                }
            }
        }

        //floyd
        for (int k = 0; k < graph.n; k++){
//            System.out.println("intermediate - " + k);
            for (int i = 0; i < graph.n; i++){
                for (int j = i; j < graph.n; j++){
//                    System.out.println("node " + i + " -> " + k + " -> " + j);
                    int undirectW = getPlus(dis[i][k], dis[k][j]);
//                    System.out.println(dis[i][j] + " " + undirectW);
                    dis[i][j] = Math.min(dis[i][j], undirectW);
                    dis[j][i] = dis[i][j];
                }
            }
        }

        System.out.println("result");
        for (int[] a : dis) System.out.println(Arrays.toString(a));

    }


    public static void main(String[] args) throws FileNotFoundException {
        Floyd ex = new Floyd();
        ex.findPath();
    }
}
