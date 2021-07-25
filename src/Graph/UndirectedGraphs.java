package Graph;

import java.util.*;

public class UndirectedGraphs {
    private class Node{
        private int size;
        private String label;

        public Node(String label) {
            this.label = label;
        }

    }
    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to ;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    //TODO => O(1)
    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node , new ArrayList<>());

    }
    //TODO => O(K)
    public void addEdge(String from , String to, int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return ;

        adjacencyList.get(fromNode).add(new Edge(fromNode,toNode,weight));
        //todo : if you want to implement underact graph you have to put
        adjacencyList.get(toNode).add(new Edge(toNode,fromNode,weight));
    }
    //TODO => O(V)
    public void print(){
        for (var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected "+ targets);
        }
    }

}
