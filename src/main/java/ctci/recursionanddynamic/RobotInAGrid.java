package ctci.recursionanddynamic;

import java.util.Arrays;

public class RobotInAGrid {

    public static int path(int[][] grid) {
        firstcolumn(grid, grid.length + 1);
        firstrow(grid, grid.length + 1);

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

    private static void firstcolumn(int[][] grid, int obstacle) {
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                obstacle = i;
                grid[i][0] = 0;
            }
            if (i >= obstacle) {
                grid[i][0] = 0;
            }else {
                grid[i][0] = 1;
            }
        }
    }

    private static void firstrow(int[][] grid, int obstacle) {
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                obstacle = i;
                grid[0][i] = 0;
            }
            if (i >= obstacle) {
                grid[0][i] = 0;
            }else{
                grid[0][i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][3];
        grid[0][1] = 1;
        grid[1][1] = 1;
        grid[2][1] = 1;
        System.out.println(Arrays.deepToString(grid));
        System.out.println(path(grid));
    }
}
