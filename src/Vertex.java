import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    // Retrieving the data
    public V getData() {
        return data;
    }

    // Adding an adjacent vertex with a defined weight
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Getting the set of adjacent vertices
    public Set<Vertex<V>> getAdjacentVertices() {
        return adjacentVertices.keySet();
    }

    // Getting the weight of the edge to a specified adjacent vertex
    public double getWeight(Vertex<V> destination) {
        return adjacentVertices.getOrDefault(destination, Double.MAX_VALUE);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    // Comparing vertices based on their data
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }

    // Generating a hash code according to the data
    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
