package ctci.sortingandserching;

import java.util.Arrays;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[4][3];
        int[] arr = {1,2,3};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arr[j] + (i * 3);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static boolean sortedMatrixSearch(int[][] matrix, int n) {



        return false;
    }
}
