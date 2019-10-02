package arrayandstring;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

//transpose method added for practice and fun purposes
    public static void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
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
        int[][] arr = {{1,2,3},{4,5,6}, {7,8,9}};
        printMatrix(arr);
        System.out.println("-----------------------------");
        rotate(arr);
        printMatrix(arr);
    }
}
