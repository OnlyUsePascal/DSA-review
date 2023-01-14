package Graph.TopoSort;
import Graph.GraphGen.AdjacencyList;
import Graph.GraphGen.AdjacencyMatrix;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class TopoSort {

    AdjacencyList graph1;
    AdjacencyMatrix graph2;

    TopoSort() throws FileNotFoundException {
        graph1 = new AdjacencyList("src/Graph/TopoSort/input",false);
        graph2 = new AdjacencyMatrix("src/Graph/TopoSort/input",false);
    }


    void getSort1() {
        System.out.println("=== Topo Sort ===");
        //Using iteration
        //for adjacency list + matrix

        //get in degree array
        int graphSize = graph1.graphStore.length;
        int[] indeg = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            AdjacencyList.Node child = graph1.graphStore[i];
            while (child != null) {
                indeg[child.vertex]++;
                child = child.next;
            }
        }

        //process node with 0 indeg
        ArrayList<Integer> dfsStore = new ArrayList<>();
        boolean[] visit = new boolean[graphSize];

        for (int i = 0; i < graphSize; i++) {
            if (indeg[i] == 0) {
                dfsStore.add(i);
                visit[i] = true;
            }
        }

        //sorting
        int idx = 0;
        while (idx < dfsStore.size()) {
            System.out.println(dfsStore);
            int curNode = dfsStore.get(idx);
            idx++;

            //handle child
            AdjacencyList.Node child = graph1.graphStore[curNode];
            while (child != null) {
                int vertex = child.vertex;

                if (!visit[vertex]) {
                    indeg[vertex]--;
                    if (indeg[vertex] == 0) {
                        visit[vertex] = true;
                        dfsStore.add(vertex);
                    }
                }

                child = child.next;
            }
        }
    }

    boolean[] visit;
    int sz;


    void getSort2(){ //using dfs
        System.out.println("=== topo sort ===");
        //adjacency matrix
        //print the parent of node before printing it

        sz = graph2.graphStore.length;
        visit = new boolean[sz];
        for (int node = 0; node < sz; node ++){
            if (!visit[node]){
                visit[node] = true;
                findParent(node);
            }
        }

    }


    void findParent(int curNode){
        //print the parent of node before printing it

        for (int par = 0; par < sz; par++){
            if (!visit[par] && graph2.graphStore[par][curNode] != 0){
                visit[par] = true;
                findParent(par);
            }
        }

        System.out.print(curNode + " -> ");
    }


    public static void main(String[] args) throws FileNotFoundException {
        TopoSort ex = new TopoSort();
//        ex.graph.printAll();
        ex.getSort1();
        ex.getSort2();
    }
}
