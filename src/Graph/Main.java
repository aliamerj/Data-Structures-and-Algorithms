package Graph;

public class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addEdge("C","A");
        graph.addEdge("C","B");
        graph.addEdge("C","D");
        graph.addEdge("A","B");
        graph.addEdge("A","F");
        graph.addEdge("A","G");
        graph.addEdge("A","E");
        graph.addEdge("B","E");
        graph.addEdge("D","E");
        graph.print();

        graph.traversDepthFirst("C");
        System.out.println("-------");
        graph.traversBreathFirst("C");
        System.out.println("-------");
        graph.traversBreathFirstR("C");


        var graph2 = new Graph();
        graph2.addNode("X");
        graph2.addNode("A");
        graph2.addNode("B");
        graph2.addNode("P");
        graph.addEdge("X","A");
        graph.addEdge("X","B");
        graph.addEdge("A","P");
        graph.addEdge("B","P");
        var list = graph2.topologicalSort();
        System.out.println(list);



    }
}
