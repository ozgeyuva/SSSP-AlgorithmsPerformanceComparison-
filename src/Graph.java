import java.io.*;
import java.util.*;

public class Graph {
    int vertices;
    ArrayList<ArrayList<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    public ArrayList<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public static Graph fromDIMACS(String filePath) {
        Graph graph = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("c")) {
                    continue;
                }

                if (line.startsWith("p")) {
                    String[] parts = line.split("\\s+");
                    int vertices = Integer.parseInt(parts[2]);

                    graph = new Graph(vertices + 1); // DIMACS uses 1-based nodes
                }

                else if (line.startsWith("a")) {
                    String[] parts = line.split("\\s+");

                    int from = Integer.parseInt(parts[1]);
                    int to = Integer.parseInt(parts[2]);
                    int weight = Integer.parseInt(parts[3]);

                    graph.addEdge(from, to, weight);
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading DIMACS file: " + e.getMessage());
        }

        return graph;
    }
}
