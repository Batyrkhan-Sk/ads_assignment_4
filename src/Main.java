public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (Vertex<String> v : search.pathTo(search.graph.getVertex(key))) {
            System.out.print(v.getData() + " -> ");
        }
        System.out.println();
    }
}
