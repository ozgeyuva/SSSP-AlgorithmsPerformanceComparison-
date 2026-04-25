import java.util.*;

public class BellmanFord {

    public static int[] shortestPath(Graph graph, int source) {
        int[] distance = new int[graph.vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        for (int i = 0; i < graph.vertices - 1; i++) {
            for (int u = 0; u < graph.vertices; u++) {
                if (distance[u] != Integer.MAX_VALUE) {
                    for (Edge edge : graph.getNeighbors(u)) {
                        if (distance[u] + edge.weight < distance[edge.to]) {
                            distance[edge.to] = distance[u] + edge.weight;
                        }
                    }
                }
            }
        }

        return distance;
    }
}