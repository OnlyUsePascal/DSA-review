package Graph.GraphGen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {
    public int[][] graphStore;

    public AdjacencyMatrix(boolean undirected) throws FileNotFoundException{
        System.out.println("=== Adjacency Matrix ===");

        //read input file
        Scanner reader = new Scanner(new File("src/graph/GraphGen/GraphInput.txt"));
        int sz = reader.nextInt();
        graphStore = new int[sz][sz];

        int edge = reader.nextInt();
        reader.nextLine();
        for (int i = 0 ; i < edge; i++){
            //invert string to number
            String[] strArr = reader.nextLine().split(" ");
            int[] intArr = new int[3];
            for (int j = 0 ; j < 3; j++){
                intArr[j] = Integer.parseInt(strArr[j]);
            }

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
        AdjacencyMatrix ex = new AdjacencyMatrix(false);
        ex.printAll();
    }
}
