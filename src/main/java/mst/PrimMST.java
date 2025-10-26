package mst;

import java.util.*;

public class PrimMST {
    public static class Result {
        public List<Edge> mstEdges;
        public int totalCost;
        public int operationsCount;
        public double executionTimeMs;

        public Result(List<Edge> mstEdges, int totalCost, int operationsCount, double executionTimeMs) {
            this.mstEdges = mstEdges;
            this.totalCost = totalCost;
            this.operationsCount = operationsCount;
            this.executionTimeMs = executionTimeMs;
        }
    }

    public static Result findMST(Graph graph) {
        long start = System.nanoTime();
        Map<String, List<Edge>> adj = graph.getAdjacencyList();

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int operationsCount = 0;

        String startNode = graph.getNodes().get(0);
        visited.add(startNode);
        pq.addAll(adj.get(startNode));

        while (!pq.isEmpty() && mstEdges.size() < graph.getNodes().size() - 1) {
            Edge edge = pq.poll();
            operationsCount++;

            if (visited.contains(edge.getTo())) continue;

            visited.add(edge.getTo());
            mstEdges.add(edge);
            totalCost += edge.getWeight();

            for (Edge next : adj.get(edge.getTo())) {
                if (!visited.contains(next.getTo())) {
                    pq.add(next);
                    operationsCount++;
                }
            }
        }

        long end = System.nanoTime();
        double executionTimeMs = (end - start) / 1_000_000.0;

        return new Result(mstEdges, totalCost, operationsCount, executionTimeMs);
    }
}
