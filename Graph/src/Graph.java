
import java.util.*;

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
                System.out.print("(" + adj.getKey().label + ", " + adj.getValue() + ") ");
            }

            System.out.println("");
        }
    }

    public void BFS (String label) {
        Vertex startVertex = getVertex(label);
        QueueArray<Vertex> queue = new QueueArray<>(1000);
        ArrayList<Vertex> visited = new ArrayList<>();
        queue.enQueue(startVertex);
        while(!queue.isEmpty()) {
            Vertex vertex = queue.deQueue();
            if(!visited.contains(vertex)) {
                System.out.print(vertex.label + " ");
                for (Map.Entry<Vertex, Integer> adj : vertex.adjList.entrySet()) {
                    if(!visited.contains(adj.getKey())) {
                        queue.enQueue(adj.getKey());
                    }
                }
                visited.add(vertex);
            }
        }
    }

    public void DFS (String label) {
        Vertex startVetext = getVertex(label);
        Stack<Vertex> stack = new Stack<>(1000);
        ArrayList<Vertex> visited = new ArrayList<>();
        stack.push(startVetext);

        while(!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if(!visited.contains(vertex)) {
                System.out.print(vertex.label + " ");
                for (Map.Entry<Vertex, Integer> adj : vertex.adjList.entrySet()) {
                    if(!visited.contains(adj.getKey())) {
                        stack.push(adj.getKey());
                    }
                }
                visited.add(vertex);
            }
        }
     }

     public void dijkstra(String start, String end) {
        QueueArray<Vertex> queue =

                QueueArray<>(1000);
        ArrayList<Vertex> visited = new ArrayList<>();
         HashMap<Vertex, Integer> distance =  new HashMap<>();
         HashMap<Vertex, Vertex> previous = new HashMap<>();

         for(Vertex vertex : this.vertices) {
             distance.put(vertex, Integer.MAX_VALUE);
         }

         Vertex startVertex = this.getVertex(start);

     }
}
