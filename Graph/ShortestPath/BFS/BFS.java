package Graph.ShortestPath.BFS;

import Graph.GraphGen.AdjacencyList;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    AdjacencyList graph;

    BFS() throws FileNotFoundException {
        System.out.println("=== bfs - shortest path ===");
        graph = new AdjacencyList("src/Graph/ShortestPath/input",true);
    }


    //O(N^2)
    void getPath(int start, int goal){
        //main -- bfs
        Queue<Integer> bfsStack = new LinkedList<>();

        //default inf distance for each destination
        boolean[] visit = new boolean[graph.n];
        int[] dis = new int[graph.n];

        for (int i = 0 ; i < graph.n; i++)
            if (i != start) dis[i] = Integer.MAX_VALUE;


        //bfs
        bfsStack.add(start);
        visit[start] = true;
        while (!bfsStack.isEmpty()){
            int curNode = bfsStack.peek();
            bfsStack.remove();
//            System.out.println("-- " + curNode);
//            System.out.println(Arrays.toString(dis));

            //for each child of cur node
            AdjacencyList.Node child = graph.graphStore[curNode];
            while (child != null){
                int childV = child.vertex,
                        childW = child.weight;

                //update the distance to that child if possible
                dis[childV] = Math.min(dis[childV], dis[curNode] + childW);

                //add child to queue
                if (!visit[childV]){
                    visit[childV] = true;
                    bfsStack.add(childV);
//                    System.out.println("+ " + childV);
                }

                child = child.next;
            }
        }

//        System.out.println(Arrays.toString(dis));
        System.out.println("distance = " + dis[goal]);
    }


    public static void main(String[] args) throws FileNotFoundException {
        BFS ex = new BFS();
        ex.getPath(0,2);
    }
}
