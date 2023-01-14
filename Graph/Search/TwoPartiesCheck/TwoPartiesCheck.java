package Graph.Search.TwoPartiesCheck;

import Graph.GraphGen.AdjacencyList;
import Graph.GraphGen.AdjacencyMatrix;
import data_structure.StackLinkedList.StackLinkedList;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TwoPartiesCheck {
    //main concept dfs
    AdjacencyList graph1;
    AdjacencyMatrix graph2;
    int sz;

    TwoPartiesCheck() throws FileNotFoundException {
        graph1 = new AdjacencyList("src/Graph/Search/input",true);
        graph2 = new AdjacencyMatrix("src/Graph/Search/input",true);
        sz = graph1.graphStore.length;
    }


    void check(){
        //for list
        System.out.println("=== two parties check ===");
        StackLinkedList<Integer> dfsStack = new StackLinkedList<>();
        int[] markList = new int[sz];

        for (int node = 0; node < sz; node++){
            if (markList[node] == 0){
                //init unvisited node
                dfsStack.push(node);
                markList[node] = 1;

                //start discover from that node
                while (!dfsStack.isEmpty()){
                    int curNode = dfsStack.peek();
                    dfsStack.pop();
                    System.out.println(curNode + " - " + Arrays.toString(markList));

                    //handle child
                    AdjacencyList.Node child = graph1.graphStore[curNode];
                    while (child != null){
                        int v = child.vertex;
                        if (markList[v] == 0){
                            markList[v] = (markList[curNode] == 1) ? 2 : 1;
                            dfsStack.push(v);
                        }
                        else if (markList[v] == markList[curNode]){
                            System.out.println("failed");
                            return;
                        }

                        child = child.next;
                    }
                }
            }
        }

        System.out.println("done");
        System.out.println(Arrays.toString(markList));
    }


    void check2(){
        //for matrix
        System.out.println("=== two parties check ===");
        StackLinkedList<Integer> dfsStack = new StackLinkedList<>();
        int[] markList = new int[sz];

        for (int node = 0; node < sz; node++){
            if (markList[node] == 0){
                //init unvisited node
                dfsStack.push(node);
                markList[node] = 1;

                //start discover from that node
                while (!dfsStack.isEmpty()){
                    int curNode = dfsStack.peek();
                    dfsStack.pop();
                    System.out.println(curNode + " - " + Arrays.toString(markList));

                    //handle child
                    for (int child = 0 ; child < sz; child++){
                        if (child != curNode && graph2.graphStore[curNode][child] != 0){
                            if (markList[child] == 0){
                                markList[child] = (markList[curNode] == 1) ? 2 : 1;
                                dfsStack.push(child);
                            }
                            else if (markList[child] == markList[curNode]){
                                System.out.println("failed");
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("done");
        System.out.println(Arrays.toString(markList));
    }


    public static void main(String[] args) throws FileNotFoundException{
        TwoPartiesCheck ex = new TwoPartiesCheck();
        ex.check2();
    }
}
