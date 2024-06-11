
import java.util.*;

public class AStar {
    private static class Node implements Comparable<Node> {
        int x, y, g, h;
        Node parent;

        Node(int x, int y, int g, int h, Node parent) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.parent = parent;
        }

        int getF() {
            return g + h;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getF(), o.getF());
        }
    }

    public static void findPath(Maze maze) {
        char[][] grid = maze.getGrid();
        int width = grid[0].length;
        int height = grid.length;

        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<String> closedList = new HashSet<>();

        Node startNode = new Node(1, 0, 0, heuristic(1, 0, width - 2, height - 1), null);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();
            closedList.add(current.x + "," + current.y);

            if (current.x == width - 2 && current.y == height - 1) {
                System.out.println("Path found!");
                markPath(grid, current);
                return;
            }

            for (int[] direction : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (newX >= 0 && newX < width && newY >= 0 && newY < height && grid[newY][newX] != '#') {
                    Node neighbor = new Node(newX, newY, current.g + 1, heuristic(newX, newY, width - 2, height - 1), current);
                    if (!closedList.contains(newX + "," + newY)) {
                        openList.add(neighbor);
                    }
                }
            }
        }

        System.out.println("No path found.");
    }

    private static void markPath(char[][] grid, Node node) {
        while (node != null) {
            grid[node.y][node.x] = '*';
            node = node.parent;
        }
        grid[0][1] = 'S'; // Start
        grid[grid.length - 1][grid[0].length - 2] = 'E'; // End
    }

    private static int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
