package Graph.GraphGen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyList {
    static public class Node{
        public int vertex;
        public int weight;
        public Node next;

        protected Node(int v, int w){
            vertex = v;
            weight = w;
            next = null;
        }


        public void printAll(){
            System.out.println(vertex + " " + weight);
        }
    }

    public Node[] graphStore;
    public int n,e;

    public AdjacencyList(String src, boolean undirected) throws FileNotFoundException{
        System.out.println("=== Adjacency List ===");

        //input maze
        Scanner reader = new Scanner(new File(src));
        n  = reader.nextInt();
        graphStore = new Node[n];

        //reading edges
        e = reader.nextInt();
        reader.nextLine();
        for (int i = 0 ; i < e; i++){
            //invert string to number
            int[] intArr = Arrays.stream(reader.nextLine().split(" ")).
                            mapToInt(Integer::parseInt).toArray();

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


    public void printAll(){
        System.out.println("=== Debug node === ");
        for (int i = 0 ; i < graphStore.length; i++){
            Node node = graphStore[i];
            System.out.println(i + "--");
            while (node != null){
                node.printAll();
                node = node.next;
            }
        }
    }


    static public  void main(String[] args) throws FileNotFoundException {
        AdjacencyList ex = new AdjacencyList("src/graph/GraphGen/GraphInput.txt", true);
        ex.printAll();

    }
}
