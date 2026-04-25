import java.util.*;

public class Dijkstra {

    public static int[] shortestPath(Graph graph, int source) {
        int[] distance = new int[graph.vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[currentNode]) {
                continue;
            }

            for (Edge edge : graph.getNeighbors(currentNode)) {
                int newDistance = currentDistance + edge.weight;

                if (newDistance < distance[edge.to]) {
                    distance[edge.to] = newDistance;
                    pq.add(new int[]{edge.to, newDistance});
                }
            }
        }

        return distance;
    }
}