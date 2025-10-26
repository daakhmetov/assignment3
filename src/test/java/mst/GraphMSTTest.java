package mst;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphMSTTest {

    @Test
    public void testPrimAndKruskalHaveSameCost() {
        List<Graph> graphs = JsonReader.readGraphs("input.json");

        for (Graph graph : graphs) {
            PrimMST.Result prim = PrimMST.findMST(graph);
            KruskalMST.Result kruskal = KruskalMST.findMST(graph);

            assertEquals(
                    prim.totalCost,
                    kruskal.totalCost,
                    "MST total costs differ for a graph"
            );
        }
    }

    @Test
    public void testMSTHasCorrectEdgeCount() {
        List<Graph> graphs = JsonReader.readGraphs("input.json");

        for (Graph graph : graphs) {
            PrimMST.Result prim = PrimMST.findMST(graph);
            int expectedEdges = graph.getNodes().size() - 1;
            assertEquals(
                    expectedEdges,
                    prim.mstEdges.size(),
                    "MST edge count incorrect for a graph"
            );
        }
    }

    @Test
    public void testMSTNotEmpty() {
        List<Graph> graphs = JsonReader.readGraphs("input.json");

        for (Graph graph : graphs) {
            PrimMST.Result prim = PrimMST.findMST(graph);
            assertFalse(prim.mstEdges.isEmpty(), "MST is empty for a graph");
        }
    }
}
