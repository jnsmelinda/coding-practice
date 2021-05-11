import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazeRunner {

    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.print("input: ");
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//                System.out.print("input: ");
//            }
//        }

        char[][] maze = {{'.', '.', '.', '.', '.','.'}, {'#', '.', '*', '#', '*','*'}, {'#', '#', '.', '#', '*','*'}, {'#', '#', '*', '#', '#','#'}, {'#', '#', '.', '.', '.','#'}};
        System.out.println(Arrays.deepToString(maze));
        System.out.println(getPathWall(maze,'*'));
        System.out.println(getPathWall(maze,'#'));
    }

    public static int getPathWall(char[][] maze, char wall) {
        if (maze == null || maze.length == 0) {
            return -1;
        }
        ArrayList<Point> path = new ArrayList<>();
        if (getPathWall(maze, maze.length - 1, maze[0].length - 1, path, wall)) {
            return path.size();
        }

        return -1;
    }

    public static boolean getPathWall(char[][] maze, int row, int col, ArrayList<Point> path, char wall) {
        if (col < 0 || row < 0 || maze[row][col] == wall) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPathWall(maze, row, col - 1, path, wall) || getPathWall(maze, row - 1, col, path, wall)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

//    private static int PATH = 0;
//
//    public static void main(String args[] ) throws Exception {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            List<String> lines = br.lines().collect(Collectors.toList());
//
//            String[] numbers = lines.get(0).split(" ");
//            int n = Integer.parseInt(numbers[0]);
//            int m = Integer.parseInt(numbers[1]);
//            char[][] maze = new char[n][m];
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    maze[i][j] = lines.get(i+1).charAt(j);
//                }
//            }
//
//            PATH = 0;
//            System.out.println(getPath(maze, '*'));
//            PATH = 0;
//            System.out.println(getPath(maze, '#'));
//        }
//    }
//
//    public static int getPath(char[][] maze, char wall) {
//        if (maze == null || maze.length == 0) {
//            return -1;
//        }
//
//        int result = getPath(maze, maze.length - 1,maze[0].length -1, wall);
//
//        return result > -1 ? result - 1 : result;
//    }
//
//    public static int getPath(char[][] maze, int row, int col, char wall) {
//        if (col < 0 || row < 0 || maze[row][col] == wall) {
//            return -1;
//        }
//
//        boolean isAtOrigin = (row == 0) && (col == 0);
//
//        if (isAtOrigin || getPath(maze, row, col-1, wall) > -1 || getPath(maze, row-1, col, wall) > -1) {
//            PATH++;
//            return PATH;
//        }
//
//        return -1;
//    }
}
