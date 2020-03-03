package leetcode.p074_search_2d_matrix;

import java.util.Arrays;

public class Search2DMartix {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int[] arr = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arr[i] + 1 + (j + i * matrix[0].length);
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(sortedMatrixSearch(matrix, 0));
    }

    public static boolean sortedMatrixSearch(int[][] matrix, int n) {
        int row = 0;
        int col = matrix[0].length -1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == n) {
                return true;
            }
            else if (matrix[row][col] > n) {
                col --;
            }
            else{
                row++;
            }
        }

        return false;
    }
}
