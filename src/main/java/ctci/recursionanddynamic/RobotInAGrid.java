package ctci.recursionanddynamic;

import java.util.Arrays;

public class RobotInAGrid {

    public static int path(int[][] grid) {
        if (grid[0][0] == 1) {
            return 0;
        }
        firstRow(grid[0], grid[0].length + 1);
        firstColumn(grid, grid.length + 1);

        System.out.println(Arrays.deepToString(grid));
        for (int c = 1; c < grid.length; c++) {
            for (int r = 1; r < grid[0].length; r++) {
                if (grid[c][r] == 1) {
                    grid[c][r] = 0;
                } else {
                    grid[c][r] = grid[c][r - 1] + grid[c - 1][r];
                }
            }
        }

        return grid[grid.length-1][grid[0].length - 1];
    }

    private static void firstColumn(int[][] grid, int obstacle) {
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                obstacle = i;
                grid[i][0] = 0;
            }
            if (i >= obstacle) {
                grid[i][0] = 0;
            }
            else {
                grid[i][0] = 1;
            }
        }
    }

    private static void firstRow(int[] row, int obstacle) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                obstacle = i;
                row[i] = 0;
            }
            else if (i >= obstacle) {
                row[i] = 0;
            }
            else {
                row[i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0},{1}};
        System.out.println(Arrays.deepToString(grid));
        System.out.println(path(grid));
    }
}
