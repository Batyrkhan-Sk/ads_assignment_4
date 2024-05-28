import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances;
    private final Set<Vertex<V>> unsettledNodes;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(graph, graph.getVertex(source));
        distances = new HashMap<>();
        unsettledNodes = new HashSet<>();
        search();
    }

    @Override
    public void search() {
        // Setting the distance to the source vertex to 0
        distances.put(source, 0.0);
        // Adding the source vertex to the unsettled nodes
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            // Iterating through the adjacent vertices of the current node
            for (Vertex<V> neighbor : currentNode.getAdjacentVertices()) {
                double newDistance = distances.get(currentNode) + currentNode.getWeight(neighbor);

                if (newDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    if (!marked.contains(neighbor)) {
                        unsettledNodes.add(neighbor);
                    }
                }
            }
        }
    }

    // Getting the vertex with the minimum weight
    private Vertex<V> getVertexWithMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex<V> minimum = null;
        // Iterating through the vertices to find the one with the smallest distance
        for (Vertex<V> vertex : vertices) {
            if (minimum == null || distances.get(vertex) < distances.get(minimum)) {
                minimum = vertex;
            }
        }
        // Returning the vertex with the smallest distance
        return minimum;
    }
}
