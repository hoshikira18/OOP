
import java.util.Random;

public class Map {
    private int width;
    private int height;
    private char[][] grid;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        generateRandomMap();
    }

    private void generateRandomMap() {
        Random random = new Random();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (random.nextDouble() < 0.4) { // 20% chance to be an obstacle
                    grid[y][x] = '#';
                } else {
                    grid[y][x] = '.';
                }
            }
        }
        grid[0][0] = 'S'; // Start
        grid[height-1][width-1] = 'E'; // End
    }

    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }

    public char[][] getGrid() {
        return grid;
    }
}
