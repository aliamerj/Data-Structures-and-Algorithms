package Graph;

import java.util.*;

public class Graph {
    private int size;
    private class Node{
        private String label ;

        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString() {
            return label;
        }
    }
    //todo :-> adjacency List O(V+E)
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node , List<Node>> adjacencyList = new HashMap<>();

    //TODO => O(1)
    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node , new ArrayList<>());
        size++;

    }
    //TODO => O(K)
    public void addEdge(String from , String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return ;

        adjacencyList.get(fromNode).add(toNode);
        //todo : if you want to implement underact graph you have to put
        //adjacencyList.get(toNode).add(fromNode);
    }
    //TODO => O(V)
    public void print(){
        for (var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected "+ targets);
        }
    }
    //TODO => O(V)
    public void removeNode(String label){
        var node = nodes.get(label);
        if (node == null)
            return;
        // remove all the edges that come to it o(v)
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        // remove all the edges that come from it o(1)
        adjacencyList.remove(node);
        // remove the vertex o(1)
        nodes.remove(node);
        size--;

    }
    //TODO => O(K)
    public void removeEdge(String from , String to ){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return ;
        adjacencyList.get(fromNode).remove(toNode);
    }

    //TODO => O(V+E) ===> O(V)
    public void traversDepthFirst(String root){
        var node = nodes.get(root);
        if (node == null)
            return;
        traversDepthFirst(node, new HashSet<>());

    }
    private void traversDepthFirst(Node root , Set<Node> visited){
        System.out.println(root);
        visited.add(root);

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traversDepthFirst(node,visited);


    }
    public void traversBreathFirst(String root){
        var node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            var current =queue.remove();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for (var neighbor : adjacencyList.get(current))
                if (!visited.contains(neighbor))
                    queue.add(neighbor);

        }

    }
    //TODO => O(V+E) ===> O(V)
    public void traversBreathFirstR(String root){
        var node = nodes.get(root);
        if (node == null)
            return;
        traversBreathFirstR(node, new HashSet<>());

    }
    private void traversBreathFirstR(Node root , Set<Node> visited){
        if (!visited.contains(root)) {
            System.out.println(root);
            visited.add(root);
        }

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node)){
                System.out.println(node);
                visited.add(node);
            }
        for (var node : adjacencyList.get(root))
                traversBreathFirstR(node,visited);

    }


    public List<String> topologicalSort(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(var node : nodes.values())
            topologicalSort(node, visited,stack);
        List<String> sorted = new ArrayList<>();
        while (!stack.empty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;
        visited.add(node);
        for (var neighbour : adjacencyList.get(node))
            topologicalSort(neighbour,visited,stack);
        stack.push(node);

    }


}
