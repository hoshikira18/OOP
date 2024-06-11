import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Maze {
    private int width;
    private int height;
    private char[][] grid;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        generateMaze();
    }

    private void generateMaze() {
        // Initialize grid
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = '#';
            }
        }

        // Create stack and start position
        Stack<Cell> stack = new Stack<>();
        Cell start = new Cell(1, 1);
        grid[start.y][start.x] = '.';
        stack.push(start);

        // Perform recursive backtracking
        while (!stack.isEmpty()) {
            Cell current = stack.peek();
            Cell next = getNextCell(current);

            if (next != null) {
                stack.push(next);
                grid[next.y][next.x] = '.';
                grid[current.y + (next.y - current.y) / 2][current.x + (next.x - current.x) / 2] = '.';
            } else {
                stack.pop();
            }
        }

        grid[0][1] = 'S'; // Start
        grid[height-1][width-2] = 'E'; // End
    }

    private Cell getNextCell(Cell current) {
        List<Cell> neighbors = new ArrayList<>();

        // Add valid neighbors (2 cells away in each direction)
        if (current.y - 2 > 0 && grid[current.y - 2][current.x] == '#') {
            neighbors.add(new Cell(current.x, current.y - 2));
        }
        if (current.y + 2 < height - 1 && grid[current.y + 2][current.x] == '#') {
            neighbors.add(new Cell(current.x, current.y + 2));
        }
        if (current.x - 2 > 0 && grid[current.y][current.x - 2] == '#') {
            neighbors.add(new Cell(current.x - 2, current.y));
        }
        if (current.x + 2 < width - 1 && grid[current.y][current.x + 2] == '#') {
            neighbors.add(new Cell(current.x + 2, current.y));
        }

        if (neighbors.isEmpty()) {
            return null;
        }

        Collections.shuffle(neighbors);
        return neighbors.get(0);
    }

    public void printMaze() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }

    private static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public char[][] getGrid() {
        return grid;
    }
}
