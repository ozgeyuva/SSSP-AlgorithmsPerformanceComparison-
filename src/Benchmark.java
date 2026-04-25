public class Benchmark {

    public static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static void runBenchmark(Graph graph, int source, String graphName) {
        System.out.println("Graph Size,Algorithm,Runtime(ms),Memory(KB)");

        System.gc();
        long memoryBeforeDijkstra = measureMemory();
        long startDijkstra = System.nanoTime();

        Dijkstra.shortestPath(graph, source);

        long endDijkstra = System.nanoTime();
        long memoryAfterDijkstra = measureMemory();

        double dijkstraRuntime = (endDijkstra - startDijkstra) / 1_000_000.0;
        double dijkstraMemory = (memoryAfterDijkstra - memoryBeforeDijkstra) / 1024.0;

        System.out.println(graphName + ",Dijkstra," + dijkstraRuntime + "," + dijkstraMemory);

        System.gc();
        long memoryBeforeBF = measureMemory();
        long startBF = System.nanoTime();

        BellmanFord.shortestPath(graph, source);

        long endBF = System.nanoTime();
        long memoryAfterBF = measureMemory();

        double bfRuntime = (endBF - startBF) / 1_000_000.0;
        double bfMemory = (memoryAfterBF - memoryBeforeBF) / 1024.0;

        System.out.println(graphName + ",Bellman-Ford," + bfRuntime + "," + bfMemory);
    }
}