package algo.graph.GraphGen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdjacencyList {
    public class Node{
        public int vertex;
        int weight;
        public Node next;

        Node(int v, int w){
            vertex = v;
            weight = w;
            next = null;
        }


        void printALll(){
            System.out.println(vertex + " " + weight);
        }
    }

    public Node[] graphStore;


    public AdjacencyList(boolean undirected) throws FileNotFoundException{
        System.out.println("=== Adjacency List ===");

        //input maze
        File file = new File("src/algo/graph/GraphGen/GraphInput.txt");
        Scanner reader = new Scanner(file);
        graphStore = new Node[reader.nextInt()];

        //reading edges
        int edges = reader.nextInt();
        reader.nextLine();
        for (int i = 0 ; i < edges; i++){
            //invert string to number
            String[] strArr = reader.nextLine().split(" ");
            int[] intArr = new int[3];
            for (int j = 0 ; j < 3; j++){
                intArr[j] = Integer.parseInt(strArr[j]);
            }

            //add node to list from input
            Node node = new Node(intArr[1], intArr[2]);
            int idx = intArr[0];
            node.next = graphStore[idx];
            graphStore[idx] = node;

            //add each other
            if (undirected){
                node = new Node(intArr[0], intArr[2]);
                idx = intArr[1];
                node.next = graphStore[idx];
                graphStore[idx] = node;
            }
        }
    }


    void debugNode(int idx){
        System.out.println("=== Debug node === " + idx);
        Node node = graphStore[idx];
        while (node != null){
            node.printALll();
            node = node.next;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        AdjacencyList ex = new AdjacencyList(true);
        ex.debugNode(2);

    }
}
