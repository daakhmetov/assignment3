package mst;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JsonReader {
    public static List<Graph> readGraphs(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray graphsArray = root.getAsJsonArray("graphs");
            List<Graph> graphs = new ArrayList<>();

            for (JsonElement element : graphsArray) {
                JsonObject graphObj = element.getAsJsonObject();
                List<String> nodes = new ArrayList<>();
                for (JsonElement n : graphObj.getAsJsonArray("nodes"))
                    nodes.add(n.getAsString());

                List<Edge> edges = new ArrayList<>();
                for (JsonElement e : graphObj.getAsJsonArray("edges")) {
                    JsonObject eo = e.getAsJsonObject();
                    edges.add(new Edge(
                            eo.get("from").getAsString(),
                            eo.get("to").getAsString(),
                            eo.get("weight").getAsInt()
                    ));
                }
                graphs.add(new Graph(nodes, edges));
            }
            return graphs;
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON: " + e.getMessage());
        }
    }
}
