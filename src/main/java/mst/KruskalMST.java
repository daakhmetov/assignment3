package mst;

import java.util.*;

public class KruskalMST {
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

    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();
        private final Map<String, Integer> rank = new HashMap<>();
        private int operations = 0;

        public void makeSet(List<String> vertices) {
            for (String v : vertices) {
                parent.put(v, v);
                rank.put(v, 0);
            }
        }

        public String find(String v) {
            operations++;
            if (!parent.get(v).equals(v)) {
                parent.put(v, find(parent.get(v)));
            }
            return parent.get(v);
        }

        public boolean union(String u, String v) {
            String rootU = find(u);
            String rootV = find(v);
            operations++;

            if (rootU.equals(rootV)) return false;

            if (rank.get(rootU) < rank.get(rootV)) {
                parent.put(rootU, rootV);
            } else if (rank.get(rootU) > rank.get(rootV)) {
                parent.put(rootV, rootU);
            } else {
                parent.put(rootV, rootU);
                rank.put(rootU, rank.get(rootU) + 1);
            }
            return true;
        }

        public int getOperations() { return operations; }
    }

    public static Result findMST(Graph graph) {
        long start = System.nanoTime();
        List<Edge> edges = new ArrayList<>(graph.getEdges());
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        UnionFind uf = new UnionFind();
        uf.makeSet(graph.getNodes());

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int operationCount = 0;

        for (Edge e : edges) {
            operationCount++;
            if (uf.union(e.getFrom(), e.getTo())) {
                mstEdges.add(e);
                totalCost += e.getWeight();
            }
            if (mstEdges.size() == graph.getNodes().size() - 1) break;
        }

        operationCount += uf.getOperations();
        long end = System.nanoTime();
        double executionTimeMs = (end - start) / 1_000_000.0;

        return new Result(mstEdges, totalCost, operationCount, executionTimeMs);
    }
}
