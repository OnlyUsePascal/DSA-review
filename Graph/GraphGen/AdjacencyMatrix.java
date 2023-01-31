package Graph.GraphGen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {
    public int[][] graphStore;
    public int n,e;

    public AdjacencyMatrix(String src, boolean undirected) throws FileNotFoundException{
        System.out.println("=== Adjacency Matrix ===");

        //read input file
        Scanner reader = new Scanner(new File(src));
        n = reader.nextInt();
        graphStore = new int[n][n];

        e = reader.nextInt();
        reader.nextLine();
        for (int i = 0 ; i < e; i++){
            //invert string to number
            int[] intArr = Arrays.stream(reader.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();

            //add node to store
            graphStore[intArr[0]][intArr[1]] = intArr[2];
            if (undirected) graphStore[intArr[1]][intArr[0]] = intArr[2];
        }
    }


    public void printAll(){
        System.out.println("=== Print all ===");
        for (int[] s : graphStore){
            System.out.println(Arrays.toString(s));
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        AdjacencyMatrix ex = new AdjacencyMatrix("src/graph/GraphGen/GraphInput.txt", false);
        ex.printAll();
    }
}
