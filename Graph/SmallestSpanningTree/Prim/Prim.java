package Graph.SmallestSpanningTree.Prim;

import Graph.GraphGen.AdjacencyList;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Prim {
    AdjacencyList graph;
    Prim() throws FileNotFoundException {
        graph = new AdjacencyList("src/Graph/SmallestSpanningTree/input",true);
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

    void getTree(){
        System.out.println("=== prim - smallest spanning tree ===");
        PriorityQueue<Node> nodeStack = new PriorityQueue<>();
        int treeLength = 0;
        boolean[] visit = new boolean[graph.n];

        //start at vertex 0
        nodeStack.add(new Node(0,0));

        while (!nodeStack.isEmpty()){
            Node curNode = nodeStack.peek();
            nodeStack.remove();
//            System.out.println("--> " + curNode.vertex + " " + curNode.weight);

            if (!visit[curNode.vertex]){
                //add cur node to tree
//                System.out.println("Added");
                visit[curNode.vertex] = true;
                treeLength += curNode.weight;

                //get unvisited child of curnode
                AdjacencyList.Node child = graph.graphStore[curNode.vertex];
                while (child != null){
                    if (!visit[child.vertex]){
//                        System.out.println("+ " + child.vertex);
                        nodeStack.add(new Node(child.vertex, child.weight));
                    }
                    child = child.next;
                }

            }
        }

        System.out.println("tree lenght = " + treeLength);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Prim ex = new Prim();
        ex.getTree();

    }
}
