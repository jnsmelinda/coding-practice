package arrayandstring;

public class ZeroMatrix {
    public static void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]){
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]){
                nullifyColumn(matrix, i);
            }
        }
    }

    private static void nullifyRow(int[][] matrix, int row){
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 100){
                    System.out.print(matrix[i][j] + "  ");
                }
                else if (matrix[i][j] < 10){
                    System.out.println(matrix[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,0,3, 2, 9, 6,9,7,4},{4,7,5,6,9,6,3,9,1,5}, {7,8,9, 8,6,4,3,8,1,0}};
        printMatrix(arr);
        System.out.println("-----------------------------");
        setZeros(arr);
        printMatrix(arr);
    }
}
