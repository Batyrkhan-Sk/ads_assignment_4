import java.util.*;

public abstract class Search<V> {
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    protected Set<Vertex<V>> marked = new HashSet<>();
    protected final Vertex<V> source;
    protected final WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph, Vertex<V> source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract void search();

    // Checking if there is a path from the source to the given vertex
    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

    // Returning the path from the source to the given vertex
    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        Deque<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> i = v; i != null; i = edgeTo.get(i)) {
            path.push(i);
        }
        return path;
    }
}
