package mst;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JsonWriter {
    public static void writeResults(String filePath, List<JsonObject> results) {
        JsonObject root = new JsonObject();
        JsonArray resultsArray = new JsonArray();
        for (JsonObject obj : results) resultsArray.add(obj);
        root.add("results", resultsArray);

        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(root, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing JSON: " + e.getMessage());
        }
    }
}

