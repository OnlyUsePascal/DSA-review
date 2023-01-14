package Graph.Search._DFS;
import Graph.GraphGen.AdjacencyList;
import Graph.GraphGen.AdjacencyMatrix;
import data_structure.StackLinkedList.StackLinkedList;
import java.io.FileNotFoundException;

public class DFS {

    AdjacencyList graphList;
    AdjacencyMatrix graphMatrix;

    DFS() throws FileNotFoundException {
        System.out.println("=== DFS ===");
        graphList = new AdjacencyList("src/Graph/Search/input",true);
        graphMatrix = new AdjacencyMatrix("src/Graph/Search/input",true);
    }

    void dfsAdjacencyList(){
        System.out.println("=== DFS Adjacency list ===");
        StackLinkedList<Integer> dfsStore = new StackLinkedList<>();
        boolean[] visit = new boolean[graphList.graphStore.length];

        //handle every node
        for (int i = 0; i < graphList.graphStore.length; i++){
            if (!visit[i]){
                System.out.println("---> " + i);
                visit[i] = true;
                dfsStore.push(i);

                //handle chilren
                while (!dfsStore.isEmpty()){
                    int node = dfsStore.peek();
                    System.out.println("-> " + node);
                    dfsStore.pop();

                    //add chilren to stack
                    AdjacencyList.Node child = graphList.graphStore[node];
                    while (child != null){
                        if (!visit[child.vertex]){
                            visit[child.vertex] = true;
                            System.out.println("+ " + child.vertex);
                            dfsStore.push(child.vertex);
                        }
                        child = child.next;
                    }
                }
            }
        }
    }


    void dfsAdjacencyMatrix(){
        System.out.println("=== DFS Adjacency Matrix ===");
        StackLinkedList<Integer> dfsStore = new StackLinkedList<>();
        boolean[] visit = new boolean[graphMatrix.graphStore.length];

        for (int i = 0; i < graphMatrix.graphStore.length; i++){
            if (!visit[i]){
                System.out.println("---> " + i);
                visit[i] = true;
                dfsStore.push(i);

                //handle children
                while (!dfsStore.isEmpty()){
                    int node = dfsStore.peek();
                    System.out.println("x " + node);
                    dfsStore.pop();

                    //add chilren to stack
                    for (int j = 0; j < graphMatrix.graphStore.length; j++){
                        if (graphMatrix.graphStore[i][j] != 0 && !visit[j]){
                            System.out.println("++ " + j);
                            visit[j] = true;
                            dfsStore.push(j);
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        DFS ex = new DFS();
//        ex.dfsAdjacencyList();
        ex.dfsAdjacencyMatrix();
    }
}
