package algo.graph.GraphGen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdjacencyList {
    class Node{
        int vertex;
        int weight;
        Node next;

        Node(int v, int w){
            vertex = v;
            weight = w;
            next = null;
        }


        void printALll(){
            System.out.println(vertex + " " + weight);
        }
    }

    Node[] nodeStore;


    AdjacencyList(boolean undirected) throws FileNotFoundException{
        //input maze
        File file = new File("src/algo/graph/GraphGen/GraphInput.txt");
        Scanner reader = new Scanner(file);
        nodeStore = new Node[reader.nextInt()];

        //reading edges
        int edges = reader.nextInt();
        reader.nextLine();
        for (int i = 0 ; i < edges; i++){
            String[] strArr = reader.nextLine().split(" ");
            int[] intArr = new int[3];
            for (int j = 0 ; j < 3; j++){
                intArr[j] = Integer.parseInt(strArr[j]);
            }

            Node node = new Node(intArr[1], intArr[2]);
            //add chilren to list
            int idx = intArr[0];
            node.next = nodeStore[idx];
            nodeStore[idx] = node;

            //add each other
            if (undirected){
                node = new Node(intArr[0], intArr[2]);
                idx = intArr[1];
                node.next = nodeStore[idx];
                nodeStore[idx] = node;
            }
        }
    }


    void debugNode(int idx){
        System.out.println("=== Debug node === " + idx);
        Node node = nodeStore[idx];
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
