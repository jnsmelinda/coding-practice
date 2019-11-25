package ctci.recursionanddynamic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RobotInAGrid {

    public static ArrayList<Point>[][] getPath(Integer[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Point>[][] path = new ArrayList[m][n];

        Point[][] points = new Point[m][n];

        points[0][0] = new Point(0,0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = new ArrayList<>();
                if (grid[i][j] != null) {
                    path[i][j].add(null);
                }
//                else {
//                    path[i][i].add(new Point(i,j));
//                }

            }
        }

        System.out.println(Arrays.deepToString(path));

        for (int i = 1; i < m; i++) {
            if (points[i-1][0] == null) {
                points[i][0] = points[i-1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (points[0][j-1] == null) {
                points[0][j] = points[0][j-1];
            }
        }
        System.out.println(Arrays.deepToString(points));



        System.out.println(Arrays.deepToString(points));
        return path;
    }

    public static void main(String[] args) {
        Integer[][] grid = new Integer[3][3];
        grid[1][1] = 0;
        System.out.println(Arrays.deepToString(grid));
        System.out.println(getPath(grid));
    }
}
