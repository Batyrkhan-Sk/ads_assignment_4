import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean isDirected;

    public WeightedGraph(boolean isDirected) {
        this.vertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Adding a vertex to the graph
    public Vertex<V> addVertex(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        vertices.put(data, vertex);
        return vertex;
    }

    // Getting a vertex by its data
    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    // Adding an edge between 2 vertices
    public void addEdge(V from, V to, double weight) {
        Vertex<V> fromVertex = vertices.get(from);
        Vertex<V> toVertex = vertices.get(to);

        // If the vertex doesn't exist, create and add it
        if (fromVertex == null) {
            fromVertex = addVertex(from);
        }
        // If the destination vertex doesn't exist, create and add it
        if (toVertex == null) {
            toVertex = addVertex(to);
        }

        // Adding an edge from the source vertex to the dest. vertex
        fromVertex.addAdjacentVertex(toVertex, weight);

        // If the graph is undirected, add an edge in the opposite direction too
        if (!isDirected) {
            toVertex.addAdjacentVertex(fromVertex, weight);
        }
    }

    // Adding an edge with default weight of 1.0
    public void addEdge(V from, V to) {
        addEdge(from, to, 1.0);
    }

}
