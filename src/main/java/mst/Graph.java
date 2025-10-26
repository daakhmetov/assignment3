package mst;

import java.util.*;

public class Graph {
    private List<String> nodes;
    private List<Edge> edges;

    public Graph(List<String> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<String> getNodes() { return nodes; }
    public List<Edge> getEdges() { return edges; }

    public Map<String, List<Edge>> getAdjacencyList() {
        Map<String, List<Edge>> adj = new HashMap<>();
        for (String node : nodes) adj.put(node, new ArrayList<>());
        for (Edge e : edges) {
            adj.get(e.getFrom()).add(e);
            adj.get(e.getTo()).add(new Edge(e.getTo(), e.getFrom(), e.getWeight()));
        }
        return adj;
    }
}
