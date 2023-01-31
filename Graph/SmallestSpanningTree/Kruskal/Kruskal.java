package Graph.SmallestSpanningTree.Kruskal;

import Graph.GraphGen.AdjacencyMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
    Edge[] edgeList;
    boolean[] visit;
    Kruskal() throws FileNotFoundException {
        System.out.println("=== kruskal - smallest spanning tree ===");

        //just need to get edge list
        Scanner reader = new Scanner(new File("src/Graph/SmallestSpanningTree/input"));
        visit = new boolean[reader.nextInt()];
        edgeList = new Edge[reader.nextInt()];
        reader.nextLine();

        for (int i = 0 ; i < edgeList.length; i++){
            int[] numArr = Arrays.stream(reader.nextLine().split(" ")).
                            mapToInt(Integer::parseInt).toArray();

            edgeList[i] = new Edge(numArr[0], numArr[1], numArr[2]);
        }
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


    void getTree1(){
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
        int remainingNode = visit.length,
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






    public static void main(String[] args) throws FileNotFoundException {
        Kruskal ex = new Kruskal();
        ex.getTree1();
    }
}
