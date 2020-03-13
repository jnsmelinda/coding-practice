package leetcode.p0240_search_2d_matrix_2;

import java.util.Arrays;

public class Search2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        int counter = matrix[0].length * matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[0].length * matrix.length - counter;
                counter--;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(sortedMatrixSearch(matrix, 0));
    }

    public static boolean sortedMatrixSearch(int[][] matrix, int n) {
        if (matrix.length > 0) {
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == n) {
                    return true;
                } else if (matrix[row][col] > n) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }
}
