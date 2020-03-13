package leetcode.p0867_transposematrix;

import java.util.Arrays;

public class TransposeMatrix {
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
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
