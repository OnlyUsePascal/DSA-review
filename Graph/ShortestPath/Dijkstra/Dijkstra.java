package Graph.ShortestPath.Dijkstra;

import Graph.GraphGen.AdjacencyList;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Dijkstra {
    AdjacencyList graph;
    Dijkstra() throws FileNotFoundException {
        graph = new AdjacencyList("src/Graph/ShortestPath/input",true);
    }


    class Node extends AdjacencyList.Node implements Comparable<Node>{
        Node(int v, int w){
            super(v,w);
        }

        @Override
        public int compareTo(Node node){
            if (this.weight > node.weight) return 1;
            if (this.weight == node.weight) return 0;
            return -1;
        }
    }
    
    
    void findPath(int start, int goal){
        System.out.println("=== dijkstra - shortest path ===");

        //bfs + only process the top element on the queue
        //when the node is currently processing,
        //the path from start -> it is smallest
        PriorityQueue<Node> nodeStack = new PriorityQueue<>();
        boolean[] visit = new boolean[graph.n];
        int pathLength = 0;

        //bfs
        nodeStack.add(new Node(start, 0));
        while (!nodeStack.isEmpty()){
            Node curNode = nodeStack.peek();
            nodeStack.remove();
            System.out.println("--> " + curNode.vertex + " " + curNode.weight);

            if (!visit[curNode.vertex]){
                visit[curNode.vertex] = true;

                if (curNode.vertex == goal){
                    pathLength = curNode.weight;
                    break;
                }

                //for each child
                AdjacencyList.Node child = graph.graphStore[curNode.vertex];
                while (child != null){
                    if (!visit[child.vertex]){
                        System.out.println("+ " + child.vertex);
                        nodeStack.add(new Node(child.vertex,
                                child.weight + curNode.weight));
                    }
                    child = child.next;
                }
            }
        }

        System.out.println("shortest path = " + pathLength);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Dijkstra ex = new Dijkstra();
        ex.findPath(0,2);
    }
}
