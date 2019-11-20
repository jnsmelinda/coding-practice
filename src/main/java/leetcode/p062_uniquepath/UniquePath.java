package leetcode.p062_uniquepath;

public class UniquePath {
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        firstRow(grid[0]);
        firstColumn(grid);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }

        return grid[grid.length-1][grid[0].length - 1];
    }

    private static void firstRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 1;
        }
    }

    private static void firstColumn(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,4));
    }
}
