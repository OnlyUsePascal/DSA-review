package Graph.TopoSort;
import Graph.GraphGen.AdjacencyList;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class TopoSort {

    AdjacencyList graph;

    TopoSort() throws FileNotFoundException {
        graph = new AdjacencyList("src/Graph/TopoSort/input",false);
    }


    void getSort() {
        System.out.println("=== Topo Sort ===");
        //Using iteration

        //get in degree array
        int graphSize = graph.graphStore.length;
        int[] indeg = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            AdjacencyList.Node child = graph.graphStore[i];
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
            AdjacencyList.Node child = graph.graphStore[curNode];
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


    public static void main(String[] args) throws FileNotFoundException {
        TopoSort ex = new TopoSort();
//        ex.graph.printAll();
        ex.getSort();
    }
}
