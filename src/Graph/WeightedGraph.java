package Graph;


import java.util.*;

public class WeightedGraph {
  private class Node {
    private String label;
    private List<Edge> edges = new ArrayList<>();
    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }

    public void addEdge(Node to, int weight) {
      edges.add(new Edge(this, to, weight));
    }

    public List<Edge> getEdges() {
      return edges;
    }
  }

  private class Edge {
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
      return from + "->" + to; // A->B
    }
  }

  private Map<String, Node> nodes = new HashMap<>();

  public void addNode(String label) {
    nodes.putIfAbsent(label, new Node(label));
  }

  public void addEdge(String from, String to, int weight) {
    var fromNode = nodes.get(from);
    if (fromNode == null)
      throw new IllegalArgumentException();

    var toNode = nodes.get(to);
    if (toNode == null)
      throw new IllegalArgumentException();

    fromNode.addEdge(toNode, weight);
    toNode.addEdge(fromNode, weight);
  }

  public void print() {
    for (var node : nodes.values()) {
      var edges = node.getEdges();
      if (!edges.isEmpty())
        System.out.println(node + " is connected to " + edges);
    }
  }

  private class NodeEntry {
    private Node node;
    private int priority;

    public NodeEntry(Node node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }

  public Path getShortestPath(String from, String to) {
    // the bac case

    var fromNode = nodes.get(from);
    if (fromNode == null)
      throw new IllegalArgumentException();

    var toNode = nodes.get(to);
    if (toNode == null)
      throw new IllegalArgumentException();


    //todo ;- make the map from node and int

    Map<Node, Integer> distances = new HashMap<>();

    // todo ;- walk through all node in graph and
    //  put all of them inside map distance and make int max

    for (var node : nodes.values())
      distances.put(node, Integer.MAX_VALUE);

    // todo ;- and then make first node 0
    distances.replace(fromNode, 0);

    // todo ;- make previous node map
    Map<Node, Node> previousNodes = new HashMap<>();

     // todo ;- make set of node --> visited
    Set<Node> visited = new HashSet<>();
    // todo ;- make priorityQueue from NodeEntry to comparator store them according to them priority
    PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    //  todo ;- add new entry to queue
    queue.add(new NodeEntry(fromNode, 0));
    // todo ;- when queue is not empty do
    while (!queue.isEmpty()) {
      var current = queue.remove().node;
      visited.add(current);
       // todo ;- for each edge around the current node if we visit the to node continue
      for (var edge : current.getEdges()) {
        if (visited.contains(edge.to))
          continue;
       // todo :-- otherwise make new newDistance that sum current node + edge.weight
        var newDistance = distances.get(current) + edge.weight;
        // todo :-- if newDistance < distances.get(edge.to)) do replace int of  edge.to in distances map with newDistance
        //  and put this node in previousNode -> edge.to and  current
        if (newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          previousNodes.put(edge.to, current);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }

    return buildPath(previousNodes, toNode);
  }

  private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {

    Stack<Node> stack = new Stack<>();
    stack.push(toNode);
    var previous = previousNodes.get(toNode);
    while (previous != null) {
      stack.push(previous);
      previous = previousNodes.get(previous);
    }

    var path = new Path();
    while (!stack.isEmpty())
      path.add(stack.pop().label);

    return path;
  }

  public boolean hasCycle() {
    // MAKE SET
    Set<Node> visited = new HashSet<>();

    for (var node : nodes.values()) {
      if (!visited.contains(node) && hasCycle(node, null, visited))
        return true;
    }

    return false;
  }

  private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
    visited.add(node);

    for (var edge : node.getEdges()) {
      if (edge.to == parent)
        continue;

      if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
        return true;
    }

    return false;
  }

  public WeightedGraph getMinimumSpanningTree() {
    var tree = new WeightedGraph();

    if (nodes.isEmpty())
      return tree;

    PriorityQueue<Edge> edges = new PriorityQueue<>(
        Comparator.comparingInt(e -> e.weight)
    );

    var startNode = nodes.values().iterator().next();
    edges.addAll(startNode.getEdges());
    tree.addNode(startNode.label);

    if (edges.isEmpty())
      return tree;

    while (tree.nodes.size() < nodes.size()) {
      var minEdge = edges.remove();
      var nextNode = minEdge.to;

      if (tree.containsNode(nextNode.label))
        continue;

      tree.addNode(nextNode.label);
      tree.addEdge(minEdge.from.label,
              nextNode.label, minEdge.weight);

      for (var edge : nextNode.getEdges())
        if (!tree.containsNode(edge.to.label))
          edges.add(edge);
    }

    return tree;
  }

  public boolean containsNode(String label) {
    return nodes.containsKey(label);
  }














}
