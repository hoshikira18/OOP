
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Set<Vertex> vertices;

    public Graph() {
        this.vertices = new HashSet<Vertex>();
    }

    public Vertex getVertex(String label) {
        for (Vertex vertex : vertices) {
            if(vertex.label.equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    public void addVertex(String label) {
        this.vertices.add(new Vertex(label));
    }

    public void addEdge(String u, String v, int weight) {
        Vertex vertexU = getVertex(u);
        Vertex vertexV = getVertex(v);
        if(vertexU != null) {
            if(vertexV == null) {
                this.vertices.add(new Vertex(v));
            }
            vertexU.adjList.put(vertexV, weight);
        }
    }

    public void display() {
        for (Vertex vertex : vertices) {
            System.out.print(vertex.label + " -> ");

            for (Map.Entry<Vertex, Integer> adj : vertex.adjList.entrySet()) {
                System.out.print(adj.getKey().label + "-" + adj.getValue() + " ");
            }

            System.out.println("");
        }
    }

    public void BFS(String label) {
        QueueArray<Vertex> queue = new QueueArray<>(1000);
        queue.enQueue(this.getVertex(label));
        ArrayList<Vertex> visited = new ArrayList<>();

        while(!queue.isEmpty()) {
            Vertex current = queue.deQueue();
            if(!visited.contains(current)) {
                System.out.println();
                for (Map.Entry<Vertex, Integer> adj : current.adjList.entrySet()) {
                    queue.enQueue(adj.getKey());
                }
            }
            visited.add(current);
        }
    }
}
