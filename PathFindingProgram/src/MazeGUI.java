import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeGUI extends JFrame {
    private Maze maze;
    private int width;
    private int height;
    private int cellSize = 20;
    private JButton generateButton;
    private JButton pathfindButton;
    private JPanel mazePanel;

    public MazeGUI(final int width, final int height) {
        this.width = width;
        this.height = height;

        maze = new Maze(width, height);

        setTitle("Maze Generator and Pathfinding");
        setSize(width * cellSize + 50, height * cellSize + 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mazePanel = new MazePanel();
        mazePanel.setPreferredSize(new Dimension(width * cellSize, height * cellSize));

        generateButton = new JButton("Generate Maze");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maze = new Maze(width, height);
                mazePanel.repaint();
            }
        });

        pathfindButton = new JButton("Find Path");
        pathfindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AStar.findPath(maze);
                mazePanel.repaint();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(generateButton);
        controlPanel.add(pathfindButton);

        add(controlPanel, BorderLayout.SOUTH);
        add(mazePanel, BorderLayout.CENTER);
    }

    private class MazePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            char[][] grid = maze.getGrid();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == '#') {
                        g.setColor(Color.BLACK);
                    } else if (grid[y][x] == '.') {
                        g.setColor(Color.WHITE);
                    } else if (grid[y][x] == 'S') {
                        g.setColor(Color.GREEN);
                    } else if (grid[y][x] == 'E') {
                        g.setColor(Color.RED);
                    } else if (grid[y][x] == '*') { // Path found
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    g.setColor(Color.GRAY);
                    g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MazeGUI gui = new MazeGUI(21, 21);
                gui.setVisible(true);
            }
        });
    }
}