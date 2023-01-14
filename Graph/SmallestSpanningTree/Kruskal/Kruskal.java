package Graph.SmallestSpanningTree.Kruskal;

import Graph.GraphGen.AdjacencyMatrix;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    AdjacencyMatrix graph;

    Kruskal() throws FileNotFoundException {
        //adjacency matrix + undirected
        System.out.println("=== kruskal - smallest spanning tree ===");
        graph = new AdjacencyMatrix("src/Graph/SmallestSpanningTree/input",true);
    }


    //way 1: sort all edge
    // -> take first n-1 edge that connect n nodes
    void getTree1(){
        //get list of edge
        Edge[] edgeList = new Edge[graph.e];
        int edgeIdx = 0;

        for (int i = 0 ; i < graph.n; i++){
            for (int j = i+1; j < graph.n; j++){
                if (graph.graphStore[i][j] != 0){
                    edgeList[edgeIdx] = new Edge(i,j,graph.graphStore[i][j]);
                    edgeIdx++;
                }
            }
        }

        //sort
        Arrays.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if (e1.weight > e2.weight) return 1;
                if (e1.weight == e2.weight) return 0;
                return -1;
            }
        });

        //filter first n-1 edge that connect all
        boolean visit[] = new boolean[graph.n];
        int remainingNode = graph.n,
            treeLength = 0;

        for (Edge e : edgeList){
            if (!visit[e.n1] || !visit[e.n2]){
                treeLength += e.weight;

                if (!visit[e.n1]){
                    remainingNode--;
                    visit[e.n1] = true;
                }

                if (!visit[e.n2]){
                    remainingNode--;
                    visit[e.n2] = true;
                }
            }

            if (remainingNode == 0) break;
        }

        System.out.println("tree length = " + treeLength);
    }


    class Edge{
        int n1, n2, weight;
        Edge(int a, int b, int c){
            n1 = a; n2 = b; weight = c;
        }


        void printAll(){
            System.out.println(n1 + " " + n2 + " " + weight);
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        Kruskal ex = new Kruskal();
        ex.getTree1();
    }
}
