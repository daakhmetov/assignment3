package mst;

import com.google.gson.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputPath = "input.json";
        String outputPath = "output.json";

        List<Graph> graphs = JsonReader.readGraphs(inputPath);
        List<JsonObject> results = new ArrayList<>();
        int graphId = 1;

        for (Graph g : graphs) {
            System.out.println("Processing Graph " + graphId);

            PrimMST.Result prim = PrimMST.findMST(g);
            KruskalMST.Result kruskal = KruskalMST.findMST(g);

            JsonObject graphResult = new JsonObject();
            graphResult.addProperty("graph_id", graphId);

            JsonObject inputStats = new JsonObject();
            inputStats.addProperty("vertices", g.getNodes().size());
            inputStats.addProperty("edges", g.getEdges().size());
            graphResult.add("input_stats", inputStats);

            graphResult.add("prim", createAlgoJson(prim));
            graphResult.add("kruskal", createAlgoJson(kruskal));

            results.add(graphResult);
            graphId++;
        }

        JsonWriter.writeResults(outputPath, results);
        System.out.println("Results written to " + outputPath);
    }

    private static JsonObject createAlgoJson(Object algoResult) {
        JsonObject obj = new JsonObject();
        if (algoResult instanceof PrimMST.Result prim) {
            obj.add("mst_edges", edgesToJson(prim.mstEdges));
            obj.addProperty("total_cost", prim.totalCost);
            obj.addProperty("operations_count", prim.operationsCount);
            obj.addProperty("execution_time_ms", prim.executionTimeMs);
        } else if (algoResult instanceof KruskalMST.Result kruskal) {
            obj.add("mst_edges", edgesToJson(kruskal.mstEdges));
            obj.addProperty("total_cost", kruskal.totalCost);
            obj.addProperty("operations_count", kruskal.operationsCount);
            obj.addProperty("execution_time_ms", kruskal.executionTimeMs);
        }
        return obj;
    }

    private static JsonArray edgesToJson(List<Edge> edges) {
        JsonArray arr = new JsonArray();
        for (Edge e : edges) {
            JsonObject obj = new JsonObject();
            obj.addProperty("from", e.getFrom());
            obj.addProperty("to", e.getTo());
            obj.addProperty("weight", e.getWeight());
            arr.add(obj);
        }
        return arr;
    }
}
