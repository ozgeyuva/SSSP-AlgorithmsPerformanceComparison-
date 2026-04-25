public class Main {
    public static void main(String[] args) {

        Graph graph = Graph.fromDIMACS("C:\\Users\\ÖZGE\\Desktop\\SSSP-Comparison\\USA-road-d.NY.gr");

        if (graph == null) {
            System.out.println("Graph could not be loaded.");
            return;
        }

        System.out.println("===== DIMACS ROAD NETWORK GRAPH =====");
        Benchmark.runBenchmark(graph, 1, "DIMACS-NY");
    }
}
