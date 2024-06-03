import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    String label;
//    ArrayList<Vertex> adjList;

    HashMap<Vertex, Integer> adjList;

    public Vertex(String label) {
        this.label = label;
//        this.adjList = new ArrayList<>();
        this.adjList = new HashMap<>();
    }
}
