import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(graph, graph.getVertex(source));
        search();
    }

    @Override
    public void search() {
        Queue<Vertex<V>> queue = new LinkedList<>();
        // Adding the source vertex to the queue
        queue.add(source);
        // Marking the source vertex as visited
        marked.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            // Iterating through the adjacent vertices of the current vertex
            for (Vertex<V> neighbor : current.getAdjacentVertices()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
