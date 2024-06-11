//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int width = 101;
        int height = 101;

        Maze maze = new Maze(width, height);
        maze.printMaze();
    }
}